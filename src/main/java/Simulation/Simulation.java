package Simulation;

import SimpleGame.Game;
import SimpleGame.GameConfiguration;
import SimpleGame.SimpleGame;
import SimpleGame.SimpleGameConfiguration;
import User.User;

import java.util.ArrayList;

public class Simulation {
    public static void main(String[] args) {
        GameConfiguration configuration = new SimpleGameConfiguration();
        User user = new User("usernameTest", "firstNameTest", "secondNameTest");
        Game game = new SimpleGame(configuration, user);
        ArrayList<Double> subResults = new ArrayList<>();
        double subtotalOfRewards = 0.0;
        int subtotalLimit = 100000;
        int tries = 10000000;
        for (int i = 0; i < tries; i++) {
            double result = game.play();
            subtotalOfRewards += result;
            if (i % subtotalLimit == 0 && i!=0) {
                subResults.add(subtotalOfRewards / subtotalLimit);
                subtotalOfRewards = 0;
            }
        }
        subResults.add(subtotalOfRewards / subtotalLimit);
        double sum = subResults.stream().mapToDouble(Double::doubleValue).sum();
        System.out.println("Average win: " + sum / subResults.size());
    }
}