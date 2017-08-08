package com.dcone.dtss.model;

public class dc_user_wallet {
	private int uid;
	private String itcode;
	private String username;
	private int amount;
	public dc_user_wallet() {}
	public dc_user_wallet(int uid, String itcode, String username, int amount) {
		this.uid = uid;
		this.itcode = itcode;
		this.username = username;
		this.amount = amount;
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
	public void setItcode(String itcode) {
		this.itcode = itcode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "dc_user_wallet [uid=" + uid + ", itcode=" + itcode + ", username=" + username + ", amount=" + amount
				+ "]";
	}
}
