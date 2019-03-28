package br.pa.com.femabra.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.SQLException;


@Component
public class ConfigTestsConnectionDB {

//    @Autowired
//    @Qualifier("jdbcFemabra01")
//    private JdbcTemplate templateF01;
//    @Autowired
//    @Qualifier("jdbcFemabra02")
//    private JdbcTemplate templateF02;


    public void get() throws SQLException {

    }


}
