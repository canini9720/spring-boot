package com.supra.annot.config;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.Servlet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import com.supra.annot.common.util.ApplicationProperties;
import com.supra.annot.common.util.GlobalEndpointInterceptor;
import com.supra.annot.common.util.WebServiceConstants;

@Component
@EnableWs
@Configuration
//@DependsOn("ApplicationProperties")
public class WebServiceConfig extends WsConfigurerAdapter{

	
		
	@Value("${server.servlet.context-path}")
    private String servletContextPath; 
	
	@Value("${app.server}")
    private String appServer; 
	
	public static  String supraAppInfoLocUri = "";
	public static  String supraBookLocUri = "";
	
	public static String server="";


	@PostConstruct
	public void initialize() {
		System.out.println("context="+servletContextPath);
		System.out.println("app.server="+appServer);
		if(appServer.equalsIgnoreCase("tomcat")){
			supraAppInfoLocUri="http://localhost:8080"+servletContextPath+WebServiceConstants.SUPR_APPLICANTINFO_LOCATION_URI;
			supraBookLocUri="http://localhost:8080"+servletContextPath+WebServiceConstants.SUPR_BOOK_LOCATION_URI;
		}else if(appServer.equalsIgnoreCase("weblogic")){
			supraAppInfoLocUri="http://localhost:7002"+servletContextPath+WebServiceConstants.SUPR_APPLICANTINFO_LOCATION_URI;
			supraBookLocUri="http://localhost:7002"+servletContextPath+WebServiceConstants.SUPR_BOOK_LOCATION_URI;
		}
		
		
		System.out.println("supraAppInfoLocUri="+supraAppInfoLocUri);
		System.out.println("supraBookLocUri="+supraBookLocUri);
	
	}

	@Override
	public void addInterceptors(List<EndpointInterceptor> interceptors) {
		 interceptors.add(new GlobalEndpointInterceptor());
	}

	@Bean
	public  ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet msgDispathServlet = new MessageDispatcherServlet();
		msgDispathServlet.setApplicationContext(applicationContext);
		ServletRegistrationBean<MessageDispatcherServlet> servletReg=new ServletRegistrationBean<>(msgDispathServlet, "/wsservice/*");
		servletReg.setLoadOnStartup(2);
		
		//return new ServletRegistrationBean<>(msgDispathServlet, "/wsservice/*");
		return servletReg;
	}
	
	
//http://localhost:8080/springboot/wsservice/ws/supraBookService/supraSample.wsdl
	@Bean(name = "supraSample")
	public DefaultWsdl11Definition applicantInfoWsdl11Definition() {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("supraSamplePort");
		wsdl11Definition.setLocationUri(supraAppInfoLocUri);
		wsdl11Definition.setTargetNamespace(WebServiceConstants.SUPRA_APPLICANTINFO_NAMESPACE);
		wsdl11Definition.setSchema(applicantInfoSchema());
		return wsdl11Definition;
	}

	
	@Bean
	public XsdSchema applicantInfoSchema() {
		return new SimpleXsdSchema(new ClassPathResource("xsds/sample.xsd"));
	}
	
	@Bean(name = "book")
	public DefaultWsdl11Definition webservice2Wsdl11Definition() {
	    DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
	    wsdl11Definition.setPortTypeName("bookPort");
	    wsdl11Definition.setLocationUri(supraBookLocUri);
	    wsdl11Definition.setTargetNamespace(WebServiceConstants.SUPRA_APPLICANTINFO_NAMESPACE);
	    wsdl11Definition.setSchema(bookSchema());
	    return wsdl11Definition;
	}

	@Bean(name="bookSchema")
	public XsdSchema bookSchema() {
	    return new SimpleXsdSchema(new ClassPathResource("xsds/book.xsd"));
	}
	
	
	


}
