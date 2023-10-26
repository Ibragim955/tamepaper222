package skypro.test.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Random;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class QuestionServiceImplTest {
    private QuestionRepository questionRepository;
    private  QuestionService questionService;
    private Random random;

    @BeforeEach
    public void init() {
        questionRepository = Mockito.mock(QuestionRepository.class);
        random = Mockito.mock(Random.class);

        questionService = new QuestionServiceImpl(questionRepository, random);
    }

    @Test
    public void testGetRandomQuestion() {
        Question question1 = new Question("test1", "test1");
        Question question2 = new Question("test2", "test2");
        Question question3 = new Question("test3", "test3");

        when(questionRepository.getAllQuestions()).thenReturn((Collection<Question>) List.of(question1, question2, question3));
        when(random.nextInt(anyInt())).thenReturn(2);

        Question actualQuestion = questionService.getRandomQuestion();

        Assertions.assertEquals(actualQuestion, question3);
    }
}
