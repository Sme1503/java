package quiz;

public class PokemonExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PokemonLeague pmLeague1 = new PokemonLeague();
		
		Pokemon pokemon1 = new Pokemon();
		pokemon1.name = "이상해씨";
		pokemon1.type = "풀";
		
		pmLeague1.arraylist_enter(pokemon1);
		pmLeague1.arraylist_imfo();
		
//		pmLeague1.obj_array_enter(pokemon1);
//		pmLeague1.obj_array_imfo();
		
		Pokemon pokemon2 = new Pokemon();
		pokemon2.name = "파이리";
		pokemon2.type = "불꽃";
		
		pmLeague1.arraylist_enter(pokemon2);
		pmLeague1.arraylist_imfo();
//		
//		pmLeague1.obj_array_enter(pokemon2);
//		pmLeague1.obj_array_imfo();
//		
		Pokemon pokemon3 = new Pokemon();
		pokemon3.name = "꼬부기";
		pokemon3.type = "물";
		
		pmLeague1.arraylist_enter(pokemon3);
		pmLeague1.arraylist_imfo();
//		
//		pmLeague1.obj_array_enter(pokemon3);
//		pmLeague1.obj_array_imfo();
	}

}
