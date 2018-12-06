package com.example.demo;

import com.example.demo.model.Bruger;
import com.example.demo.model.Courses;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BrugerRepository extends CrudRepository<Bruger,Long> {
    Bruger findByEmail(String email);

    List<Bruger> findAll();

}
