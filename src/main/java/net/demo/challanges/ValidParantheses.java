package net.demo.challanges;

import java.util.HashMap;
import java.util.Map;

public class ValidParantheses {

    public static void main(String[] args) {
        ValidParantheses a = new ValidParantheses();
        System.err.println(a.isValid("{}"));
        System.err.println(a.isValid("{}()[]"));
        System.err.println(a.isValid("{{[]}}"));
        System.err.println(a.isValid("]["));
		System.err.println(a.isValid("}}[]{{"));
    }


    public boolean isValid(String s) {
		Map<Character, Character> openingPairs = new HashMap();
		openingPairs.put('{', '}');
		openingPairs.put('[', ']');
		openingPairs.put('(', ')');

        java.util.Stack<Character> pStack = new java.util.Stack();
        char[] sChars = s.toCharArray();
        for (char sChar : sChars) {
            if (pStack.isEmpty()) {
                pStack.push(sChar);
            } else {
                if (openingPairs.get(pStack.peek()) != null && sChar == openingPairs.get(pStack.peek())) {
                    pStack.pop();
                } else {
                    pStack.push(sChar);
                }
            }
        }
        return pStack.isEmpty();
    }

}
