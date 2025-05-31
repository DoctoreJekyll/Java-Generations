package org.generations.springdemojbdcgenerations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;

@SpringBootApplication
public class SpringDemoJbdcGenerationsApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SpringDemoJbdcGenerationsApplication.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(SpringDemoJbdcGenerationsApplication.class, args);
        DataSource dataSource = context.getBean(DataSource.class);
    }

}
