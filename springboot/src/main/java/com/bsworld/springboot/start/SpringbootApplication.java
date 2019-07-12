package com.bsworld.springboot.start;

import com.bsworld.springboot.start.util.Logger;
import com.bsworld.springboot.start.util.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author bsworld
 */
@SpringBootApplication(scanBasePackages = "com.bsworld.springboot.start")
public class SpringbootApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger();

    public static void main(String[] args) throws IOException, InterruptedException, SQLException {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
