package exam.paperContext.domain.service;

import exam.paperContext.domain.model.paper.Paper.BlankQuiz;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BlankQuizDto {
    private String quizId;
    private int score;

    public static BlankQuiz toBlankQuiz(BlankQuizDto blankQuizDto) {
        return new BlankQuiz(blankQuizDto.quizId, blankQuizDto.score);
    }
}
