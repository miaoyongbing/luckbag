package com.dcone.dtss.model;

public class dc_wallet {
	int uid;
	int wid;
	int amount;
	public dc_wallet() {}
	public dc_wallet(int uid, int wid,int amount) {
		this.uid = uid;
		this.wid = wid;
		this.amount = amount;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "dc_wallet [uid=" + uid + ", wid=" + wid + ", amount=" + amount + "]";
	}
	
	
	
}
