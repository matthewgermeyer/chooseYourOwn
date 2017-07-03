package com.example.entity;

import com.example.Main;

import java.util.Scanner;

/**
 * Created by MattyG on 7/3/17.
 */

public class Scene {
Scanner scanner = new Scanner(System.in);
    private String name;

    public Scene(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void initialScene() {
        System.out.println("1 - Walk Forward\n" +
                "2 - cower in fear\n" +
                "3 - pack up your equipment and proceed\n");
    }

    public void doorScene() throws InterruptedException {
        System.out.println("You come across a large glyphed wall which seems to glow\n");

        System.out.println("1 - Touch it!!\n" +
                           "2 - Analyze what you are able to see\n");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Main.tutorialCombat();
                break;
            case 2:
                System.out.println("you live for now\n");
                break;
        }

    }


}



