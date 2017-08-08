package com.dcone.dtss.dao;

import org.springframework.jdbc.core.*;

import com.dcone.dtss.model.dc_user;

public class UserDAO {
	public static dc_user getUserByUid(int uid,JdbcTemplate jdbcTemplate) {
		RowMapper<dc_user> user_mapper=new BeanPropertyRowMapper<dc_user>(dc_user.class);
		try {
			dc_user wanted=jdbcTemplate.queryForObject("select * from dc_user where uid=?;",user_mapper, new Object[] {uid});
			return wanted;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("uid错误,找不到用户!");
		}
		return null;
	}
	public static dc_user getUserByItcode(String itcode,JdbcTemplate jdbcTemplate) {
		RowMapper<dc_user> user_mapper=new BeanPropertyRowMapper<dc_user>(dc_user.class);
		try {
			dc_user wanted=jdbcTemplate.queryForObject("select * from dc_user where itcode=?;",user_mapper, new Object[] {itcode});
			return wanted;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("itcode错误,找不到用户!");
		}
		return null;
	}
	public static dc_user getUserByName(String username,JdbcTemplate jdbcTemplate) {
		RowMapper<dc_user> user_mapper=new BeanPropertyRowMapper<dc_user>(dc_user.class);
		try {
			dc_user wanted=jdbcTemplate.queryForObject("select * from dc_user where username=?;",user_mapper, new Object[] {username});
			return wanted;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("用户名错误,找不到用户!");
		}
		return null;
	}
	public static boolean checkItcodeUsername(String itcode,String username,JdbcTemplate jdbcTemplate) {
		try {
			int i=jdbcTemplate.queryForInt("select count(*) from dc_user where itcode=? or username=?;",new Object[] {itcode,username});
			if(i==0)
				return true;
			else {
				System.out.println("用户名或itcode重复！");
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("用户名和itcode不匹配！");
		}
		return false;
	}
	public static int createUser(String itcode, String username,JdbcTemplate jdbcTemplate) {
		RowMapper<dc_user> user_mapper=new BeanPropertyRowMapper<dc_user>(dc_user.class);
		try {
			if(checkUserInfo(itcode, username, jdbcTemplate)) {
				int i=jdbcTemplate.update("insert into dc_user (itcode,username) values(?,?);", user_mapper,new Object[] {itcode,username});
				if(i>0) {
					return 1;
				}
				else {
					return -2;
				}
			}
			else {
				return -1;
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("初始化失败！itcode或用户名重复！");
		}
		return 0;
	}
	
	public static boolean checkUserInfo(String itcode, String username,JdbcTemplate jdbcTemplate) {
		try {
			int i=jdbcTemplate.queryForInt("select count(*) from dc_user where itcode=? or username=?;",new Object[] {itcode,username});
			if(i==0)
				return true;
			else {
				System.out.println("用户名或itcode重复！");
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("用户名和itcode不匹配！");
		}
		return false;
	}
	/**
	 * 修改数据库,修改model,完成用户锁定
	 * @param uid
	 * @return
	 */
	public static boolean lockUserById(int uid,JdbcTemplate jdbcTemplate) {
		RowMapper<dc_user> user_mapper=new BeanPropertyRowMapper<dc_user>(dc_user.class);
		try {
			int i=jdbcTemplate.update("update dc_user set wlock = 1 where uid=?;",user_mapper, new Object[] {uid});
			if(i>0)
				return true;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("uid错误,找不到用户!");
		}
		return false;
	}
	/**
	 * 
	 * @param itcode
	 * @return
	 */
	public static boolean lockUserByItcode(String itcode,JdbcTemplate jdbcTemplate) {
		RowMapper<dc_user> user_mapper=new BeanPropertyRowMapper<dc_user>(dc_user.class);
		try {
			int i=jdbcTemplate.update("update dc_user set wlock = 1 where itcode=?;",user_mapper, new Object[] {itcode});
			if(i>0)
				return true;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("itcode错误,找不到用户!");
		}
		return false;
	}
	
	public static boolean unlockUserByID(int uid,JdbcTemplate jdbcTemplate) {
		RowMapper<dc_user> user_mapper=new BeanPropertyRowMapper<dc_user>(dc_user.class);
		try {
			int i=jdbcTemplate.update("update dc_user set wlock = 0 where uid=?;",user_mapper, new Object[] {uid});
			if(i>0)
				return true;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("uid错误,找不到用户!");
		}
		return false;
	}
	
	public static boolean unlockUserByItcode(String itcode,JdbcTemplate jdbcTemplate) {
		RowMapper<dc_user> user_mapper=new BeanPropertyRowMapper<dc_user>(dc_user.class);
		try {
			int i=jdbcTemplate.update("update dc_user set wlock = 1 where itcode=?;",user_mapper, new Object[] {itcode});
			if(i>0)
				return true;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("itcode错误,找不到用户!");
		}
		return false;
	}
	public static boolean isLock(int uid,JdbcTemplate jdbcTemplate) {
		try {
			int i=jdbcTemplate.queryForInt("select wlock from dc_user where uid=?;",new Object[] {uid});
			if(i==0)
				return true;
		}
		catch(Exception e) {
			System.out.println("查询用户状态失败！");
			e.printStackTrace();
		}
		return false;
	}
	public static boolean isLock(String itcode,JdbcTemplate jdbcTemplate) {
		dc_user user=getUserByItcode(itcode,jdbcTemplate);
		return isLock(user.getUid(),jdbcTemplate);
	}
}
