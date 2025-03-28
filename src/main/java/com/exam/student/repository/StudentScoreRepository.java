package com.exam.student.repository;

import com.exam.student.entity.StudentScore;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentScoreRepository extends JpaRepository<StudentScore, Long> {
    List<StudentScore> findByStudentStudentId(Long studentId);
}