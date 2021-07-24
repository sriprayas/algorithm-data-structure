package main.java.com.stack;

import java.util.Scanner;
import java.util.Stack;

public class ReverseString {

    private String getReverse(String wrd){
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(Character ch : wrd.toCharArray()){
            stack.push(ch);
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args){
        ReverseString rev = new ReverseString();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the word");
        String wrd = sc.nextLine();
        System.out.println("Revers is " + rev.getReverse(wrd));
    }
}
