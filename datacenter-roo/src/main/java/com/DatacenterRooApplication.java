package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/*@ComponentScan("com.dao")*/
public class DatacenterRooApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatacenterRooApplication.class, args);
	}

}
