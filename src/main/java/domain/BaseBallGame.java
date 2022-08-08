package domain;

public class BaseBallGame {

    private String ANSWER;
    private Integer BALL_COUNT;
    private Integer STRIKE_COUNT;

    public BaseBallGame() {
        answerGenerator();
    }

    private void answerGenerator() {
        //랜덤 글자 생성
        //중복되는 숫자가 있으면 재생성
    }

    private boolean isDuplicatedNumber(String number){
        //중복된 숫자 확인하기
        return false;
    }

    public boolean isCorrectAnswer(){
        //strike count가 4면 correct
        return false;
    }

    public String printAnswerResult(){
        //정답 결과 출력
        return "";
    }

    public void setBALL_COUNT(Integer BALL_COUNT) {
        this.BALL_COUNT = BALL_COUNT;
    }

    public void setSTRIKE_COUNT(Integer STRIKE_COUNT) {
        this.STRIKE_COUNT = STRIKE_COUNT;
    }

}
