package service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class AnswerCheckServiceImplTest {

    AnswerCheckServiceImpl answerCheckService;

    @BeforeEach
    void init() {
        answerCheckService = new AnswerCheckServiceImpl();
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "987"})
    void 값이_1_에서_9_까지_세글자만_와야_성공(String input) {
        //when
        boolean result = answerCheckService.answerValidation(input);
        //then
        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "012", "001", "2", "34"})
    void 값에_0_이_들어가거나_3_자리가_아니면_실패(String expected, String input) {
        //when
        boolean result = answerCheckService.answerValidation(input);
        //then
        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @MethodSource("failInput")
    void 값이_틀리면_실패(String expected, String input) {
        //when
        boolean result = answerCheckService.answerCheck(expected,input);
        //then
        assertThat(result).isFalse();
    }

    private static Stream<Arguments> failInput(){
        return Stream.of(
            Arguments.of("123","345"),
            Arguments.of("123","367"),
            Arguments.of("123","853")
        );
    }

    @ParameterizedTest
    @MethodSource("successInput")
    void 값이_맞을때_성공(String expected, String input) {
        //when
        boolean result = answerCheckService.answerCheck(expected,input);
        //then
        assertThat(result).isTrue();
    }

    private static Stream<Arguments> successInput(){
        return Stream.of(
            Arguments.of("123","123"),
            Arguments.of("234","234"),
            Arguments.of("478","478")
        );
    }

}