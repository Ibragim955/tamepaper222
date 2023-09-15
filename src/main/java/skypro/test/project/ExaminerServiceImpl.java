package skypro.test.project;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl extends ExaminerService {
    private final QuestionService javaQuestionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.javaQuestionService = questionService;
    }

    @Override
    public java.util.Collection<Question> getQuestion(Integer amount) throws NotEnoughQuestionExeption {
        if (amount > javaQuestionService.getAllQuestions().size()) {
            throw new NotEnoughQuestionExeption("Requested more questions than exists");
        }
        Set<Question> questions = new HashSet<>();

        while (questions.size() < amount) {
            questions.add(javaQuestionService.getRandomQuestion());
        }
        return (java.util.Collection<Question>) questions;
    }
}
