package exam.paperContext.domain.model.blankQuiz;

public class IllegalScoreException extends IllegalArgumentException {
    public IllegalScoreException(int score) {
        super("IllegalScoreException: exception score is not in range [0,100], actual:" + score);
    }
}
