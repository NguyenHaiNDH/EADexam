package com.exam.student.service;

import com.exam.student.entity.Student;
import com.exam.student.entity.StudentScore;
import com.exam.student.repository.StudentRepository;
import com.exam.student.repository.StudentScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentScoreRepository studentScoreRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public StudentScore addScore(StudentScore score) {
        return studentScoreRepository.save(score);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<StudentScore> getScoresByStudent(Long studentId) {  // Đổi từ int sang Long
        return studentScoreRepository.findByStudentStudentId(studentId);
    }
}