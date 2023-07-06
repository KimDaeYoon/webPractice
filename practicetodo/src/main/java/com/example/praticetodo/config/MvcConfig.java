package com.example.praticetodo.config;

import java.util.List;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


@Configuration //꼭 알려줘야함
@EnableWebMvc // 여기서 mvc 실행될거임
@ComponentScan("com.example.todomvc.controller") //com.example.todomvc.controller 로 좁힐 수 있음. 왜냐면 이미 ioc 애들은 스캔해놧음
public class MvcConfig implements WebMvcConfigurer {
	
	

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		//swageer 사용위해. dispatcher servelt말고 default 타게 해야 swagger를 탐
		configurer.enable();
	}


	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp"); // /WEB-INF/views 이걸로 안됨 / 이거 빠져서 
	}
	//servlet-context.xml 대체용 클래스
	
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {// java객체를 json형태로 바꿔줌
		final Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		final ObjectMapper objectMapper = new ObjectMapper();

		objectMapper.configure(com.fasterxml.jackson.databind.SerializationFeature.
				WRITE_DATES_AS_TIMESTAMPS, false);
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		converter.setObjectMapper(objectMapper);

		builder.serializationInclusion(JsonInclude.Include.NON_NULL);
		builder.serializationInclusion(JsonInclude.Include.NON_EMPTY);

		// Add settings to converter, builder
		converters.add(converter);
		converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
	}
	
}
