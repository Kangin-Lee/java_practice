package my.day05.exam6;

import java.util.ArrayList;

public class GameCharacterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Wizard wizard = new Wizard(); //자동 형변환
		wizard.name= "간달프";
		wizard.hp = 100;
		wizard.mp =80; //강제 형변환
		//wizard.punch();
		//wizard.fireball(); //강제 형변환
		
		Knight knight = new Knight(); //자동 형변환
		knight.name = "킹아서";
		knight.hp = 150;
		knight.stamina = 70; //강제 형변환
		//knight.punch();
		//knight.slash(); //강제 형변환
		
		
		ArrayList<Novice> gamelist = new ArrayList<Novice>();
		gamelist.add(knight);
		gamelist.add(wizard);
		
		for(Novice n : gamelist) {
			if(n instanceof Knight) {
				((Knight)n).slash();
			}else if(n instanceof Wizard) {
				((Wizard)n).fireball();	
			}
		}
	} 

}

class Novice{
	String name;
	int hp;
	
	void punch() {
		System.out.printf("%s(HP: %d)의 펀치!\n",name, hp);
	}
}

class Wizard extends Novice{
	int mp;
	
	public void fireball() {
		System.out.printf("%s(MP: %d)의 파이어볼!\n",name, mp);
	}
}

class Knight extends Novice{
	int stamina;
	
	public void slash() {
		System.out.printf("%s(Stamina: %d)의 슬레쉬!\n",name, stamina);
	}
}