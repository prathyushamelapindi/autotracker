package tracker;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JPAConfig {
	@Bean
	public LocalContainerEntityManagerFactoryBean enf() throws Exception{
		LocalContainerEntityManagerFactoryBean enf = new LocalContainerEntityManagerFactoryBean();
		enf.setDataSource(dataSource());
		enf.setPackagesToScan("tracker","Controller","service","entity","repository","exception"); //TO DO: revisit
		enf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	
		enf.setJpaProperties(JpaProperties());
		return enf;
		
	}
	@Bean
	public DataSource dataSource() throws Exception{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		
		//ds.setUrl("jdbc:mysql://localhost:3306/vehicle?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		ds.setUrl("jdbc:mysql://localhost:3306/vehicle");
		ds.setUsername("root");
		ds.setPassword("root");
		System.out.println("DriverManagerDataSource is : "+ds.getConnection().getSchema());
		return ds;
	}
	
	@Bean
    public PlatformTransactionManager txnManager(EntityManagerFactory emf) {
        JpaTransactionManager txnMgr = new JpaTransactionManager(emf);
        return txnMgr;
    }

	
	private Properties JpaProperties() {
		Properties prop = new Properties();
		//props.put("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        //props.put("hibernate.show_sql", "true");
       // props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.ddl"));
		prop.put("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.hbm2ddl.auto", "create");
		return prop;
	}
}
