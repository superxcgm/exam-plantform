package exam.paperContext.infrastructure;

import exam.paperContext.domain.model.blankQuiz.BlankQuiz;
import exam.paperContext.domain.model.blankQuiz.BlankQuizId;
import exam.paperContext.domain.model.blankQuiz.BlankQuizRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MemoryBlankQuizRepository implements BlankQuizRepository {
    private Set<BlankQuiz> blankQuizs = new HashSet<>();

    @Override
    public BlankQuiz find(BlankQuizId blankQuizId) {
        return null;
    }

    @Override
    public void save(BlankQuiz blankQuiz) {
        blankQuizs.add(blankQuiz);
    }

    @Override
    public List<BlankQuiz> getAll() {
        return null;
    }
}
