import java.util.ArrayList;

public class Game {
    private Room cave_floor0;
    private Player player;
    private Action action = new Action();

    //initializes all player starter items
    private static ArrayList<Item> starterItems() {
        Item torch = new Item("Torch", "This torch is currently lit.", true, 5);
        Weapon rock = new Weapon("Rock","A sharp rock.", true, 4, 1);
        ArrayList<Item> starterItems = new ArrayList<Item>();
        starterItems.add(rock);
        starterItems.add(torch);
        return  starterItems;
    }

    //initializes all the items in cave floor 0
    private static ArrayList<Item> floor0Items() {
        Item whetstone = new Item("Whetstone", "A rough whetstone.", false, -1);
        Item occultSymbol = new Item("Occult Symbol", "A stone in the shape of an occult symbol", false, -1);
        whetstone.item_xCord = 5;
        whetstone.item_yCord = 2;
        occultSymbol.item_xCord = 3;
        occultSymbol.item_yCord = 6;
        ArrayList<Item> floor0Items = new ArrayList<Item>();
        floor0Items.add(whetstone);
        floor0Items.add(occultSymbol);
        return floor0Items;
    }

    //initialize the map of cave floor 0
    private char[][] initializeMap() {
        char[][] map = cave_floor0.getMap();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if(i != 0 && i != map.length-1 && j != 0 && j != map.length - 1) {
                    map[i][j] = cave_floor0.EMPTY;
                }else {
                    map[i][j] = cave_floor0.WALL;
                }
            }
        }
        //set the player's position
        map[1][1] = cave_floor0.PLAYER;
        //set the item positions
        map[5][2] = cave_floor0.ITEM;
        map[3][6] = cave_floor0.ITEM;
        //set the monster positions
        map[3][2] = cave_floor0.MONSTER;
        map[7][4] = cave_floor0.MONSTER;
        return map;
    }

    //initialize monsters of cave floor 0
    private ArrayList<Monster> initializeMonsters() {
        ArrayList<Monster> Monsters = new ArrayList<Monster>();
        Monster skeleton = new Monster("Skeleton", 5, 0, 2,0,0);
        Monster ghoul = new Monster("Ghoul",7,3,2,1,0);
        Monsters.add(skeleton);
        Monsters.add(ghoul);
        return Monsters;
    }

    public void movePlayer() {
        int move = -1; //used to store the player move direction
        int change = 0; //used to determine the new cell loc of player
        int playerX = 1; //stores player x cord
        int playerY = 1; //stores player y cord
        int newX = playerX; //stores new x cord of player
        int newY = playerY; //stores new y cord of player
        int tmpX = newX;
        int tmpY = newY;
        do {
            move = action.Move();
            switch(action.intToDir(move)) {
                case UP:
                    tmpY--;
                    break;
                case RIGHT:
                    tmpX++;
                    break;
                case DOWN:
                    tmpY++;
                    break;
                case LEFT:
                    tmpX--;
                    break;
            }
            if(cave_floor0.containsChar(cave_floor0.ITEM, tmpY, tmpX)==1) {
                givePlayerItem(tmpX, tmpY);
            }
            if(cave_floor0.updateMap(playerX, playerY, tmpX, tmpY)==1) {
                playerX = newX = tmpX;
                playerY = newY = tmpY;
            } else {
                tmpX = newX;
                tmpY = newY;
            }
            cave_floor0.printMap();
        }while(move!=-1);
    }

    public void givePlayerItem(int y, int x) {
        for(int i = 0; i < cave_floor0.getItems().size(); i++) {
            if(cave_floor0.getItems().get(i).item_xCord == x && cave_floor0.getItems().get(i).item_yCord == y) {
                player.addItemToInv(cave_floor0.getItems().get(i));
                System.out.println(cave_floor0.getItems().get(i).getName()+" was added to your inventory!");
                cave_floor0.removeItem(i);
            }
        }
    }

    public Game() {
        player = Player.getInstance("default");
        player.setInventory(starterItems());
        cave_floor0 = new Room("Cave Entrance", "You can make out a few stalagmites and bats sleeping on stalactites.");
        cave_floor0.setItems(floor0Items());
        cave_floor0.setMap(initializeMap());
        cave_floor0.setMonsters(initializeMonsters());
        //FOR DEBUGGING
        /*cave_floor0.printMap();
        cave_floor0.mapInfo();*/
    }

    public void start() {
        System.out.println("You find yourself in a dark cave.");
        System.out.println(cave_floor0.getDescription());
        int choice = 0;
        do {
            choice = action.Choice();
            switch (choice) {
                case 0:
                    movePlayer();
                    break;
                case 1:
                    action.equipItem(player.getInventory(),player.getEquippedItems());
            }
        }while(choice != -1);
    }
}
