package com.group2.miniproject.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResRepo extends MongoRepository<ExamResult, String> {

    public ExamResult findByName(String name);
    public void deleteByName(String name);
    public ExamResult save(ExamResult examResult);
}