package baseball.service;

import baseball.domain.BaseballNumber;
import baseball.domain.GameResult;
import baseball.dto.BaseballGameResultDto;

public class BaseballGameService {

    public BaseballGameResultDto playGame(BaseballNumber computer, BaseballNumber player) {
        return new BaseballGameResultDto(new GameResult(computer, player));
    }
}
