public class Weapon extends Item{
    private int atkModifier; //det by how much the wielder's attack is modified

    /*Constructor: initializes a weapon with a name, description, if it's equipable, which slot it
    goes in and it's attack modifier*/
    public Weapon(String pName, String pDescription, Boolean canEquip, int slot, int atkModifier) {
        super(pName, pDescription, canEquip, slot);
        this.atkModifier = atkModifier;
    }

    /*BEGIN GET/SET METHODS*/
    public int getAtkModifier() {
        return atkModifier;
    }

    public void setAtkModifier(int atkModifier) {
        this.atkModifier = atkModifier;
    }
    /* END OF get/set methods*/
}
