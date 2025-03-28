package com.exam.student.service;

import com.exam.student.entity.Student;
import com.exam.student.entity.StudentScore;
import com.exam.student.entity.Subject;
import com.exam.student.repository.StudentRepository;
import com.exam.student.repository.StudentScoreRepository;
import com.exam.student.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentScoreRepository studentScoreRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public StudentScore addScore(StudentScore score) {
        return studentScoreRepository.save(score);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<StudentScore> getScoresByStudent(Long studentId) {
        return studentScoreRepository.findByStudentStudentId(studentId);
    }

    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + studentId));
    }

    public Subject getSubjectById(Long subjectId) {
        return subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found with ID: " + subjectId));
    }

    public void updateScore(Long studentScoreId, double score1, double score2) {
        StudentScore score = studentScoreRepository.findById(studentScoreId)
                .orElseThrow(() -> new RuntimeException("StudentScore not found with ID: " + studentScoreId));
        score.setScore1(score1);
        score.setScore2(score2);
        studentScoreRepository.save(score);
    }
}