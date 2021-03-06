package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.compensation.Compensation;
import com.example.demo.empdao.CompDao;
import com.example.demo.employee.Employee;


@Controller
public class CompController 
{
	@Autowired
	CompDao dao;
	
	
	@RequestMapping("/insertcomp")
	public String insertComp(Compensation e)
	{
		if(dao.existsById(e.getEid()))
			System.out.println("sorry already employee exixts with:"+e.getEid());
		else
		    dao.save(e);
		return "home.html";
	}
	
	@RequestMapping("/displaycomp")
	@ResponseBody
	public List<Compensation> showEmployee()
	{
		return dao.findAll();
	}
	
	@RequestMapping("/updatecomp")
	public String updateComp(Compensation e)
	{
		if(dao.existsById(e.getEid()))
			dao.save(e);
		else
			System.out.println("no fields exists with:"+e.getEid());
		return "welcome.html";
	}

}
