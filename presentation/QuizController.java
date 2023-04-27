package engine.presentation;

import engine.business.Quiz;
import engine.business.QuizDTO;
import engine.business.QuizService;
import engine.business.User;
import engine.business.Util.QuizResponse;
import engine.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("api")
@Validated
public class QuizController {
    private final QuizService quizService;
    private final UserRepository userRepo;

    private final PasswordEncoder encoder;

    @Autowired
    public QuizController(QuizService quizService, UserRepository userRepo, PasswordEncoder encoder) {
        this.quizService = quizService;
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    @PostMapping("/quizzes")
    public Quiz createQuiz(@Valid @RequestBody Quiz quiz) {
        return quizService.createQuiz(quiz);
    }

    @GetMapping("/quizzes/{id}")
    public QuizDTO getQuiz(@PathVariable long id) {
        return quizService.getQuizDTOById(id);
    }

    @GetMapping("/quizzes")
    public List<QuizDTO> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    @PostMapping("/quizzes/{id}/solve")
    public QuizResponse postAnswer(@PathVariable long id, @RequestBody HashMap<String, HashSet<@Min(0) Integer>> answer) {
        return quizService.postAnswer(id, answer);
    }

    @DeleteMapping("/quizzes/{id}")
    public ResponseEntity<String> deleteQuiz(@PathVariable long id, Authentication auth) {
        Quiz quiz = quizService.getQuizById(id);
        if (quiz.getUser().getEmail().equals(auth.getName())) {
            quizService.deleteQuiz(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        try {
            userRepo.save(user);
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

}
