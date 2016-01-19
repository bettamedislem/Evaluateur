/**
 * @author betta
 *
 */
public class Symbole {

	private char symbole;
	private float value;
	
	public Symbole() {
		// TODO Auto-generated constructor stub
	}
	
	public Symbole(char s)
	{
		this.symbole = s;
	}
	
	public Symbole(String s)
	{
		this.symbole = s.charAt(0);
	}
	
	public Symbole(char s, float v)
	{
		this.symbole = s;
		this.value = v;
	}
	
	public Symbole(String s , float v)
	{
		this.symbole = s.charAt(0);
		this.value = v;
	}
	
	public void setSymbole(char s)
	{
		this.symbole = s;
	}
	
	public void setSymbole(String s){
		this.symbole = s.charAt(0);
	}
	
	public char getSymbole()
	{
		return (this.symbole);
	}
	
	public String getSymbolestr()
	{
		return (this.symbole+"");
	}
	
	public void setSymbole(char s, float v)
	{
		this.symbole = s;
		this.value = v;
	}
	
	public void setSymbole(String s, float v)
	{
		this.symbole = s.charAt(0);
		this.value = v;
	}
	
	public void setValue (float v)
	{
		this.value = v;
	}
	
	public float getValue()
	{
		return this.value;
	}

}
