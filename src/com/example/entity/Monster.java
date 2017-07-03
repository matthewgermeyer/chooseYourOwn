package com.example.entity;

/**
 * Created by MattyG on 7/3/17.
 */
public class Monster {
    private String name;
    private int health;
    private int attack;
    private int accuracy;
    private int critChance;
    private boolean isDead;

    public Monster(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.accuracy = 75;
        this.critChance = 5;
        this.isDead = false;
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

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getCritChance() {
        return critChance;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public void setCritChance(int critChance) {
        this.critChance = critChance;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", accuracy=" + accuracy +
                ", critChance=" + critChance +
                '}';
    }

    public boolean hitRoll(int accuracy) {
        boolean isHit = false;

        int roll = (int) (Math.random() * 101);
        if (roll <= accuracy) {
            isHit = true;
        }
        return isHit;
    }

    public int attack(int attack, int accuracy) {
        if (hitRoll(accuracy)) {
            System.out.println("Hit!");
            System.out.println(attack + " damage inflicted!");
            return attack;

        }
        System.out.println("Miss!\n");
        return 0;
    }


}
