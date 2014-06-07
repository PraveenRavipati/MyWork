package com.training.frominfix.toprefix.testcases;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Test3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String exp[] = scanner.nextLine().split(" ");
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();

		for (int i = 0; i < exp.length; i++) {
			String s = exp[i];
			if (s.equals("(")) {
				System.out.println("The Open peranthesis");
			} else if (s.equals("+")) {
				System.out.println(s + "is going to push");
				String isout = ops.push(s);
				System.out.println(isout);
			} else if (s.equals("-")) {
				System.out.println(s);
				ops.push(s);
			} else if (s.equals("*") || s.equals("/")) {
				System.out.println("in");
				if (ops.empty()) {
					if (s.equals("*")) {
						System.out.println(s + " value");
						vals.push(vals.pop() * Double.parseDouble(exp[i + 1]));
						System.out.println(vals.peek());
						i++;
						continue;
					} else if (s.equals("/")) {
						System.out.println(s + "value");
						vals.push(vals.pop() / Double.parseDouble(exp[i + 1]));
						System.out.println(vals.peek());
						i++;
						continue;
					}
				} else {
					if (ops.peek().equals("+") || ops.peek().equals("-")) {
						if (s.equals("*")) {
							System.out.println(s + "value");
							vals.push(vals.pop()
									* Double.parseDouble(exp[i + 1]));
							System.out.println(vals.peek());
							i++;
							continue;
						} else if (s.equals("/")) {
							System.out.println(s + "value");
							vals.push(vals.pop()
									/ Double.parseDouble(exp[i + 1]));
							System.out.println(vals.peek());
							i++;
							continue;
						}
					} else {
						ops.push(s);
					}
				}
			} else if (s.equals(")")) {
				System.out.println("The closed perantasis");
				// getComp(ops, vals);
			} else {
				vals.push(Double.parseDouble(s));
				System.out.println("Else Values" + vals.peek());
			}
		}
		LastCal(ops,vals);
	}

	private static void LastCal(Stack<String> ops, Stack<Double> vals) {
		if(ops.empty())
		{
			System.out.print("\n\nThe Final Value:"+vals.pop());
		}
		else {
			Iterator<String> its = ops.iterator();
			System.out.println("The elements in Oper stack is");
			int j = 0;
			while (its.hasNext()) {
				if(ops.pop().equals("+"))
				{
					vals.push(vals.pop()+vals.pop());
				}
				else if (ops.pop().equals("-")) {
					vals.push(vals.pop()-vals.pop());
				}
				its=ops.iterator();
			}
			LastCal(ops, vals);
		}
	}

}
