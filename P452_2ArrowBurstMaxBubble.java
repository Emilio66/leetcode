import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

//不能用贪心算法！！
//贪心过程：1. 找出 1 枪打中的最多的区间 2. 去掉这些区间求 剩余的 最多的区间，两个相加
//因为两个极大值相加不一定是最大值!!!
//正解：三重循环
//算法题尽量不要用面向对象那一套，不暴力，不直观，内存耗费大，效率不高
public class Solution {
    static class Interval {
        int start;
        int len;
        boolean visited;

        public Interval(int start, int len) {
            this.start = start;
            this.len = len;
            this.visited = false;
        }

        public boolean isIn(int p) {
            if (p > start && p < start + len)
                return true;
            return false;
        }
    }

    //wrong answer
    public static void solveByOOP(){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        if(size < 2) {
            System.out.println(size);
            return;
        }
        Interval[] intervals = new Interval[size];
        int min = 0, max = 0;
        for (int i = 0; i < size; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            intervals[i] = new Interval(x, y);
            if (x + y > max)
                max = x + y;
        }

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                if(i1.start == i2.start)
                    return (i1.start + i1.len) - (i2.start + i2.len);
                return i1.start - i2.start;
            }
        });

        min = intervals[0].start;

        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = min; i < max; i++) {
            int cnt = 0;
            int p = i;
            for(Interval inter : intervals){
                if(inter.isIn(i)) {
                    if(!inter.visited) {
                        cnt++;
                        p = (p >  inter.start + inter.len) ? inter.start + inter.len:p;
                    }

                }else{
                    i = p;
                    break;
                }

                inter.visited = true;
            }
            set.add(cnt);
        }

        int first = set.pollLast();
        int second = 0;
        if(!set.isEmpty())
            set.pollLast();
        System.out.println(first + second);
    }

    //procedure way
    //any 2 non-crossed cars assembling together to find the maximum
    public static void solve(){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        if(size < 2) {
            System.out.println(size);
            return;
        }

        //input: cars[i][0] is head, cars[i][1] tail
        int[][] cars = new int[size][2];
        for (int i = 0; i < size; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            cars[i][0] = x;
            cars[i][1] = x + y;
        }

        //sorting by the head, ascending order
        Arrays.sort(cars, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[0] == p2[0] ? p1[1] - p2[1] : p1[0] - p2[0];
            }
        });

        int maxSum = 1;
        for(int first = 0; first < size; first++){
            int sum1 = 1;
            int firstShot = cars[first][0];

            //calculate first shot's gain
            int i = 0;
            while(i < first) {
                if(cars[i][0] <=  firstShot && cars[i][1] >= firstShot)
                    sum1 ++;
                i++;
            }

            //find the max sum in the next non-intersected cars
            int maxSum2 = 1;
            for(int second = first+1; second < size; second++){
                int sum2 = 1;
                int secondShot = cars[second][0];

                //calculate the second shot's gain
                while(i < second){
                    if(cars[i][0] <=  secondShot && cars[i][1] >= secondShot)
                        sum2 ++;
                    i++;
                }

                maxSum2 = sum2 > maxSum2 ? sum2 : maxSum2;
            }

            maxSum = (maxSum < sum1 + maxSum2) ? sum1 + maxSum2 : maxSum;

            //up bound is all cars
            if (maxSum == size) {
                System.out.println(size);
                return;
            }
        }

        System.out.println(maxSum);
    }
    public static void main(String args[]) {
        solve();
    }
}
