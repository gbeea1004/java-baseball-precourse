package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
//    @Test
//    void 게임종료_후_재시작() {
//        assertRandomNumberInRangeTest(
//                () -> {
//                    run("246", "135", "1", "597", "589", "2");
//                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
//                },
//                1, 3, 5, 5, 8, 9
//        );
//    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"111", "222", "333"})
    void 플레이어가_중복된_수를_입력하면_예외발생(String no) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(no))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "22", "4444", "125125134", " "})
    void 플레이어가_3자리가_아닌수를_입력하면_예외발생(String no) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(no))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"안녕", "asd2", "vfs"})
    void 플레이어가_잘못된_수를_입력하면_예외발생(String no) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(no))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
