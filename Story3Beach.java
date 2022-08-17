public class Story3Beach extends Story {

    public Story3Beach(Game g, GameUI userInterface, ScreenTransitions st) {
        super(g, userInterface, st);
    }
    
    

    public void choosePosition(String nextPosition) { // Controls which method needs to be called

        switch (nextPosition) {
            case "beach": beach("It's a cloudless warm day. What would you like to do?"); break;
            case "enterElliotsShop": enterElliotsShop("You are inside Elliot's shop."); break;
            case "talkToElliot": talkToElliot(); break;
            case "buyFishingRod": buyFishingRod(); break;
            case "sellFish": sellFish(); break;
            case "sellAllFish": sellAllFish(); break;
            case "dialogueOption1": dialogueElliot1(); break;
            case "leaveShop": beach("What do you want to do?"); break;
            case "goFishing": goFishing(); break;
            case "leaveDocks": leaveDocks(); break;
            case "castFishingLine": castFishingLine(); break;
            case "caughtFish": caughtFish(); break;
            case "failToCatchFish": failToCatchFish(); break;
            case "rebuildBridge": rebuildBridge(); break;
            case "battleGiantSlime": battleGiantSlime(); break;
            case "approachGiantSlime": approachGiantSlime(); break;
            case "stabGiantSlime": playerHitGiantSlime(); break;
            case "giantSlimeAttacks": giantSlimeAttacks(); break;
            case "runFromSlime": runFromSlime(); break;
            case "endGameScreen": endGameScreen(); break;
            case "leaveBeach": exitBeach(); break;
        }
    }

    public void beach(String storyText) { // Display main text and text on buttons once beach entered
        transitionManager.showInventoryButton("Beach");
        game.nextPosition5 = "beach";

        ui.storyTextArea.setText(storyText);
        ui.locationNameLabel.setText("Beach");
        ui.option1.setText("Go fishing");
        ui.option2.setText("Enter Elliot's Shop");
        ui.option3.setText("Cross bridge");
        ui.option4.setText("Leave the beach");

        game.nextPosition1 = "goFishing";
        game.nextPosition2 = "enterElliotsShop";
        game.nextPosition3 = "rebuildBridge";
        game.nextPosition4 = "leaveBeach";
    }

    public void enterElliotsShop(String storyText) { // Shows options once player enters shop
        transitionManager.showInventoryButton("Shop");
        game.nextPosition5 = "enterElliotsShop";

        ui.storyTextArea.setText(storyText);
        ui.locationNameLabel.setText("Shop");
        ui.option1.setText("Talk to Elliot");
        ui.option2.setText("Buy rod (100g)");
        ui.option3.setText("Sell fish");
        ui.option4.setText("Leave shop");

        game.nextPosition1 = "talkToElliot";
        game.nextPosition2 = "buyFishingRod";
        game.nextPosition3 = "sellFish";
        game.nextPosition4 = "leaveShop";
    }

    public void talkToElliot() { // Shows options once user clicks talk to Elliot
        transitionManager.showInventoryButton("Shop");
        game.nextPosition5 = "talkToElliot";


        ui.storyTextArea.setText("Ask Elliot: ");
        ui.locationNameLabel.setText("Shop");
        ui.option1.setText("What do you do here?");
        ui.option2.setText("Err.. nothing");
        ui.option3.setText("");
        ui.option4.setText("");

        game.nextPosition1 = "dialogueOption1";
        game.nextPosition2 = "enterElliotsShop";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void buyFishingRod() { // Adds rod to inventory if user has enough gold
        transitionManager.showInventoryButton("Shop");
        game.nextPosition5 = "buyFishingRod";

        if(player.getBalance() >= 100) {
            items = new FishingRod();
            items.increasingFishingRodQuantity(1);
            player.increaseBalance(-100);
            player.getSpecialItemsList().add("Fishing rod");
            ui.coinsNumberLabel.setText("" + player.getBalance());
            intermediateScreen("You have bought 1 " + items.getItemName() + " for 100 coins", "Beach", "enterElliotsShop");
        }
        else if(player.getBalance() < 100){
            intermediateScreen("You do not have enough coins to buy a fishing rod.\nYou need 100 gold.", "Shop", "enterElliotsShop");
        }
        
       
    }

    public void dialogueElliot1() { // Shows dialogue for talking to Elliot
        transitionManager.showInventoryButton("Shop");
        game.nextPosition5 = "dialogueOption1";

        intermediateScreen("Elliot: fish", "Shop", "talkToElliot");
    }

    public void sellFish() { // Allows player to choose if they would like to sell fish
        transitionManager.showInventoryButton("Shop");
        game.nextPosition5 = "sellFish";

        ui.storyTextArea.setText("What would you like to sell?");
        ui.locationNameLabel.setText("Shop");
        ui.option1.setText("Sell all fish");
        ui.option2.setText("Err.. nothing");
        ui.option3.setText("");
        ui.option4.setText("");

        game.nextPosition1 = "sellAllFish";
        game.nextPosition2 = "enterElliotsShop";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void sellAllFish() { // Sells all fish user has

        try {
            if((fish.getAnchovyQuantity() + fish.getRedSnapperQuantity()) == 0) { // Extra if statement required so noFishToSell is called even if player successfuly sells and then tries to sell again when they have 0 fish
                noFishToSell();
            }
            else {
                transitionManager.showInventoryButton("Shop");
                game.nextPosition5 = "sellAllFish";
    
                player.increaseBalance((fish.getAnchovyQuantity() + fish.getRedSnapperQuantity()) * fish.getCommonFishCost());
                System.out.println("PLAYER BAL IS NOW: " + player.getBalance());
                ui.coinsNumberLabel.setText("" + player.getBalance());
        
                intermediateScreen("You have sold " + fish.getAnchovyQuantity() + " anchovies and " + fish.getRedSnapperQuantity() + " red snappers." , "Shop", "enterElliotsShop");
                fish.resetAllFish(0);
            }

        }
        catch(Exception e) {
            noFishToSell();
        }
    }

    public void noFishToSell() { // Informs player that they have no fish
        transitionManager.showInventoryButton("Shop");
        game.nextPosition5 = "sellAllFish";

        intermediateScreen("You have no fish to sell.", "Shop", "enterElliotsShop");
    }

    public void goFishing() { // Shows options: cast line or leave docks
        transitionManager.hideInventoryButton("Docks");
        

        ui.storyTextArea.setText("You are at the fishing dock.");
        ui.locationNameLabel.setText("Docks");
        ui.option1.setText("Cast your line");
        ui.option2.setText("Leave docks");
        ui.option3.setText("");
        ui.option4.setText("");

        game.nextPosition1 = "castFishingLine";
        game.nextPosition2 = "leaveDocks";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void castFishingLine() { // If player has rod, allows them to fish
        if(! player.getSpecialItemsList().contains("Fishing rod")) {
            intermediateScreen("You need a fishing rod to do that.", "Docks", "goFishing");
        }
        else if(player.getSpecialItemsList().contains("Fishing rod")) {

            transitionManager.hideInventoryButton("Docks");
        
            ui.storyTextArea.setText("You cast your line and wait...");
            ui.locationNameLabel.setText("Docks");

            ui.option1.setText(">");
            ui.option2.setText("Stop fishing");
            ui.option3.setText("");
            ui.option4.setText("");
            
            if (generateRandomNumber(100) < 35) { // 35% chance to catch fish
                game.nextPosition1 = "caughtFish";
                game.nextPosition2 = "beach";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
            }
            else { // Fails to catch fish
                game.nextPosition1 = "failToCatchFish";
                game.nextPosition2 = "beach";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
            }
        }    
    }

    public void chooseFish(int randomNumber) { // Randomly generates fish. 
        if (randomNumber <= 50) {
            fish = new Anchovy();
            fish.increaseAnchovyQuantity(1);
        }
        else if (randomNumber <= 100) {
            fish = new RedSnapper();  
            fish.increaseRedSnapperQuantity(1); 
        }
    }

    public void caughtFish() { // Shows what fish player caught
        transitionManager.hideInventoryButton("Docks");

        chooseFish(generateRandomNumber(100));

        ui.storyTextArea.setText("You caught a" + fish.getFishSpecies());
        ui.locationNameLabel.setText("Docks");

        ui.option1.setText(">");
        ui.option2.setText("Stop fishing");
        ui.option3.setText("");
        ui.option4.setText("");

        game.nextPosition1 = "castFishingLine";
        game.nextPosition2 = "beach";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void failToCatchFish() { // Informs player they failed to catch fish
        transitionManager.showInventoryButton("Docks");
        game.nextPosition5 = "failToCatchFish";

        intermediateScreen("You failed to catch a fish.", "Docks", "castFishingLine");
    }

    public void rebuildBridge() {  // If player has 10 wood, rebuilds bridge
        transitionManager.showInventoryButton("Bridge");
        game.nextPosition5 = "rebuildBridge";

        items = new Wood();

        if(isBridgeRebuilt) {
            intermediateScreen("You cross the bridge into the swamp...", "Swamp", "battleGiantSlime");
        }
        else {
            if(items.getWoodQuantity() < 10) {
                notEnoughWood();
            }
            else if(items.getWoodQuantity() >= 10) {
                items.increaseWoodQuantity(-10);
                intermediateScreen("You successfully rebuild the bridge using 10 pieces of wood.\n\nYou cross the bridge and are in a giant swamp.", "Bridge", "battleGiantSlime");
                isBridgeRebuilt = true;
            }
        }
    }

    public void notEnoughWood() { // Informs player they don't have enough wood
        transitionManager.showInventoryButton("Bridge");
        game.nextPosition5 = "rebuildBridge";

        intermediateScreen("The bridge is broken.\n\nYou need 10 logs to rebuild the bridge.", "Bridge", "beach");
    }

    public void battleGiantSlime() { // Shows options: approach giant slime or run
        transitionManager.showInventoryButton("Swamp");
        game.nextPosition5 = "battleGiantSlime";

        ui.storyTextArea.setText("You see a massive giant slime in the distance bobbing towards you! What do you do?");
        ui.locationNameLabel.setText("Swamp");

        ui.option1.setText("Approach Giant Slime");
        ui.option2.setText("Run Away");
        ui.option3.setText("");
        ui.option4.setText("");

        game.nextPosition1 = "approachGiantSlime";
        game.nextPosition2 = "runFromSlime";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void approachGiantSlime() { // If player has infinity blade and warrior's shield, allows them to fight giant slime
        transitionManager.hideInventoryButton("Swamp");
        if(! (player.getSpecialItemsList().contains("Infinity Blade") && player.getSpecialItemsList().contains("Warrior's Shield"))) {
            intermediateScreen("You don't feel strong enough to attack the slime.\n\nYou need some items before you can take on the Giant Slime!", "Swamp", "battleGiantSlime");
        }
        else if((player.getSpecialItemsList().contains("Infinity Blade") && player.getSpecialItemsList().contains("Warrior's Shield"))) {
            monster = new GiantSlime();

            transitionManager.hideInventoryButton("Swamp");
        
            ui.storyTextArea.setText("You feel strong enough to take on the Giant Slime and equip your Infinity Blade and Warrior's Shield.");
            ui.locationNameLabel.setText("Swamp");

            ui.option1.setText("Stab Giant Slime");
            ui.option2.setText("Run Away");
            ui.option3.setText("");
            ui.option4.setText("");

            game.nextPosition1 = "stabGiantSlime";
            game.nextPosition2 = "runFromSlime";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }  
    }

    public void playerHitGiantSlime() { // Player does damage to giant slime
        transitionManager.hideInventoryButton("Swamp");

        int playerHitDamage = generateRandomNumber(50); // Remove this once weapons added
        monster.decreaseMonsterHp(playerHitDamage);

        if (monster.getMonsterHp() < 0) { // Displays 0 health if monster's health is a negative number
            monster.setMonsterHp(0);
        }
        
        ui.storyTextArea.setText("You attacked the " + monster.getMonsterName() + " for " + playerHitDamage + " damage!\n" + monster.getMonsterName() + " HP: " + monster.getMonsterHp() );

        ui.option1.setText(">");
        ui.option2.setText("");
        ui.option3.setText("");
        ui.option4.setText("");

        if (monster.getMonsterHp() > 0) {
            game.nextPosition1 = "giantSlimeAttacks";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else if (monster.getMonsterHp() <= 0) { // If monster dead, player beats game             
            game.nextPosition1 = "endGameScreen";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }

    public void giantSlimeAttacks() { // Giant slime does damage to player
        transitionManager.hideInventoryButton("Swamp");
        
        int monsterHitDamage = generateRandomNumber(monster.getMonsterMaxHit());
        ui.storyTextArea.setText("The " + monster.getMonsterName() + " attacks you for " + monsterHitDamage + 
        " damage!\n\nYour Warrior's Shield blocks some of the damage!");

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
            game.nextPosition1 = "stabGiantSlime";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else if (player.getHp() <= 0) {
            game.nextPosition1 = "gameOver";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }

    public void runFromSlime() { // Runs from giant slime
        transitionManager.showInventoryButton("Swamp");
        game.nextPosition5 = "runFromSlime";

        intermediateScreen("You turn around and run for your life, crossing the bridge back to the beach.", "Bridge", "beach");
    }

    public void leaveDocks() { // Player left docks
        transitionManager.showInventoryButton("Beach");
        game.nextPosition5 = "beach";

        intermediateScreen("You left the docks", "Beach", "beach");
    }

    public void endGameScreen() { // Screen shown if player beats game
        transitionManager.showInventoryButton("Swamp");

        game.nextPosition5 = "endGameScreen";
        ui.storyTextArea.setText("Congratulations! You successfully defeated the Giant Slime.\n\nYou help the Wizard by bringing him the items he need.\n\nThanks for playing!");

        ui.option1.setText("To menu");
        ui.option2.setText("");
        ui.option3.setText("");
        ui.option4.setText("");

        game.nextPosition1 = "toStartScreen";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void exitBeach() { // Player changes location to either mines/wood/beach
        transitionManager.showInventoryButton("Beach");
        game.nextPosition5 = "leaveBeach";

        changeLocation("You have left the beach.", "Beach");
    }
}
