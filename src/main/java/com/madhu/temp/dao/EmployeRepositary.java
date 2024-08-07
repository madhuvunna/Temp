package com.madhu.temp.dao;

import java.util.List;

import com.madhu.temp.entity.Employee;

public interface EmployeRepositary {
	
	public List<Employee> findAll();

	public Employee findById(int Id);
	
    public int save1(Employee emp);
    
    public int update(Employee emp);
    
    public int deleteByid(int Id);
}
