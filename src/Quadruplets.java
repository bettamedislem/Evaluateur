/**
 * @author betta
 *
 */
public class Quadruplets {

	private String operation;
	private String operande1;
	private String operande2;
	private String destination;
	
	public Quadruplets() {
		// TODO Auto-generated constructor stub
	}
	
	public Quadruplets(String op, String op1, String op2, String dest)
	{
		this.operation = op;
		this.operande1 = op1;
		this.operande2 = op2;
		this.destination = dest;
	}
	
	public void set(String op, String op1, String op2, String dest)
	{
		this.operation = op;
		this.operande1 = op1;
		this.operande2 = op2;
		this.destination = dest;
	}
	
	public String GetOp()
	{
		return this.operation;
	}
	
	public String GetOp1()
	{
		return this.operande1;
	}
	
	public String GetOp2()
	{
		return this.operande2;
	}
	
	public String GetDest()
	{
		return this.destination;
	}
}
