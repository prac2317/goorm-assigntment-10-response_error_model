package com.example.responseError.Repository;

import com.example.responseError.domain.Student;

import java.util.*;
import java.util.stream.Collectors;

public class StudentRepository {

    private static final List<Student> store = new LinkedList<>();

    private static final StudentRepository instance = new StudentRepository();

    public static StudentRepository getInstatnce() {
        return instance;
    }


    public List<Student> findStudentByGrade(int grade) {
        List<Student> filteredStudents = store.stream()
                                                .filter(student -> student.getGrade() == grade)
                                                .toList();
        return filteredStudents;
    }

    public List<Student> findAll() {
        return store;
    }

    public void save(Student student) {
        store.add(student);
    }
}
