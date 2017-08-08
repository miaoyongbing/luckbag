package com.dcone.dtss.model;

public class ln_record {
	int rid;
	int wid;
	int lucky_number;
	int round;
	@Override
	public String toString() {
		return "LuckyNumberRecord [rid=" + rid + ", wid=" + wid + ", lucky_number=" + lucky_number + ", round=" + round
				+ "]";
	}
	public ln_record() {}
	public ln_record(int r_id, int wid, int luck_number, int round) {
		super();
		this.rid = r_id;
		this.wid = wid;
		this.lucky_number = luck_number;
		this.round = round;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int r_id) {
		this.rid = r_id;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public int getLucky_number() {
		return lucky_number;
	}
	public void setLucky_number(int luck_number) {
		this.lucky_number = luck_number;
	}
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	
}
