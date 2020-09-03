package exam.paperContext.application;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateBlankQuizCommand {
    private String teacherId;
    private String content;
    private String referenceAnswer;
    private int score;
}
