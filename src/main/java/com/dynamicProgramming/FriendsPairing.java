package main.java.com.dynamicProgramming;

public class FriendsPairing {
    private int getWays(int totPeople){
        int[] cache = new int[totPeople+1];
        // Base Case
        cache[0] = 1;
        cache[1] = 1;
        for(int i=2; i<=totPeople; i++){
            cache[i] = cache[i-1] + (i-1)*cache[i-2];
        }
        return cache[totPeople];
    }

    public static void main(String[] args){
        FriendsPairing pairing = new FriendsPairing();
        int totPeople = 5;
        System.out.println("Total number of ways in which " + totPeople +
                " friend can remain single or paired are " + pairing.getWays(totPeople));
    }
}
