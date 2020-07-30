package com.essContext.domain.service;

import com.essContext.controller.request.LegalPersonRequest;
import com.essContext.domain.model.LegalPerson;
import com.essContext.domain.repository.LegalPersonRepository;

import lombok.NonNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LegalPersonService {
    @Autowired
    LegalPersonRepository legalPersonRepository;

    public LegalPerson register(LegalPersonRequest request) throws Exception {
    	if(!"666".equals(request.getType())) {
    		throw new RuntimeException("企业类型不正确");
    	}
    	if(!"111".equals(request.getIdType())) {
    		throw new RuntimeException("证件类型不正确");
    	}
    	
    	if(legalPersonIsExist(request.getCompanyCode())) {
    		throw new RuntimeException("企业已存在,无法重复注册");
    	}
    	
    	if(!verification(request.getCompanyCode(),request.getCompanyName())){
    		throw new RuntimeException("企业信息核验失败");
    	};
    	
    	if(!synchCountry(request)){
    		throw new RuntimeException("企业同步国家失败");
    	};
    	
        LegalPerson legalPerson = transfer(request);
        return legalPersonRepository.save(legalPerson);
    }

	private boolean synchCountry(LegalPersonRequest request) { 
		return true;
	}

	private boolean verification(@NonNull String companyCode, @NonNull String companyName) {
		if(companyCode.equals("88888")&&companyName.equals("吉林祥云")) {
			return true;
		}
		return false;
	}

	private boolean legalPersonIsExist(@NonNull String companyCode) {
		if("8888".equals(companyCode)) {
			return true;
		}
		return false;
	}

	private LegalPerson transfer(LegalPersonRequest request) {
		LegalPerson legalPerson = LegalPerson.builder()
                .type(request.getType())
                .companyName(request.getCompanyName())
                .companyCode(request.getCompanyCode())
                .name(request.getName())
                .idType(request.getIdType())
                .idCode(request.getIdCode())
                .build();
		return legalPerson;
	}
}
