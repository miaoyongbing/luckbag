package com.dcone.dtss;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dcone.dtss.dao.TradeDAO;
import com.dcone.dtss.dao.WalletDAO;
import com.dcone.dtss.model.dc_trade;
import com.dcone.dtss.model.dc_user;
import com.dcone.dtss.model.dc_wallet;

import form.WalletForm;

@Controller
public class BalanceController {
	
	private static final Logger logger = LoggerFactory.getLogger(BalanceController.class);
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value="/balance_add", method=RequestMethod.GET)
	public String balanceAdd() {
		return "balance_add";
	}
	@RequestMapping(value="/balance_adding")
	public String balanceAdding(@Valid WalletForm walletForm ,BindingResult bindingResult ,Locale locale,  Model model) {
		logger.info("itcode:" +walletForm.getItcode() +"username:"+walletForm.getUsername() + " ��ֵ "+ walletForm.getAmount());
		logger.info(jdbcTemplate.toString());
		String result = "";
		if (bindingResult.hasErrors()) {
			result="<br>���󣡾������£�"+"<br>";
			List<ObjectError> errors = bindingResult.getAllErrors();
			for (ObjectError error : errors) {
				result += error.getDefaultMessage() + "<br>";
			}
			System.out.println("walletform��Ϣ:"+walletForm.toString());
			model.addAttribute("msg", result);
			return "balance_add";
		} else {
			int i = WalletDAO.balance_add(walletForm.getItcode(), walletForm.getUsername(), walletForm.getAmount(),
					locale, jdbcTemplate);
			if (i == 1) {
				result = "��ֵ�ɹ�";
			} else if (i == -1 || i == -2) {
				result = "�û���Ϣ��д����!";
			} else {
				result = "��ֵʧ��,���Ժ�����!";
			}
			TradeDAO td = new TradeDAO();
			/*List<dc_trade> wanted = td.getTimeTradesByItcode(walletForm.getItcode(), "2017-08-03 10:30:00",
					"2017-08-04 00:00:00", jdbcTemplate);
			for (dc_trade temp : wanted) {
				System.out.println(temp.toString());
			}*/
			model.addAttribute("result", result);
			return "balance_add_result";
		}
	}
	
	
}