package quiz;

import java.util.ArrayList;

public class PokemonLeague {
	
	ArrayList pokemon0 = new ArrayList();	// arrayList
	Pokemon[] pokemon1 = new Pokemon[10];	// 객체 배열
	
	void arraylist_enter(Pokemon po) {			// 참가- arrayList
		
			this.pokemon0.add(po);
		
	}
	
	void arraylist_imfo() {						// 정보- arrayList
		for(int i=0; i<pokemon0.size(); i++) {
			Pokemon p = (Pokemon) pokemon0.get(i);
			System.out.println(p.name + " " + p.type);
			System.out.println();
		}
	}
	
	
	void obj_array_enter(Pokemon po) {			// 참가- 객체 배열
		for(int i=0; i<pokemon1.length; i++) {	
			if(pokemon1[i]== null ) {
				pokemon1[i] = po;
				
			}
		}
//		int i = 0;
//		pokemon1[i] = po;
//		i++;
	}
	
	void obj_array_imfo() {						// 정보- 객체 배열
		for(int i=0; i<pokemon1.length; i++) {
			if(pokemon1[i] != null ) {
				System.out.println(pokemon1[i].name + " " + pokemon1[i].type);
				System.out.println();
			} else {
				continue;
			}
			
		}
	}
}
