import java.util.ArrayList;


public class Identification {
	
	private ArrayList<String> mot = new ArrayList<String>();
	
	public Identification() {
		// TODO Lire le tableau des characteres et les placer dans une chaine de mots 
		char tc = Main.tabchaine[0];
		int parc = 0;
		String mem = ""; //le nombre qui est en cours de traitement 
		
		//Erreurs
		String e1 = "Lexical 1 : Caractere inconnu rencontre";
		
		while (tc != '#' && tc != '=')
		{
			
			if (isInt(tc) || tc=='.')
			{
				while (isInt(tc) || tc=='.'){
					mem = mem + tc;
					parc++;
					tc = Main.tabchaine[parc];
					
				}
				mot.add(mem);
				mem = "";
			
			}
			
			else if (isOp(tc))
			{
				if (tc=='{' || tc=='[')
				{
					mem = "(";
				}
				else if (tc=='}' || tc==']')
				{
					mem = ")";
				}
				else mem = "" + tc;
				mot.add(mem);
				mem = "";
				parc++;
				tc = Main.tabchaine[parc];
			}
			
			else if(isLetter(tc))
			{
				while (isLetter(tc)){
					tc = Character.toLowerCase(tc);
					mem = mem + tc; 
					parc++;
					tc = Main.tabchaine[parc];
				}
				mot.add(mem);
				mem = "";
			}
			
			else if(tc==',' || tc==';')
			{
				mem = "" + tc;
				parc++;
				tc = Main.tabchaine[parc];
				mot.add(",");
				mem = "";
			}
			
			else {
				System.out.print("Erreur "+ e1 + ", " + tc + " non attendu\n");
				Main.nbe++;
				parc++;
				tc = Main.tabchaine[parc];
			}
			
		}
		mot.add("#");
		
	}
	
	
	ArrayList<String> getMots()
	{
		return this.mot;
	}
	
	
	
	
	//verefication
	
		public boolean isInt(char s)
		{
			return Character.isDigit(s);	
		}
		
		public boolean isLetter(char s)
		{
			return Character.isAlphabetic(s);	
		}
		
		public boolean isOp(char s)
		{
			if ((s=='+')||(s=='-')||(s=='*')||(s=='/')||(s=='(')||(s==')')||(s=='[')||(s==']')||(s=='{')||(s=='}')) return true ;
			else return false ;
		}
		

}
