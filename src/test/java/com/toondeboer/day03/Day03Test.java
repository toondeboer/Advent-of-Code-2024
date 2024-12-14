package com.toondeboer.day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day03Test {
    @Test
    void testPart1() {
        String input = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";
        assertEquals(161, Day03.solve(input)[0]);
    }

    @Test
    void testPart2() {
        String input = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))";
        assertEquals(48, Day03.solve(input)[1]);
    }
}
