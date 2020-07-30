package com.essContext.domain.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.essContext.BaseTest;
import com.essContext.controller.request.LegalPersonRequest;
import com.essContext.domain.model.LegalPerson;

public class LegalPersonServiceTest extends BaseTest{
	
	@Autowired
	LegalPersonService legalPersonService;
	
	@Test
	void should_return_success_when_register_given_leaglPersong_info() throws Exception {
		LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
		legalPersonRequest.setIdCode("2222");
		legalPersonRequest.setType("1");
		legalPersonRequest.setCompanyCode("DSDSDSDADA");
		legalPersonRequest.setCompanyName("吉林祥云");
		legalPersonRequest.setName("郭永博");
		legalPersonRequest.setIdType("111");
		
		Exception exception = assertThrows(
				Exception.class, () -> legalPersonService.register(legalPersonRequest));
		assertTrue(exception.getMessage().contains("企业核验失败"));
	}
	
	@Test
	void should_return_success_when_register_given_leaglPersong_Type() throws Exception {
		LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
		legalPersonRequest.setIdCode("2222");
		legalPersonRequest.setType("666");
		legalPersonRequest.setCompanyCode("DSDSDSDADA");
		legalPersonRequest.setCompanyName("吉林祥云");
		legalPersonRequest.setName("郭永博");
		legalPersonRequest.setIdType("111");
		
		Exception exception = assertThrows(
				Exception.class, () -> legalPersonService.register(legalPersonRequest));
		assertTrue(exception.getMessage().contains("企业类型不正确"));
	}
	
	@Test
	void should_return_success_when_register_given_leaglPersong_idType() throws Exception {
		LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
		legalPersonRequest.setIdCode("2222");
		legalPersonRequest.setType("666");
		legalPersonRequest.setCompanyCode("DSDSDSDADA");
		legalPersonRequest.setCompanyName("吉林祥云");
		legalPersonRequest.setName("郭永博");
		legalPersonRequest.setIdType("111");
		
		Exception exception = assertThrows(
				Exception.class, () -> legalPersonService.register(legalPersonRequest));
		assertTrue(exception.getMessage().contains("证件类型不正确"));
	}
	
	@Test
	void should_return_success_when_register_given_leaglPersong_isExsits() throws Exception {
		LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
		legalPersonRequest.setIdCode("2222");
		legalPersonRequest.setType("666");
		legalPersonRequest.setCompanyCode("8888");
		legalPersonRequest.setCompanyName("吉林祥云");
		legalPersonRequest.setName("郭永博");
		legalPersonRequest.setIdType("111");
		
		Exception exception = assertThrows(
				Exception.class, () -> legalPersonService.register(legalPersonRequest));
		assertTrue(exception.getMessage().contains("企业已存在,无法重复注册"));
		
	}
	
	@Test
	void should_return_success_when_register_given_leaglPersong_sync() throws Exception {
		LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
		legalPersonRequest.setIdCode("2222");
		legalPersonRequest.setType("666");
		legalPersonRequest.setCompanyCode("DSDSDSDADA");
		legalPersonRequest.setCompanyName("吉林祥云");
		legalPersonRequest.setName("郭永博");
		legalPersonRequest.setIdType("111");
		
		LegalPerson legalPerson = legalPersonService.register(legalPersonRequest);
		assertTrue(legalPerson!=null);
	}
}
