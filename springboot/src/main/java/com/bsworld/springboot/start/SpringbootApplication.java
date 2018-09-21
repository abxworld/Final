package com.bsworld.springboot.start;

import com.bsworld.springboot.start.util.Logger;
import com.bsworld.springboot.start.util.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author bsworld
 */
@SpringBootApplication(scanBasePackages = "com.bsworld.springboot.start")
public class SpringbootApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger();

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SpringbootApplication.class, args);
        File file = new File("logs/operate-console_detail.log");
        long length = file.length();
        RandomAccessFile accessFile = new RandomAccessFile(file,"r");
        accessFile.seek(length);
        accessFile.readLine();
    }
}
