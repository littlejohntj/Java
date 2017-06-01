import java.util.Random;
import java.util.Scanner;

interface ChooseAbilities {
	public void calculateHP();
}

class Character implements ChooseAbilities {

	protected int level; 
	private int intelligence, wisdom, charisma, strength, dexterity, constitution;
	protected int hitPoints;

	public static void main(String[] args) {

	}

	public Character() {
		Random r = new Random();
		level = r.nextInt(26);
		intelligence = r.nextInt(36);
		wisdom = r.nextInt(36);
		charisma = r.nextInt(36);
		strength = r.nextInt(36);
		dexterity = r.nextInt(36);
		constitution = r.nextInt(36);
	}

	public int getLevel() {
		return level;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public int getWisdom() {
		return wisdom;
	}

	public int getCharisma() {
		return charisma;
	}

	public int getStrength() {
		return strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public int getConsitituition() {
		return constitution;
	}

	public int getHitPoints() {
		return hitPoints;
	}



	public void setLevel(int l) {
		if (l > 25) {
			level = 25;
		} else if (l < 0) {
			level = 0;
		} else {
			level = l;
		}
	}

	public void setIntelligence(int i) {
		if (i > 35) {
			intelligence = 35;
		} else if (i < 0) {
			intelligence = 0;
		} else {
			intelligence = i; 
		}
	}

	public void setWisdom(int w) {
		if (w > 35) {
			wisdom = 35;
		} else if (w < 0) {
			wisdom = 0;
		} else {
			wisdom = w; 
		}
	}

	public void setCharisma(int c) {
		if (c > 35) {
			charisma = 35;
		} else if (c < 0) {
			charisma = 0;
		} else {
			charisma = c; 
		}
	}

	public void setStrength(int s) {
		if (s > 35) {
			strength = 35;
		} else if (s < 0) {
			strength = 0;
		} else {
			strength = s; 
		}
	}

	public void setDexterity(int d) {
		if (d > 35) {
			dexterity = 35;
		} else if (d < 0) {
			dexterity = 0;
		} else {
			dexterity = d; 
		}
	}

	public void setConstitution(int c) {
		if (c > 35) {
			constitution = 35;
		} else if (c < 0) {
			constitution = 0;
		} else {
			constitution = c; 
		}
	}

	public void calculateHP() {
		hitPoints = constitution;
	}
}

class Fighter extends Character {

	public static void main(String[] args) {

	}

	public Fighter(String s) {
		super();
		sword = s;
		hitDie = 10;
		if (0 <= getConsitituition() && getConsitituition() <= 8) {
			modifier = -1;
		} else if (9 <= getConsitituition() && getConsitituition() <= 12) {
			modifier = 0;
		} else {
			modifier = 1;
		}
		calculateHP();
	}

	private final int hitDie; 
	private String sword;
	private int modifier;

	public void setSword(String s) {
		sword = s;
	}

	public void setModifier(int m) {
		modifier = m;
	}

	public int getHitDie() {
		return hitDie;
	}

	public String getSword() {
		return sword;
	}

	public int getModifier() {
		return modifier; 
	}

	public int rollOfHitDie() {
		Random r = new Random();
		return r.nextInt(hitDie) + 1;
	}

	public void calculateHP() {
		hitPoints = getHitDie() + level * (getConsitituition() + getModifier()) * rollOfHitDie();
	}

}

class Wizard extends Character {

	public static void main(String[] args) {

	}

	public Wizard(String s) {
		super();
		spell = s;
		hitDie = 10;
		if (0 <= getConsitituition() && getConsitituition() <= 8) {
			modifier = -1;
		} else if (9 <= getConsitituition() && getConsitituition() <= 12) {
			modifier = 0;
		} else {
			modifier = 1;
		}
		calculateHP();
	}

	private final int hitDie; 
	private String spell;
	private int modifier;

	public void setModifier(int m) {
		modifier = m;
	}

	public void setSpell(String s) {
		spell = s;
	}

	public int getHitDie() {
		return hitDie;
	}

	public String getSpell() {
		return spell;
	}

	public int getModifier() {
		return modifier;
	}

	public int rollOfHitDie() {
		Random r = new Random();
		return r.nextInt(hitDie) + 1;
	}

	public void calculateHP() {
		hitPoints = getHitDie() + level * (getConsitituition() + getModifier()) * rollOfHitDie();
	}

}

public class Party {

	public static void main(String[] args) {

		int i, x, t;
		Character[] characters;
		Scanner input;  
		Character tempCharacter;
		String word;
		System.out.printf("Enter the number of players: ");

		input = new Scanner(System.in);
		x = input.nextInt();
		characters = new Character[x];

		for (i = 1; i <= x; i++) {
			System.out.printf("Player %d - Choose class ( 1 for Fighter, 2 for Wizard) : ");
			t = input.nextInt();
			if (t == 1) {
				System.out.printf("Enter Sword Type: ");
				word = input.next();
				characters[i-1] = Fighter(word);
			} else {
				System.out.printf("Enter Spell Type: ");
			}
		}

	}

}
