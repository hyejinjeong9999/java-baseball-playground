package service;

public class AnswerCheckServiceImpl implements AnswerCheckService{

    @Override
    public boolean answerValidation(String answer) {
        //세글자가 들어와야 한다
        //0이 들어가면 안된다
        
        return false;
    }

    @Override
    public boolean answerCheck(String expected, String answer) {
        boolean b = answerValidation(answer);
        return true;
    }
}
