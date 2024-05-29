package com.crudexample.spr_crud.repository;

import com.crudexample.spr_crud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Student,Integer> {
}
