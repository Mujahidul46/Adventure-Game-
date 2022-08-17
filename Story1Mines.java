public class Story1Mines extends Story {

    public Story1Mines(Game g, GameUI userInterface, ScreenTransitions st) { 
        super(g, userInterface, st);
    }

    public void choosePosition(String nextPosition) { // Controls which method needs to be called

        switch (nextPosition) {
            case "playerHouse": playerHouse("You are in your house."); break;
            case "abandonedMines": abandonedMines("What would you like to do?"); break;
            case "goMining": goMining(); break;
            case "slayMonsters": lookForMonsters(); break;
            case "drinkHealthPotion": drinkHealthPotion(); break;
            case "exploreMines": exploreMines(); break;
            case "enterDungeon": enterDungeon(); break;
            case "findChest": findChest(); break;
            case "exitMines": exitMines(); break;
            case "attackMonster": attackMonster(); break;
            case "runAway": runAway(); break;
            case "playerHit": playerHit(); break;
            case "monsterHit": monsterHit(); break;
            case "monsterDefeated": monsterDefeated(); break;
            case "gameOver": gameOver(); break;
            case "toStartScreen": toStartScreen(); break;
            case "changeLocation": playerHouse("Where would you like to go?"); break;
        }
    }

    public void chooseMonster(int randomNumber) { // Randomly generates monster. 
        if (randomNumber < 50) {
            monster = new Slime();
        }
        else if (randomNumber < 70) {
            monster = new Skeleton();
        }
        else if (randomNumber <= 100) {
            monster = new GiantSpider(); 
        }
    }

    public void abandonedMines(String storyText) { // Shows options once mines entered
        transitionManager.showInventoryButton("Mines");
        
        ui.storyTextArea.setText(storyText);
        ui.locationNameLabel.setText("Mines");
        ui.option1.setText("Mine for resources");
        ui.option2.setText("Search for monsters");
        ui.option3.setText("Go exploring");
        ui.option4.setText("Leave the mines");

        game.nextPosition1 = "goMining";
        game.nextPosition2 = "slayMonsters";
        game.nextPosition3 = "exploreMines";
        game.nextPosition4 = "exitMines";
        game.nextPosition5 = "abandonedMines";
    }

    public void goMining() { // Shows options once user clicks go mining
        transitionManager.showInventoryButton("Mines");
        game.nextPosition5 = "goMining";
        intermediateScreen("You need a pickaxe to do that.", "Mines", "abandonedMines");   
    }

    public void lookForMonsters() { // Shows options once user clicks search for monsters
        transitionManager.hideInventoryButton("Mines");
    
        int number = generateRandomNumber(100);

        chooseMonster(number);

        ui.storyTextArea.setText("You climb down a ladder and a " + monster.getMonsterName() + " appears.");
        ui.option1.setText("Attack");
        ui.option2.setText("Drink Health Potion");
        ui.option3.setText("Run");
        ui.option4.setText("");

        game.nextPosition1 = "attackMonster";
        game.nextPosition2 = "drinkHealthPotion";
        game.nextPosition3 = "runAway";
        game.nextPosition4 = "";
    }

    public void exploreMines() { // Randomly chooses a scanario once the user clicks explore mines
        transitionManager.showInventoryButton("Mines");
        game.nextPosition5 = "exploreMines";

        int randomNumber = generateRandomNumber(100);

        if (randomNumber <= 30) {
            intermediateScreen("Your footsteps echo through the cave as you look around...", "Mines", "exploreMines");
            findHealthPotion();
        }
        else if (randomNumber <= 60 && (! player.getSpecialItemsList().contains("Dungeon key"))) {
            intermediateScreen("You can barely see but spot a lava lake in the distance. You walk towards it...", "Mines", "exploreMines");
            findKey();
        }
        else if (randomNumber <= 90) {
            getStuckInWeb();
        }
        else if(randomNumber <= 100) {
            findSecretDungeon();
        } 
    }

    public void findHealthPotion() { // Adds a health potion to user's inventory
        transitionManager.hideInventoryButton("Mines");

        player.getSpecialItemsList().add("Health potion");
        items = new HealthPotion();
        items.increaseHealthPotionQuantity(1);
        intermediateScreen("You search a crate and find a " + items.getItemName() + "!", "Mines", "abandonedMines");
    }

    public void drinkHealthPotion() { // Increases player health
        transitionManager.hideInventoryButton("Mines");

        if(! player.getSpecialItemsList().contains("Health potion")){
            intermediateScreen("You do not have any health potions.", "Mines", "abandonedMines");
        }
        else if(player.getSpecialItemsList().contains("Health potion")) {
            items.increaseHealthPotionQuantity(-1);

            if(items.getHealthPotionQuantity() == 0) {
                player.getSpecialItemsList().remove("Health potion");
            }

            intermediateScreen("You drink your health potion and feel invigorated.", "Mines", "slayMonsters");
            player.setHp(player.getHp() + (player.getMaxHp() - player.getHp()) / 2);
            
            ui.healthNumberLabel.setText("" + player.getHp());
        }

    }

    public void findKey() { // Adds key to player's inventory
        transitionManager.hideInventoryButton("Mines");

        items = new Key();
        intermediateScreen("You find an item lying by a skeleton's corpse!\n" + items.getItemName() + "\nYou take it and head back.", "Mines", "abandonedMines");
        player.getSpecialItemsList().add(items.getItemName());
        items.increaseKeyQuantity(1);
    }

    public void findSecretDungeon() { // Shows options once user finds dungeon
        transitionManager.hideInventoryButton("Mines");

        ui.storyTextArea.setText("After walking down a long tunnel, you see a massive steel door.");
        ui.locationNameLabel.setText("Mines");
        ui.option1.setText("Enter Dungeon");
        ui.option2.setText("");
        ui.option3.setText("");
        ui.option4.setText("");

        game.nextPosition1 = "enterDungeon";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void enterDungeon() { // Allows user in dungeon if they have a key
        transitionManager.hideInventoryButton("Mines");

        if(! player.getSpecialItemsList().contains("Dungeon key")) {
            intermediateScreen("It looks like you need a key to enter.", "Mines", "abandonedMines");
        }
        else if(player.getSpecialItemsList().contains("Dungeon key")) {

            transitionManager.hideInventoryButton("Mines");
        
            ui.storyTextArea.setText("CLICK! You use your dungeon key to unlock the gate!");
            ui.locationNameLabel.setText("Mines");

            ui.option1.setText(">");
            ui.option2.setText("");
            ui.option3.setText("");
            ui.option4.setText("");

            game.nextPosition1 = "findChest";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }  
    }

    public void findChest() { // Adds random amount of coins to user's balance
        transitionManager.hideInventoryButton("Mines");

        int numOfCoinsInChest = generateRandomNumber(1000);
        intermediateScreen("You find a chest and take " + numOfCoinsInChest + " coins!", "Mines", "abandonedMines");
        player.increaseBalance(numOfCoinsInChest);
        ui.coinsNumberLabel.setText("" + player.getBalance());  
    }

    public void getStuckInWeb() { // Shows options if user gets stuck in web
        transitionManager.hideInventoryButton("Mines");
        int loseHealthRandomNum = generateRandomNumber(30);
        player.decreaseHp(loseHealthRandomNum); 
            
        if (player.getHp() < 0) { // Displays 0 health if player's health is a negative number
            player.setHp(0);
        }

        ui.healthNumberLabel.setText("" + player.getHp());

        ui.storyTextArea.setText("It's pitch black and you walk into a massive cobweb.\nA giant spider attacks you.\nYou manage to scare it away but get injured. You eventually free yourself and are exhausted.\nYou lose " + loseHealthRandomNum + " health.");
        ui.option1.setText(">");
        ui.option2.setText("");
        ui.option3.setText("");
        ui.option4.setText("");

        if (player.getHp() > 0) {
            game.nextPosition1 = "abandonedMines";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } 
        else if (player.getHp() <= 0) {
            game.nextPosition1 = "gameOver";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }

    public void exitMines() { // Shows text if user exits mines
        transitionManager.showInventoryButton("Mines");

        game.nextPosition5 = "exitMines";
        changeLocation("You have left the mines.", "Mines");
    }

    public void attackMonster() { // Shows options attack monster and run away
        transitionManager.hideInventoryButton("Mines");
        ui.storyTextArea.setText(monster.getMonsterName() + " has " + monster.getMonsterHp() + " HP. What do you do?");
        ui.option1.setText("Attack");
        ui.option2.setText("Run");
        ui.option3.setText("");
        ui.option4.setText("");

        game.nextPosition1 = "playerHit";
        game.nextPosition2 = "runAway";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void runAway() { // Shows text if user runs away
        transitionManager.showInventoryButton("Mines");
        
        game.nextPosition5 = "runAway";
        intermediateScreen("You run for your life!", "Mines", "abandonedMines");
    }

    public void playerHit() { // Shows options once player hits monster
        transitionManager.hideInventoryButton("Mines");
        
        if (player.getSpecialItemsList().contains("Infinity Blade")) {
            player.setPlayerDamage(30);
        }
        else {
            player.setPlayerDamage();
        }
        monster.decreaseMonsterHp(player.getPlayerDamage());

        if (monster.getMonsterHp() < 0) { // Displays 0 health if monster's health is a negative number
            monster.setMonsterHp(0);
        }
        
        ui.storyTextArea.setText("You attacked the " + monster.getMonsterName() + " for " + player.getPlayerDamage() + " damage!\n" + monster.getMonsterName() + " HP: " + monster.getMonsterHp() );

        ui.option1.setText(">");
        ui.option2.setText("");
        ui.option3.setText("");
        ui.option4.setText("");

        if (monster.getMonsterHp() > 0) {
            game.nextPosition1 = "monsterHit";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else if (monster.getMonsterHp() <= 0) {                
            game.nextPosition1 = "monsterDefeated";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }  
    }

    public void monsterHit() { // Shows options once monster hits player
        transitionManager.hideInventoryButton("Mines");
        
        int monsterHitDamage = generateRandomNumber(monster.getMonsterMaxHit());
        ui.storyTextArea.setText(monster.monsterDialogue() + " The " + monster.getMonsterName() + " attacks you for " + monsterHitDamage + 
        " damage!");

        player.decreaseHp(monsterHitDamage); 

        if (player.getHp() < 0) { // Displays 0 health if player's health is a negative number
            player.setHp(0);
        }
 
        ui.healthNumberLabel.setText("" + player.getHp());

        ui.option1.setText(">");
        ui.option2.setText("");
        ui.option3.setText("");
        ui.option4.setText("");

        if (player.getHp() > 0) {
            game.nextPosition1 = "playerHit";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } 
        else if (player.getHp() <= 0) {
            game.nextPosition1 = "gameOver";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }

    public void monsterDefeated() { // Shows text once user kills monster
        transitionManager.showInventoryButton("Mines");
        game.nextPosition5 = "monsterDefeated";

        intermediateScreen("You have killed the " + monster.getMonsterName() + "!\nIt dropped " + monster.getMonsterCoinsDrop() + " coins.", "Mines", "abandonedMines");
        player.increaseBalance(monster.getMonsterCoinsDrop());
        ui.coinsNumberLabel.setText("" + player.getBalance());   
    }

    public void gameOver() { // Allows player to restart if they die
        transitionManager.showInventoryButton("Mines");

        game.nextPosition5 = "gameOver";
        ui.storyTextArea.setText("You died.");

        ui.option1.setText("To menu");
        ui.option2.setText("");
        ui.option3.setText("");
        ui.option4.setText("");

        game.nextPosition1 = "toStartScreen";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
        
    }

    public void toStartScreen() { // Resets player's items
        game.nextPosition5 = "toStartScreen";

        try {
            items.resetAllItems(0);
            fish.resetAllFish(0);
            defaultValues();
            transitionManager.displayMenuScreen();
        }
        catch(Exception E) {
            transitionManager.displayMenuScreen();
        }

        
    }
}

    

