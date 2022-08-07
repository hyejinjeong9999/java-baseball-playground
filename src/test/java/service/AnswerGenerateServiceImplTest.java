package service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnswerGenerateServiceImplTest {

    AnswerGenerateService answerGenerateService;

    @BeforeEach
    void init() {
        answerGenerateService = new AnswerGenerateServiceImpl();
    }

    @Test
    void 반복되는_숫자가_없이_세글자_반환_해야한다(){
        //when
        String result = answerGenerateService.answerGenerator();

        boolean isUnique = Arrays.stream(result.split(""))
            .distinct()
            .count() == result.length();

        //then
        assertThat(result.length()).isEqualTo(3);
        assertTrue(isUnique);

    }


}