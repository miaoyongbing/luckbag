package com.dcone.dtss.model;

public class dc_trade {
	int tid;
	int wid;
	int volume;
	String tradetime;
	String tip;
	public dc_trade() {};
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public dc_trade(int tid, int wid, int volume, String tradetime,String tip) {
		this.tid = tid;
		this.wid = wid;
		this.volume = volume;
		this.tradetime = tradetime;
		this.tip=tip;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public String getTradetime() {
		return tradetime;
	}
	public void setTradetime(String tradetime) {
		this.tradetime = tradetime;
	}
	@Override
	public String toString() {
		return "dc_trade [tid=" + tid + ", wid=" + wid + ", volume=" + volume + ", tradetime=" + tradetime + ", tip="
				+ tip + "]";
	}
	
	
}
