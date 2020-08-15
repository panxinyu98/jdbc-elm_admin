package com.neusoft.elm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.elm.dao.BusinessDao;
import com.neusoft.elm.po.Business;
import com.neusoft.elm.util.DBUtil;

public class BusinessDaoImpl implements BusinessDao{

	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	@Override
	public List<Business> listBusiness(){
		List<Business> list = new ArrayList<>();
		String sql = "select * from business order by businessId";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				Business business = new Business();
				business.setBusinessId(rs.getInt("businessId"));
				business.setPassword(rs.getString("password"));
				business.setBusinessName(rs.getString("businessName"));
				business.setBusinessExplain(rs.getString("businessExplain"));
				business.setBusinessAddress(rs.getString("businessAddress"));
				business.setStarPrice(rs.getDouble("starPrice"));
				business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
				list.add(business);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, pst, con);
		}
		return list;
	}
	@Override
	public int removeBusinessById(Integer businessId){
		
		int result=0;
		String sql = "delete from business where businessId=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, businessId);
			result = pst.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(null, pst, con);
		}
		return result;
	}
	@Override
	public List<Business> listBusinessByLike(String businessName,String businessAddress){
		List<Business> list = new ArrayList<>();
		StringBuffer sql =new  StringBuffer("select * from business where 1=1");
		if(businessName!=null&&!businessName.equals("")){//判断一个字符串是否为空
		     sql.append(" and businessName like '%"+businessName+"%' ");
	
		}
		if(businessAddress!=null&&!businessAddress.equals("")){//判断一个字符串是否为空
		     sql.append(" and businessAddress like '%"+businessAddress+"%' ");
	
		}
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql.toString());
			rs = pst.executeQuery();
			while(rs.next()) {
				Business business = new Business();
				business.setBusinessId(rs.getInt("businessId"));
				business.setPassword(rs.getString("password"));
				business.setBusinessName(rs.getString("businessName"));
				business.setBusinessExplain(rs.getString("businessExplain"));
				business.setBusinessAddress(rs.getString("businessAddress"));
				business.setStarPrice(rs.getDouble("starPrice"));
				business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
				list.add(business);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, pst, con);
		}
		return list;
	}
	@Override
	public int saveBusiness(String businessName){
		
		int businessId=0;
		String sql = "insert into business(password,businessName) values('123',?)";
		try {
			con = DBUtil.getConnection();
			//使用PreparedStatement.RETURN_GENERATED_KEYS，设置返回自增长率主键
			pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);//常量=1，设置返回主键
			pst.setString(1, businessName);
		    pst.executeUpdate();
		    //返回接受的主键(只有一行一列)
		    rs=pst.getGeneratedKeys();
		    if(rs.next()){
		    	businessId = rs.getInt(1);
		    }
		    	
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, pst, con);
		}
		return businessId;
	}
	@Override
	public Business getBusinessByIdByPass(Integer businessId, String password) {
		Business business = null;
		String sql = "select * from business where businessId=? and password=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, businessId);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()) {
				business = new Business();
				business.setBusinessId(rs.getInt("businessId"));
				business.setPassword(rs.getString("password"));
				business.setBusinessName(rs.getString("businessName"));
				business.setBusinessExplain(rs.getString("businessExplain"));
				business.setBusinessAddress(rs.getString("businessAddress"));
				business.setStarPrice(rs.getDouble("starPrice"));
				business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, pst, con);
		}
		return business;
	}
	
	@Override
	public Business getBusinessById(Integer businessId) {
		Business business = null;
		String sql = "select * from business where businessId=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, businessId);
			rs = pst.executeQuery();
			if(rs.next()) {
				business = new Business();
				business.setBusinessId(rs.getInt("businessId"));
				business.setPassword(rs.getString("password"));
				business.setBusinessName(rs.getString("businessName"));
				business.setBusinessExplain(rs.getString("businessExplain"));
				business.setBusinessAddress(rs.getString("businessAddress"));
				business.setStarPrice(rs.getDouble("starPrice"));
				business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, pst, con);
		}
		return business;
	}
	
	@Override
	public int updateBusiness(Business business) {
		int result = 0;
		String sql = "update business set businessName=?,businessAddress=?,businessExplain=?,starPrice=?,deliveryPrice=? where businessId=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, business.getBusinessName());
			pst.setString(2, business.getBusinessAddress());
			pst.setString(3, business.getBusinessExplain());
			pst.setDouble(4, business.getStarPrice());
			pst.setDouble(5, business.getDeliveryPrice());
			pst.setInt(6, business.getBusinessId());
			result = pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(null, pst, con);
		}
		return result;
	}
	@Override
	public int updateBusinessPassWord(Integer businessId, String password) {
		int result = 0;
		String sql = "update business set password=? where businessId=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, password);
			pst.setInt(2, businessId);
			result = pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(null, pst, con);
		}
		return result;
	}
}

