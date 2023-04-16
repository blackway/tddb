package chap02;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

//@Order을 사용하기 위해서 추가 테스트 메소드를 순번은 지정 해서 순서대로 실행 하도록 할수 있다.
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PasswordStrengthMeterTest {

    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expStr) {
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr, result);
    }

    //@Order를 추가하여 사용자가 원하는 순서를 지정합니다.
    /**
     * 1.첫 번째 테스트: 모든 규직을 충족하는 경우.
     */
    @Test
    @Order(1)
    @DisplayName("1.첫 번째 테스트: 모든 규직을 충족하는 경우.")
    void meetsAllCriteria_Then_Strong() {
        assertStrength("ab12!@", PasswordStrength.STRONG);
//        assertStrength("abc1!Add", PasswordStrength.STRONG);
    }

//    /**
//     * 2.두 번째 테스트: 길이만 8글자 미만이고 나머지 조건은 충족하는 경우.
//     */
//    @Test
//    @Order(2)
//    @DisplayName("2.두 번째 테스트: 길이만 8글자 미만이고 나머지 조건은 충족하는 경우.")
//    void meetsOtherCriteria_except_for_Length_Then_Normal() {
//        assertStrength("ab12!@A", PasswordStrength.NORMAL);
//        assertStrength("Ab12!c", PasswordStrength.NORMAL);
//    }
//
//    /**
//     * 3.세 번째 테스트: 숫자를 포함하지 않고 나머지 조건은 충족하는 경우.
//     */
//    @Test
//    @Order(3)
//    @DisplayName("3.세 번째 테스트: 숫자를 포함하지 않고 나머지 조건은 충족하는 경우.")
//    void meetsOtherCriteria_except_for_number_Then_Normal() {
//        assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);
//    }
//
//    /**
//     * 4.네 번째 테스트: 값이 없는 경우.
//     */
//    @Test
//    @Order(4)
//    void nullInput_Then_Invalid() {
//        assertStrength(null, PasswordStrength.INVALID);
//    }
//
//    /**
//     * 4.네 번째 테스트: 값이 없는 경우.
//     */
//    @Test
//    @Order(5)
//    void emptyInput_Then_Invalid() {
//        assertStrength("", PasswordStrength.INVALID);
//    }
//
//    /**
//     * 5.다섯 번째 테스트: 대문자를 포함하지 않고 나머지 조건을 충족하는 경우.
//     */
//    @Test
//    @Order(6)
//    void meetsOtherCriteria_except_for_Uppercase_Then_Normal() {
//        assertStrength("ab12!@df", PasswordStrength.NORMAL);
//    }
//
//    /**
//     * 6.여섯 번째 테스트: 길이가 8글자 이상인 조건만 충족하는 경우.
//     */
//    @Test
//    @Order(7)
//    void meetsOnlyLengthCriteria_Then_Weak() {
//        assertStrength("abdefghi", PasswordStrength.WEAK);
//    }
//
//    /**
//     * 7.일곱 번재 테스트: 숫자 포함 조건만 충족하는 경우.
//     */
//    @Test
//    @Order(8)
//    void meetsOnlyNumCriteria_Then_Weak() {
//        assertStrength("12345", PasswordStrength.WEAK);
//    }
//
//    /**
//     * 8.여덟 번째 테스트: 대문자 포함 조건만 충족하는 경우.
//     */
//    @Test
//    @Order(9)
//    void meetsOnlyUpperCriteria_Then_Weak() {
//        assertStrength("ABZEF", PasswordStrength.WEAK);
//    }
//
//    /**
//     * 9.아홉 번째 테스트: 아무 조건도 충족하지 않는 경우.
//     */
//    @Test
//    @Order(10)
//    void meetsNoCriteria_Then_Weak() {
//        assertStrength("abc", PasswordStrength.WEAK);
//    }

}
