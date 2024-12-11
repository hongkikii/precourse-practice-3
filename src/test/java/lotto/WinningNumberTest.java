package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {
    @DisplayName("당첨 번호가 정상적으로 저장된다.")
    @Test
    void normalTest() {
        Assertions.assertDoesNotThrow(() -> new WinningNumber("1,2,3,4,5,6"));
    }

    @DisplayName("당첨 번호에 쉼표 이외의 문자가 입력될 경우 예외가 발생한다.")
    @Test
    void characterExceptionTest() {
        assertThatThrownBy(() ->new WinningNumber("1,2,3,4,5&6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 1~45 이외의 숫자가 입력될 경우 예외가 발생한다.")
    @Test
    void numberRangeExceptionTest() {
        assertThatThrownBy(() ->new WinningNumber("1,2,3,4,5,100"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->new WinningNumber("1,2,3,4,5,3o"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->new WinningNumber("1,2,3,4,5,2200000000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("쉼표 앞 혹은 뒤가 비어 있을 경우 예외가 발생한다.")
    @Test
    void formatExceptionTest() {
        assertThatThrownBy(() ->new WinningNumber("1,2,3,4,5,6,"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->new WinningNumber(",1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->new WinningNumber("1,,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->new WinningNumber("1,2,3,4,5,"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->new WinningNumber(",1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 빈 문자열(\"\")일 경우 예외가 발생한다.")
    @Test
    void emptyExceptionTest() {
        assertThatThrownBy(() ->new WinningNumber(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 중복될 경우 예외가 발생한다.")
    @Test
    void duplicateExceptionTest() {
        assertThatThrownBy(() ->new WinningNumber("1,2,3,3,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
