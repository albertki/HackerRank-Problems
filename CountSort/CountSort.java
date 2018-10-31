// https://www.hackerrank.com/challenges/countingsort4/problem

import java.util.*;

class CountSort {
    public static void main(String[] args) {
        countSort();
    }
    public static void countSort() {
    // Input: List<List<String>> arr
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<ArrayList<String>> arr = new ArrayList<>();
        while (in.hasNext()) {
            ArrayList<String> m = new ArrayList<>();
            m.add(Integer.toString(in.nextInt()));
            m.add(in.next());
            arr.add(m);
        }
        //System.out.println(arr.toString());

    long startTime = System.nanoTime();
        //.....your program....
        HashMap<Integer, ArrayList<String>> helper = new HashMap<>();
        for(int i = 0; i < n/2; i++) {
            ArrayList<String> a = new ArrayList<>();
            int index = Integer.valueOf(arr.get(i).get(0));
            a = helper.getOrDefault(index, a);
            a.add("-");
            helper.put(index, a);
        }
        //System.out.println(helper.toString());
        // 2nd half of input
        for(int i = n/2; i < n; i++) {
            ArrayList<String> a = new ArrayList<>();
            int index = Integer.valueOf(arr.get(i).get(0));
            a = helper.getOrDefault(index, a);
            a.add(arr.get(i).get(1));
            helper.put(index, a);
        }
        for (int k : helper.keySet()) {
            for (int i =0; i < helper.get(k).size(); i++) {
                System.out.print(helper.get(k).get(i) + " ");
            }
        }
        System.out.println();

        // Calculate runtime in nanoseconds
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
}
