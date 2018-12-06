package com.example.demo;

import com.example.demo.model.Courses;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CoursesRepository extends CrudRepository<Courses,Long> {
    List<Courses> findAll();
    List<Courses> findAll(Specification specification);
    Optional<Courses> findById(Long id);
}
