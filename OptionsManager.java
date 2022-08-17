import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionsManager implements ActionListener{

    Game game;
    public OptionsManager(Game g) {
        game = g;
    }

    public void actionPerformed(ActionEvent event){

        String yourChoice = event.getActionCommand();
        

        if(yourChoice == "clickedPlay") { // Shows initial options once play button is clicked
            game.st.transitionToGame(); 
            game.s1.playerHouse("Tired of the monotonous cycle of city life, you decide to leave it all and return to your countryside home:\n\nWillowdale Valley\n\nWhere would you like to go?");
        }

        if(yourChoice == "clickedOpenInventory") {
            game.st.transitionToInventory();
            game.s1.openInventory();
        }

    
        if(yourChoice == "clickedCloseInventory") {
            game.st.transitionToGame();
            
            game.s1.choosePosition(game.nextPosition5);
            game.s2.choosePosition(game.nextPosition5);
            game.s3.choosePosition(game.nextPosition5);   
        }

        if(yourChoice == "clickedOption1") { // Controls where each button takes the player for story 1 (abandoned mines)
            game.s1.choosePosition(game.nextPosition1);
        }
        else if(yourChoice == "clickedOption2") {
            game.s1.choosePosition(game.nextPosition2);
        }
        else if(yourChoice == "clickedOption3") {
            game.s1.choosePosition(game.nextPosition3);
        }
        else if(yourChoice == "clickedOption4") {
            game.s1.choosePosition(game.nextPosition4);
        }

        if(yourChoice == "clickedOption1") { // Controls where each button takes the player for story 2 (Enchanted Woods)
            game.s2.choosePosition(game.nextPosition1);
        }
        else if(yourChoice == "clickedOption2") {
            game.s2.choosePosition(game.nextPosition2);
        }
        else if(yourChoice == "clickedOption3") {
            game.s2.choosePosition(game.nextPosition3);
        }
        else if(yourChoice == "clickedOption4") {
            game.s2.choosePosition(game.nextPosition4);
        }

        if(yourChoice == "clickedOption1") { // Controls where each button takes the player for story 3 (beach)
            game.s3.choosePosition(game.nextPosition1);
        }
        else if(yourChoice == "clickedOption2") {
            game.s3.choosePosition(game.nextPosition2);
        }
        else if(yourChoice == "clickedOption3") {
            game.s3.choosePosition(game.nextPosition3);
        }
        else if(yourChoice == "clickedOption4") {
            game.s3.choosePosition(game.nextPosition4);
        }


}}