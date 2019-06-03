package com.nico.student.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nico.student.bean.Account;
import com.nico.student.service.AccountService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nico.student.bean.Log;
import com.nico.student.bean.Student;
import com.nico.student.service.LogService;
import com.nico.student.service.StudentService;

@RestController
@RequestMapping("/stu")
public class StudentController {
	
	@Autowired
	private StudentService service;
	@Autowired
	private LogService logService;
	@Autowired
	private AccountService accService;
	
	@RequestMapping("/login")
	public String login(String name,String password,HttpServletRequest rs){
		UsernamePasswordToken token = new UsernamePasswordToken(name, password);
		Subject subject = SecurityUtils.getSubject();
		boolean bool = false;
		try {
			subject.login(token);
		} catch (UnknownAccountException uae) {
			return "0";
		} catch (IncorrectCredentialsException lae) {
			return "-1";
		} finally{
			bool = subject.isAuthenticated();
			if(bool) {
				Log log = new Log();
				log.setLogintime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
				Student stu = (Student)SecurityUtils.getSubject().getSession().getAttribute("stu");
				log.setSid(stu.getId());
				log.setIp(rs.getRemoteAddr());
				logService.loginSave(log);
				Subject subject2 = SecurityUtils.getSubject();
				subject2.getSession().setAttribute("log", log);
			}
		}
		return "1";
	}
	
	@RequestMapping("/list")
	public Map<String, Object> getAll(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", (page - 1) * limit);
		map.put("limit", limit);
		Student stu = (Student)SecurityUtils.getSubject().getSession().getAttribute("stu");
		map.put("name", stu.getName());
		List<Student> userLst = service.getAll(map);
		List<Account> accs = accService.getAll();
		for(Student st:userLst){
			for(Account acc:accs){
				if(st.getId() == acc.getSid()){
					st.setAmount(acc.getAmount());
					st.setIntegral(acc.getIntegral());
				}
			}
		}
		int count = service.getAllCount(map);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("code", 0);
		resultMap.put("msg", "");
		resultMap.put("count", count);
		resultMap.put("data", userLst);
		return resultMap;
	}

	@RequestMapping("/add")
	public String addUser(Student stu2,HttpServletRequest rs){
		Student result = service.checkName(stu2);
		if(null != result) {
			return "-1";
		}
		int flag = service.add(stu2);
		if( 0 < flag){
			UsernamePasswordToken token = new UsernamePasswordToken(stu2.getName(), stu2.getPassword());
			Subject subject = SecurityUtils.getSubject();
			boolean bool = false;
			try {
				subject.login(token);
			} catch (UnknownAccountException uae) {
				return "0";
			} catch (IncorrectCredentialsException lae) {
				return "-1";
			} finally{
				bool = subject.isAuthenticated();
				if(bool) {
					Log log = new Log();
					log.setLogintime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
					Student stu = (Student)SecurityUtils.getSubject().getSession().getAttribute("stu");
					log.setSid(stu.getId());
					log.setIp(rs.getRemoteAddr());
					logService.loginSave(log);
					Subject subject2 = SecurityUtils.getSubject();
					subject2.getSession().setAttribute("log", log);
				}
			}
		}
 		return String.valueOf(flag);
	}
	
	@RequestMapping("/edit")
	public String edit(Student stu){
		Student result = service.checkName(stu);
		if(result.getId() != stu.getId()) {
			return "-1";
		}else if(result.getId() == stu.getId()) {
			int flag = service.edit(stu);
			if(1 == flag) {
				return "1";
			}
		}
		return "0";
	}
	
	@RequestMapping("/logout")
	public void logout(HttpServletRequest rs , HttpServletResponse resp) throws IOException{
		Subject subject = SecurityUtils.getSubject();
		Log log = (Log)subject.getSession().getAttribute("log");
		log.setLogouttime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		logService.logoutSave(log);
		subject.logout();
		resp.sendRedirect(rs.getContextPath() + "/login.jsp");
	}



	
}
