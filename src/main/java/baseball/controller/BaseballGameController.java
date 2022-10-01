package baseball.controller;

import baseball.domain.BaseballNumber;
import baseball.dto.BaseballGameResultDto;
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

            BaseballGameResultDto baseballGameResultDto = baseballGameService.playGame(computer, player);
            isFinish = baseballGameResultDto.isFinishGame();
        }
    }
}
