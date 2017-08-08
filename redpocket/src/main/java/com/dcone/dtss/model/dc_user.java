package com.dcone.dtss.model;
/**
 * 
 * @author wrs
 *记录用户
 */
public class dc_user {
	int uid;
	String itcode;
	String username;
	int wlock;
	public dc_user() {}
	/**
	 * 
	 * @param uid 用户id
	 * @param itcode 用户员工号
	 * @param username 用户名
	 * @param wlock 用户钱包是否被锁定
	 */
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
	/**
	 * 串行输出
	 */
	@Override
	public String toString() {
		return "dc_user [uid=" + uid + ", itcode=" + itcode + ", username=" + username + ",wlock" + wlock + "]";
	}
	
	
	
}
