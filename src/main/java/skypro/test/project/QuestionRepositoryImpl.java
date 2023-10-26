package skypro.test.project;

import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
public class QuestionRepositoryImpl extends QuestionRepository {
    private final Set<Question> storageQuestions = new HashSet<>();

    @Override
    public Question addQuestion(Question question) {
        storageQuestions.add(question);
        return question;
    }

    @Override
    public Question removeQuestion(Question question) {
        storageQuestions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAllQuestions() {
        return (Collection<Question>) Collections.unmodifiableSet(storageQuestions);
    }
}
