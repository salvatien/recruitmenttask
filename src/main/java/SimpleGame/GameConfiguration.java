package SimpleGame;

import Boxes.Box;
import Rewards.Reward;

import java.util.List;


public interface GameConfiguration {
    public void initializeBoxes();
    public void initializeEndGameBoxes(boolean isSecondChanceUsed);
    public List<Box> getBoxes();
    public List<Box> getEndGameBoxes();
}

