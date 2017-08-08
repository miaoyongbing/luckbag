package com.dcone.dtss;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dcone.dtss.dao.LuckyDAO;
import com.dcone.dtss.dao.WalletDAO;
import com.dcone.dtss.dao.ln_recordDAO;
import com.dcone.dtss.model.dc_wallet;
import com.dcone.dtss.model.ln_record;

import MyThead.LuckyNumberThread;
import form.WalletForm;

@Controller
public class AdminController {
	
	boolean flag = false;
	@Autowired
	JdbcTemplate template;
	
	@RequestMapping("/admin")
	public String admin() {
		//判断用户是否登录
		//登录成功后显示admin页面
		return "admin";
	}
	
	
	
	@RequestMapping("/lucky_on") 
	public String Lucky_on(String round) {
		LuckyNumberThread t = new LuckyNumberThread();
		t.setTemplate(template);
		int r = 0;
		try {
			r = Integer.parseInt(round);
		} catch (Exception e) {
			// TODO: handle exception
		}
		t.setRound(r);
		t.setFlag(true);		
		t.start();
		return "luckyon";
	}
	
	@RequestMapping("/viewrecord")
	public String viewrecord(Model model) {
		List<ln_record> wanted=ln_recordDAO.getAllRecords(template);
		String str1="",str2="",str3="",str4="";
		if(wanted!=null) {
			str1="流水号";
			str2="红包雨轮次";
			str3="用户钱包id";
			str4="红包数额";
		}
		else {
			str1="暂无红包雨相关交易记录！";
		}
		model.addAttribute("str1", str1);
		model.addAttribute("str2", str2);
		model.addAttribute("str3", str3);
		model.addAttribute("str4", str4);
		model.addAttribute("record",wanted);
		return "view_record";
	}
	
}
