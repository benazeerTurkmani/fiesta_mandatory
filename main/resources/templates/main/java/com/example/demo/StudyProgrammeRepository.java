package com.example.demo;

import com.example.demo.model.StudyProgramme;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudyProgrammeRepository extends CrudRepository<StudyProgramme, Long> {
    List<StudyProgramme> findAll();
}
