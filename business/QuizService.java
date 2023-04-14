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
        try {
            Quiz quiz = getQuizById(id);
            if (answer.get("answer").equals(quiz.getAnswer())) {
                return new QuizResponse(true, "Congratulations, you're right!");
            } else {
                return new QuizResponse(false, "Wrong answer! Please, try again.");
            }
        } catch (EntityNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public QuizDTO getQuizDTOById(long id) {
        try {
            return new QuizDTO(getQuizById(id));
        } catch (EntityNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Quiz getQuizById(long id) {
        try {
            return quizRepository.getById(id);
        } catch (EntityNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
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
