package com.dcone.dtss.dao;

import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.dcone.dtss.model.*;

public class TradeDAO {
	public List<dc_trade> getTradesByUid(int uid,JdbcTemplate jdbcTemplate){
		RowMapper<dc_trade> trade_mapper=new BeanPropertyRowMapper<dc_trade>(dc_trade.class);
		try {
			dc_wallet wallet= WalletDAO.getWalletByUid(uid, jdbcTemplate);
			List<dc_trade> wanted=jdbcTemplate.query("select * from dc_trade where wid=?;", trade_mapper,new Object[] {wallet.getWid()});
			return wanted;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("uid错误,找不到用户!");
		}
		return null;
	}
	public List<dc_trade> getTradesByItcode(String itcode,JdbcTemplate jdbcTemplate){
		dc_user user=UserDAO.getUserByItcode(itcode, jdbcTemplate);
		return getTradesByUid(user.getUid(), jdbcTemplate);
	}
	public List<dc_trade> getTradesByUser(String username,JdbcTemplate jdbcTemplate){
		dc_user user=UserDAO.getUserByName(username, jdbcTemplate);
		return getTradesByUid(user.getUid(), jdbcTemplate);
	}
	public List<dc_trade> getTimeTradesByUid(int uid,String start,String end,JdbcTemplate jdbcTemplate){
		RowMapper<dc_trade> trade_mapper=new BeanPropertyRowMapper<dc_trade>(dc_trade.class);
		try {
			dc_wallet wallet= WalletDAO.getWalletByUid(uid, jdbcTemplate);
			List<dc_trade> wanted=jdbcTemplate.query("select * from dc_trade where wid=? and tradetime>? and tradetime<?;", trade_mapper,new Object[] {wallet.getWid(),start,end});
			int i=0;
			System.out.println("start is "+start+",end is "+end);
			for(dc_trade temp:wanted) {
				System.out.println("i is "+i);
				i++;
				temp.toString();
			}
			return wanted;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("uid错误,找不到用户相关交易记录!");
		}
		return null;
	}
	public List<dc_trade> getTimeTradesByItcode(String itcode,String start,String end,JdbcTemplate jdbcTemplate){
		dc_user user=UserDAO.getUserByItcode(itcode, jdbcTemplate);
		return getTimeTradesByUid(user.getUid(),start,end, jdbcTemplate);
	}
	public List<dc_trade> getTimeTradesByUser(String username,String start,String end,JdbcTemplate jdbcTemplate){
		dc_user user=UserDAO.getUserByName(username, jdbcTemplate);
		return getTimeTradesByUid(user.getUid(),start,end, jdbcTemplate);
	}
	/**
	 * 判定交易是否能够进行
	 * @return
	 */
	
	private static boolean preTrade(int wid,int amount,JdbcTemplate jdbcTemplate) {
		RowMapper<dc_wallet> wallet_mapper=new BeanPropertyRowMapper<dc_wallet>(dc_wallet.class);
		try {
			dc_wallet wanted=jdbcTemplate.queryForObject("select * from dc_wallet where wid=?;", wallet_mapper,new Object[] {wid});
			if(wanted.getAmount()>=amount)
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("wid错误,找不到用户钱包!");
		}
		return false;
	}
	
	public static boolean createTrade(int wid1,int wid2, int amount, String date , String memo,JdbcTemplate jdbcTemplate) {
		if(preTrade(wid1,amount, jdbcTemplate)) {
			//写入交易数据
			int i=jdbcTemplate.update("insert into dc_trade(wid,volume,tradetime,tip) values(?,?,?,?)",new Object[] {wid2,amount,date,memo});
			if(i>0) {
				i=jdbcTemplate.update("insert into dc_trade(wid,volume,tradetime,tip) values(?,?,?,?)",new Object[] {wid1,amount,date,"转出钱:"+memo});
				i=jdbcTemplate.update("update dc_wallet set amount=amount-? where wid =?;",new Object[] {amount,wid1});
				i=jdbcTemplate.update("update dc_wallet set amount=amount+? where wid =?;",new Object[] {amount,wid2});
				if(i>0)
					return true;
			}
		}
		return false;
	}
	public static int createTrade(int wid,int lucknumber, String time, String tip,JdbcTemplate jdbcTemplate) {
		
		return 0;
	}
}
