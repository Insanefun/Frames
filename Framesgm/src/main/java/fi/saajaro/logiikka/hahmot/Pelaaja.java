
package fi.saajaro.logiikka.hahmot;


public class Pelaaja {
    private int hp;
    private int streight;
    private int agility;
    private int currentHp;
    private int xp;
    private int level;
    private int sp;
    
    public Pelaaja() {
        this.hp = 10;
        this.streight = 1;
        this.agility = 1;
        this.currentHp = 10;
        this.xp = 0;
        this.level = 1;
        this.sp = 5;
    }
    public void gainXp(int exp) {
        this.xp = this.xp + exp;
        if (this.xp >= this.level * 5 + 5) {
            this.level = this.level + 1;
            this.sp++;
            this.xp = 0;
        }
        
        
        
        
    }
    public void gainStreight() {
        if (this.sp > 0) {
            this.streight++;
            this.sp--;
        }
    }
    public void gainHp() {
        if (this.sp > 0) {
            this.hp++;
            this.currentHp++;
            this.sp--;
        }
    }
    public void gainAgility() {
        if (this.sp > 0) {
            this.agility++;
            this.sp--;
        }
    }
    public void takeDamage(int damage) {
        this.currentHp = this.currentHp - damage;
        if (this.currentHp < 1) {
            System.out.println("You dun goofed"); // korvaa kun käyttöliittymä käytössä.
        }
        
    }
    public int dealDamage() {
        int ignoredStr = this.streight % 2;
        int strDmg = (this.streight - ignoredStr) / 2;
        return 1 + strDmg;  
    }
    
    
    @Override
    public String toString() {
        return "Max hp " + this.hp + " current hp " + this.currentHp + " streight " + this.streight + " agility " + this.agility + "xp"
                + this.xp + " level " + this.level + " skill points " + this.sp;
    }
    
    public int currentXp() {
        return this.xp;
    }
    
    public int currentLevel() {
        return this.level;
    }
    
    public int tellMaxHp() {
        return this.hp;
    }
    
    public int tellCurrentHp() {
        return this.currentHp;
    }
    
    public int tellStreight() {
        return this.streight;
    }
    
}


