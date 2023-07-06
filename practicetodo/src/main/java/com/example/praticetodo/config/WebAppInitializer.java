package com.example.praticetodo.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer { //기본적으로 dispatcherservlet이 설정이 되어 있음

	@Override
	protected Class<?>[] getRootConfigClasses() { //비지니스 레이어 누구 참고 할꺼임?
		return new Class<?>[] {ApplicationConfig.class};
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("utf-8");
		return new Filter[] {filter};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() { //mvc config 설정
		return new Class<?>[] {MvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"}; // web.xml에 servelt mapping url임
	}

}
