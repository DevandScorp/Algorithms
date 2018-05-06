package Convex_Hull_Norm;

import java.util.Comparator;

public class Point2D {
    public  final Comparator<Point2D> POLAR_ORDER = new PolarOrder();
    public  static final Comparator<Point2D> Y_COORD = new CoordOrder();
    private final double x,y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public static int ccw(Point2D a,Point2D b,Point2D c){
        double area2 = (b.x-a.x)*(c.y-a.y)-(b.y-a.y)*(c.x-a.x);
        if(area2<0) return -1;//clockwise
        else if(area2>0) return 1;//counter-clockwise
        else return 0;//collinear
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    private  static class CoordOrder implements Comparator<Point2D>{

        @Override
        public int compare(Point2D o1, Point2D o2) {
            if(o1.y<o2.y)return -1;
            else if(o1.y>o2.y) return 1;
            return 0;
        }
    }
    private  class PolarOrder implements Comparator<Point2D>{

        @Override
        public int compare(Point2D o1, Point2D o2) {
            double dy1 = o1.y - y;
            double dy2 = o2.y - y;
            if(dy1==0 && dy2==0){
                return 0;
            }
            else if(dy1>=0 && dy2<0) return -1;
            else if(dy2>=0 && dy1<0) return 1;
            else return -ccw(Point2D.this,o1,o2);
        }
    }
}
