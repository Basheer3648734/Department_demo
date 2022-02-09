package com.example.dept.service;

import com.example.dept.Entity.Department;

import java.util.List;

public interface DepartmentService {
  public  Department saveDepartment(Department department);

  public  List<Department> getAllDepartments();

  public Department getDepartmentByName(String departmentName);

  public Department updateDepartment(Long departmentId, Department department);

  public String deleteDepartment(Long departmentId);
}
