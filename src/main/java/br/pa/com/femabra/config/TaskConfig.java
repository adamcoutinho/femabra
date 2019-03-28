//package br.pa.com.femabra.config;
//
//import br.pa.com.femabra.util.Console;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.time.Instant;
//
//@Component
//@EnableScheduling
//public class TaskConfig {
//    private static final String TIME_ZONE = "America/Sao_Paulo";
//
//    private static final String END_OF_LIFE="* * * * * *";
//
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//    @Scheduled(cron = END_OF_LIFE,zone = TIME_ZONE)
//    public void syncClient(){
//
////
////        jdbcTemplate.query("SELECT * FROM client ", (rs)->{
////            System.out.println(rs.getString("clientName"));
////        });
//        Console.println("INIT SYNCHRONIZED DATA CLIENT");
//        Long begin  = Instant.now().getEpochSecond();
//        new Thread(()->{
//
//
//        }).start();
//
//        Long end  =Instant.now().getEpochSecond();
//
//
//        Long finalTemp = end -begin;
//
//
//        System.out.println("Temp Exection: "+finalTemp);
//
//
//
//    }
//}
