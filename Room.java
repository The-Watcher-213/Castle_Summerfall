
import java.util.ArrayList;

public class Room {
    private ArrayList<Interactable> interactables;
    private String description;
    private Door southDoor;
    private Door eastDoor;

    public Room(ArrayList<Interactable> interactables, String description, Door southDoor, Door eastDoor) {
        this.interactables = interactables;
        this.description = description;
        this.southDoor = southDoor;
        this.eastDoor = eastDoor;
    }

    public Room(int seed){
        
    }
    
    //Grab the description of the room
    public String getDescription(){
        StringBuilder describe = new StringBuilder();
        describe.append(description);
        switch (interactables.size()) {
            case 0:
                break;
            case 1:
            describe.append("\n");
            describe.append("There is a " + interactables.get(0).getName() + " in the room.");
            break;
            case 2:
            describe.append("\n");
            describe.append(String.format("In the room is a %s and a %s", interactables.get(0).getName(),interactables.get(0).getName()));
            break;
            default:
            describe.append("\n");
            for(int i = 0;i<interactables.size();i++){
                if(i != interactables.size() - 1){
                    describe.append(" a "+interactables.get(i).getName() + ",");
                } else{
                    describe.append(" and a" + interactables.get(i).getName() + ".");
                }
            }
        }
        return describe.toString();
    }

    // DO NOT USE this method. Use the one in the Floor Class, it's much easier.
    public Door getDoor(Direction direction){
        switch (direction) {
            case SOUTH:
                return southDoor;
            case EAST:
                return eastDoor;
            default:
            return null;
        }
    }

    public Interactable getItem(String name, int index){
        int timesFound = -1;
        int latestIndex = -1;
        for(int i = 0;i<interactables.size();i++){
            if(interactables.get(i).getName().toLowerCase().equals(name.toLowerCase())){
                latestIndex = i;
                timesFound++;
                if(timesFound == index){
                    return interactables.get(i);
                }
            }
        }
        if(latestIndex !=-1){
            return interactables.get(latestIndex);
        } else{
            //to stop it from crashing, sorry coban
            return new Interactable("Chest", "There is no such thing in the room", 5, 20, false);
        }
    }

    public Interactable getItem(String name){
        return getItem(name,0);
    }

    public Interactable takeItem(String name, int index){
        int timesFound = -1;
        int latestIndex = -1;
        for(int i = 0;i<interactables.size();i++){
            if(interactables.get(i).getName().toLowerCase().equals(name.toLowerCase())){
                latestIndex = i;
                timesFound++;
                if(timesFound == index){
                    Interactable result = interactables.get(i);
                    interactables.remove(i);
                    return result;
                }
            }
        }
        if(latestIndex !=-1){
            Interactable result = interactables.get(latestIndex);
            interactables.remove(latestIndex);
            return result;
        } else{
            //to stop it from crashing, sorry coban
            return new Interactable("Chest", "There is no such thing in the room", 5, 20, false);
        }
    }

    public Interactable takeItem(String name){
        return takeItem(name, 0);
    }
}
