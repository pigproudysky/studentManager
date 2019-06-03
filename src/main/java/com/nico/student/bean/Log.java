package com.nico.student.bean;

public class Log{

	private Integer lid;
	private String ip;
	private String logintime;
	private String logouttime;
	private Integer sid;

	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getLogintime() {
		return logintime;
	}
	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}
	public String getLogouttime() {
		return logouttime;
	}
	public void setLogouttime(String logouttime) {
		this.logouttime = logouttime;
	}
	@Override
	public String toString() {
		return "Log [lid=" + lid + ", ip=" + ip + ", logintime=" + logintime + ", logouttime=" + logouttime + ", sid="
				+ sid + "]";
	}
	
	
}
