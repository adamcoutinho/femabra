package br.pa.com.femabra.properties;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@Configuration
@PropertySources(
        {
                @PropertySource(value = "classpath:app/femabra-teste.properties")
        }
)
public class FemabraProperties implements InitializingBean {


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("teste:"+getFemabraTeste());
    }

    @Value("${config001.field001}")
     private String femabraTeste;


    public String getFemabraTeste() {
        return femabraTeste;
    }
}
