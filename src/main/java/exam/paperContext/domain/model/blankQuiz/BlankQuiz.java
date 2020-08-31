package exam.paperContext.domain.model.blankQuiz;


import exam.paperContext.shared.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@EqualsAndHashCode(of = {"blankQuizId"})
@Getter
public class BlankQuiz implements Entity<BlankQuiz> {
    private final BlankQuizId blankQuizId;
    private final String teacherId;
    private String content;
    private String referenceAnswer;
    private int score;
    private final LocalDateTime createTime;
    private LocalDateTime updateTime;
    private boolean deleted;

    private BlankQuiz(BlankQuizId blankQuizId, String teacherId, String content, String referenceAnswer, int score) {
        this.blankQuizId = blankQuizId;
        this.teacherId = teacherId;
        this.content = content;
        this.referenceAnswer = referenceAnswer;
        this.score = score;
        this.createTime = LocalDateTime.now();
        this.updateTime = createTime;
        this.deleted = false;
    }

    public static BlankQuiz create(BlankQuizId blankQuizId, String teacherId, String content, String referenceAnswer, int score) {
        validateScore(score);
        return new BlankQuiz(blankQuizId, teacherId, content, referenceAnswer, score);
    }

    private static void validateScore(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalScoreException(score);
        }
    }

    @Override
    public boolean sameIdentityAs(BlankQuiz other) {
        return blankQuizId.sameValueAs(other.getBlankQuizId());
    }

    public void revise(String content, String referenceAnswer, int score) {
        validateScore(score);
        this.content = content;
        this.referenceAnswer = referenceAnswer;
        this.score = score;
        updateTime = LocalDateTime.now();
    }

    public void delete() {
        deleted = true;
    }

}
