package com.neusoft.elm.view;

import com.neusoft.elm.po.Business;

public interface BusinessView {

	public void listBusiness();
	public void removeBusinessById();
	public void listBusinessByLike();
	public void saveBusiness();
	
	public Business login();//password and id
	public Business getBusinessById(Integer businessId);
	public void updateBusiness(Integer businessId);
	public boolean updateBusinessPassword(Integer businessId);
	
	
	
}


