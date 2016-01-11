import java.util.*;

public class Main {

	/**
	 * @param args
	 */
	private boolean endmain = false;  // indique la fin du programme
	private static String chaine ; 
	public static char[] tabchaine = new char[1000]; 
	public static int nbe=0;
	public static ArrayList<String> mot = new ArrayList<String>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Introduisez la chaine : ");
		chaine = readConsole();	
		System.out.println("\n\nDebut de l'identification\n");
		Identification id = new Identification();
		mot = id.getMots();
		//for(int i = 0; i < mot.size(); i++)	{ System.out.println("Donnee " + (i+1) + " = " + mot.get(i));}
		System.out.print("\nDebut de l'analyse\n");
		Evaluation ev = new Evaluation();
		System.out.print("\nFin de l'analyse");
		if(nbe>0){
		if (nbe == 1 ) System.out.print("\nUne erreur detectee");
		else if(nbe > 1) System.out.print("\n"+nbe+" erreurs detectees");}
		System.out.print("\nResultat : "+ev.value);
	}
	
	private static String readConsole(){
		
		Scanner sc = new Scanner(System.in);
		String exp = new String();     // l'expression introduite
		exp= "";
		
		exp = sc.nextLine();  //recuperer l'expression
		exp = exp.toLowerCase() ; //eliminer les capitales
		exp = supWhiteSpace(exp); //eliminer les espaces blanc 
		
		int i;
		for (i=0;i<exp.length();i++)
		{
			tabchaine[i] = exp.charAt(i);
			//System.out.print(tabchaine[i]);
		}
		tabchaine[i] = '#';
		return exp;		
		
	}
	
	public static String supWhiteSpace (String chaine)
	{
		String sb=""; 
		for (int i=0;i<chaine.length();i++)
		{
			while((chaine.charAt(i) == ' ')||(chaine.charAt(i) == '	') ) {
				i++;
				if (chaine.length() == i ) {i--;break;}
				
			}
			sb = sb + chaine.charAt(i);
		}
		
		return sb;
		
	}
	
}
