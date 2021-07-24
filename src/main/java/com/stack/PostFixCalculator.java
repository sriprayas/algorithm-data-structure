package main.java.com.stack;

import java.util.Scanner;
import java.util.Stack;

public class PostFixCalculator {

    private int getValueSingleDigit(String exp){
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(Character ch : exp.toCharArray()){
            if(Character.isDigit(ch)){
                stack.push(ch-'0');
            }else{
                int b = stack.pop();
                int a = stack.pop();
                stack.push(calculate(ch, a, b));
            }
        }
        return stack.pop();
    }

    private int getValueMultipleDigits(String exp){
        String[] expArr = exp.split(" ");
        Stack<Integer> stack = new Stack<>();
        for(String str : expArr){
            if(str.length()==1 && isOperator(str)){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(calculate(str.charAt(0), a, b));
            }else{
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String str){
        if("+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str)){
            return true;
        }else {
            return false;
        }
    }

    private int calculate(Character ch, int a, int b){
        if(ch=='/'){
            return a/b;
        }else if(ch=='*'){
            return a*b;
        }else if(ch=='+'){
            return a+b;
        }else{
            return a-b;
        }
    }

    public static void main(String[] args){
        PostFixCalculator call = new PostFixCalculator();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value for single digit");
        String expSingle = sc.nextLine();
        System.out.println("Enter value for multiple digit");
        String expMulti = sc.nextLine();
        System.out.println("Calculated value for exp is " + call.getValueSingleDigit(expSingle));
        System.out.println("Calculated value for exp is " + call.getValueMultipleDigits(expMulti));
    }
}
