package com.app.mvc.common;

import static com.app.utility.common.AppPropertyBuilder.getProperty;

import java.text.ParseException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.app.common.controller.RefillCacheController;
import com.app.common.interceptor.AuthInterceptor;
import com.app.getcitydealz.merchant.service.MerchantService;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.getcitydealz.service.GetCityDealzService;
import com.app.getcitydealz.service.MerchantServiceImpl;
import com.app.mvc.util.AppEntityBasePackageSacnner;
import com.app.rss.feed.RssViewer;
import com.app.scheduler.subscription.GetDailyDealsScheduler;
import com.app.utility.common.AppPropertyBuilder;

@Configuration
//@AnnotationDrivenConfig
@ComponentScan(basePackages = { "com.app" })
@EnableWebMvc
@EnableTransactionManagement
@EnableScheduling
// @ImportResource("classpath:/spring_entity.xml")
public class AppConfig extends WebMvcConfigurerAdapter {

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(
				getProperty("gcd.database.connectionurl", "01"), getProperty("gcd.database.username", "01"),
				getProperty("gcd.database.password", "01"));
		dataSource.setDriverClassName(getProperty("gcd.database.driverclassname", "01"));
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("persistence.001");
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan("com.app.model.*");
		factoryBean.setPersistenceUnitPostProcessors(getPackageSacnner());
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setShowSql(true);
		jpaVendorAdapter.setDatabasePlatform(AppPropertyBuilder.getProperty("gcd.database.dialect", "01"));
		jpaVendorAdapter.setGenerateDdl(Boolean.parseBoolean(AppPropertyBuilder.getProperty("gcd.generate.ddl", "01")));
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		return factoryBean;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getNativeEntityManagerFactory());
		return transactionManager;
	}

	@Bean
	public AppEntityBasePackageSacnner getPackageSacnner() {
		AppEntityBasePackageSacnner sacnner = new AppEntityBasePackageSacnner();
		sacnner.setPackagesToScan(new String[] { "com.app.model.*" });
		return sacnner;
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		return multipartResolver;
	}

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/*").addPathPatterns("/component/*");
	}

	public void test() {
		System.out.println("hi");
	}

	@Bean(initMethod = "refillCache")
	@Scope("prototype")
	public RefillCacheController refillCacheController() {
		RefillCacheController controller = new RefillCacheController();
		return controller;
	}

	@Bean
	public BeanNameViewResolver beanNameViewResolver() {
		BeanNameViewResolver resolver = new BeanNameViewResolver();
		resolver.setOrder(1);
		return resolver;
	}

	@Bean(name = "rssViewer")
	public RssViewer rssViewer() {
		RssViewer rssViewer = new RssViewer();
		return rssViewer;
	}

	@Bean
	public GetDailyDealsScheduler defaultScheduler() throws ParseException {
		GetDailyDealsScheduler scheduler = new GetDailyDealsScheduler();
		scheduler.scheduleTask();
		return scheduler;
	}

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames(new String[] { AppPropertyBuilder.getProperty("message.properties", "01") });
		messageSource.setCacheSeconds(1);
		return messageSource;
	}

	@Bean(name = "getCityDealz")
	public GetCityDealz getCityDealz() {
		GetCityDealzService dealzService = new GetCityDealzService();
		return dealzService;
	}

	@Bean(name = "merchantService")
	public MerchantService getMerchantService() {
		MerchantServiceImpl merchantServiceImpl = new MerchantServiceImpl();
		return merchantServiceImpl;
	}

	/*
	 * public BufferedImageHttpMessageConverter
	 * bufferedImageHttpMessageConverter() { BufferedImageHttpMessageConverter
	 * converter = new BufferedImageHttpMessageConverter();
	 * 
	 * return converter; }
	 * 
	 * @Bean public RequestMappingHandlerAdapter requestMappingHandlerAdapter()
	 * { RequestMappingHandlerAdapter handlerAdapter = new
	 * RequestMappingHandlerAdapter();
	 * handlerAdapter.getMessageConverters().add(0,
	 * bufferedImageHttpMessageConverter()); return handlerAdapter; }
	 */

	/*
	 * @Bean public RestTemplate restTemplate() { return new
	 * RestTemplate(clientHttpRequestFactory()); }
	 * 
	 * private ClientHttpRequestFactory clientHttpRequestFactory() {
	 * HttpComponentsClientHttpRequestFactory factory = new
	 * HttpComponentsClientHttpRequestFactory(); factory.setReadTimeout(2000);
	 * factory.setConnectTimeout(2000); return factory; }
	 */
}
