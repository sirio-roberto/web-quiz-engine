package engine.business;

import engine.business.Util.QuizResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    public QuizResponse postAnswer(int answer) {
        if (answer == 2) {
            return new QuizResponse(true, "Congratulations, you're right!");
        } else {
            return new QuizResponse(false, "Wrong answer! Please, try again.");
        }
    }

    public Quiz getQuizById() {
        List<String> options = List.of("Robot","Tea leaf","Cup of coffee","Bug");
        return new Quiz("The Java Logo", "What is depicted on the Java logo?", options);
    }
}
