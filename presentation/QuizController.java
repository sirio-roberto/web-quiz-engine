package engine.presentation;

import engine.business.Quiz;
import engine.business.QuizService;
import engine.business.Util.QuizResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/quizzes")
public class QuizController {
    private final QuizService service;

    @Autowired
    public QuizController(QuizService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Quiz getQuiz(@PathVariable int id) {
        return service.getQuizById(id);
    }

    @GetMapping
    public Quiz getAllQuizzes() {
        return service.getAllQuizzes();
    }

    @PostMapping
    public QuizResponse postAnswer(@RequestParam int answer) {
        return service.postAnswer(answer);
    }

}
