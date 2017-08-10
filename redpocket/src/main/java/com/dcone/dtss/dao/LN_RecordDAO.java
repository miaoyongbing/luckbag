package com.dcone.dtss.dao;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.dcone.dtss.model.*;
/**
 * 
 * @author wrs
 *���������¼����
 */
public class LN_RecordDAO {
	/**
	 * �����������¼
	 * @param round ������ִ�
	 * @param wallet �û�Ǯ��
	 * @param number �������
	 * @param jdbcTemplate
	 * @param time  ����ʱ��
	 * @return 1�ɹ�,0ʧ��
	 */
	public static int newRecord(int round ,dc_wallet wallet,int number,String time,JdbcTemplate jdbcTemplate) {
		try {
			int i =jdbcTemplate.update("insert into luckynumberrecord(round,wid,lucky_number,tradetime) values(?,?,?,?);",new Object[] {round,wallet.getWid(),number,time});
			if(i>0)
				return 1;
		}catch(Exception e) {
			System.out.println("���Ӻ��֧����¼ʧ�ܣ�");
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * ��ȡȫ�������¼
	 * @param jdbcTemplate
	 * @return ȫ�������¼
	 */
	public static List<ln_record> getAllRecords(JdbcTemplate jdbcTemplate) {
		RowMapper<ln_record> lnrmapper= new BeanPropertyRowMapper<ln_record>(ln_record.class);
		try {
			List<ln_record> wanted=jdbcTemplate.query("select * from luckynumberrecord;", lnrmapper);
			return wanted;
		}catch(Exception e) {
			System.out.println("��ȡ�����¼ʧ�ܣ�");
			e.printStackTrace();
		}
		return null;
	}
}