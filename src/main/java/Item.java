public class Item {
    //item fields: both initialized in constructor
    private String name;
    private String description;
    private Boolean equipable;
    public int slot; //the equip slot, -1 if not equipable
    public int item_xCord;
    public int item_yCord;

    public Item(String pName, String pDescription, Boolean canEquip, int slot) {
        name = pName;
        description = pDescription;
        equipable = canEquip;
        this.slot = slot;
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

    public Boolean getEquipable() {
        return equipable;
    }

    public void setEquipable(Boolean equipable) {
        this.equipable = equipable;
    }
    /* END OF get/set methods*/
}
