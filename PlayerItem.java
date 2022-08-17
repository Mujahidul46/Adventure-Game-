public class PlayerItem {
    private static String itemName;
    private static int fishingRodQuantity = 0; 
    private static int healthPotionQuantity = 0;
    private static int keyQuantity = 0;
    private static int woodQuantity = 0;
    private static int infinityBladeQuantity = 0;
    private static int warriorShieldQuantity = 0;

    // Getter methods

    public String getItemName() { 
        return itemName;
    }

    public int getFishingRodQuantity() {
        return fishingRodQuantity;
    }

    public int getHealthPotionQuantity() {
        return healthPotionQuantity;
    }

    public int getKeyQuantity() {
        return keyQuantity;
    }

    public int getWoodQuantity() {
        return woodQuantity;
    }

    public int getInfinityBladeQuantity() {
        return infinityBladeQuantity;
    }

    public int getWarriorsShieldQuantity() {
        return warriorShieldQuantity;
    }


    // Setter methods

    public void setItemName(String newItemName) {
        itemName = newItemName;
    }

    public void increasingFishingRodQuantity(int amount) {
        fishingRodQuantity += amount;
    }

    public void increaseHealthPotionQuantity(int amount) {
        healthPotionQuantity += amount;
    }

    public void increaseKeyQuantity(int amount) {
        keyQuantity += amount;
    }


    public void increaseWoodQuantity(int amount) {
        woodQuantity += amount;
    }

    public void increaseInfinityBladeQuantity(int amount) {
        infinityBladeQuantity += amount;
    }

    public void increaseWarriorShieldQuantity(int amount) {
        warriorShieldQuantity += amount;
    }

    public void resetAllItems(int resetTo) { // Resets all items to 0 quantity
        fishingRodQuantity = resetTo;
        healthPotionQuantity = resetTo;
        keyQuantity = resetTo;
        woodQuantity = resetTo;
        infinityBladeQuantity = resetTo;
        warriorShieldQuantity = resetTo;
    }



}
