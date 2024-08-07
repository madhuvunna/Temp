package com.madhu.temp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.madhu.temp.entity.Employee;

@Repository
public class EmployeRepositoryimp implements EmployeRepositary {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Employee> findAll() {
		String sql = "select * from employ";

		List<Employee> emp = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Employee.class));

		return emp;
	}

	@Override
	public Employee findById(int Id) {
		Employee emp = jdbcTemplate.queryForObject("SELECT * FROM employ WHERE Id = ?",
				BeanPropertyRowMapper.newInstance(Employee.class), Id);
		return emp;
	}

	@Override
	public int save1(Employee emp) {
		return jdbcTemplate.update("INSERT INTO employ " + "(firstname,lastname,email) VALUES(?,?,?)",
				new Object[] { emp.getFirstName(), emp.getLastName(), emp.getEmail() });
	}

	@Override
	public int update(Employee emp) {
		return jdbcTemplate.update("UPDATE employ SET firstname=?,lastname=?, email=? WHERE id=?",
				new Object[] { emp.getFirstName(), emp.getLastName(), emp.getEmail(), emp.getId() });

	}

	@Override
	public int deleteByid(int id) {
		return jdbcTemplate.update("Delete from employ where id=?", id);
	}
}
