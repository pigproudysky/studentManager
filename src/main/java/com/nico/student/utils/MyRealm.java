package com.nico.student.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.nico.student.bean.Student;
import com.nico.student.service.StudentService;

public class MyRealm extends AuthorizingRealm{

	@Autowired
	private StudentService service;
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		Student stu = this.login((String)token.getPrincipal());
		AuthenticationInfo info = null;
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		if(null != stu){
			session.setAttribute("stu", stu);
			info = new SimpleAuthenticationInfo(stu.getName(),stu.getPassword(),super.getName());
		}
		return info;
	}
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Student stu = this.login((String)principals.getPrimaryPrincipal());
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		Student result = (Student)session.getAttribute("stu");
		List<String> lst = new ArrayList<String>();
		lst.add("1");
		info.addRoles(lst);
		return info;
	}
	
	private Student login(String account){
		Student stu = service.login(account);
		return stu;
	}

}
