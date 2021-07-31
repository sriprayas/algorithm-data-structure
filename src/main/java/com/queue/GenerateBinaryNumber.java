package main.java.com.queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumber {

    private void printBinaryNum(int n){
        Queue<String> binQ = new LinkedList<>();
        binQ.add("1");
        while(n-->0){
            String s = binQ.peek();
            System.out.println(s);
            binQ.remove();
            binQ.add(s + "0");
            binQ.add(s+"1");
        }
    }

    public static void main(String[] args){
        GenerateBinaryNumber num = new GenerateBinaryNumber();
        num.printBinaryNum(100);
    }
}
