package com.neusoft.elm;

import java.util.Scanner;

import com.neusoft.elm.po.Admin;
import com.neusoft.elm.po.Business;
import com.neusoft.elm.view.AdminView;
import com.neusoft.elm.view.BusinessView;
import com.neusoft.elm.view.FoodView;
import com.neusoft.elm.view.impl.AdminViewImpl;
import com.neusoft.elm.view.impl.BusinessViewImpl;
import com.neusoft.elm.view.impl.FoodViewImpl;

public class ElmBusinessEnter {
	
	public void work() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("---------------------------------------------------------");
		System.out.println("|\t\t\t 饿了么后台管理系统 \t\t\t|");
		System.out.println("---------------------------------------------------------");
		
		BusinessView businessView = new BusinessViewImpl();
		
		//登陆
		Business business = businessView.login();
		
		if(business!=null) {
			int menu = 0;
			while(menu!=5) {
				System.out.println("\n----主菜单-----1.查看商家信息--2.修改商家信息--3.更新密码--4.所属食品管理--5.退出------");
				System.out.println("请选择主菜单功能：");
				menu = input.nextInt();
				switch(menu) {
					case 1:
						businessView.getBusinessById(business.getBusinessId());
						break;
					case 2:
						businessView.updateBusiness(business.getBusinessId());
						break;
					case 3:
						businessView.updateBusinessPassword(business.getBusinessId());
						break;
					case 4:
						foodManager(business.getBusinessId());
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
	
	private void foodManager(Integer businessId) {
		Scanner input = new Scanner(System.in);
		
		FoodView foodView = new FoodViewImpl();
		
		int menu = 0;
		while(menu!=5) {
			System.out.println("\n----二级菜单----1.查看食品列表--2.新增食品--3.修改食品--4.删除食品--5.返回主菜单------");
			System.out.println("请选择二级菜单功能：");
			menu = input.nextInt();
			switch(menu) {
				case 1:
					foodView.listFoodByBusinessId(businessId);
					break;
				case 2:
					System.out.println("新增食品");
					break;
				case 3:
					System.out.println("修改食品");
					break;
				case 4:
					System.out.println("删除食品");
					break;
				case 5:
					break;	
			}
		}
	}
	
	public static void main(String[] args) {
		new ElmBusinessEnter().work();
	}
}
