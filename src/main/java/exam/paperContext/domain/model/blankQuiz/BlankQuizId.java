package exam.paperContext.domain.model.blankQuiz;

import exam.paperContext.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Getter
public class BlankQuizId implements ValueObject<BlankQuizId> {
    private final String id;

    public static BlankQuizId nextId() {
        return new BlankQuizId("blankQuiz-" + UUID.randomUUID().toString());
    }

    public boolean sameValueAs(BlankQuizId other) {
        return equals(other);
    }
}
