package com.dcone.dtss.model;

public class dc_user {
	int uid;
	String itcode;
	String username;
	int wlock;
	public dc_user() {}
	public dc_user(int uid, String itcode,String username,int wlock) {
		this.uid = uid;
		this.itcode = itcode;
		this.username = username;
		this.wlock=wlock;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getItcode() {
		return itcode;
	}
	public int getWlock() {
		return wlock;
	}
	public void setWlock(int wlock) {
		this.wlock = wlock;
	}
	public void setItcode(String itcode) {
		this.itcode = itcode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "dc_user [uid=" + uid + ", itcode=" + itcode + ", username=" + username + ",wlock" + wlock + "]";
	}
	
	
	
}
