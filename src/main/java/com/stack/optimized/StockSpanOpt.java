package main.java.com.stack.optimized;

import java.util.Stack;

public class StockSpanOpt {

    private void getSpan(int[] prices){
        Stack<Integer> dayNumber = new Stack<>();
        int[] span = new int[prices.length];
        dayNumber.push(0);
        span[0] = 1;

        for(int i=1; i<prices.length; i++){
            while(!dayNumber.isEmpty() &&
                    prices[dayNumber.peek()]<=prices[i]){
                dayNumber.pop();
            }
            if(dayNumber.isEmpty()){
                span[i] = i+1;
            }else{
                span[i] = i-dayNumber.peek();
            }
            dayNumber.push(i);
        }
        print(span);
    }

    private void print(int[] arr){
        for(int ele : arr){
            System.out.print(ele + " ");
        }
    }

    public static void main(String[] args){
        StockSpanOpt stockSpan = new StockSpanOpt();
        int[] prices = {10, 4, 5, 90, 120, 80};
        stockSpan.getSpan(prices);
    }
}
