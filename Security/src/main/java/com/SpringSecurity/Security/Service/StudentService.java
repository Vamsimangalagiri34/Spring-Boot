package com.SpringSecurity.Security.Service;

import com.SpringSecurity.Security.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.*;
import java.util.List;

@Service
public class StudentService {

    List<Student> stud = new ArrayList<Student>(List.of(
            new Student(1, "Vamsi", "INDIA"),
            new Student(2, "Leo", "UK"),
            new Student(3, "Melio", "USA"),
            new Student(4, "Aarav", "INDIA"),
            new Student(5, "Emma", "CANADA"),
            new Student(6, "Lucas", "GERMANY"),
            new Student(7, "Sophia", "AUSTRALIA"),
            new Student(8, "Ethan", "FRANCE")
    ));



    public List<Student> getStudents(){
        return  stud;
    }

    public String addStudent(Student stu){
        stud.add(stu);
        return "201";
    }

}
