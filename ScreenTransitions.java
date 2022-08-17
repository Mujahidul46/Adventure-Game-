public class ScreenTransitions {

    GameUI ui;
    String[] locations = {"Home", "Mines", "Town", "Beach", "Woods"};

    public ScreenTransitions(GameUI userInterface) {
        ui = userInterface;

    }

    public void displayMenuScreen() { // displays menu screen
        ui.titlePanel.setVisible(true);
        ui.playButtonPanel.setVisible(true);

        ui.storyPanel.setVisible(false);
        ui.optionsPanel.setVisible(false);
        ui.playerStatusPanel.setVisible(false);
        ui.coinsPanel.setVisible(false);
        ui.inventoryPanel.setVisible(false);
        ui.closeInventoryPanel.setVisible(false);
        ui.inventoryTitlePanel.setVisible(false);
    }

    public void transitionToGame() { // goes to screen after user clicks play
        ui.titlePanel.setVisible(false);
        ui.playButtonPanel.setVisible(false);
        ui.closeInventoryPanel.setVisible(false);

        ui.storyPanel.setVisible(true);
        ui.optionsPanel.setVisible(true);
        ui.playerStatusPanel.setVisible(true);
        ui.coinsPanel.setVisible(true);
        ui.inventoryPanel.setVisible(true);
        ui.inventoryTitlePanel.setVisible(false);
        ui.locationNameLabel.setText(locations[0]);
    }

    public void transitionToInventory() { // goes to screen after user clicks inventory button
        ui.inventoryTitlePanel.setVisible(true);
        ui.storyPanel.setVisible(true);

        ui.titlePanel.setVisible(false);
        ui.playButtonPanel.setVisible(false);
        ui.closeInventoryPanel.setVisible(true);
        ui.optionsPanel.setVisible(false);
        ui.playerStatusPanel.setVisible(false);
        ui.coinsPanel.setVisible(false);
        ui.inventoryPanel.setVisible(false);
    }

    public void hideInventoryButton(String currentLocation) { // returns to screen user was on before inventory was clicked
        ui.titlePanel.setVisible(false);
        ui.playButtonPanel.setVisible(false);
        ui.closeInventoryPanel.setVisible(false);

        ui.storyPanel.setVisible(true);
        ui.optionsPanel.setVisible(true);
        ui.playerStatusPanel.setVisible(true);
        ui.coinsPanel.setVisible(true);
        ui.inventoryPanel.setVisible(false);
        ui.inventoryTitlePanel.setVisible(false);
        ui.locationNameLabel.setText(currentLocation);
    }

    public void showInventoryButton(String currentLocation) { // displays inventory button
        ui.titlePanel.setVisible(false);
        ui.playButtonPanel.setVisible(false);
        ui.closeInventoryPanel.setVisible(false);

        ui.storyPanel.setVisible(true);
        ui.optionsPanel.setVisible(true);
        ui.playerStatusPanel.setVisible(true);
        ui.coinsPanel.setVisible(true);
        ui.inventoryPanel.setVisible(true);
        ui.inventoryTitlePanel.setVisible(false);
        ui.locationNameLabel.setText(currentLocation);
    }
}
