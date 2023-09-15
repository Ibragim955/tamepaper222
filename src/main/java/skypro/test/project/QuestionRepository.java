package skypro.test.project;

import org.springframework.stereotype.Repository;

@Repository
public class QuestionRepository {
    public Question addQuestion(Question question) {
        return question;
    }

    public Question removeQuestion(Question question) {
        return question;
    }

    public Collection<Question> getAllQuestions() {
        Collection<Question> o = null;
        return o;
    }
}
