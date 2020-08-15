package com.neusoft.elm.view.impl;

import java.util.List;

import com.neusoft.elm.dao.FoodDao;
import com.neusoft.elm.dao.impl.FoodDaoImpl;
import com.neusoft.elm.po.Food;
import com.neusoft.elm.view.FoodView;

public class FoodViewImpl implements FoodView{

	@Override
	public void listFoodByBusinessId(Integer businessId) {
		FoodDao dao = new FoodDaoImpl();
		List<Food> list = dao.listFoodByBusinessId(businessId);
		System.out.println("食品编号\t食品名称\t食品介绍\t食品价格");
		for(Food food : list) {
			System.out.println(food);
		}
	}
}
