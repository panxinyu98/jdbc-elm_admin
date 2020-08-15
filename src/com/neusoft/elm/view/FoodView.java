package com.neusoft.elm.view;

import java.util.List;

import com.neusoft.elm.po.Food;

public interface FoodView {

	public List<Food> listFoodByBusinessId(Integer businessId);
	public void saveFood(Integer businessId);
	public void removeFood(Integer businessId);
	public boolean updateFood(Integer businessId);
	
	
}
