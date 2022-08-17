public class Story2Woods extends Story {

    public Story2Woods(Game g, GameUI userInterface, ScreenTransitions st) {
        super(g, userInterface, st);
    }

    public void choosePosition(String nextPosition) { // Controls which method needs to be called

        switch (nextPosition) {
            case "woods": woods("It's a rainy day in the woods. What would you like to do?"); break;
            case "collectWood": collectWood(); break;
            case "enterWizardsCastle": enterWizardsCastle(); break;
            case "wizardDialogue": wizardDialogue(); break;
            case "leaveCastle": leaveCastle(); break;
            case "wizardQuest": wizardQuest(); break;
            case "acceptQuest": acceptQuest(); break;
            case "visitTrader": visitTrader(); break;
            case "buyFromTrader": buyFromTrader(); break;
            case "leaveTrader": leaveTrader(); break;
            case "leaveWoods": exitWoods(); break;
        }
    }

    public void woods(String storyText) { // Shows options once user enters woods
        transitionManager.showInventoryButton("Woods");
        game.nextPosition5 = "woods";

        ui.storyTextArea.setText(storyText);
        ui.locationNameLabel.setText("Woods");
        ui.option1.setText("Collect Wood");
        ui.option2.setText("Enter Wizard's Castle");
        ui.option3.setText("Visit Trader");
        ui.option4.setText("Leave Woods");

        game.nextPosition1 = "collectWood";
        game.nextPosition2 = "enterWizardsCastle";
        game.nextPosition3 = "visitTrader";
        game.nextPosition4 = "leaveWoods";
    }

    public void collectWood() { // Adds wood to player's inventory
        transitionManager.hideInventoryButton("Woods");

        items = new Wood();
        items.increaseWoodQuantity(5);
        
        intermediateScreen("You use a steel axe you found.\n\nChop chop. You chop a tree down and get 5 " + items.getItemName() + "!", "Woods", "woods");
    }

    public void enterWizardsCastle() { // Shows options once player enters wizard's castle
        transitionManager.showInventoryButton("Castle");
        game.nextPosition5 = "enterWizardsCastle";

        ui.storyTextArea.setText("Wizard:\tHello there, what can I do for you?");
        ui.locationNameLabel.setText("Castle");
        ui.option1.setText("What do you do here?");
        ui.option2.setText("Ask for a quest");
        ui.option3.setText("Leave castle");
        ui.option4.setText("");

        game.nextPosition1 = "wizardDialogue";
        game.nextPosition2 = "wizardQuest";
        game.nextPosition3 = "leaveCastle";
        game.nextPosition4 = "";
    }

    public void wizardDialogue() { // Displayers text once user clicks talk to wizard
        transitionManager.showInventoryButton("Wizard's Castle");
        game.nextPosition5 = "wizardDialogue";

        intermediateScreen("Wizard:\twizard stuff...", "Castle", "enterWizardsCastle");
    }

    public void wizardQuest() { // Shows options once user clicks Quest button
        transitionManager.showInventoryButton("Castle");
        game.nextPosition5 = "wizardQuest";

        ui.storyTextArea.setText("Wizard: I need somebody to repair the bridge by the beach.\n\nI need some ingredients for my potions which are only found there...\n\nThere may be monsters lurking around so be careful!");
        ui.locationNameLabel.setText("Castle");
        ui.option1.setText("Accept quest");
        ui.option2.setText("Sorry, maybe later");
        ui.option3.setText("");
        ui.option4.setText("");

        game.nextPosition1 = "acceptQuest";
        game.nextPosition2 = "enterWizardsCastle";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void acceptQuest() { // Shows dialogue once user accepts quest and adds shield to inventory
        transitionManager.showInventoryButton("Castle");
        game.nextPosition5 = "enterWizardsCastle";

        intermediateScreen("You accept the quest.\n\nThe wizard gives you a Warrior's Shield which he thinks will be useful...", "Castle", "enterWizardsCastle");
        player.getSpecialItemsList().add("Warrior's Shield");
        items = new WarriorsShield();
        items.increaseWarriorShieldQuantity(1);
    }

    public void leaveCastle() { // Leaves castle
        transitionManager.showInventoryButton("Woods");
        game.nextPosition5 = "leaveCastle";

        intermediateScreen("You have left the Wizard's Castle", "Woods", "woods");
    }

    public void visitTrader() { // Shows options once player visits trader
        transitionManager.showInventoryButton("Woods");
        game.nextPosition5 = "visitTrader";

        ui.storyTextArea.setText("Trader: Hello there, would you like to purchase an Infinity Blade? It is a very strong sword! It costs 100 gold.");
        ui.locationNameLabel.setText("Woods");
        ui.option1.setText("Yes Please");
        ui.option2.setText("No, sorry");
        ui.option3.setText("");
        ui.option4.setText("");

        game.nextPosition1 = "buyFromTrader";
        game.nextPosition2 = "leaveTrader";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void buyFromTrader() { // Adds Infinity Blade to inventory if user has enough gold
        transitionManager.showInventoryButton("Trader");
        game.nextPosition5 = "buyFromTrader";

        if(player.getBalance() >= 100){
            items = new InfinityBlade();
            items.increaseInfinityBladeQuantity(1);
            player.increaseBalance(-100);
            player.getSpecialItemsList().add("Infinity Blade");
            ui.coinsNumberLabel.setText("" + player.getBalance());
            intermediateScreen("You have bought 1 Infinity Blade for 100 coins and leave the trader.", "Trader", "woods");
        }
        else if(player.getBalance() < 100){
            intermediateScreen("You do not have enough coins to buy an Infinity Blade.\nYou need 100 gold.", "Trader", "visitTrader");
        }
    }

    public void leaveTrader() { // Leaves trader
        transitionManager.showInventoryButton("Woods");
        game.nextPosition5 = "leaveTrader";

        intermediateScreen("You leave the trader and continue walking in the woods.", "Woods", "woods");
    }


 
    public void exitWoods() { // Changes location so player can go to mines/woods/beach
        transitionManager.showInventoryButton("Woods");
        game.nextPosition5 = "leaveWoods";

        changeLocation("You have left the Enchanted Woods.", "Woods");
    }
}
