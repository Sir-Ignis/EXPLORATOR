import java.util.ArrayList;
import java.util.Map;

public class Room {
    private String name;
    private String description;
    //room populated with items stored in array list
    private ArrayList<Item> items;
    //room populated with monsters stored in array list
    private ArrayList<Monster> monsters;

    //map used to store object locations
    private char[][] Map = new char[9][9];
    public final char EMPTY = '.';
    public final char WALL = '#';
    public final char PLAYER = '@';
    public final char ITEM = 'i';
    public final char MONSTER = 'm';

    //constructor: initializes the room name and description
    public Room(String pName, String pDescription) {
        name = pName;
        description = pDescription;
    }

    /*BEGIN GET/SET METHODS*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public char[][] getMap() {
        return Map;
    }

    public void setMap(char[][] map) {
        Map = map;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }
    /* END OF get/set methods*/

    //removes item at pos i from the item array
    public void removeItem(int i) {
        items.remove(i);
    }

    public void printMap() {
        for(int i = 0; i < Map.length; i++) {
            for(int j = 0; j < Map.length; j++) {
                System.out.print(Map[i][j]);
            }
            System.out.println();
        }
    }

    //returns 1 if map[x][y] contains c else returns 0
    public int containsChar(char c, int x, int y) {
        if(Map[x][y] == c) {
            return 1;
        }
        return 0;
    }
    public void mapInfo() {
        for (int i = 0; i < Map.length; i++) {
            for (int j = 0; j < Map.length; j++) {
                switch (Map[i][j]) {
                    case MONSTER:
                        System.out.println("Monster found at: ("+i+','+j+')');
                        break;
                    case ITEM:
                        System.out.println("Item found at: ("+i+','+j+')');
                        break;
                    case PLAYER:
                        System.out.println("Player found at: ("+i+','+j+')');
                        break;
                }
            }
        }
    }

    //returns 1 if successfully updated else 0
    public int updateMap(int oldX, int oldY, int newX, int newY) {
        //if the player is at the old cords
        if(Map[oldY][oldX] == PLAYER) {
            //if the new position is empty or has an item or monster
            if(Map[newY][newX] == EMPTY || Map[newY][newX] == ITEM || Map[newY][newX] == MONSTER) {
                Map[oldY][oldX] = EMPTY;
                Map[newY][newX] = PLAYER;
                return 1;
            }
            else {
                System.out.println("You cannot move there.");
            }
        }else {
            System.out.println("ERROR (player not located here): You cannot move from there.");
        }
        return 0;
    }
}
