package main.java.com.dynamicProgramming;

public class AssemblyLineScheduling {
    /*
     * Array a : Time taken at individual station
     * Array t : Time taken to change line, and move next station
     * Array e : Entry time
     * Array x : Exit time
     */
    private int getMinTime(int[][] a, int[][] t, int[] e, int[] x){
        int totStation = a[0].length;
        int[] time1 = new int[totStation];
        int[] time2 = new int[totStation];

        // Initial time path 1
        time1[0] = e[0] + a[0][0];
        // Initial time path 2
        time2[0] = e[1] + a[1][0];
        // Assembly line time
        for(int j=1; j<totStation; j++){
            time1[j] = Math.min((a[0][j]+time1[j-1]),
                       (a[0][j]+time2[j-1]+t[1][j]));
            time2[j] = Math.min((a[1][j]+time2[j-1]),
                    (a[1][j]+time1[j-1]+t[0][j]));
        }
        // Exit time
        time1[totStation-1] += x[0];
        time2[totStation-1] += x[1];
        return Math.min(time1[totStation-1],time2[totStation-1]);
    }

    public static void main(String[] args){
        int[][] a = {{4, 5, 3, 2},
                    { 2, 10, 1, 4}};
        int[][] t = {{0, 7, 4, 5},
                    { 0, 9, 2, 8}};
        int[] e = {10, 12};
        int[] x = {18, 7};
        AssemblyLineScheduling assemblyLine = new AssemblyLineScheduling();
        System.out.println("Minimum time, a car must spent is "
                + assemblyLine.getMinTime(a, t, e, x));
    }
}
