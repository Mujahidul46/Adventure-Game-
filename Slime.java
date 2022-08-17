public class Slime extends Monster {
    public Slime() {
        super("Slime", 5, 2, 56);

    }

    public String monsterDialogue() {
        monsterDialogue = "The slime clumsily jumps and hits you!";
        return monsterDialogue;
    }
}
