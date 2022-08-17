public class GiantSpider extends Monster {
    
    public GiantSpider() {
        super("Giant Spider", 11, 6, 200);  
    }

    public String monsterDialogue() {
        monsterDialogue = "The Giant Spider bites you!";
        return monsterDialogue;
    }
}