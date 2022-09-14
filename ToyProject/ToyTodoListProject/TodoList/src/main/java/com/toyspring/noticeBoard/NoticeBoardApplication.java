package com.toyspring.noticeBoard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"TodoList/src/main/java/com/toyspring/noticeBoard/repository/TodoRepository.java"})
public class NoticeBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoticeBoardApplication.class, args);
	}

}
