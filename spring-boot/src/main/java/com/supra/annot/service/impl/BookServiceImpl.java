package com.supra.annot.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.supra.annot.common.util.CommonConstants;
import com.supra.annot.model.ApplicationPropertyEntity;
import com.supra.annot.repository.ApplicationPropertyRepository;
import com.supra.annot.service.BookService;
import com.supra.supra.service.BookRequest;



@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {
	
	private static final Logger loggerInfo = Logger.getLogger(CommonConstants.LOGGER_SUPRA_SERVICES_INFO);
	
	@Autowired
	private ApplicationPropertyRepository appPropertyRepository;

	

	@Override
	public int saveBookOrder(BookRequest request)throws Exception {
		List<ApplicationPropertyEntity> list=appPropertyRepository.findAll();
		System.out.println(list);
		return 1;
	}
		

}
