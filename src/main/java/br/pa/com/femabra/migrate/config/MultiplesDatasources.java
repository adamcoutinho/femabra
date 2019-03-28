package br.pa.com.femabra.migrate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class MultiplesDatasources    {

//    @Bean(name = "dsCrm")
//    @ConfigurationProperties(prefix="spring.datasource")
//    public DataSource dataSourceCRM() {
//        return DataSourceBuilder.create().build();
//    }
//    @Bean(name = "jdbcCrm")
//    @Primary
//    @Autowired
//    public JdbcTemplate jdbcTemplateCRM(@Qualifier("dsCrm") DataSource dsCRM) {
//
//        return new JdbcTemplate(dsCRM);
//    }
    @Bean(name = "dsFemabra01")
    @ConfigurationProperties(prefix="spring.datasource.db1")
    public DataSource dataSourceFemabra01() {
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "jdbcFemabra01")
    @Autowired
    @Primary
    public JdbcTemplate jdbcTemplateFemabra01(@Qualifier("dsFemabra01") DataSource dsFemabra01) {

        return new JdbcTemplate(dsFemabra01);
    }
    @Bean(name = "dsFemabra02")
    @ConfigurationProperties(prefix="spring.datasource.db2")
    public DataSource dataSourceFemabra02() {
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "jdbcFemabra02")
    @Autowired
    @Primary
    public JdbcTemplate jdbcTemplateFemabra02(@Qualifier("dsFemabra02") DataSource dsFemabra02) {
        return new JdbcTemplate(dsFemabra02);
    }


}
