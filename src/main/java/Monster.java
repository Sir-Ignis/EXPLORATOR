public class Monster
{
    private String name;
    private int HP;
    private int MP;
    private int ATK;
    private int DEF;
    private int SP;

    public Monster(String pName, int pHP, int pMP, int pATK, int pDEF, int pSP) {
        name = pName;
        HP = pHP;
        MP = pMP;
        ATK = pATK;
        DEF = pDEF;
        SP = pSP;
    }

    /*BEGIN GET/SET METHODS*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public int getSP() {
        return SP;
    }

    public void setSP(int SP) {
        this.SP = SP;
    }
    /* END OF get/set methods*/
}
