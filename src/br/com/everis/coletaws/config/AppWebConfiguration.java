package br.com.everis.coletaws.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.everis.coletaws.ColetaWS;
import br.com.everis.coletaws.amostrador.services.IAmostradorService;
import br.com.everis.coletaws.amostrador.services.impl.AmostradorServiceImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses={ColetaWS.class,AmostradorServiceImpl.class,IAmostradorService.class})
public class AppWebConfiguration extends WebMvcConfigurerAdapter {

}
