public class GiantSlime extends Monster {
    
    public GiantSlime() {
        super("Giant Slime", 100, 15, 5000);  

    }

    public String monsterDialogue() {
        monsterDialogue = "The Giant Slime towers over you and smacks you!";
        return monsterDialogue;
    }
}