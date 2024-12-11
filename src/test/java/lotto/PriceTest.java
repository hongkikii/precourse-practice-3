package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PriceTest {
    @DisplayName("구입 금액이 빈 문자열일 경우 예외가 발생한다.")
    @Test
    void duplicateExceptionTest() {
        assertThatThrownBy(() ->new Price(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
