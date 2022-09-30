package baseball;

import baseball.controller.BaseballGameController;
import baseball.repository.BaseballGameRepository;
import baseball.service.BaseballGameService;

public class Application {

    public static void main(String[] args) {
        BaseballGameController baseballGameController = new BaseballGameController(new BaseballGameService(new BaseballGameRepository()));
        baseballGameController.run();
    }
}
