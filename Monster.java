import java.util.Random;

public class Monster {
    private String monsterName; 
    private int monsterHp;
    private int monsterMaxHit;
    private int monsterCoinsDrop = 0;
    protected String monsterDialogue;

    public Monster(String name, int hp, int maxHit, int coinsDropNum) {
        this.monsterName = name;
        this.monsterHp = hp;
        this.monsterMaxHit = maxHit;
        this.monsterCoinsDrop = coinsDropNum;
    }

    public String monsterDialogue() {
        monsterDialogue = "The monster attacks you!";
        return monsterDialogue;
    }

    // Getter methods

    public String getMonsterName() { 
        return monsterName;
    }

    public int getMonsterMaxHit() { 
        return monsterMaxHit;
    }

    public int getMonsterHp() { 
        return monsterHp;
    }

    public int getMonsterCoinsDrop() {
        return monsterCoinsDrop;
    }

    // Setter methods

    public void setMonsterName(String newMonsterName) {
        this.monsterName = newMonsterName;
    }

    public void setMonsterMaxHit(int newMonsterMaxHit) {
        this.monsterMaxHit = newMonsterMaxHit;
    }

    public void setMonsterHp(int newMonsterMaxHp) {
        this.monsterHp = newMonsterMaxHp;
    }

    public void decreaseMonsterHp(int decreaseHpAmount) {
        monsterHp -= decreaseHpAmount;
    }

    public void setMonsterCoinsDrop(int newMonsterCoinsDrop) {
        monsterCoinsDrop = newMonsterCoinsDrop;
    }

    public int generateRandomNumber(int upTo) // Generates a random number between 0 and the number passed
    {
        int randomNum;
        Random randomNumber = new Random();
        randomNum = randomNumber.nextInt(upTo);

        return randomNum;
    }
}


