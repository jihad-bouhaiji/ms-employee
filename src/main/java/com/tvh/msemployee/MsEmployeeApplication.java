package com.tvh.msemployee;

import com.tvh.msemployee.api.EmployeeController;
import com.tvh.msemployee.domain.Employee;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class MsEmployeeApplication {

	@Bean
	public ApplicationRunner runner(EmployeeController controller){
		return args -> {
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(MsEmployeeApplication.class, args);
	}

}
