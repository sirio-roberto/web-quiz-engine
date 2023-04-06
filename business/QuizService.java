package engine.business;

import engine.business.Util.QuizResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    private final List<Quiz> quizzes = new ArrayList<>();

    public QuizResponse postAnswer(int id, int answer) {
        Quiz quiz = getQuizById(id);
        if (quiz != null) {
            if (answer == quiz.getAnswer()) {
                return new QuizResponse(true, "Congratulations, you're right!");
            } else {
                return new QuizResponse(false, "Wrong answer! Please, try again.");
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public QuizDTO getQuizDTOById(int id) {
        return new QuizDTO(getQuizById(id));
    }

    public Quiz getQuizById(int id) {
        Quiz quiz = quizzes.stream()
                .filter(q -> q.getId() == id)
                .findAny().orElse(null);
        if (quiz != null) {
            return quiz;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Quiz createQuiz(Quiz quiz) {
        quizzes.add(quiz);
        return quiz;
    }

    public List<QuizDTO> getAllQuizzes() {
        return quizzes.stream()
                .map(QuizDTO::new)
                .toList();
    }
}
