import java.util.ArrayList;
import java.util.Random;

public class Player {
    
    private static double hp;
    private static double maxHp = 50;
    private static int balance;
    private static ArrayList<String> specialItems = new ArrayList<String>();
    private static int playerDamage;


    // Getter methods

    public double getHp() { // Returns player hp
        return hp;
    }

    public double getMaxHp() {  // returns player's maximum hp
        return maxHp;
    }

    public int getBalance() { // returns number of coins player has
        return balance;
    }

    public ArrayList<String> getSpecialItemsList() { // returns arraylist of items
        return specialItems;
    }

    public int getPlayerDamage() {
        return playerDamage;
    }


    // Setter methods

    public void setHp(double newHp) { // sets player hp
        hp = newHp;
    }

    public void resetToMaxHp() { // resets player hp to max
        hp = maxHp;
    }

    public void decreaseHp(int decreaseBy) { // decreases player hp
        hp -= decreaseBy;
    }

    public void increaseBalance(int amount) { // increases player balance
        balance += amount;
    }

    public int setPlayerDamage() { // Sets default player damage 
        Random randomDmgNumber = new Random();
        playerDamage = randomDmgNumber.nextInt(10);

        return playerDamage;
    }

    public int setPlayerDamage(int maxDmg) { // Sets damage to go up to the number passed
        Random randomDmgNumber = new Random();
        playerDamage = randomDmgNumber.nextInt(maxDmg);

        return playerDamage;
    }


}


