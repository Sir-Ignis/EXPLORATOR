import java.util.ArrayList;

public class Player {
    // static variable single_instance of type Player
    private static Player single_instance = null;

    //Player fields: all fields apart from Inventory initialized in constructor
    private String name;
    private int HP, MP, SP, ATK, DEF, INT, STR, DEX, AGT, CHR;
    private ArrayList<Item> Inventory;
    private ArrayList<Item> EquippedItems;

    /* Abbreviation Meanings
     * HP = Health Points
     * MP = Mana Points
     * SP = Special Points
     * ATK = Attack Points
     * DEF = Defense Points
     * INT = Intelligence Points
     * STR = Strength Points
     * DEX = Dexterity Points
     * AGT = Agility Points
     * CHR = Charisma Points
     * ***END OF abbr. meanings***
     */

    /*Constructor: takes the player name as an argument
    and initializes player stats to default values*/
    private Player(String pName) {
        name = pName;
        HP = MP = 10;
        SP = 0;
        ATK = DEF = INT = STR = DEX = AGT = CHR = 1;
        EquippedItems = new ArrayList<Item>() {{
            add(null);add(null);add(null);add(null);add(null);add(null);add(null);
            //helmet, necklace, body armour, ring/weapon/shield, ring/weapon/shield, leg armour, shoes
        }};
    }

    //static method to create an instance of Player
    public static Player getInstance(String n) {
        if (single_instance == null)
            single_instance = new Player(n);

        return single_instance;
    }

    /*BEGIN GET/SET METHODS*/
    public int getHP() {
        return HP;
    }
    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getMP() {
        return MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public int getDEF() {
        return DEF;
    }

    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSP() {
        return SP;
    }

    public void setSP(int SP) {
        this.SP = SP;
    }

    public int getINT() {
        return INT;
    }

    public void setINT(int INT) {
        this.INT = INT;
    }

    public int getSTR() {
        return STR;
    }

    public void setSTR(int STR) {
        this.STR = STR;
    }

    public int getDEX() {
        return DEX;
    }

    public void setDEX(int DEX) {
        this.DEX = DEX;
    }

    public int getAGT() {
        return AGT;
    }

    public void setAGT(int AGT) {
        this.AGT = AGT;
    }

    public int getCHR() {
        return CHR;
    }

    public void setCHR(int CHR) {
        this.CHR = CHR;
    }

    public ArrayList<Item> getInventory() {
        return Inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        Inventory = inventory;
    }

    public ArrayList<Item> getEquippedItems() {
        return EquippedItems;
    }

    public void setEquippedItems(ArrayList<Item> equippedItems) {
        EquippedItems = equippedItems;
    }
    /* END OF get/set methods*/

    public void printStats() {
        System.out.println("PLAYER STATS");
        System.out.println("HP: "+HP);
        System.out.println("MP: "+MP);
        System.out.println("SP: "+SP);
        System.out.println("ATK: "+ATK);
        System.out.println("DEF: "+DEF);
        System.out.println("INT: "+INT);
        System.out.println("CHR: "+CHR);
        System.out.println("AGT: "+AGT);
        System.out.println("DEX: "+DEX);
    }

    public void printInventory() {
        for (int i = 0; i < Inventory.size(); i++) {
            System.out.println("Item ["+i+"]: "+Inventory.get(i).getName());
        }
    }

    //adds item to inventory
    public void addItemToInv(Item item) {
        Inventory.add(item);
    }
}