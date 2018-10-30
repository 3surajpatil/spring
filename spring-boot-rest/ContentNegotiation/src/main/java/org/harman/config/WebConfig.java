package org.harman.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer){
		
		// setting parameter false.
		//localhost:9090/getEmployee/10/?mediaType=xml or localhost:9090/getEmployee/10/?mediaType=json
		configurer.favorParameter(true);
		configurer.parameterName("mediaType");
		
		/* enabeling path extensions.
		 to use this our request path should be correct with extention.
		 e.g. correct :-  /getEmployee.json or /getEmployee.xml 
		     incorrect :- /getEmployee/{id}/.json or /getEmployee/{id}/.xml
		     i.e. i removed id path parameter from url and it worked.
		      
		*/		
		configurer.favorPathExtension(false);  
		
		//ignoring accept header.
		configurer.ignoreAcceptHeader(true); //
						
		configurer.defaultContentType(MediaType.APPLICATION_XML);
		// adding supoprted media types.
		configurer.mediaType("xml", MediaType.APPLICATION_XML);
		configurer.mediaType("json", MediaType.APPLICATION_JSON);
	}
	
}
