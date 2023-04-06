package engine.presentation;

import engine.business.Quiz;
import engine.business.QuizService;
import engine.business.Util.QuizResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/quiz")
public class QuizController {
    private final QuizService service;

    @Autowired
    public QuizController(QuizService service) {
        this.service = service;
    }

    @GetMapping
    public Quiz getQuiz() {
        return service.getOneQuiz();
    }

    @PostMapping
    public QuizResponse postAnswer(@RequestParam int answer) {
        return service.postAnswer(answer);
    }

}
