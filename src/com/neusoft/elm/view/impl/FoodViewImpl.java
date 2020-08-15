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
		System.out.println("食品编号\t食品名称\t食品介绍\t食品价格");
		for (Food food : list) {
			System.out.println(food);
		}
		return list;
	}

	@Override
	public void saveFood(Integer businessId) {
		Scanner input = new Scanner(System.in);
		Food food = new Food();
		System.out.println("请输入食品名称：");
		food.setFoodName(input.next());
		System.out.println("请输入食品介绍：");
		food.setFoodExplain(input.next());
		System.out.println("请输入食品价格：");
		food.setFoodPrice(input.nextDouble());

		FoodDao dao = new FoodDaoImpl();
		food.setBusinessId(businessId);
		int result = dao.saveFood(food);
		if (result > 0) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}
	}

	@Override
	public void removeFood(Integer businessId) {
		Scanner input = new Scanner(System.in);
		listFoodByBusinessId(businessId);
		System.out.println("请输入要删除的食品编号：");
		int foodId = input.nextInt();
		FoodDao dao = new FoodDaoImpl();
		System.out.println("请确认要删除吗(y/n)？");
		String inputStr = input.next();
		if (inputStr.equals("y")) {
			int result = dao.removeFoodById(foodId);
			if (result > 0) {
				System.out.println("删除成功");
			} else {
				System.out.println("删除失败");
			}
		}
	}
	
	@Override
	public boolean updateFood(Integer businessId) {
		FoodDao dao = new FoodDaoImpl();
		Scanner input = new Scanner(System.in);
		
		List<Food> list = listFoodByBusinessId(businessId);
		if(list.size()<=0) {
			System.out.println("没有任何食品");
			return false;
		}
		
		System.out.println("请输入要更新的食品编号：");
		int foodId = input.nextInt();
		
		Food food = dao.getFoodById(foodId);
		System.out.println("食品编号："+food.getFoodId());
		System.out.println("食品名称："+food.getFoodName());
		System.out.println("食品介绍："+food.getFoodExplain());
		System.out.println("食品价格："+food.getFoodPrice());
		String inputStr = "";
		
		System.out.println("是否更新食品名称(y/n)：");
		inputStr = input.next();
		if(inputStr.equals("y")) {
			System.out.println("请输入食品名称：");
			food.setFoodName(input.next());
		}
		
		System.out.println("是否更新食品介绍(y/n)：");
		inputStr = input.next();
		if(inputStr.equals("y")) {
			System.out.println("请输入食品介绍：");
			food.setFoodExplain(input.next());
		}
		
		System.out.println("是否更新食品价格(y/n)：");
		inputStr = input.next();
		if(inputStr.equals("y")) {
			System.out.println("请输入食品价格：");
			food.setFoodPrice(input.nextDouble());
		}
		
		int result = dao.updateFood(food);
		if (result > 0) {
			System.out.println("更新成功");
		} else {
			System.out.println("更新失败");
		}
		return true;
	}
}
