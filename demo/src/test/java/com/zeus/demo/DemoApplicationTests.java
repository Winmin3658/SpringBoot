package com.zeus.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.zeus.domain.Board;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		String[] name = {"kdj","zeus"};
		Board board = new Board();
		System.out.println(board.getTitle());
	}

}
