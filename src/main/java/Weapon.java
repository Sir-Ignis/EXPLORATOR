public class Weapon extends Item{
    private int atkModifier; //det by how much the wielder's attack is modified
    public Weapon(String pName, String pDescription, Boolean canEquip, int slot, int atkModifier) {
        super(pName, pDescription, canEquip, slot);
        this.atkModifier = atkModifier;
    }

    public int getAtkModifier() {
        return atkModifier;
    }

    public void setAtkModifier(int atkModifier) {
        this.atkModifier = atkModifier;
    }
}
