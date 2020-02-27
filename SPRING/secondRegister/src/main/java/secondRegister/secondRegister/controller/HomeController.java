package secondRegister.secondRegister.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aimdek.DAO.DAO;
import com.aimdek.model.Employee;

@Controller
public class HomeController {
	
	@Autowired
	DAO dao;	
	
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}	
	
	@RequestMapping(value="/register")
	public ModelAndView register(ModelAndView model) throws IOException{
		Employee e = new Employee();
		model.addObject(e);
		model.setViewName("register");		
		return model;	
	}
	
	@RequestMapping(value="/saveEmployee")
	public ModelAndView saveEmployee(@ModelAttribute Employee emp) throws IOException{
		dao.save(emp);
		return new ModelAndView("redirect:/viewemp");	
	}		
	
	@RequestMapping(value="/viewemp")
	public ModelAndView viewEmployee(ModelAndView model) throws IOException{
		model.setViewName("viewemp");
		List<Employee>  emp = dao.getEmp();
		model.addObject("emp", emp);
		return model;
	}	

	@RequestMapping(value="/deleteEmployee")
	public ModelAndView delete(HttpServletRequest request) throws IOException{
		String  ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		dao.delete(id);
		return new ModelAndView("redirect:/viewemp");
	}	

	@RequestMapping(value="/editEmployee")
	public ModelAndView update(HttpServletRequest request) throws IOException{
		String  ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		Employee emp = dao.getEmpById(id);
		ModelAndView mv = new ModelAndView("edit");
		mv.addObject("emp",emp);
		return mv;
	}
	
	@RequestMapping(value="/aftereditEmployee")
	public ModelAndView newupdate(HttpServletRequest request) throws IOException{
		String  ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		dao.update2(id, name, email);
		return new ModelAndView("redirect:/viewemp");		
	}

}
	
	

