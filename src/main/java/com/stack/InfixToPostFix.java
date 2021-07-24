package main.java.com.stack;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostFix {

    private int getPrecedence(char ch){
        int pre = -1;
        if(ch=='^'){
            pre=3;
        }else if(ch=='/' || ch=='*'){
            pre=2;
        }else if(ch=='+' || ch=='-'){
            pre=1;
        }
        return pre;
    }

    private String convert(String exp){
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(Character ch : exp.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                res.append(ch);
            }else if(ch=='('){
                stack.push(ch);
            }else if(ch==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    res.append(stack.pop());
                }
                stack.pop();
            }else {
                while(!stack.isEmpty() && getPrecedence(ch) <= getPrecedence(stack.peek())){
                    res.append(stack.pop());
                 }
                stack.push(ch);
            }
        }

        while(!stack.isEmpty()){
            res.append(stack.pop());
        }

        return res.toString();
    }

    public static void main(String[] args){
        InfixToPostFix infixToPostFix = new InfixToPostFix();
        System.out.println("Enter exp");
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        System.out.println("Infix = " + exp);
        System.out.println("PostFix = " + infixToPostFix.convert(exp));
    }
}
