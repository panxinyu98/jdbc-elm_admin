package com.neusoft.elm.view.impl;

import java.util.List;
import java.util.Scanner;

import com.neusoft.elm.dao.FoodDao;
import com.neusoft.elm.dao.impl.FoodDaoImpl;
import com.neusoft.elm.po.Food;
import com.neusoft.elm.view.FoodView;

public class FoodViewImpl implements FoodView {

	@Override
	public List<Food> listFoodByBusinessId(Integer businessId) {
		FoodDao dao = new FoodDaoImpl();
		List<Food> list = dao.listFoodByBusinessId(businessId);
		System.out.println("ʳƷ���\tʳƷ����\tʳƷ����\tʳƷ�۸�");
		for (Food food : list) {
			System.out.println(food);
		}
		return list;
	}

	@Override
	public void saveFood(Integer businessId) {
		Scanner input = new Scanner(System.in);
		Food food = new Food();
		System.out.println("������ʳƷ���ƣ�");
		food.setFoodName(input.next());
		System.out.println("������ʳƷ���ܣ�");
		food.setFoodExplain(input.next());
		System.out.println("������ʳƷ�۸�");
		food.setFoodPrice(input.nextDouble());

		FoodDao dao = new FoodDaoImpl();
		food.setBusinessId(businessId);
		int result = dao.saveFood(food);
		if (result > 0) {
			System.out.println("��ӳɹ�");
		} else {
			System.out.println("���ʧ��");
		}
	}

	@Override
	public void removeFood(Integer businessId) {
		Scanner input = new Scanner(System.in);
		listFoodByBusinessId(businessId);
		System.out.println("������Ҫɾ����ʳƷ��ţ�");
		int foodId = input.nextInt();
		FoodDao dao = new FoodDaoImpl();
		System.out.println("��ȷ��Ҫɾ����(y/n)��");
		String inputStr = input.next();
		if (inputStr.equals("y")) {
			int result = dao.removeFoodById(foodId);
			if (result > 0) {
				System.out.println("ɾ���ɹ�");
			} else {
				System.out.println("ɾ��ʧ��");
			}
		}
	}
	
	@Override
	public boolean updateFood(Integer businessId) {
		FoodDao dao = new FoodDaoImpl();
		Scanner input = new Scanner(System.in);
		
		List<Food> list = listFoodByBusinessId(businessId);
		if(list.size()<=0) {
			System.out.println("û���κ�ʳƷ");
			return false;
		}
		
		System.out.println("������Ҫ���µ�ʳƷ��ţ�");
		int foodId = input.nextInt();
		
		Food food = dao.getFoodById(foodId);
		System.out.println("ʳƷ��ţ�"+food.getFoodId());
		System.out.println("ʳƷ���ƣ�"+food.getFoodName());
		System.out.println("ʳƷ���ܣ�"+food.getFoodExplain());
		System.out.println("ʳƷ�۸�"+food.getFoodPrice());
		String inputStr = "";
		
		System.out.println("�Ƿ����ʳƷ����(y/n)��");
		inputStr = input.next();
		if(inputStr.equals("y")) {
			System.out.println("������ʳƷ���ƣ�");
			food.setFoodName(input.next());
		}
		
		System.out.println("�Ƿ����ʳƷ����(y/n)��");
		inputStr = input.next();
		if(inputStr.equals("y")) {
			System.out.println("������ʳƷ���ܣ�");
			food.setFoodExplain(input.next());
		}
		
		System.out.println("�Ƿ����ʳƷ�۸�(y/n)��");
		inputStr = input.next();
		if(inputStr.equals("y")) {
			System.out.println("������ʳƷ�۸�");
			food.setFoodPrice(input.nextDouble());
		}
		
		int result = dao.updateFood(food);
		if (result > 0) {
			System.out.println("���³ɹ�");
		} else {
			System.out.println("����ʧ��");
		}
		return true;
	}
}
