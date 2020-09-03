package exam.paperContext.userInterface;

import exam.paperContext.application.BlankQuizApplicationService;
import exam.paperContext.application.CreateBlankQuizCommand;
import exam.paperContext.application.ReviseBlankQuizCommand;
import exam.paperContext.domain.model.blankQuiz.BlankQuizId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlankQuizController {
    private final BlankQuizApplicationService blankQuizApplicationService;

    @Autowired
    public BlankQuizController(BlankQuizApplicationService blankQuizApplicationService) {
        this.blankQuizApplicationService = blankQuizApplicationService;
    }


    @PostMapping("/blank-quizs")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    BlankQuizDTO create(@RequestBody CreateBlankQuizCommand command) {
        final BlankQuizId blankQuizId = blankQuizApplicationService.createBlankQuiz(command);
        return BlankQuizDTO.from(blankQuizId);
    }


    @PutMapping("/blank-quizs/{blankQuizId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void revise(@PathVariable String blankQuizId, @RequestBody ReviseBlankQuizCommand command) {
        blankQuizApplicationService.reviseBlankQuiz(blankQuizId, command);
    }

    @DeleteMapping("/blank-quizs/{blankQuizId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable String blankQuizId) {
        blankQuizApplicationService.deleteBlankQuiz(blankQuizId);
    }
}
