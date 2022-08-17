import java.util.Random;

public abstract class Story {

    Game game;
    GameUI ui;
    ScreenTransitions transitionManager;
    Player player = new Player();
    Monster monster;
    GiantSlime giantSlime;
    Fish fish;
    String currentScreen;
    PlayerItem items;
    boolean isBridgeRebuilt = false;
    
    public Story(Game g, GameUI userInterface, ScreenTransitions st) {
        game = g;
        ui = userInterface;
        transitionManager = st;
    }

    public abstract void choosePosition(String nextPosition); // Controls which method needs to be called 

    public void defaultValues() // Resets to default game values if game ends or player dies
    {
        player.resetToMaxHp(); 
        player.increaseBalance(-(player.getBalance()));
        player.getSpecialItemsList().clear();
        ui.coinsNumberLabel.setText("" + player.getBalance());
        ui.healthNumberLabel.setText("" + player.getHp());
    }

    public void openInventory() { // displays list of player's items
        fish = new RedSnapper();
        fish = new Anchovy();
        items = new FishingRod();
        items = new HealthPotion();
        items = new Key();
        items = new Wood();
        items = new InfinityBlade();
        items = new WarriorsShield();

        ui.storyTextArea.setText("Anchovies: " + (fish.getAnchovyQuantity()) + "\nRed Snapper: " + (fish.getRedSnapperQuantity())
        +"\nFishing rod: " + (items.getFishingRodQuantity()) + "\nHealth potions: " + (items.getHealthPotionQuantity()) + "\nDungeon Keys: " + 
        (items.getKeyQuantity()) + "\nWood: " + (items.getWoodQuantity()) + "\nInfinity Blade: " + (items.getInfinityBladeQuantity() + "\nWarrior's Shield: " + (items.getWarriorsShieldQuantity())));
        
    }


    public void playerHouse(String storyText) { // Shows options if player is in house 
        transitionManager.showInventoryButton("House");
        game.nextPosition5 = "playerHouse";
        ui.storyTextArea.setText(storyText);
        ui.option1.setText("Abandoned Mines");
        ui.option2.setText("Enchanted Woods");
        ui.option3.setText("Beach");
        ui.option4.setText("");

        game.nextPosition1 = "abandonedMines";
        game.nextPosition2 = "woods";
        game.nextPosition3 = "beach";
        game.nextPosition4 = "";
    }

    public void changeLocation(String storyText, String exitingFrom) { // Changes location by going back to player house
        ui.storyTextArea.setText(storyText);
        ui.locationNameLabel.setText(exitingFrom);
        ui.option1.setText(">");
        ui.option2.setText("");
        ui.option3.setText("");
        ui.option4.setText("");

        game.nextPosition1 = "changeLocation";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void intermediateScreen(String storyText, String locationName, String nextScreen) { // Displays any text passed as well as continue (>) button.
        ui.storyTextArea.setText(storyText);
        ui.locationNameLabel.setText(locationName);
        ui.option1.setText(">");
        ui.option2.setText("");
        ui.option3.setText("");
        ui.option4.setText("");

        game.nextPosition1 = nextScreen;
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public int generateRandomNumber(int upTo) // Generates a random number between 0 and the number passed
    {
        int randomNum;
        Random randomNumber = new Random();
        randomNum = randomNumber.nextInt(upTo);

        return randomNum;
    }


}
