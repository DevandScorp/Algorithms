package Convex_Hull_Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Main {
    public static class Y_Coord implements Comparator<Point>{

        @Override
        public int compare(Point o1, Point o2) {
            if(o1.getY()<o2.getY()) return -1;
            if(o1.getY()==o2.getY()) return 0;
            return 1;
        }
    }
    public static void main(String[] args){
        Stack<Point> hull = new Stack<>();
        Point[] arr = new Point[7];
        arr[0] = new Point(0,0);
        arr[1] = new Point(1,2);
        arr[2] = new Point(5,1);
        arr[3] = new Point(3,2);
        arr[4] = new Point(4,2);
        arr[5] = new Point(3,5);
        arr[6] = new Point(5,5);
        Arrays.sort(arr,new Y_Coord());
        int d = arr.length/2;
        for(int i = 1;i<arr.length-1;++i){
            for(int j = i+1;j<arr.length;++j){
                if(arr[j].getCos(arr[0]) > arr[i].getCos(arr[0])){
                    Point p1 = arr[j];
                    arr[j] = arr[i];
                    arr[i] = p1;
                }
            }
        }
        for(Point p:arr){
            System.out.println(p.getX() + " " + p.getY() + " " + p.getCos(arr[0]));
        }
        hull.push(arr[0]);
        hull.push(arr[1]);
        for(int i = 2;i<arr.length;++i){
            Point top = hull.pop();
            while(Point.ccw(hull.peek(),top,arr[i])<=0){
                top = hull.pop();
            }
            hull.push(top);
            hull.push(arr[i]);
        }
        System.out.println("result");
        while(!hull.empty()){
            Point  point= hull.pop();
            System.out.println(point.getX()+" "+point.getY());

        }

    }
}
