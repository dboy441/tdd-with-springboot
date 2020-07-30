package com.essContext.controller;

import com.essContext.controller.request.LegalPersonRequest;
import com.essContext.domain.model.LegalPerson;
//import com.essContext.domain.service.LegalPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/legalPerson")
public class LegalPersonController {
//    @Autowired
//    LegalPersonService legalPersonService;
//
//    @PostMapping("/register")
//    public LegalPerson register(@Validated @RequestBody LegalPersonRequest request) throws Exception {
//        return legalPersonService.register(request);
//    }
}
