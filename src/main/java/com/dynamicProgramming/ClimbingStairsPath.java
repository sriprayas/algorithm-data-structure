package main.java.com.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class ClimbingStairsPath {
    public List getMinCostPath(int stairNum, int[] cost){
        int[] cache = new int[stairNum+1];
        int[] path = new int[stairNum+1];
        cache[0] = 0;
        cache[1] = cost[1];
        for(int i=2; i<=stairNum; i++){
            cache[i] = Math.min(cache[i-1], cache[i-2]) + cost[i];
            if(cache[i-1]<cache[i-2]){
                path[i] = i-1;
            }else{
                path[i] = i-2;
            }
        }
        List<Integer> pathList = new ArrayList<>();
        int i=stairNum;
        pathList.add(stairNum);
        while(i!=0){
            pathList.add(0,path[i]);
            i=path[i];
        }

        return pathList;
    }

    public static void main(String[] args) {
        int[] cost = {0, 3, 2, 4,};
        int steps = cost.length - 1;
        ClimbingStairsPath stairs = new ClimbingStairsPath();
        List<Integer> res = stairs.getMinCostPath(steps, cost);
        for(Integer ele : res){
            System.out.print(ele + " ");
        }
    }
}
