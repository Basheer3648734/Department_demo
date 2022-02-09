package com.example.dept.service;

import com.example.dept.Entity.Department;
import com.example.dept.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department dep=departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equals(department.getDepartmentAddress())){
            dep.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equals(department.getDepartmentCode())){
            dep.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentName()) && !"".equals(department.getDepartmentName())){
            dep.setDepartmentName(department.getDepartmentName());
        }
      return  departmentRepository.save(dep);
    }

    @Override
    public String deleteDepartment(Long departmentId) {
         departmentRepository.deleteById(departmentId);
         return "department deleted successfully!";
    }
}
