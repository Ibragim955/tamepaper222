package skypro.test.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuestionServiceImpl extends QuestionService {
    private final QuestionRepository questionRepository;
    private final Random random;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
        this.random = new Random();
    }

    public QuestionServiceImpl(QuestionRepository questionRepository, Random random) {
        this.questionRepository = questionRepository;
        this.random = random;
    }

    @Override
    public Question add(Question question) {
        return questionRepository.addQuestion(question);
    }

    @Override
    public Question remove(Question question) {
        return questionRepository.removeQuestion(question);
    }

    @Override
    public Collection<Question> getAllQuestions() {
        return questionRepository.getAllQuestions();
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> allQuestions = new ArrayList<>((java.util.Collection) questionRepository.getAllQuestions());
        Integer index = random.nextInt(allQuestions.size());
        return allQuestions.get(index);
    }
}
