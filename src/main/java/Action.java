import java.util.ArrayList;
import java.util.Scanner;
public class Action {
    public enum direction {UP, RIGHT, DOWN, LEFT, NONE};
    private Scanner scan = new Scanner(System.in);

    //returns the user's choice of action to take
    public int Choice() {
        System.out.println("Action: ");
        System.out.println("Move (0)");
        System.out.println("View inventory (1)");
        System.out.println("Equip an item (2)");
        System.out.println("View equipped items (3)");
        int option = scan.nextInt();
        return option;
    }

    //returns the direction that the player moves in as an int 0-3 or -1 to remain in the same spot
    public int Move() {
        int direction = -2;
        do {
            System.out.println("Which direction would you like to move in?");
            System.out.println("UP (0), RIGHT (1), DOWN (2), LEFT (3), NONE (-1)");
            direction = scan.nextInt();
            if(direction < 0 || direction > 3) {
                System.out.println("Please enter a number between -1 and 3.");
            }
        }while(direction < -1 || direction > 3);
        return direction;
    }

    //converts the int to a direction enum and returns the enum
    public direction intToDir(int i) {
        switch (i) {
            case 0:
                return direction.UP;
            case 1:
                return direction.RIGHT;
            case 2:
                return direction.DOWN;
            case 3:
                return direction.LEFT;
            default:
                System.out.println("ERROR! Could not move in any direction!!!");
                break;
        }
        return direction.NONE;
    }

    //returns the array of equipped items after an attempt has been made to equip an item
    public ArrayList<Item> equipItem(ArrayList<Item> Inventory, ArrayList<Item> EquippedItems) {
        System.out.println("Which item would you like to equip? (enter a number)");
        for (int i = 0; i < Inventory.size(); i++) {
            System.out.println("["+i+']'+": "+Inventory.get(i).getName());
        }
        System.out.println("Position [0-"+(Inventory.size()-1)+"]: ");
        int pos = scan.nextInt();
        Item item = Inventory.get(pos);
        if(item.getEquipable() == true) {
            //if the equip slot is empty
            if(EquippedItems.get(item.slot) == null) {
                //equip the item to the slot
                System.out.println("You equipped the "+item.getName()+'.');
                EquippedItems.set(item.slot, item);
            }else {
                System.out.println("You already have an item equipped in this slot!");
            }
        }
        return EquippedItems;
    }

    //the player and the monster fight one another
    public Player Fight(Player player, Monster monster) {
        int pDMG, mDMG;
        while(monster.getHP() > 0) {
            pDMG = player.atkDamage(monster.getDEF());
            monster.setHP(monster.getHP()-pDMG);
            if(pDMG > 0 ){
                System.out.println("You attack the monster and deal "+pDMG+" damage.");
            }else {
                System.out.println("You attack and don't deal any damage!");
            }
            if(monster.getHP() > 0) {
                mDMG = monster.atkDMG(player.getDEF());
                player.setHP(player.getHP()-mDMG);
                if(mDMG > 0 ){
                    System.out.println("The "+monster.getName()+" attacks you and deals "+mDMG+" damage!");
                }else {
                    System.out.println("The "+monster.getName()+" didn't deal any damage.");
                }
                if(player.getHP()<0) {
                    System.out.println("You were killed by a "+monster.getName()+'.');
                    break;
                }
            } else {
                player.XP += monster.XP;
                System.out.println("You killed the "+monster.getName()+" and gained "+monster.XP+" XP.");
            }
        }
        return player;
    }
}
