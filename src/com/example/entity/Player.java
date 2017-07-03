package com.example.entity;

/**
 * Created by MattyG on 7/3/17.
 */
public class Player {
    private String name;
    private int health;
    private  int hunger;
    private int level;
    private int exp;
    private boolean dead;

    public Player(String name, int health, int level) {
        this.name = name;
        this.health = health;
        this.level = level;
        this.hunger = 0;
        this.exp = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", hunger=" + hunger +
                ", level=" + level +
                ", exp=" + exp +
                '}';
    }

    public void moreHungry() {
        System.out.println("You feel a pain in your gut...when's the last time you ate?");
        hunger += 5;
        System.out.println("hunger increases by 5 to -> " + getHunger());
    }

    public void killShot() {
        health = 0;
        if (health < 1) {
            System.out.println("RIP");
            dead = true;
        }
    }

    public void smallExp() {
        exp += 105;
        checkLevel();
    }

    public void checkLevel() {
        if (exp >= 100) {
            int overflow = exp % 100;
            level+= 1;
            setExp(overflow);
            System.out.println("\nlevel up!!\n" +"now level " + level);
        }
    }

    public void checkDeath() {
        if (health < 1) {
            System.out.println("RIP -  Game Over");
            dead = true;
        }
    }

    public int defend(int attack) {
        setHealth(health - attack);
        System.out.println("Current HP: " +getHealth());
        checkDeath();

        return health;
    }


}




