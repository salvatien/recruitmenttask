package Boxes;

import Rewards.CashReward;
import Rewards.Reward;

public class BoxImpl implements Box {
    private Reward reward;
    public BoxImpl(Reward reward) {
        this.reward = reward;
    }
    public Reward open() {
        return reward;
    }
}