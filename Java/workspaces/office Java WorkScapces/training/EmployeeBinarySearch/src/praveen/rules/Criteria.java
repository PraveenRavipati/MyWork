package praveen.rules;

/*Interface*/
public interface Criteria {
	/* This Method is used to check whether the both objects are equal or not */
	public int checkCondition(Object Element, Object key);
	/**/
	public boolean BinarySearch(Object Element[], Object key);

	public void sort(int integer[], boolean Acending);

	public void sort(String[] String, boolean Alpabetic);
}
