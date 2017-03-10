package br.com.everis.coletaws.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import br.com.everis.coletaws.amostrador.model.Amostrador;
import br.com.everis.coletaws.amostradoreslojasunidades.model.AmostradoresLojasUnidades;
import br.com.everis.coletaws.atividade.model.Atividade;
import br.com.everis.coletaws.coletaAmostra.model.ColetaAmostra;
import br.com.everis.coletaws.funcionario.model.Funcionario;
import br.com.everis.coletaws.loja.model.Loja;
import br.com.everis.coletaws.lojaprodutoatividade.model.LojaProdutosAtividade;
import br.com.everis.coletaws.produto.model.Produto;
import br.com.everis.coletaws.unidade.model.Unidade;

@EnableTransactionManagement
public class JPAConfiguration {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws PropertyVetoException {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("org.postgresql.Driver");
		dataSource.setUser("sysnac");
		dataSource.setPassword("sysnac01");
		dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/sysnac");
		
		dataSource.setMinPoolSize(10);
		dataSource.setMaxPoolSize(20);
		dataSource.setIdleConnectionTestPeriod(1);
		
		factoryBean.setDataSource(dataSource);

		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.default_schema", "sysnac");
		props.setProperty("hibernate.cache.use_second_level_cache", "true");
		props.setProperty("hibernate.cache.use_query_cache", "true");
		props.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");
		
		factoryBean.setJpaProperties(props);
		factoryBean.setPackagesToScan(
				ColetaAmostra.class.getPackage().getName(),
				Amostrador.class.getPackage().getName(),
				Loja.class.getPackage().getName(),
				Produto.class.getPackage().getName(),
				Unidade.class.getPackage().getName(),
				Funcionario.class.getPackage().getName(),
				Atividade.class.getPackage().getName(),
				LojaProdutosAtividade.class.getPackage().getName(),
				AmostradoresLojasUnidades.class.getPackage().getName());

		return factoryBean;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf){
		return new JpaTransactionManager(emf);
	}
	
}
