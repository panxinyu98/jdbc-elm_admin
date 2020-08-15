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
		System.out.println("|\t\t\t 饿了么后台管理系统 \t\t\t|");
		System.out.println("---------------------------------------------------------");
		
		BusinessView businessView = new BusinessViewImpl();
		AdminView adminView = new AdminViewImpl();
		
		//登陆
		Admin admin = adminView.login();
		
		if(admin!=null) {
			int menu = 0;
			while(menu!=5) {
				System.out.println("\n------1.所有商家列表--2.搜索商家--3.新建商家--4.删除商家--5.退出------");
				System.out.println("请选择主菜单功能：");
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
						System.out.println("-------------------- 欢迎下次光临 ---------------------");
						break;	
				}
			}
		}else {
			System.out.println("用户名或密码输入错误！");
		}
		
	}

	public static void main(String[] args) {
		new ElmAdminEnter().work();
	}
}
