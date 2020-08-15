package com.neusoft.elm.view.impl;

import java.util.Scanner;

import com.neusoft.elm.dao.AdminDao;
import com.neusoft.elm.dao.impl.AdminDaoImpl;
import com.neusoft.elm.po.Admin;
import com.neusoft.elm.view.AdminView;

public class AdminViewImpl implements AdminView{

	@Override
	public Admin login() {
		Scanner input = new Scanner(System.in);
		//获取客户提交参数
		System.out.println("请输入用户名：");
		String adminName = input.next();
		System.out.println("请输入密码：");
		String password = input.next();
		//根据提交参数做业务处理
		AdminDao dao = new AdminDaoImpl();
		Admin admin = dao.getAdminByNameByPass(adminName, password);
		//输出业务返回结果
		return admin;
	}
}

