package skypro.test.project;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/j")
public class QuestionController {
    private QuestionService questionService;


    public void JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping()
    //как параметры получаем вопрос - ответ
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.add(new Question(question, answer));
    }

    @GetMapping()
    //метод для получения всех вопросов
    private Collection<Question> getAll() {
        return questionService.getAllQuestions();
    }



    @GetMapping()
    //метод для удаления вопроса
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.remove(new Question(question, answer));
    }

    @GetMapping()
    //метод для получения рандомного вопроса
    public Question getRandomQuestion() {
        return questionService.getRandomQuestion();
    }
}
