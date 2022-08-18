package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseBallGameTest {
    BaseBallGame baseBallGame;

    @BeforeEach
    void init(){
        baseBallGame = new BaseBallGame();
    }

    @Test
    void STRIKE가_3이면_옳은_정답이다() {
        //given
        baseBallGame.setSTRIKE_COUNT(3);
        //when
        boolean result = baseBallGame.isCorrectAnswer();
        //then
        Assertions.assertTrue(result);
    }

    @Test
    void STRIKE가_3이_아니면_틀린_정답이다() {
        //given
        baseBallGame.setSTRIKE_COUNT(2);
        //when
        boolean result = baseBallGame.isCorrectAnswer();
        //then
        Assertions.assertFalse(result);
    }

    @Test
    void 결과값을_포맷에_맞게_출력한다() {
        //given
        baseBallGame.setBALL_COUNT(2);
        baseBallGame.setSTRIKE_COUNT(1);
        String expected = "2볼 1스트라이크";
        //when
        String result = baseBallGame.printAnswerResult();
        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 결과에서_ball_count_가_0이면_ball_count_는_출력되지_않는다() {
        //given
        baseBallGame.setBALL_COUNT(0);
        baseBallGame.setSTRIKE_COUNT(1);
        String expected = "1스트라이크";
        //when
        String result = baseBallGame.printAnswerResult();
        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 결과에서_strike_count_가_0이면_strike_count_는_출력되지_않는다() {
        //given
        baseBallGame.setBALL_COUNT(2);
        baseBallGame.setSTRIKE_COUNT(0);
        String expected = "2볼";
        //when
        String result = baseBallGame.printAnswerResult();
        //then
        assertThat(result).isEqualTo(expected);

    }
}