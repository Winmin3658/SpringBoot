package com.zeus.demo;

import org.junit.jupiter.api.Test;

import com.zeus.domain.Board;

public class LombokTest {
    @Test
    public void testGetter() {
        Board board = new Board();
        System.out.println(board.getTitle());
    }

    @Test
    public void testSetter() {
        Board board = new Board();
        board.setTitle("타이틀");
        System.out.println(board.getTitle());
    }
}
