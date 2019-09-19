import java.util.ArrayList;
import java.util.Scanner;
public class Action {
    public enum direction {UP, RIGHT, DOWN, LEFT, NONE};
    private Scanner scan = new Scanner(System.in);
    public int Choice() {
        System.out.println("Action: ");
        System.out.println("Move (0)");
        System.out.println("Equip an item (1)");
        int option = scan.nextInt();
        return option;
    }

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

    public ArrayList<Item> equipItem(ArrayList<Item> Inventory, ArrayList<Item> EquippedItems) {
        System.out.println("Which item would you like to equip? (enter a number)");
        for (int i = 0; i < Inventory.size(); i++) {
            System.out.println("["+i+']'+": "+Inventory.get(i).getName());
        }
        System.out.println("Position [0-"+Inventory.size()+"]: ");
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
}
