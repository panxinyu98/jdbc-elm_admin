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
		System.out.println("|\t\t\t ����ô��̨����ϵͳ \t\t\t|");
		System.out.println("---------------------------------------------------------");
		
		BusinessView businessView = new BusinessViewImpl();
		
		//��½
		Business business = businessView.login();
		
		if(business!=null) {
			int menu = 0;
			while(menu!=5) {
				System.out.println("\n----���˵�-----1.�鿴�̼���Ϣ--2.�޸��̼���Ϣ--3.��������--4.����ʳƷ����--5.�˳�------");
				System.out.println("��ѡ�����˵����ܣ�");
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
						System.out.println("-------------------- ��ӭ�´ι��� ---------------------");
						break;	
				}
			}
		}else {
			System.out.println("�û����������������");
		}
	}
	
	private void foodManager(Integer businessId) {
		Scanner input = new Scanner(System.in);
		
		FoodView foodView = new FoodViewImpl();
		
		int menu = 0;
		while(menu!=5) {
			System.out.println("\n----�����˵�----1.�鿴ʳƷ�б�--2.����ʳƷ--3.�޸�ʳƷ--4.ɾ��ʳƷ--5.�������˵�------");
			System.out.println("��ѡ������˵����ܣ�");
			menu = input.nextInt();
			switch(menu) {
				case 1:
					foodView.listFoodByBusinessId(businessId);
					break;
				case 2:
					System.out.println("����ʳƷ");
					break;
				case 3:
					System.out.println("�޸�ʳƷ");
					break;
				case 4:
					System.out.println("ɾ��ʳƷ");
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
