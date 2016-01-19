import java.util.*;
/**
 * 
 */

/**
 * @author betta
 *
 */
public class Evaluation implements Evaluable {

	/**
	 * 
	 */
	//Result 
	public float value = 0.0f; 
	public float value() {return value;}
	
	
	private int parc=0; //variable de parcours de la chaine 
	private int pou,pfe=0; //nombre de parenthese ouvrante et fermante 
	private String tc; // terme courant 
	
	
	
	//Erreurs
	 String e1 = "Syntaxique 1 : parenthese ouvrante '(' ou nombre attendue";
     String e2 = "Syntaxique 2 : parenthese fermante ')' ou operation attendue";
     String e3 = "Syntaxique 3 : parenthese fermante ')' attendue";
     String e4 = "Syntaxique 4 : le nombre des parentheses ouvrantes est differents du nombre de parentheses fermantes";
     String e5 = "Syntaxique 5 : parenthese ouvrante '(' attendue";
     String e6 = "Syntaxique 6 : operation ou fonction attendue";
     String e7 = "Syntaxique 7 : le nombre de parametres d'une fonction est eronee";
	
	public Evaluation() {
		// TODO Auto-generated constructor stub
		tc = Main.mot.get(0) ;
		value = E();
		if (pou != pfe) {
			System.out.print("Erreur "+ e4+"\n");
            Main.nbe++;
		}
	}
	
	//procedures
	private float E() {
		float local = 0.0f,  localp =0.0f;
		
		if (tc.equals("(") || isInt(tc) || isFct(tc) || tc.equals("-"))
        {
            local = T();
            localp = Ep(local);
            return localp;
        }
        else
        {
            System.out.print("Erreur "+ e1 + ", " + tc + " non attendu\n");
            Main.nbe++;
            return 0;
        }		
	}
	
	private float Ep(float ep) {
		float local = 0.0f, localp = ep;
		
		if (isOp1(tc)) {
			if (tc.equals("+")){
				parc++;
				tc = Main.mot.get(parc);
				local = ep + T();
				localp = Ep(local);
			}
			else if(tc.equals("-")){
				parc++;
				tc = Main.mot.get(parc);
				local = ep - T();
				localp = Ep(local);
			}					
			
		}
		else if ((tc.equals(")"))||(tc.equals("#"))) ;
		else if (tc.equals(","));
		else
        {
            //Erreur
        }
		return localp;
	}
	
	private float T() {
		// TODO Auto-generated method stub
		float local = 0.0f,  localp =0.0f;
		if (tc.equals("(") || isInt(tc) || isFct(tc) || tc.equals("-"))
        {
            local = F();
            localp = Tp(local);
            return localp;
        }
		else
        {
            System.out.print("Erreur "+ e1 + ", " + tc + " non attendu\n");
            Main.nbe++;
            return 0;
        }
	}

	private float Tp(float tp) {
		// TODO Auto-generated method stub
		float local = 0.0f, localp =tp;
		if (isOp2(tc)) {

			if (tc.equals("*"))
			{
				parc++;
				tc = Main.mot.get(parc);
				local = tp * F();
				localp = Tp(local);
			}
			else if (tc.equals("/")){
				parc++;
				tc = Main.mot.get(parc);
				local = tp / F();
				localp = Tp(local);
			}					
		}
			
		else if ((tc.equals(")"))||(tc.equals("#"))||(isOp1(tc))||(tc.equals(","))) ;
		else
        {
            System.out.print("Erreur "+ e2 + ", " + tc + " non attendu\n");
            Main.nbe++;
        }
		return localp;
	}
	
	private float F() {
		// TODO Auto-generated method stub
		float local = 0.0f;
		if (tc.equals("("))
        {	
			parc++;
            pou++;
            tc = Main.mot.get(parc);
            local = E();
            vfe(); 
            
        }
        else
        {
            if (isInt(tc))
            {
                local = Float.parseFloat(tc+"");
            	parc++;
                tc = Main.mot.get(parc);
            }
            else if(tc.equals("-"))
            {
            	parc++;
	            tc = Main.mot.get(parc);
	            local = -1*F();
            }
            else
            {
            	local = G();
            }
        }
		return local;
	}
	
	private float G() {
		// TODO Auto-generated method stub
		float local = 0.0f;
		ArrayList<Float> arg = new ArrayList<Float>();
		
		
		if(tc.equals("somme")||(tc.equals("sum"))||(tc.equals("som")))
		{
			float somme = 0.0f;
			parc++;
            tc = Main.mot.get(parc);
			if (tc.equals("("))
			{
				parc++;
	            pou++;
	            tc = Main.mot.get(parc);
	            arg = L(arg);
	            somme = somme(arg);
	            local = somme;
	            vfe();
			}
			else 
			{
				System.out.print("Erreur "+ e5 + ", " + tc + " non attendu\n");
	            Main.nbe++;
			}
            
		}
		
		else if(tc.equals("moyenne")||(tc.equals("moy"))||(tc.equals("average"))||(tc.equals("avr")))
		{
			float moyenne = 0.0f;
			parc++;
            tc = Main.mot.get(parc);
			if (tc.equals("("))
			{
				parc++;
	            pou++;
	            tc = Main.mot.get(parc);
	            arg = L(arg);
	            moyenne = moyenne(arg);
	            local = moyenne;
	            vfe();
			}
			else 
			{
				System.out.print("Erreur "+ e5 + ", " + tc + " non attendu\n");
	            Main.nbe++;
			}
            
		}
		
		else if(tc.equals("variance")||(tc.equals("var")))
		{
			float variance = 0.0f;
			parc++;
            tc = Main.mot.get(parc);
			if (tc.equals("("))
			{
				parc++;
	            pou++;
	            tc = Main.mot.get(parc);
	            arg = L(arg);
	            variance = variance(arg);
	            local = variance;
	            vfe();
			}
			else 
			{
				System.out.print("Erreur "+ e5 + ", " + tc + " non attendu\n");
	            Main.nbe++;
			}
            
		}
		
		else if(tc.equals("ecarttype")||(tc.equals("ecart")))
		{
			float ecart = 0.0f;
			parc++;
            tc = Main.mot.get(parc);
			if (tc.equals("("))
			{
				parc++;
	            pou++;
	            tc = Main.mot.get(parc);
	            arg = L(arg);
	            ecart = ecart(arg);
	            local = ecart;
	            vfe();
			}
			else 
			{
				System.out.print("Erreur "+ e5 + ", " + tc + " non attendu\n");
	            Main.nbe++;
			}
            
		}
		
		else if(tc.equals("cos")||(tc.equals("sin"))||tc.equals("tan"))
		{
			float trigo = 0.0f;
			String fct = tc+"";
			parc++;
            tc = Main.mot.get(parc);
            if (tc.equals("("))
			{
				parc++;
	            pou++;
	            tc = Main.mot.get(parc);
	            arg = L(arg);
	            if(fct.equals("cos"))
	            {
	            	trigo = cos(arg);
	            }
	            else if(fct.equals("sin"))
	            {
	            	trigo = sin(arg);
	            }
	            else if(fct.equals("tan"))
	            {
	            	trigo = tan(arg);
	            }
	            local = trigo;
	            vfe();
			}
			else 
			{
				System.out.print("Erreur "+ e5 + ", " + tc + " non attendu\n");
	            Main.nbe++;
			}
            
		}
	
		
		else
        {
        	System.out.print("Erreur "+ e6 + ", " + tc + " non attendu\n");
            Main.nbe++;
        }
		return local;
		
	}
	
	


	private ArrayList<Float> L(ArrayList<Float> arg)
	{
		arg.add(E());
		Lp(arg);
		return arg;
		
	}
	
	private ArrayList<Float> Lp(ArrayList<Float> arg)
	{
		if(tc.equals(","))
		{
			parc++;
            tc = Main.mot.get(parc);
            L(arg);
		}
		return arg;
		
	}
	
	
	
	//operation
	
	private float somme(ArrayList<Float> tab)
	{
		float resultat = 0.0f;
		for (int i=0; i<tab.size(); i++)
		{
			resultat += tab.get(i);
		}
		return resultat;
	}
	
	private float moyenne(ArrayList<Float> arg) {
		// TODO Auto-generated method stub
		return somme(arg)/arg.size();
	}
	
	private float variance(ArrayList<Float> arg) {
		// TODO Auto-generated method stub
		float moyenne = moyenne(arg), item = 0.0f;
		ArrayList<Float> items = new ArrayList<Float>();;
		for(int i =0; i<arg.size();i++)
		{
			item = arg.get(i);
			item = item - moyenne;
			item = item * item;
			items.add(item);
		}
		float variance = somme(items)/arg.size();
		return variance;
	}
	
	private float ecart(ArrayList<Float> arg) {
		// TODO Auto-generated method stub
		return (float) Math.sqrt((double)variance(arg));
	}
	
	private float cos(ArrayList<Float> arg) {
		// TODO Auto-generated method stub
		if (arg.size() > 1) {
			System.out.print("Erreur "+ e7 + "\n");
            Main.nbe++;
		}

		double rad = ((double) arg.get(0)*Math.PI)/180;
		return (float) Math.cos(rad);
	}
	
	private float sin(ArrayList<Float> arg) {
		// TODO Auto-generated method stub
		if (arg.size() > 1) {
			System.out.print("Erreur "+ e7 + "\n");
            Main.nbe++;
		}
	
		double rad = ((double) arg.get(0)*Math.PI)/180;
		return (float) Math.sin(rad);
	}
	
	private float tan(ArrayList<Float> arg) {
		// TODO Auto-generated method stub
		if (arg.size() > 1) {
			System.out.print("Erreur "+ e7 + "\n");
            Main.nbe++;
		}
	
		double rad = ((double) arg.get(0)*Math.PI)/180;
		return (float) Math.tan(rad);
	}
	
	
	
	//traitement repetitif 
	
	private void vfe() //verefication parenthese fermante 
	{
		if (tc.equals(")"))
        {
        	parc++;
            pfe++;
            tc = Main.mot.get(parc);
        }
        else
        {
        	System.out.print("Erreur "+ e3 + ", " + tc + " non attendu\n");
            Main.nbe++;
        }
	}
	
	
	
	
	//verefication
	
	

	public static boolean isInt(String s)
	{
		if(s.charAt(0) == ('.') && (Character.isDigit(s.charAt(1))) && s.substring(1).indexOf('.') == -1) {return true;}
		else if ( Character.isDigit(s.charAt(0))) {return true;}	
		else if ((s.indexOf('.') == s.lastIndexOf('.')) &&(s.indexOf('.') != -1)) {return true;}
		else return false;
	}
	
	public static boolean isOp1(String s)
	{
		if ((s.equals("+"))||(s.equals("-"))) {return true ;}
		else return false ;
	}
	
	public static boolean isOp2(String s)
	{
		if ((s.equals("*"))||(s.equals("/"))) {return true ;}
		else return false ;
	}
	
	public static boolean isFct(String s)
	{
		if ((s.equals("somme"))||(s.equals("variance"))||(s.equals("moyenne"))||(s.equals("cos"))||(s.equals("som"))||(s.equals("sin"))||(s.equals("ecart"))||(s.equals("ecarttype"))||(s.equals("tan"))||(s.equals("moy"))||(s.equals("sum"))||(s.equals("var"))||(s.equals("average"))||(s.equals("avr"))||(s.equals("pow"))||(s.equals("power"))||(s.equals("puissance"))||(s.equals("puis"))||(s.equals("racine"))||(s.equals("rac"))||(s.equals("sqrt"))) {return true ;}
		else return false ;
	}
	
	
	
}
