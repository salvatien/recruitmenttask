package Simulation;
import SimpleGame.Game;
import SimpleGame.SimpleGame;
import SimpleGame.GameConfiguration;
import SimpleGame.SimpleGameConfiguration;
import User.User;

import java.util.*;

public class Simulation {
    public static void main (String[] args){
        //TODO logic for simulation
        GameConfiguration configuration = new SimpleGameConfiguration();
        User user = new User("usernameTest", "firstNameTest", "secondNameTest");
        Game game = new SimpleGame(configuration, user);
        ArrayList<Double> results = new ArrayList<Double>();
        //TODO for 10 million tries, int limit may be exceeded. Store average score from every 100 000 or something
        double totalOfRewards = 0.0;
        for(int i=0; i<100000; i++){
            double result = game.play();
            System.out.println(result);
            totalOfRewards += result;
        }
        System.out.println("Average win in 100000 games: " + totalOfRewards / 100000);

    }
}