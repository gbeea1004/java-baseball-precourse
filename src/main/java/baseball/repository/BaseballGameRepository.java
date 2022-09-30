package baseball.repository;

import baseball.domain.GameStatus;

public class BaseballGameRepository {

    private GameStatus gameStatus;

    public BaseballGameRepository() {
        gameStatus = GameStatus.PROGRESS;
    }

    public void updateToFinishGame() {
        gameStatus = GameStatus.FINISH;
    }

    public GameStatus findGameStatus() {
        return gameStatus;
    }
}
