package main.java.com.stack;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    private boolean isBalanced(String exp){
        boolean balanced = true;
        Stack<Character> stack = new Stack<>();

        for(Character ch : exp.toCharArray()){
            if(stack.isEmpty() || canBePushed(ch)){
                stack.push(ch);
            }else if(getPair(ch).equals(stack.peek())){
                stack.pop();
            }else{
                balanced = false;
            }
        }
        if(stack.isEmpty() && balanced){
            return true;
        }else{
            return false;
        }
    }

    private boolean canBePushed(Character ch) {
        if(ch=='(' || ch=='{' || ch=='['){
            return true;
        }
        return false;
    }

    private Character getPair(Character ch){
        if(ch==')'){
            return '(';
        }else if(ch=='}'){
            return '{';
        }else {
            return '[';
        }
    }

    public static void main(String[] args){
        BalancedBrackets brackets = new BalancedBrackets();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the expression ");
        String exp = sc.nextLine();
        System.out.println("Give exp is balance = " + brackets.isBalanced(exp));
    }
}
