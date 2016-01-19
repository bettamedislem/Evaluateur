/**
 * @author betta
 *
 */


import java.util.ArrayList;


public class EvaluationInter implements Evaluable {
	
	public float value = 0.0f; 
	public float value() {return value;}
	
	private int parc=0; //variable de parcours de la chaine 
	private int pou,pfe=0; //nombre de parenthese ouvrante et fermante 
	private String tc; // terme courant 
	
	private int qcpt=0; //compteur des variables tomporaire des quadruplets
	private Quadruplets qc ; //quadruplets courant 
	
	
	
	
	public EvaluationInter() {
		tc = Main.mot.get(0) ;
		E();
		if (pou != pfe) {
			System.out.print("Erreur "+ e4+"\n");
            Main.nbe++;
		}}
	
	
	//Erreurs
		 String e1 = "Syntaxique 1 : parenthese ouvrante '(' ou nombre attendue";
	     String e2 = "Syntaxique 2 : parenthese fermante ')' ou operation attendue";
	     String e3 = "Syntaxique 3 : parenthese fermante ')' attendue";
	     String e4 = "Syntaxique 4 : le nombre des parentheses ouvrantes est differents du nombre de parentheses fermantes";
	     String e5 = "Syntaxique 5 : parenthese ouvrante '(' attendue";
	     String e6 = "Syntaxique 6 : operation ou fonction attendue";
	     String e7 = "Syntaxique 7 : le nombre de parametres d'une fonction est eronee";
		
		
		//procedures
		private String E() {
			String local = "",  localp = "";
			
			
			if (tc.equals("(") || Evaluation.isInt(tc) || Evaluation.isFct(tc) || isVar(tc) || tc.equals("-"))
	        {
	            local = T();
	            localp = Ep(local);
	            return localp;
	        }
	        else 
	        {
	            System.out.print("Erreur "+ e1 + ", " + tc + " non attendu\n");
	            Main.nbe++;
	            return "";
	        }		
		}
		
		private String Ep(String ep) {
			String local = "", localp = ep,fct;
			
			if (Evaluation.isOp1(tc)) {
				if (tc.equals("+")){
					parc++;
					tc = Main.mot.get(parc);
					fct = T();
					qcpt++;
					qc = new Quadruplets("+",ep,fct,"temp"+qcpt);
					Main.quad.add(qc);
					local = "temp"+qcpt;
					localp = Ep(local);
					
				}
				else if(tc.equals("-")){
					parc++;
					tc = Main.mot.get(parc);
					fct = T();
					qcpt++;
					qc = new Quadruplets("-",ep,fct,"temp"+qcpt);
					Main.quad.add(qc);
					local = "temp"+qcpt;
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
		
		private String T() {
			// TODO Auto-generated method stub
			String local = "",  localp ="";
			if (tc.equals("(") || Evaluation.isInt(tc) || Evaluation.isFct(tc) || isVar(tc) || tc.equals("-"))
	        {
	            local = F();
	            localp = Tp(local);
	            return localp;
	        }
			else
	        {
	            System.out.print("Erreur "+ e1 + ", " + tc + " non attendu\n");
	            Main.nbe++;
	            return "";
	        }
		}

		private String Tp(String tp) {
			// TODO Auto-generated method stub
			String local = "", localp =tp,fct;
			if (Evaluation.isOp2(tc)) {

				if (tc.equals("*"))
				{
					parc++;
					tc = Main.mot.get(parc);
					fct = F();
					qcpt++;
					qc = new Quadruplets("*",tp,fct,"temp"+qcpt);
					Main.quad.add(qc);
					local = "temp"+qcpt;
					localp = Tp(local);
					
				}
				else if (tc.equals("/")){
					parc++;
					tc = Main.mot.get(parc);
					fct = F();
					qcpt++;
					qc = new Quadruplets("/",tp,fct,"temp"+qcpt);
					Main.quad.add(qc);
					local = "temp"+qcpt;
					localp = Tp(local);
					
				}	
			}
				
			else if ((tc.equals(")"))||(tc.equals("#"))||(Evaluation.isOp1(tc))||(tc.equals(","))) ;
			else
	        {
	            System.out.print("Erreur "+ e2 + ", " + tc + " non attendu\n");
	            Main.nbe++;
	        }
			return localp;
		}
		
		private String F() {
			// TODO Auto-generated method stub
			String local = "";
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
	            if (Evaluation.isInt(tc) || isVar(tc))
	            {
	                local = tc;
	            	parc++;
	                tc = Main.mot.get(parc);
	            }
	            else if(tc.equals("-"))
	            {
	            	parc++;
		            tc = Main.mot.get(parc);
		            local = F();
					qcpt++;
					qc = new Quadruplets("*",local,"-1","temp"+qcpt);
					Main.quad.add(qc);
					local = "temp"+qcpt;
		            
	            }
	            else
	            {
	            	local = G();
	            }
	        }
			return local;
		}
		
		private String G() {
			// TODO Auto-generated method stub
			String local = "";
			ArrayList<String> arg = new ArrayList<String>();
			
			
			if(tc.equals("somme")||(tc.equals("sum"))||(tc.equals("som")))
			{
				String somme = "";
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
				String moyenne = "";
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
				String variance = "";
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
				String ecart = "";
				parc++;
	            tc = Main.mot.get(parc);
				if (tc.equals("("))
				{
					parc++;
		            pou++;
		            tc = Main.mot.get(parc);
		            arg = L(arg);
		           // ecart = ecart(arg);
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
				String trigo = "";
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
		            	//trigo = cos(arg);
		            }
		            else if(fct.equals("sin"))
		            {
		            	//trigo = sin(arg);
		            }
		            else if(fct.equals("tan"))
		            {
		            	//trigo = tan(arg);
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
		
		


		private ArrayList<String> L(ArrayList<String> arg)
		{
			arg.add(E());
			Lp(arg);
			return arg;
			
		}
		
		private ArrayList<String> Lp(ArrayList<String> arg)
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
		
		private String somme(ArrayList<String> tab)
		{
			qcpt++;
			String resultat = "temp"+qcpt;
			String start = tab.get(0);
			
			for (int i=0; i<tab.size()-1; i++)
			{
				qc = new Quadruplets("+",start,tab.get(i+1),resultat);
				Main.quad.add(qc);
				start = "temp"+qcpt;
				qcpt++;
				resultat = "temp"+qcpt;
			}
			qcpt--;
			return "temp"+(qcpt);
		}
		
		private String moyenne(ArrayList<String> arg) {
			// TODO Auto-generated method stub
			
			String somme = somme(arg);
			qcpt++;
			String resultat = "temp"+qcpt;
			qc = new Quadruplets("/",somme,arg.size()+"",resultat);
			Main.quad.add(qc);
			return resultat;
			
			
		}
		
		private String variance(ArrayList<String> arg) {
			// TODO Auto-generated method stub
			String local = moyenne(arg);//sauvgarder et calculer la moyenne 
			String item = "";
			ArrayList<String> items = new ArrayList<String>();;
			for(int i =0; i<arg.size();i++)
			{
				item = arg.get(i);
				qcpt++;
				qc = new Quadruplets("-",item,local,"temp"+qcpt);
				Main.quad.add(qc);
				item = "temp"+qcpt;
				qcpt++;
				qc = new Quadruplets("*",item,item,"temp"+qcpt);
				Main.quad.add(qc);
				items.add("temp"+qcpt);
			}
			local = somme(items);
			qcpt++;
			qc = new Quadruplets("/",local,arg.size()+"","temp"+qcpt);
			Main.quad.add(qc);
			return "temp"+qcpt;
		}
		
		private float ecart(ArrayList<Float> arg) {
			// TODO Auto-generated method stub
			//return (float) Math.sqrt((double)variance(arg));
			return 0;
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
				
		public boolean isVar(String s)
		{
			return (Character.isLetter(s.charAt(0)) && (s.length()==1));
		}
		

}
