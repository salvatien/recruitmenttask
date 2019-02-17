package SimpleGame;

import Boxes.Box;
import Rewards.*;
import User.User;

import java.util.List;
import java.util.Random;

public class SimpleGame implements Game{
    private boolean isSecondChanceAlreadyUsed = false;
    private GameConfiguration config;
    private List<Box> boxes;
    private List<Box> endGameBoxes;
    private User user;

    public SimpleGame(GameConfiguration config, User user) {
        this.config = config;
        this.user = user;
        configure();
        this.user.resetWallet();
    }

    public double play() {
        configure();
        firstPhase();
        endGamePhase();
        double winning = user.getWallet().getCashAmount();
        afterGameCleanUp();
        return winning;
    }

    private void configure() {
        config.initializeBoxes();
        config.initializeEndGameBoxes(isSecondChanceAlreadyUsed);
        boxes = config.getBoxes();
        endGameBoxes = config.getEndGameBoxes();
        user.setLives(1);
    }

    private void firstPhase() {
        while(!boxes.isEmpty() && user.getLives() > 0) {
            Reward reward = openBox( new Random().nextInt(boxes.size()), false);
            claimReward(reward);
        }
    }

    void afterGameCleanUp() {
        this.user.resetWallet();
        isSecondChanceAlreadyUsed = false;
    }

    private void endGamePhase() {
        Reward reward = openBox( new Random().nextInt(endGameBoxes.size()), true);
        claimReward(reward);
    }

    int getAmountOfBoxesLeftToOpen() {
        return boxes.size();
    }

    public int getAmountOfEndGameBoxesLeftToOpen() {
        return endGameBoxes.size();
    }

    Reward openBox(int numberOfBox, boolean isEndGameReward) throws IndexOutOfBoundsException {
        Box openedBox;
        if(isEndGameReward) {
            if(numberOfBox > endGameBoxes.size())
                throw new IndexOutOfBoundsException("number of box was greater than the amount of remaining boxes");
            openedBox = endGameBoxes.get(numberOfBox);
        }
        else {
            if (numberOfBox > boxes.size())
                throw new IndexOutOfBoundsException("number of box was greater than the amount of remaining boxes");
            openedBox = boxes.get(numberOfBox);
            boxes.remove(numberOfBox);
        }
        Reward receivedReward = openedBox.open();
        return receivedReward;
    }

    void claimReward(Reward reward) {
        if(reward instanceof CashReward) {
            user.addToWallet(((CashReward)reward).getCashAmount());
        }
        else if (reward instanceof ExtraLifeReward) {
            user.addLife();
        }
        else if (reward instanceof GameOverReward) {
            user.removeLife();
        }
        else if (reward instanceof SecondChanceReward) {
            isSecondChanceAlreadyUsed = true;
            user.addToWallet(play());
        }
        else throw new IllegalArgumentException("Unsupported reward type");
    }
}
