package domain;

public class BaseBallGame {

    private String ANSWER;
    private Integer BALL_COUNT = 0;
    private Integer STRIKE_COUNT = 0;

    public BaseBallGame() {
        answerGenerator();
    }

    private void answerGenerator() {
        boolean isValidAnswer = false;
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        while (!isValidAnswer) {
            num1 = makeRandomNumber();
            num2 = makeRandomNumber();
            num3 = makeRandomNumber();
            isValidAnswer = isDuplicatedNumber(num1, num2, num3);
        }
        ANSWER = num1 + "" + num2 + "" + num3;
    }

    private int makeRandomNumber() {
        return (int) ((Math.random() * 9) + 1);
    }

    private Boolean isDuplicatedNumber(int number1, int number2, int number3) {
        return !(number1 == number2 || number2 == number3 || number3 == number1);
    }

    public void checkAnswer(String userAnswer) {
        for (int i = 0; i < 3; i++) {
            setCount(i, userAnswer.charAt(i));
        }
    }

    private void setCount(Integer i, Character ch) {
        int findResult = ANSWER.indexOf(ch);
        //아예 없을때
        if (findResult < 0) {
            return;
        }
        //같은 위치에 있을 때
        if (findResult == i) {
            STRIKE_COUNT++;
            return;
        }
        //다른 위치에 있을 때
        BALL_COUNT++;
    }

    public Boolean isCorrectAnswer() {
        return STRIKE_COUNT == 3;
    }

    public String printAnswerResult() {
        if (BALL_COUNT == 0 && STRIKE_COUNT == 0) {
            return "0볼 0스트라이크";
        }
        if (BALL_COUNT == 0) {
            return STRIKE_COUNT + "스트라이크";
        }
        if (STRIKE_COUNT == 0) {
            return BALL_COUNT + "볼";
        }
        return BALL_COUNT + "볼 " + STRIKE_COUNT + "스트라이크";
    }

    public void resetCount(){
        BALL_COUNT = 0;
        STRIKE_COUNT = 0;
    }

    public void setBALL_COUNT(Integer BALL_COUNT) {
        this.BALL_COUNT = BALL_COUNT;
    }

    public void setSTRIKE_COUNT(Integer STRIKE_COUNT) {
        this.STRIKE_COUNT = STRIKE_COUNT;
    }
}
