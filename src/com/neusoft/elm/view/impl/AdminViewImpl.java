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
		//��ȡ�ͻ��ύ����
		System.out.println("�������û�����");
		String adminName = input.next();
		System.out.println("���������룺");
		String password = input.next();
		//�����ύ������ҵ����
		AdminDao dao = new AdminDaoImpl();
		Admin admin = dao.getAdminByNameByPass(adminName, password);
		//���ҵ�񷵻ؽ��
		return admin;
	}
}

