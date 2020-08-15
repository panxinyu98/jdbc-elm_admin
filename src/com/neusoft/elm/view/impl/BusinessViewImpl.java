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
		System.out.println("\n�̼ұ��\t�̼�����\t�̼ҵ�ַ\t�̼ҽ���\t���ͷ�\t���ͷ�");
		for(Business business : list) {
			System.out.println(business);
		}
	}
	@Override
	public void removeBusinessById(){
		Scanner input = new Scanner(System.in);//��̬��ʵ�ַ���
		BusinessDao dao = new BusinessDaoImpl();
		//�Ƚ������̼��б��û���ʾ����
		listBusiness() ;
		//Ȼ�����û��Ӵ��б���ѡȡҪɾ���ı��
		System.out.println("������Ҫɾ�����̼ұ�ţ�");
		int businessId = input.nextInt();
		int result=dao.removeBusinessById(businessId);
		if(result>0){
			System.out.println("ɾ���ɹ�");
		}else{
			System.out.println("ɾ��ʧ��");
		}
		
		
	}
	

	@Override
	public void listBusinessByLike() {
		Scanner input = new Scanner(System.in);
			
		String inputStr = "";
		String businessName=null;
		String businessAddress=null;
			
		System.out.println("�Ƿ������̼�����Ϊ��ѯ����(y/n):");
		inputStr = input.next();
		if(inputStr.equals("y")){
		     System.out.println("�����̼�����:");
		     businessName = input.next();
		 }
		System.out.println("�Ƿ������̼�����Ϊ��ѯ����(y/n):");
		inputStr = input.next();
		if(inputStr.equals("y")){
		     System.out.println("�����̼ҵ�ַ��");
		     businessAddress = input.next();
		 }	
		
			
		BusinessDao dao = new BusinessDaoImpl();
		List<Business> list = dao.listBusinessByLike(businessName,businessAddress);
		System.out.println("\n�̼ұ��\t�̼�����\t�̼ҵ�ַ\t�̼ҽ���\t���ͷ�\t���ͷ�");
		for(Business business : list) {
			System.out.println(business);
			}
		}
	@Override
	public void saveBusiness(){
		Scanner input = new Scanner(System.in);//��̬��ʵ�ַ���
		System.out.println("�������̼����ƣ�");
		String businessName = input.next();
		
		BusinessDao dao = new BusinessDaoImpl();
		int businessId=dao.saveBusiness(businessName);
		if(businessId>0){
			System.out.println("��ӳɹ����̼ұ��Ϊ��"+businessId);
		}else{
			System.out.println("���ʧ��");
		}
		
		
	}
	@Override
	public Business login() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("�������̼ұ��:");
		int businessId = input.nextInt();
		System.out.println("�������̼�����:");
		String password = input.next();
		
		BusinessDao dao = new BusinessDaoImpl();
		Business business = dao.getBusinessByIdByPass(businessId, password);
		return business;
	}
	
	@Override
	public Business getBusinessById(Integer businessId) {
		BusinessDao dao = new BusinessDaoImpl();
		Business business = dao.getBusinessById(businessId);
		System.out.println("�̼ұ�ţ�"+business.getBusinessId());
		System.out.println("�̼����ƣ�"+business.getBusinessName());
		System.out.println("�̼ҵ�ַ��"+business.getBusinessAddress());
		System.out.println("�̼ҽ��ܣ�"+business.getBusinessExplain());
		System.out.println("���ͷѣ�"+business.getStarPrice());
		System.out.println("���ͷѣ�"+business.getDeliveryPrice());
		return business;
	}
	@Override
	public void updateBusiness(Integer businessId) {
		Scanner input = new Scanner(System.in);
		
		Business business = getBusinessById(businessId);//�鿴��ǰ����
		String inputStr = "";
		
		System.out.println("�Ƿ��޸��̼�����(y/n)��");
		inputStr = input.next();
		if(inputStr.equals("y")) {
			System.out.println("�������µ��̼����ƣ�");
			business.setBusinessName(input.next());
		}
		
		System.out.println("�Ƿ��޸��̼ҵ�ַ(y/n)��");
		inputStr = input.next();
		if(inputStr.equals("y")) {
			System.out.println("�������µ��̼ҵ�ַ��");
			business.setBusinessAddress(input.next());
		}
		
		System.out.println("�Ƿ��޸��̼ҽ���(y/n)��");
		inputStr = input.next();
		if(inputStr.equals("y")) {
			System.out.println("�������µ��̼ҽ��ܣ�");
			business.setBusinessExplain(input.next());
		}
		
		System.out.println("�Ƿ��޸����ͷ�(y/n)��");
		inputStr = input.next();
		if(inputStr.equals("y")) {
			System.out.println("�������µ����ͷѣ�");
			business.setStarPrice(input.nextDouble());
		}
		
		System.out.println("�Ƿ��޸����ͷ�(y/n)��");
		inputStr = input.next();
		if(inputStr.equals("y")) {
			System.out.println("�������µ����ͷѣ�");
			business.setDeliveryPrice(input.nextDouble());
		}
		
		BusinessDao dao = new BusinessDaoImpl();
		int result = dao.updateBusiness(business);
		if(result>0) {
			System.out.println("���³ɹ�");
		}else {
			System.out.println("����ʧ��");
		}
	}
	
	@Override
	public boolean updateBusinessPassword(Integer businessId) {
		Scanner input = new Scanner(System.in);
		Business business = getBusinessById(businessId);
		System.out.println("����������룺");
		String oldPassword = input.next();
		System.out.println("�����������룺");
		String newPassword = input.next();
		System.out.println("���ٴ����������룺");
		String beginNewPassword = input.next();
		
		if(!(oldPassword.equals(business.getPassword()))) {
			System.out.println("���������벻��ȷ��");
			return false;
		}
		if(!(newPassword.equals(beginNewPassword))) {
			System.out.println("�����������벻һ�£�");
			return false;
		}
		
		BusinessDao dao = new BusinessDaoImpl();
		int result = dao.updateBusinessPassWord(businessId, newPassword);
		if(result>0) {
			System.out.println("��������ɹ�");
		}else {
			System.out.println("��������ʧ��");
		}
		return true;
	}
	
}
