package controller;

import domain.BaseBallGame;
import service.BaseBallGameService;

public class BaseBallGameController {

    BaseBallGameService baseBallGameService;

    public BaseBallGameController(){
        baseBallGameService = new BaseBallGameService();
    }
    public void game() {
        boolean gameFlag = true;
        while (gameFlag) {
            BaseBallGame baseBallGame = new BaseBallGame();
            gameFlag = baseBallGameService.playGame(baseBallGame);
        }
    }

}
