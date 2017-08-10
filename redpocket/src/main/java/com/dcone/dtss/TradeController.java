package com.dcone.dtss;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dcone.dtss.dao.TradeDAO;
import com.dcone.dtss.dao.UserDAO;
import com.dcone.dtss.model.dc_trade;

@Controller
/**
 * 
 * @author wrs
 *���״��������
 */
public class TradeController {
	private static final Logger logger = LoggerFactory.getLogger(BalanceController.class);
	@Autowired
    JdbcTemplate jdbcTemplate;
	/**
	 * ��ѯĳ�콻�׼�¼
	 * @param username �û���
	 * @param itcode Ա����
	 * @param date ���ڣ���ʽ2017-2-1
	 * @param model 
	 * @return ��ѯ�������
	 */
	
	@RequestMapping(value="/trade_check")
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	public String tradeCheck(String username,String itcode,String date,Model model) {
		
		//String date1=(new SimpleDateFormat("yyyy-MM-dd")).format(date);
		String starttime=date+" 00:00:00",endtime=date+" 23:59:59";
		//UserDAO.unlockUserByItcode(itcode, jdbcTemplate);
		/*if(UserDAO.isLock(itcode, jdbcTemplate))
			System.out.println("unlock failed!");
		else
			System.out.println("unlock successed!");*/
		System.out.println("starttime is:"+starttime+" and endtime is:"+endtime);
		TradeDAO td=new TradeDAO();
		List<dc_trade> wanted=td.getTimeTradesByItcode(itcode, starttime, endtime, jdbcTemplate);
		if(wanted!=null) {
			for(dc_trade temp:wanted) 
				System.out.println(temp.toString());
			model.addAttribute("list",wanted);
			model.addAttribute("result", "��ѯ�ɹ�������������"+date+"�Ľ��׼�¼��");
			model.addAttribute("str1", "������ˮ��");
			model.addAttribute("str2", "Ǯ��id");
			model.addAttribute("str3", "ת����");
			model.addAttribute("str4", "����ʱ��");
			model.addAttribute("str5","��ע");
		}
		return "trade_check_result";
	}
}
