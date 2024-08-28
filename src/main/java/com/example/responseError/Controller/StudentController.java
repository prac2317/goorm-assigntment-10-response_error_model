package com.example.responseError.Controller;

import com.example.responseError.Repository.StudentRepository;
import com.example.responseError.domain.ApiResponse;
import com.example.responseError.domain.MetaData;
import com.example.responseError.domain.Status;
import com.example.responseError.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class StudentController {

    private StudentRepository studentRepository = StudentRepository.getInstatnce();

    @PostMapping("/save")
    public ApiResponse<Student> saveStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        log.info("student.name={}", student.getName());
        log.info("student.grade={}", student.getGrade());
        List<Student> students = studentRepository.findAll();
        return makeResponse(students);
    }

    @GetMapping("/all")
    public ApiResponse<Student> searchAllStudent() {
        List<Student> students = studentRepository.findAll();
        return makeResponse(students);
    }

    @GetMapping("/grade")
    public ApiResponse<Student> searchStudentByGrade(@RequestParam int grade) {
        List<Student> students = studentRepository.findStudentByGrade(grade);
        return makeResponse(students);
    }

    private ApiResponse<Student> makeResponse(List<Student> students) {
        Status status = new Status(2000, "OK");
        MetaData metaData = new MetaData(students.size());
        students.sort((student1, student2) -> student1.getGrade() - student2.getGrade());
        return new ApiResponse<>(status, metaData, students);
    }
}
