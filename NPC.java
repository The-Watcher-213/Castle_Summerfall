import java.util.Random;

public class NPC extends Actor {
    protected String npcAllience;

    public NPC() {

    }

    public NPC(String allience) {
        setAllience(allience);

    }

    public void setAllience(String allience) {
        npcAllience = allience;
    }

    public void npcTurnNoneCombat(String doorLocation, boolean doorLocked, boolean doorBarred) {
        for (int i = 0; i < speed; i++) {
            if (health <= health / 2) {
            }
        }

    }

}
