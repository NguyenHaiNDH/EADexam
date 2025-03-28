package com.exam.student.repository;
import com.exam.student.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SubjectRepository extends JpaRepository<Subject, Long> {
}