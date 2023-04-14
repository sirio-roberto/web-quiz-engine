package engine.presentation;

import engine.business.Quiz;
import engine.business.QuizDTO;
import engine.business.QuizService;
import engine.business.Util.QuizResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping(path = "api/quizzes")
@Validated
public class QuizController {
    private final QuizService service;

    @Autowired
    public QuizController(QuizService service) {
        this.service = service;
    }

    @PostMapping
    public Quiz createQuiz(@Valid @RequestBody Quiz quiz) {
        return service.createQuiz(quiz);
    }

    @GetMapping("/{id}")
    public QuizDTO getQuiz(@PathVariable int id) {
        return service.getQuizDTOById(id);
    }

    @GetMapping
    public List<QuizDTO> getAllQuizzes() {
        return service.getAllQuizzes();
    }

    @PostMapping("/{id}/solve")
    public QuizResponse postAnswer(@PathVariable long id, @RequestBody HashMap<String, HashSet<@Min(0) Integer>> answer) {
        return service.postAnswer(id, answer);
    }

}
