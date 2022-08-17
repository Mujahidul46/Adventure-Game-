public class Skeleton extends Monster {
    
    public Skeleton() {
        super("Skeleton", 15, 4, 135);
    }

    public String monsterDialogue() {
        monsterDialogue = "The skeleton smacks you in the face!";
        return monsterDialogue;
    }
}
