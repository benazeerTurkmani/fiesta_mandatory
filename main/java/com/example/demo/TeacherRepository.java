package com.example.demo;

import com.example.demo.model.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeacherRepository extends CrudRepository<Teacher,Long> {
    Teacher findById(long id);
    List<Teacher> findAll();
}
