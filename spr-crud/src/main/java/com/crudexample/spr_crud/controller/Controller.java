package com.crudexample.spr_crud.controller;

import com.crudexample.spr_crud.model.Student;
import com.crudexample.spr_crud.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @Autowired
     Repository r;
        //READ
        @GetMapping("/students")   //get all students data
         public List<Student> getAllStudents(){
            return r.findAll();
        }

        @GetMapping("/students/{id}")//id is a path variable. get student by i
        public Student getStudent(@PathVariable("id") int id) {
           Optional<Student> student = r.findById(id);
            return student.orElseThrow(() -> new RuntimeException("Student not found with id: " + id));}


       //CREATE
       @PostMapping ("/students/add")//create student data
        public void createStudent(@RequestBody Student s) {
          r.save(s);}

    // UPDATE
    @PutMapping("/students/update/{id}") // ID is a path variable. Update student data
    public Student updateStudent(@PathVariable int id, @RequestBody Student studentDetails) {
        Student student = r.findById(id).orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        student.setName(studentDetails.getName());
        student.setBranch(studentDetails.getBranch());
        student.setPercentage(studentDetails.getPercentage());
        return r.save(student);
    }

    //DELETE
    @DeleteMapping ("/students/delete/{id}")//delete student data
    public void deleteStudent(@PathVariable int id) {
            Student st=r.findById(id).orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
            r.delete(st);
        }
}



