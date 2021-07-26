package main.java.com.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpan {
    static List<Integer> res = new ArrayList<>();
    static Stack<Integer> stack = new Stack<>();

    private void push(int price){
        stack.push(price);
        res.add(callSpan(price, 0));
    }

    private int callSpan(int currPrice, int cnt){
        if(stack.isEmpty()){
            return cnt;
        }else {
            int lastPrice = stack.pop();
            if(lastPrice<=currPrice){
                cnt++;
                cnt = callSpan(currPrice, cnt);
            }
            stack.push(lastPrice);
        }
        return cnt;
    }

    public static void main(String[] args){
        StockSpan stock = new StockSpan();
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        for(int price : prices){
            stock.push(price);
        }
        System.out.println(res);
    }
}
