package com.dcone.dtss.dao;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.dcone.dtss.model.*;
public class ln_recordDAO {
	/**
	 * 
	 * @param round
	 * @param wallet
	 * @param number
	 * @param jdbcTemplate
	 * @return 1成功,0失败
	 */
	public static int newRecord(int round ,dc_wallet wallet,int number,JdbcTemplate jdbcTemplate) {
		try {
			int i =jdbcTemplate.update("insert into luckynumberrecord(round,wid,lucky_number) values(?,?,?);",new Object[] {round,wallet.getWid(),number});
			if(i>0)
				return 1;
		}catch(Exception e) {
			System.out.println("添加红包支付记录失败！");
			e.printStackTrace();
		}
		return 0;
	}
	public static List<ln_record> getAllRecords(JdbcTemplate jdbcTemplate) {
		RowMapper<ln_record> lnrmapper= new BeanPropertyRowMapper<ln_record>(ln_record.class);
		try {
			List<ln_record> wanted=jdbcTemplate.query("select * from luckynumberrecord;", lnrmapper);
			return wanted;
		}catch(Exception e) {
			System.out.println("获取红包记录失败！");
			e.printStackTrace();
		}
		return null;
	}
}
