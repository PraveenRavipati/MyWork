package com.inteended.switching;

public class CoditionImpl implements Condtion {

	@Override
	public int commentCondition(char first, char second,int index) {
		
		return index;
	}

	@Override
	public int charCondition(char charactor,int depth) {
		
		return depth;
	}
	
	
}
