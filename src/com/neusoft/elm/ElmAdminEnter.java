package com.neusoft.elm;

import java.util.Scanner;

import com.neusoft.elm.po.Admin;
import com.neusoft.elm.view.AdminView;
import com.neusoft.elm.view.BusinessView;
import com.neusoft.elm.view.impl.AdminViewImpl;
import com.neusoft.elm.view.impl.BusinessViewImpl;

public class ElmAdminEnter {

	public void work() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("---------------------------------------------------------");
		System.out.println("|\t\t\t ����ô��̨����ϵͳ \t\t\t|");
		System.out.println("---------------------------------------------------------");
		
		BusinessView businessView = new BusinessViewImpl();
		AdminView adminView = new AdminViewImpl();
		
		//��½
		Admin admin = adminView.login();
		
		if(admin!=null) {
			int menu = 0;
			while(menu!=5) {
				System.out.println("\n------1.�����̼��б�--2.�����̼�--3.�½��̼�--4.ɾ���̼�--5.�˳�------");
				System.out.println("��ѡ�����˵����ܣ�");
				menu = input.nextInt();
				switch(menu) {
					case 1:
						businessView.listBusiness();
						break;
					case 2:
						businessView.listBusinessByLike();
						break;
					case 3:
						businessView.saveBusiness();
						break;
					case 4:
						businessView.removeBusinessById();
						break;
					case 5:
						System.out.println("-------------------- ��ӭ�´ι��� ---------------------");
						break;	
				}
			}
		}else {
			System.out.println("�û����������������");
		}
		
	}

	public static void main(String[] args) {
		new ElmAdminEnter().work();
	}
}
