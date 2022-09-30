package baseball.service;

import baseball.domain.BaseballNumber;
import baseball.domain.GameStatus;
import baseball.repository.BaseballGameRepository;

public class BaseballGameService {

    private final BaseballGameRepository baseballGameRepository;

    public BaseballGameService(BaseballGameRepository baseballGameRepository) {
        this.baseballGameRepository = baseballGameRepository;
    }

    public void playGame(BaseballNumber computer, BaseballNumber player) {
        System.out.println("computer = " + computer.getNumberText());
        System.out.println("player = " + player.getNumberText());
        baseballGameRepository.updateToFinishGame();
    }

    public boolean isFinishGame() {
        return baseballGameRepository.findGameStatus() == GameStatus.FINISH;
    }
}
