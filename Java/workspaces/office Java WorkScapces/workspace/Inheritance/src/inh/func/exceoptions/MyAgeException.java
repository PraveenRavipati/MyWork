package inh.func.exceoptions;

public class MyAgeException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int Age;
	public MyAgeException(int Age)
	{
		this.Age=Age;
	}
	public String toString(){
        return "Price should not be in negative, you are entered" +Age;
    }
}
