package exam.paperContext.application;

import exam.paperContext.domain.model.blankQuiz.BlankQuiz;
import exam.paperContext.domain.model.blankQuiz.BlankQuizId;
import exam.paperContext.domain.model.blankQuiz.BlankQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlankQuizApplicationService {
    private final BlankQuizRepository blankQuizRepository;

    @Autowired
    public BlankQuizApplicationService(BlankQuizRepository blankQuizRepository) {
        this.blankQuizRepository = blankQuizRepository;
    }

    public BlankQuizId createBlankQuiz(CreateBlankQuizCommand command) {
        BlankQuizId blankQuizId = BlankQuizId.nextId();

        BlankQuiz blankQuiz = BlankQuiz.create(blankQuizId, command.getTeacherId(), command.getContent(), command.getReferenceAnswer(), command.getScore());

        blankQuizRepository.save(blankQuiz);

        return blankQuizId;
    }
}
