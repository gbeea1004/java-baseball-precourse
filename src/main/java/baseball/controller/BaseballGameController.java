package baseball.controller;

import baseball.domain.BaseballNumber;
import baseball.dto.BaseballGameResultDto;
import baseball.service.BaseballGameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {

    private final BaseballGameService baseballGameService;

    public BaseballGameController(BaseballGameService baseballGameService) {
        this.baseballGameService = baseballGameService;
    }

    public void run() {
        BaseballNumber computer = BaseballNumber.createRandomNumber();
        System.out.println("computer = " + computer.getNumberText());
        boolean isFinish = false;
        while (!isFinish) {
            BaseballNumber player = new BaseballNumber(InputView.inputPlayerNumber());

            BaseballGameResultDto baseballGameResultDto = baseballGameService.playGame(computer, player);
            OutputView.printGameResult(baseballGameResultDto);
            isFinish = baseballGameResultDto.isFinishGame();
        }
    }
}
