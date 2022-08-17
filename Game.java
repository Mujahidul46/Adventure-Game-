public class Game {

    OptionsManager choiceManager = new OptionsManager(this);
    GameUI UI = new GameUI();
    ScreenTransitions st = new ScreenTransitions(UI);
    Story1Mines s1 = new Story1Mines(this, UI, st);
    Story2Woods s2 = new Story2Woods(this, UI, st);
    Story3Beach s3 = new Story3Beach(this, UI, st);
    String nextPosition1, nextPosition2, nextPosition3, nextPosition4, nextPosition5;

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        UI.createGameUI(choiceManager);
        s1.defaultValues();
        st.displayMenuScreen();
    }

}



