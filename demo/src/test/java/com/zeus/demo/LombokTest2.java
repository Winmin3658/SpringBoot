package com.zeus.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.zeus.domain.Board;


@SpringBootTest
public class LombokTest2 {
    @Test
    public void testGetter() {
        Board board = new Board();
        System.out.println(board.getTitle());
    }
}
