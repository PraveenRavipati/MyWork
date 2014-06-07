package com.training.frominfix.toprefix.testcases;

import java.util.Scanner;
import java.util.Stack;

public class Test1 {
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                String exp[] = scanner.nextLine().split(" ");
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();

        for(int i = 0; i < exp.length; i++) {
                        String s = exp[i];
            if (s.equals("(")) {
            }
            else if (s.equals("+") || s.equals("-")||s.equals("*")||s.equals("/")) {
                ops.push(s);
            } else if (s.equals(")")) {
                getComp(ops, vals);
            } else {
                vals.push(Double.parseDouble(s));
            }
        }
        getComp(ops, vals);
        System.out.println(vals.pop());
    }

    private static void getComp(Stack<String> ops, Stack<Double> vals) {
        String op = ops.pop();
        if (op.equals("+")) {
            vals.push(vals.pop() + vals.pop());
        } else if (op.equals("*")) {
            vals.push(vals.pop() * vals.pop());
        }
        else if (op.equals("-")) {
			vals.push(vals.pop()-vals.pop());
		}
        else if (op.equals("/")) {
			vals.push(vals.pop()/vals.pop());
		}
    }
    /*private static int opEqual(Stack<String> ops, Stack<Double> vals) {
    	
    	int status=-2;
		return status;
	}*/
}
