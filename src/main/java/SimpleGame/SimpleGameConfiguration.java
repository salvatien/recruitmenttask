package SimpleGame;

import Boxes.Box;
import Boxes.BoxImpl;
import Rewards.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleGameConfiguration implements GameConfiguration {

    private ArrayList<Box> boxes = new ArrayList<Box>();
    private ArrayList<Reward> rewards = new ArrayList<Reward>();
    private ArrayList<Box> endGameBoxes = new ArrayList<Box>();
    private ArrayList<Reward> endGameRewards = new ArrayList<Reward>();


    public List<Box> getBoxes() {
        return boxes;
    }

    public List<Box> getEndGameBoxes() {
        return endGameBoxes;
    }
    public SimpleGameConfiguration() {
        initializeBoxes();
        initializeEndGameBoxes(false);
    }
    public void initializeBoxes() {
        boxes.clear();
        initializeRewards();
        for (Reward reward : rewards){
            boxes.add(new BoxImpl(reward));
        }
        Collections.shuffle(boxes);
    }
    private void initializeRewards() {
        rewards.clear();
        for (int i=0; i<5; i++)
            rewards.add(new CashReward(5));
        for (int i=0; i<2; i++)
            rewards.add(new CashReward(20));
        rewards.add(new CashReward(100));
        rewards.add(new ExtraLifeReward()) ;
        for (int i=0; i<3; i++)
            rewards.add(new GameOverReward());
    }
    public void initializeEndGameBoxes(boolean isSecondChanceUsed) {
        endGameBoxes.clear();
        initializeEndGameRewards(isSecondChanceUsed);
        for (Reward reward : endGameRewards){
            endGameBoxes.add(new BoxImpl(reward));
        }
        Collections.shuffle(endGameBoxes);
    }
    private void initializeEndGameRewards(boolean isSecondChanceUsed) {
        endGameRewards.clear();
        endGameRewards.add(new CashReward(20));
        endGameRewards.add(new CashReward(10));
        endGameRewards.add(new CashReward(5));
        if(!isSecondChanceUsed)
            endGameRewards.add(new SecondChanceReward());
    }
}
