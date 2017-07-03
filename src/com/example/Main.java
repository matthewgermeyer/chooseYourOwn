package com.example;

import com.example.entity.Monster;
import com.example.entity.Player;
import com.example.entity.Scene;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        boolean quit = false;

        Player p1 = new Player("", 100, 1);
        Scene scene = new Scene("scene1");

        name(p1);
        intro();
        scene.initialScene();

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 1:
                    System.out.println("you walk forward into a pit full of spikes.");
                    p1.killShot();
                    break;

                case 2:
                    System.out.println("the forest only gets darker.. ");
                    p1.moreHungry();
                    scene.initialScene();
                    break;

                case 3:
                    System.out.println("you pack your sleeping bag into your kit and set out into the darkness.");
                    p1.smallExp();
                    scene.doorScene();
                    break;
            }

            if (p1.isDead()) {
                quit = true;
            }
        }
    }

    private static void intro() {
        System.out.println("You awake from a horrifying dream, and find yourself in a dark forest.  You stand up, pondering your next action");
    }

    private static void name(Player p1) {
        System.out.println("What is your name?");
        String name = scanner.nextLine();

        if (!(name.equals(""))) {
            p1.setName(name);
            System.out.println(p1);
        }

        while (name.equals("")) {
            System.out.println("No really, what's your name?");
            name = scanner.nextLine();

            if (!(name.equals(""))) {
                p1.setName(name);
                System.out.println(p1);
            }
        }
    }

    public static void tutorialCombat() throws InterruptedException {
        System.out.println("A wild boar charges the wall with a snort!");

        Player p2 = new Player("wall", 100, 1);
        Monster boar = new Monster("boar", 10, 10);

        int attackCount = 0;
        while (!(boar.isDead()) && !(p2.isDead())) {

            p2.defend(boar.attack(18,70));
            attackCount +=1;
            Thread.sleep(2000);

            if (attackCount > boar.getHealth()){
                System.out.println("The boar collapses in exhaustion!  You made it!");
                boar.setDead(true);
            }
        }
    }

}
