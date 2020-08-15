package com.neusoft.elm.view.impl;

import java.util.List;
import java.util.Scanner;

import com.neusoft.elm.dao.BusinessDao;
import com.neusoft.elm.dao.impl.BusinessDaoImpl;
import com.neusoft.elm.po.Business;
import com.neusoft.elm.view.BusinessView;

public class BusinessViewImpl implements BusinessView{

	@Override
	public void listBusiness() {
		BusinessDao dao = new BusinessDaoImpl();
		List<Business> list = dao.listBusiness();
		System.out.println("\n商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
		for(Business business : list) {
			System.out.println(business);
		}
	}
	@Override
	public void removeBusinessById(){
		Scanner input = new Scanner(System.in);//多态的实现方法
		BusinessDao dao = new BusinessDaoImpl();
		//先将所有商家列表用户显示出来
		listBusiness() ;
		//然后让用户从此列表中选取要删除的编号
		System.out.println("请输入要删除的商家编号：");
		int businessId = input.nextInt();
		int result=dao.removeBusinessById(businessId);
		if(result>0){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}
		
		
	}
	

	@Override
	public void listBusinessByLike() {
		Scanner input = new Scanner(System.in);
			
		String inputStr = "";
		String businessName=null;
		String businessAddress=null;
			
		System.out.println("是否输入商家名称为查询条件(y/n):");
		inputStr = input.next();
		if(inputStr.equals("y")){
		     System.out.println("输入商家名称:");
		     businessName = input.next();
		 }
		System.out.println("是否输入商家名称为查询条件(y/n):");
		inputStr = input.next();
		if(inputStr.equals("y")){
		     System.out.println("输入商家地址：");
		     businessAddress = input.next();
		 }	
		
			
		BusinessDao dao = new BusinessDaoImpl();
		List<Business> list = dao.listBusinessByLike(businessName,businessAddress);
		System.out.println("\n商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
		for(Business business : list) {
			System.out.println(business);
			}
		}
	@Override
	public void saveBusiness(){
		Scanner input = new Scanner(System.in);//多态的实现方法
		System.out.println("请输入商家名称：");
		String businessName = input.next();
		
		BusinessDao dao = new BusinessDaoImpl();
		int businessId=dao.saveBusiness(businessName);
		if(businessId>0){
			System.out.println("添加成功，商家编号为："+businessId);
		}else{
			System.out.println("添加失败");
		}
		
		
	}
	@Override
	public Business login() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("请输入商家编号:");
		int businessId = input.nextInt();
		System.out.println("请输入商家密码:");
		String password = input.next();
		
		BusinessDao dao = new BusinessDaoImpl();
		Business business = dao.getBusinessByIdByPass(businessId, password);
		return business;
	}
	
	@Override
	public Business getBusinessById(Integer businessId) {
		BusinessDao dao = new BusinessDaoImpl();
		Business business = dao.getBusinessById(businessId);
		System.out.println("商家编号："+business.getBusinessId());
		System.out.println("商家名称："+business.getBusinessName());
		System.out.println("商家地址："+business.getBusinessAddress());
		System.out.println("商家介绍："+business.getBusinessExplain());
		System.out.println("起送费："+business.getStarPrice());
		System.out.println("配送费："+business.getDeliveryPrice());
		return business;
	}
	@Override
	public void updateBusiness(Integer businessId) {
		Scanner input = new Scanner(System.in);
		
		Business business = getBusinessById(businessId);//查看当前对象
		String inputStr = "";
		
		System.out.println("是否修改商家名称(y/n)：");
		inputStr = input.next();
		if(inputStr.equals("y")) {
			System.out.println("请输入新的商家名称：");
			business.setBusinessName(input.next());
		}
		
		System.out.println("是否修改商家地址(y/n)：");
		inputStr = input.next();
		if(inputStr.equals("y")) {
			System.out.println("请输入新的商家地址：");
			business.setBusinessAddress(input.next());
		}
		
		System.out.println("是否修改商家介绍(y/n)：");
		inputStr = input.next();
		if(inputStr.equals("y")) {
			System.out.println("请输入新的商家介绍：");
			business.setBusinessExplain(input.next());
		}
		
		System.out.println("是否修改起送费(y/n)：");
		inputStr = input.next();
		if(inputStr.equals("y")) {
			System.out.println("请输入新的起送费：");
			business.setStarPrice(input.nextDouble());
		}
		
		System.out.println("是否修改配送费(y/n)：");
		inputStr = input.next();
		if(inputStr.equals("y")) {
			System.out.println("请输入新的配送费：");
			business.setDeliveryPrice(input.nextDouble());
		}
		
		BusinessDao dao = new BusinessDaoImpl();
		int result = dao.updateBusiness(business);
		if(result>0) {
			System.out.println("更新成功");
		}else {
			System.out.println("更新失败");
		}
	}
	
	@Override
	public boolean updateBusinessPassword(Integer businessId) {
		Scanner input = new Scanner(System.in);
		Business business = getBusinessById(businessId);
		System.out.println("请输入旧密码：");
		String oldPassword = input.next();
		System.out.println("请输入新密码：");
		String newPassword = input.next();
		System.out.println("请再次输入新密码：");
		String beginNewPassword = input.next();
		
		if(!(oldPassword.equals(business.getPassword()))) {
			System.out.println("旧密码输入不正确！");
			return false;
		}
		if(!(newPassword.equals(beginNewPassword))) {
			System.out.println("两次输入密码不一致！");
			return false;
		}
		
		BusinessDao dao = new BusinessDaoImpl();
		int result = dao.updateBusinessPassWord(businessId, newPassword);
		if(result>0) {
			System.out.println("更新密码成功");
		}else {
			System.out.println("更新密码失败");
		}
		return true;
	}
	
}
