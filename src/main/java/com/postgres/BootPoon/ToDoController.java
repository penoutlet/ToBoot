package com.postgres.BootPoon;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoController {

    @Autowired
    private ToDoRepository questionRepository;

    @GetMapping("/questions")
    public List<ToDo> getQuestions(){
    	return questionRepository.findAll();
    }
    
//    @GetMapping("/questions")
//    public Page<Question> getQuestions(Pageable pageable) {
//        return questionRepository.findAll(pageable);
//    }


    @PostMapping("/questions")
    public ToDo createQuestion(@Valid @RequestBody ToDo question) {
        return questionRepository.save(question);
    }

//    @PutMapping("/questions/{questionId}")
//    public Question updateQuestion(@PathVariable Long questionId,
//                                   @Valid @RequestBody Question questionRequest) {
//        return questionRepository.findById(questionId)
//                .map(question -> {
//                    question.setTitle(questionRequest.getTitle());
//                    question.setDescription(questionRequest.getDescription());
//                    return questionRepository.save(question);
//                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
//    }
//
//
//    @DeleteMapping("/questions/{questionId}")
//    public ResponseEntity<?> deleteQuestion(@PathVariable Long questionId) {
//        return questionRepository.findById(questionId)
//                .map(question -> {
//                    questionRepository.delete(question);
//                    return ResponseEntity.ok().build();
//                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
//    }
}