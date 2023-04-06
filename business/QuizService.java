package engine.business;

import engine.business.Util.QuizResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    private final List<Quiz> quizzes = new ArrayList<>();

    public QuizResponse postAnswer(int id, int answer) {
        Quiz quiz = getQuizById(id);
        if (answer == quiz.getAnswer()) {
            return new QuizResponse(true, "Congratulations, you're right!");
        } else {
            return new QuizResponse(false, "Wrong answer! Please, try again.");
        }
    }

    public QuizDTO getQuizDTOById(int id) {
        return new QuizDTO(getQuizById(id));
    }

    public Quiz getQuizById(int id) {
        return quizzes.stream()
                .filter(q -> q.getId() == id)
                .findAny().orElse(null);
    }

    public Quiz createQuiz(Quiz quiz) {
        quiz.getId();
        quizzes.add(quiz);
        return quiz;
    }

    public List<QuizDTO> getAllQuizzes() {
        return quizzes.stream()
                .map(QuizDTO::new)
                .toList();
    }
}
