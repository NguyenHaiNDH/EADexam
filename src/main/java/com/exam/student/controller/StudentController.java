package com.exam.student.controller;

import com.exam.student.entity.Student;
import com.exam.student.entity.StudentScore;  // Import StudentScore
import com.exam.student.entity.Subject;       // Import Subject
import com.exam.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    // hiển thị danh sách
    @GetMapping("/")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("studentScores", studentService.getAllStudents().stream()
                .collect(Collectors.toMap(Student::getStudentId, student -> studentService.getScoresByStudent(student.getStudentId()))));
        return "studentList";
    }

    // thêm học sinh
    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute Student student) {
        studentService.addStudent(student);
        return "redirect:/";
    }

    // thêm điểm
    @PostMapping("/addScore")
    public String addScore(@RequestParam Long studentId, @RequestParam Long subjectId,
                           @RequestParam double score1, @RequestParam double score2) {
        StudentScore score = new StudentScore();
        score.setStudent(new Student() {{ setStudentId(studentId); }});
        score.setSubject(new Subject() {{ setSubjectId(subjectId); }});
        score.setScore1(score1);
        score.setScore2(score2);
        studentService.addScore(score);
        return "redirect:/";
    }

    // sửa điểm
    @PostMapping("/editScore")
    public String editScore(@RequestParam Long studentScoreId, @RequestParam double score1, @RequestParam double score2) {
        studentService.updateScore(studentScoreId, score1, score2);
        return "redirect:/";
    }
}