package Convex_Hull_Norm;

import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        Stack<Point2D> hull = new Stack<>();
        Point2D[] arr = new Point2D[7];
        arr[0] = new Point2D(0,0);
        arr[1] = new Point2D(1,2);
        arr[2] = new Point2D(5,1);
        arr[3] = new Point2D(3,2);
        arr[4] = new Point2D(4,2);
        arr[5] = new Point2D(3,5);
        arr[6] = new Point2D(5,5);
        Arrays.sort(arr,Point2D.Y_COORD);
        Arrays.sort(arr,arr[0].POLAR_ORDER);
        hull.push(arr[0]);
        hull.push(arr[1]);
        for(int i = 2;i<arr.length;++i){
            Point2D top = hull.pop();
            while(Point2D.ccw(hull.peek(),top,arr[i])<=0){
                top = hull.pop();
            }
            hull.push(top);
            hull.push(arr[i]);
        }
        System.out.println("result");
        while(!hull.empty()){
            Point2D  point= hull.pop();
            System.out.println(point.getX()+" "+point.getY());

        }
    }
}
