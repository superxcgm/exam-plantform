package exam.paperContext.application;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviseBlankQuizCommand {
    private String teacherId;
    private String content;
    private String referenceAnswer;
    private int score;
}
