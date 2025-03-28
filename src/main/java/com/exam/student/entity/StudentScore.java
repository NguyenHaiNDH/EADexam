package com.exam.student.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_score_t")
@NoArgsConstructor
@AllArgsConstructor
public class StudentScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_score_id")
    private Long studentScoreId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @Column(name = "score1")
    private double score1;

    @Column(name = "score2")
    private double score2;


    public Long getStudentScoreId() { return studentScoreId; }
    public void setStudentScoreId(Long studentScoreId) { this.studentScoreId = studentScoreId; }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
    public Subject getSubject() { return subject; }
    public void setSubject(Subject subject) { this.subject = subject; }
    public double getScore1() { return score1; }
    public void setScore1(double score1) { this.score1 = score1; }
    public double getScore2() { return score2; }
    public void setScore2(double score2) { this.score2 = score2; }

    // Calculate Grade
    public String calculateGrade() {
        double finalScore = 0.3 * score1 + 0.7 * score2;
        if (finalScore >= 8.0 && finalScore <= 10.0) return "A";
        else if (finalScore >= 6.0 && finalScore <= 7.9) return "B";
        else if (finalScore >= 4.0 && finalScore <= 5.9) return "D";
        else return "F";
    }
}