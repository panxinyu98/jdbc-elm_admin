package com.neusoft.elm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.elm.dao.FoodDao;
import com.neusoft.elm.po.Food;
import com.neusoft.elm.util.DBUtil;

public class FoodDaoImpl implements FoodDao{
	
	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	@Override
	public List<Food> listFoodByBusinessId(Integer businessId) {
		List<Food> list = new ArrayList<>();
		String sql = "select * from food where businessId=? order by foodId";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, businessId);
			rs = pst.executeQuery();
			while(rs.next()) {
				Food food = new Food();
				food.setFoodId(rs.getInt("foodId"));
				food.setFoodName(rs.getString("foodName"));
				food.setFoodExplain(rs.getString("foodExplain"));
				food.setFoodPrice(rs.getDouble("foodPrice"));
				food.setBusinessId(rs.getInt("businessId"));
				list.add(food);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, pst, con);
		}
		return list;
	}
}

