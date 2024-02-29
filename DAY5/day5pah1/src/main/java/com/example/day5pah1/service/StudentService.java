package com.example.day5pah1.service;

import org.springframework.stereotype.Service;

import com.example.day5pah1.model.Student;
import com.example.day5pah1.repository.StudentRepo;
import java.util.List;

@Service
public class StudentService {
    private StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo)
    {
        this.studentRepo=studentRepo;
    }

    public boolean saveStudent(Student student)
    {
        try
        {
            studentRepo.save(student);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean updateDetails(int id,Student student)
    {
        if(this.getStudentById(id)==null)
        {
            return false;
        }
        try{
            studentRepo.save(student);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteStudent(int id)
    {
        if(this.getStudentById(id) == null)
        {
            return false;
        }
        studentRepo.deleteById(id);
        return true;
    }
    public Student getStudentById(int id)
    {
        return studentRepo.findById(id).orElse(null);
    }
    public List<Student> getListStudent()
    {
        return studentRepo.findAll();
    }
}
