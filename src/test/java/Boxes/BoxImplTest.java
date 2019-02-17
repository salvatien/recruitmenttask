package Boxes;

import Rewards.CashReward;
import Rewards.Reward;

import static org.junit.jupiter.api.Assertions.*;

class BoxImplTest {
    @org.junit.jupiter.api.Test
    void openCashBox() {
        Reward reward = new CashReward(20);
        Box box = new BoxImpl(reward);
        Reward openedReward = box.open();
        assertEquals(reward, openedReward);
    }
}