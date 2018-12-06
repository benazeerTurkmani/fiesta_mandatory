package com.example.demo;

import com.example.demo.model.Administrator;
import com.example.demo.model.Bruger;
import com.example.demo.model.Courses;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdminRepository extends CrudRepository<Administrator,Long> {
    List<Administrator> findAll();

}
