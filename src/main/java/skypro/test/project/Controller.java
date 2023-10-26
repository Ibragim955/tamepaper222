package skypro.test.project;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class Controller {

    private final ExaminerService examinerService;


    public Controller(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping()
    public Collection<Question> getQuestions(@PathVariable Integer amount) throws NotEnoughQuestionExeption {
        return examinerService.getQuestion(amount);
    }
}

