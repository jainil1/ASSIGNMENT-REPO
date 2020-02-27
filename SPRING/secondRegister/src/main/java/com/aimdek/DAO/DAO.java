package com.aimdek.DAO;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aimdek.model.Employee;

import java.util.List;

import javax.sql.DataSource;


public class DAO {		

	JdbcTemplate template;	
	
	public DAO(DataSource dataSource) {
	template = new JdbcTemplate(dataSource);
	}
	
	public  int save( Employee e) {
		
		
		String query = "INSERT INTO spring.spring values(?,?,?)";
	
		return template.update(query ,e.getName(),e.getEmail(),e.getId());
	}
	
	public int update(Employee emp) {
		String query = "UPDATE spring  set name =? , email=? where id =? ";
		return template.update(query,emp.getName(),emp.getId(),emp.getEmail());
	}
	
	public int update2(int id ,String name, String email) {
		String query = "UPDATE spring  set name =? , email=? where id =? ";
		return template.update(query,name,email,id);
	}
		
	public int delete(int id) {
		
		String query = "DELETE FROM spring where id=?";
		return template.update(query,id);
		}
	
	public Employee getEmpById(int id) {
		String query= "SELECT * FROM spring where id ="+id;
		return template.queryForObject(query,BeanPropertyRowMapper.newInstance(Employee.class));
	}
	
	public List<Employee> getEmp(){
		 return template.query("select * from spring",new RowMapper<Employee>(){    
		        public Employee mapRow(ResultSet rs, int row) throws SQLException {    
		            Employee e=new Employee();    
		            e.setId(rs.getString(1));    
		            e.setName(rs.getString(2));    
		            e.setEmail(rs.getString(3));    
		            
		            return e;    
		        }    
		    });    
		}    

}
