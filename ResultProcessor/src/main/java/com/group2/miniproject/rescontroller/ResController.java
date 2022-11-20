package com.group2.miniproject.rescontroller;

import com.group2.miniproject.model.ExamResult;
import com.group2.miniproject.model.ResRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResController {

    private final ResRepo repo;

    @Autowired
    public ResController(ResRepo repo) {
        this.repo = repo;
    }

// the below get controller is working fine
//
//    @GetMapping(value = "/getresult")
//    public String getData(@RequestParam String name){
//        ExamResult examResult = repo.findByName(name);
//        return examResult.toString();
//    }
//

    @PostMapping(value="/storeresult")
    public ExamResult storeData(@RequestBody ExamResult examResult) {
        examResult = repo.save(examResult);
        return examResult;
    }

    @PutMapping(value = "/updateresult/{name}")
    public ExamResult updateData(@RequestBody ExamResult examResult,
                                 @PathVariable String name) {
        ExamResult result = repo.findByName(name);
        result.setScienceMarks(examResult.getScienceMarks());
        result.setMathMarks(examResult.getMathMarks());
        result.setSocialScienceMarks(examResult.getSocialScienceMarks());
        result.setArtMarks(examResult.getArtMarks());
        result.setSportMarks(examResult.getSportMarks());
        repo.deleteByName(name);
        repo.save(result);
        return repo.findByName(name);
    }

    @DeleteMapping(value = "/deleteresult")
    public String deleteData(@RequestParam String name) {
        if (repo.findByName(name) == null){
            return "no data entry found associated with " + name;
        }
        else{
            repo.deleteByName(name);
            return "data entry associated with " + name +" is deleted";
        }
    }
}
