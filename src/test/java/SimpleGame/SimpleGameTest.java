package SimpleGame;

import Boxes.Box;
import Boxes.BoxImpl;
import Rewards.CashReward;
import Rewards.ExtraLifeReward;
import Rewards.GameOverReward;
import Rewards.Reward;
import User.User;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SimpleGameTest {

    private GameConfiguration config;
    private SimpleGame game;
    private User user;

    @org.junit.jupiter.api.Test
    void play() {
    }

    @org.junit.jupiter.api.Test
    void firstPhase() {
    }

    @org.junit.jupiter.api.Test
    void afterGameCleanUp() {
    }

    @org.junit.jupiter.api.Test
    void endGamePhase() {
    }

    @org.junit.jupiter.api.Test
    void openAllBoxes() {
        ArrayList<Reward> rewards = new ArrayList<Reward>();
        int cashRewardsNumber = 0;
        int gameOversNumber = 0;
        int extraLivesNumber = 0;
        double cashRewardTotal = 0;
        for(int i=0; i<12; i++) {
            Reward reward = game.openBox(0, false);
            rewards.add(reward);
            if(reward instanceof CashReward) {
                cashRewardsNumber++;
                cashRewardTotal+=((CashReward) reward).getCashAmount();
            }
            else if(reward instanceof GameOverReward) {
                gameOversNumber++;
            }
            else if(reward instanceof ExtraLifeReward)
                extraLivesNumber++;
        }
        assertEquals(0, game.getAmountOfBoxesLeftToOpen());
        assertEquals(165, cashRewardTotal);
        assertEquals(8, cashRewardsNumber);
        assertEquals(3, gameOversNumber);
        assertEquals(1, extraLivesNumber);
    }

    @org.junit.jupiter.api.Test
    void claimCashReward() {
        Reward reward = new CashReward(20);
        game.claimReward(reward);
        assertEquals(20, user.getWallet().getCashAmount());
    }

    @org.junit.jupiter.api.BeforeEach
    void configure() {
        config = new SimpleGameConfiguration();
        user = new User("test", "test", "test");
        game = new SimpleGame(config, user);
    }
    @org.junit.jupiter.api.AfterEach
    void cleanup() {
        game.afterGameCleanUp();
    }
}