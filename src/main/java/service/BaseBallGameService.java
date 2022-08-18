package service;

import domain.BaseBallGame;
import java.util.Scanner;

public class BaseBallGameService {

    private String userAnswer;
    private Scanner sc = new Scanner(System.in);

    private static String START_GAME_MESSAGE = "게임을 시작했습니다";
    private static String REGAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 : ";
    private static String ASK_USER_ANSWER = "숫자를 입력해주세요";

    public Boolean playGame(BaseBallGame baseBallGame) {
        Boolean isCorrectAnswer = false;
        printMessage(START_GAME_MESSAGE);
        while (!isCorrectAnswer) {
            inputUserAnswer();
            baseBallGame.checkAnswer(userAnswer);
            isCorrectAnswer = baseBallGame.isCorrectAnswer();
            printMessage(baseBallGame.printAnswerResult());
            baseBallGame.resetCount();
        }
        return playGameAgain();
    }

    private void inputUserAnswer() {
        boolean correctUserAnswer = false;
        while (!correctUserAnswer) {
            System.out.println(ASK_USER_ANSWER);
            userAnswer = sc.nextLine();
            correctUserAnswer = userAnswer.length() == 3;
        }
    }

    private Boolean playGameAgain() {
        printMessage(REGAME_MESSAGE);
        String input = sc.nextLine();
        return input.equals("1");
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}