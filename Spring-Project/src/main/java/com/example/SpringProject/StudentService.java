package com.example.SpringProject;

import com.example.SpringProject.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public String addStudent(Student student) {
        studentRepository.save(student);
        return "Student data is added to Database!!";
    }

    public Student getStudent(Integer studentId) {
        Optional<Student> optionalStudent=studentRepository.findById(studentId);
        if(!optionalStudent.isPresent()){
            return new Student();
        }
        Student student=optionalStudent.get();
        return student;
    }

    public String updateStudent(Integer studentId, String name) {
       Optional<Student> student=studentRepository.findById(studentId);
       if(!student.isPresent()){
           return "This studentId does not exist in Database";
       }
       Student student1=student.get();
       student1.setName(name);
        studentRepository.save(student1);
       return "Name has been updated successfully";
    }

    public String deleteStudent(Integer studentId) {
        Optional<Student> student=studentRepository.findById(studentId);
        if(!student.isPresent()){
            return "This studentId does not exist in Database";
        }
        studentRepository.deleteById(studentId);
        return "Student with student Id "+studentId+" has been deleted successfully";
    }
}
