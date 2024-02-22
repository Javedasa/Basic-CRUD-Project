package com.example.SpringProject;

import com.example.SpringProject.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/getStudent")
    public Student getStudent(@RequestParam("studentId")Integer studentId){
        return studentService.getStudent(studentId);
    }
    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @PutMapping("/updateStudent")
    public String updateStudent(@RequestParam("studentId")Integer studentId,@RequestParam("name")String name){
        return studentService.updateStudent(studentId,name);
    }

    @DeleteMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId")Integer studentId){
        return studentService.deleteStudent(studentId);
    }
}
