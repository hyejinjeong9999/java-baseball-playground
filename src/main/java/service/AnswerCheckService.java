package service;

public interface AnswerCheckService {
    boolean answerValidation(String answer);
    boolean answerCheck(String expected, String answer);
}
