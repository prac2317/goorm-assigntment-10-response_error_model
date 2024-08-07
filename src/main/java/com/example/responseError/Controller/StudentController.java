package com.example.responseError.Controller;

import com.example.responseError.Repository.StudentRepository;
import com.example.responseError.domain.ApiResponse;
import com.example.responseError.domain.MetaData;
import com.example.responseError.domain.Status;
import com.example.responseError.domain.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private StudentRepository studentRepository = StudentRepository.getInstatnce();

    @PostMapping("/save")
    public ApiResponse<List<Student>> saveStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        List<Student> students = studentRepository.findAll();
        return makeResponse(students);
    }

    @GetMapping("/all")
    public ApiResponse<List<Student>> searchAllStudent() {
        List<Student> students = studentRepository.findAll();
        return makeResponse(students);
    }

    @GetMapping("/grade")
    public ApiResponse<List<Student>> searchStudentByGrade(@RequestParam int grade) {
        List<Student> students = studentRepository.findStudentByGrade(grade);
        return makeResponse(students);
    }

    private ApiResponse<List<Student>> makeResponse(List<Student> students) {
        Status status = new Status(2000, "OK");
        MetaData metaData = new MetaData(students.size());
        return new ApiResponse<>(status, metaData, students);
    }
}
