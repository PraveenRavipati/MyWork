package inh.func.exceoptions;

public class MyAgeAndNameException extends MyAgeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String Name;
	public MyAgeAndNameException(int Age) {
		super(Age);
	}
	public MyAgeAndNameException(String name)
	{
		super(0);
		this.Name=name;
	}
	public String toString(){
        return "Name is inCompatable, you are entered"+Name;
    }
}
