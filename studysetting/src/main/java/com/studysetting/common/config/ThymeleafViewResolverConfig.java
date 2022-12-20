package com.studysetting.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
@EnableWebMvc
public class ThymeleafViewResolverConfig {

	@Bean
	public ClassLoaderTemplateResolver templateResolver() {
		var templateResolver = new ClassLoaderTemplateResolver();
		
		templateResolver.setPrefix("templates/");
		templateResolver.setCacheable(false);
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML");
		templateResolver.setCharacterEncoding("UTF-8");
		
		return templateResolver;
	}
	@Bean
	public SpringTemplateEngine templateEngine() {
		
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
//		templateEngine.setTemplateEngineMessageSource(messageSource);
		return templateEngine;
	}
//	@Bean
//    public SpringTemplateEngine templateEngine(MessageSource messageSource) {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//        templateEngine.setTemplateEngineMessageSource(messageSource);
//        return templateEngine;
//    }

	@Bean
	public ThymeleafViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setCharacterEncoding("UTF-8");
		return viewResolver;
	}
//	@Bean
//	public ViewResolver viewResolver(MessageSource messageSource) {
//		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//		viewResolver.setTemplateEngine(TemplateEngine(messageSource));
//		viewResolver.setCharacterEncoding("UTF-8");
//		viewResolver.setOrder(1);
//		return viewResolver;
//	}
}