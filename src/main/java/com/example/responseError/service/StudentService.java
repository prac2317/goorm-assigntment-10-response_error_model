package com.example.responseError.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.responseError.entity.Student;
import com.example.responseError.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;


    //이름과 성적 받아 저장
    public Student addStudent(String name, int grade) {
        Student student = new Student(name, grade);
        studentRepository.add(student);

        return student;
    }

    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    public List<Student> get(int grade) {
        return studentRepository.get(grade);
    }
}

