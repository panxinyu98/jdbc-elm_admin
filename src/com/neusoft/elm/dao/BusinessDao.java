package com.neusoft.elm.dao;

import java.util.List;

import com.neusoft.elm.po.Business;

public interface BusinessDao {

	public List<Business> listBusiness();
	public int removeBusinessById(Integer businessId);  
	public List<Business> listBusinessByLike(String businessName,String businessAddress);
    public int saveBusiness(String businessName);

    public Business getBusinessByIdByPass(Integer businessId,String password);
	public Business getBusinessById(Integer businessId);
	public int updateBusiness(Business business);
	public int updateBusinessPassWord(Integer businessId,String password);
	
	
	
}