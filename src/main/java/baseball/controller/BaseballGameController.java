package baseball.controller;

import baseball.domain.BaseballNumber;
import baseball.service.BaseballGameService;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameController {

    private final BaseballGameService baseballGameService;

    public BaseballGameController(BaseballGameService baseballGameService) {
        this.baseballGameService = baseballGameService;
    }

    public void run() {
        BaseballNumber computer = BaseballNumber.createRandomNumber();
        boolean isFinish = false;
        while (!isFinish) {
            BaseballNumber player = new BaseballNumber(Console.readLine());
            baseballGameService.playGame(computer, player);
            isFinish = baseballGameService.isFinishGame();
        }
    }
}
