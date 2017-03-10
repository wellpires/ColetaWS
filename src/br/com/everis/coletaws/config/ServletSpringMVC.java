package br.com.everis.coletaws.config;

import java.util.TimeZone;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
		return new Class[]{AppWebConfiguration.class,JPAConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
}
