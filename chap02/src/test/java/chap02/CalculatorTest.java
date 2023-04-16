package chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;

public class CalculatorTest {

    @Test
    @DisplayName("2.마이너스 테스트")
    void minus() {
        int result = Calculator.minus(1, 2);
        assertEquals(-1, result);
        assertEquals(3, Calculator.minus(4, 1));
    }

//    @Test
//    void plus() {
//        int result = Calculator.plus(1, 2);
//        assertEquals(3, result);
//        assertEquals(5, Calculator.plus(4, 1));
//    }
    
    @Test
    @DisplayName("1.플러스 테스트")
    void plus() {
        int result = Calculator2.plus(1, 2);
        assertEquals(3, result);
        assertEquals(5, Calculator2.plus(4, 1));
    }    
}
