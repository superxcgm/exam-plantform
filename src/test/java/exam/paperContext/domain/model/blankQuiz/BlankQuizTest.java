package exam.paperContext.domain.model.blankQuiz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class BlankQuizTest {
    @Test
    void should_create_blank_quiz() {
        BlankQuizId blankQuizId = new BlankQuizId("blankQuizId-a4c68d5d-6c18-4707-b8c2-1fd18846ebf1");
        final String teacherId = "teacher-6b35fdd8-31de-4af4-9420-3331058260c5";
        String content = "1 + 1 = ?";
        String referenceAnswer = "2";
        int score = 10;

        BlankQuiz blankQuiz = BlankQuiz.create(blankQuizId, teacherId, content, referenceAnswer, score);

        assertThat(blankQuiz, is(notNullValue()));
        assertThat(blankQuiz.getBlankQuizId(), is(new BlankQuizId("blankQuizId-a4c68d5d-6c18-4707-b8c2-1fd18846ebf1")));
        assertThat(blankQuiz.getTeacherId(), is(teacherId));
        assertThat(blankQuiz.getContent(), is(content));
        assertThat(blankQuiz.getReferenceAnswer(), is(referenceAnswer));
        assertThat(blankQuiz.getScore(), is(score));
        assertThat(blankQuiz.getCreateTime(), instanceOf(LocalDateTime.class));
        assertThat(blankQuiz.getUpdateTime(), instanceOf(LocalDateTime.class));
        assertThat(blankQuiz.isDeleted(), is(false));
    }

    @Test
    void should_score_between_0_and_100() {
        BlankQuizId blankQuizId = new BlankQuizId("blankQuizId-a4c68d5d-6c18-4707-b8c2-1fd18846ebf1");
        final String teacherId = "teacher-6b35fdd8-31de-4af4-9420-3331058260c5";
        String content = "1 + 1 = ?";
        String referenceAnswer = "2";
        int score = 110;

        Assertions.assertThrows(IllegalScoreException.class, () -> {
            BlankQuiz.create(blankQuizId, teacherId, content, referenceAnswer, score);
        });
    }

    @Test
    void should_revise_blank_quiz() {
        BlankQuizId blankQuizId = new BlankQuizId("blankQuizId-a4c68d5d-6c18-4707-b8c2-1fd18846ebf1");
        final String teacherId = "teacher-6b35fdd8-31de-4af4-9420-3331058260c5";
        String content = "1 + 1 = ?";
        String referenceAnswer = "2";
        int score = 10;
        String newContent = "new content";
        String newReferenceAnswer = "3";
        int newScore = 6;
        BlankQuiz blankQuiz = BlankQuiz.create(blankQuizId, teacherId, content, referenceAnswer, score);

        blankQuiz.revise(newContent, newReferenceAnswer, newScore);

        assertThat(blankQuiz.getContent(), is(newContent));
        assertThat(blankQuiz.getReferenceAnswer(), is(newReferenceAnswer));
        assertThat(blankQuiz.getScore(), is(newScore));
    }
}
