package com.example.qlsukien.Controller;

import com.example.qlsukien.Entity.Department;
import com.example.qlsukien.Repo.DepartmentRepo;
import com.example.qlsukien.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/QLSK")
public class BoMonController {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentRepo departmentRepo;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        List<Department> list = departmentRepo.findAll();
        model.addAttribute("departments", list);
        return "QLSK/hien-thi";
    }

    @PostMapping("/add")
    public String addDepartment(@ModelAttribute Department department) {
        departmentService.save(department);
        return "redirect:/QLSK/hien-thi";
    }

    @GetMapping("/update/{id}")
    public String editDepartment(@PathVariable Long id, Model model) {
        Optional<Department> department = departmentService.findById(id);
        if (department.isPresent()) {
            model.addAttribute("department", department.get());
            return "QLSK/edit-form"; // Chuyển đến JSP cho form chỉnh sửa
        }
        return "redirect:/QLSK/hien-thi"; // Quay lại danh sách nếu không tìm thấy
    }

    @PostMapping("/update")
    public String updateDepartment(@ModelAttribute Department department) {
        departmentService.save(department);
        return "redirect:/QLSK/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        departmentService.deleteById(id);
        return "redirect:/QLSK/hien-thi";
    }

}
