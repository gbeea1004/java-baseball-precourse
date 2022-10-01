package baseball.domain;

import baseball.exception.BaseballGameException;

public enum GameState {

    PROGRESS("1"),
    END("2"),
    ;

    private final String state;

    GameState(String state) {
        this.state = state;
    }

    public boolean isGameProgress() {
        return this == PROGRESS;
    }

    public static GameState getGameState(String state) {
        // TODO: depth 2 분리하기
        for (GameState gameState : values()) {
            if (gameState.state.equals(state)) {
                return gameState;
            }
        }
        throw new BaseballGameException("게임 상태를 잘못 입력하셨습니다.");
    }
}
