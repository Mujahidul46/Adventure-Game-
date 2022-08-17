public class Fish {
    private String fishSpecies;
    private static int anchovyQuantity = 0; 
    private static int redSnapperQuantity = 0;
    private static int commonFishCost;

    // Getter methods

    public String getFishSpecies() {
        return fishSpecies;
    }

    public int getAnchovyQuantity() {
        return anchovyQuantity;
    }

    public int getRedSnapperQuantity() {
        return redSnapperQuantity;
    }

    public int getCommonFishCost() {
        return commonFishCost;
    }

    // Setter methods

    public void setFishSpecies(String newFishSpecies) {
        this.fishSpecies = newFishSpecies;
    }

    public void increaseAnchovyQuantity(int amount) {
        anchovyQuantity += amount;
    }

    public void increaseRedSnapperQuantity(int amount) {
        redSnapperQuantity += amount;
    }

    public void setCommonFishCost(int amount) {
        commonFishCost = amount;
    }

    public void resetAllFish(int resetTo) { // Resets all fish to 0
        anchovyQuantity = resetTo;
        redSnapperQuantity = resetTo;
    }



}
