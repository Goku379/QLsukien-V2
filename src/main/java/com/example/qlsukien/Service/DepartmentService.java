package com.example.qlsukien.Service;

import com.example.qlsukien.Entity.Department;
import com.example.qlsukien.Repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }



    public void save(Department department) {
        departmentRepository.save(department);
    }

    public Optional<Department> findById(Long id) {
        return departmentRepository.findById(id);
    }

    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }
}
