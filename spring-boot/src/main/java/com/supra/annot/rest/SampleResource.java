package com.supra.annot.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping({ "/sample" })
public class SampleResource {
	@RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.GET }, produces = {"application/json;charset=UTF-8" })
	public String getSampleReq(@RequestParam("param1") long param1) throws Exception {
		System.out.println("Method invoked SampleResource.getSampleReq,");
		return new Gson().toJson("Rest working");
	}
}
