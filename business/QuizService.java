package engine.business;

import engine.business.Util.QuizResponse;
import engine.persistence.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
public class QuizService {

    private final QuizRepository quizRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public QuizResponse postAnswer(long id, HashMap<String, HashSet<Integer>> answer) {
        Quiz quiz = getQuizById(id);
        if (answer.get("answer").equals(quiz.getAnswer())) {
            return new QuizResponse(true, "Congratulations, you're right!");
        } else {
            return new QuizResponse(false, "Wrong answer! Please, try again.");
        }
    }

    public QuizDTO getQuizDTOById(long id) {
        return new QuizDTO(getQuizById(id));
    }

    public Quiz getQuizById(long id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        if (quiz.isPresent()) {
            return quiz.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public List<QuizDTO> getAllQuizzes() {
        return quizRepository.findAll().stream()
                .map(QuizDTO::new)
                .toList();
    }
}
