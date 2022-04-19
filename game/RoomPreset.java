package game;

import java.util.ArrayList;

public class RoomPreset {
    public String[] descriptions;
    public ArrayList<InteractablePreset> interactables;
    public ArrayList<InteractablePreset> descriptionInteractables;
    public NPC boss;

    public RoomPreset(String[] descriptions, ArrayList<InteractablePreset> interactables,
            ArrayList<InteractablePreset> descriptionInteractables) {
        this.descriptions = descriptions;
        this.interactables = interactables;
        this.descriptionInteractables = descriptionInteractables;
    }
    
}