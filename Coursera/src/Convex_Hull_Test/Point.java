package Convex_Hull_Test;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public static int ccw(Point a,Point b,Point c){
        double area2 = (b.x-a.x)*(c.y-a.y)-(b.y-a.y)*(c.x-a.x);
        if(area2<0) return -1;//clockwise
        else if(area2>0) return 1;//counter-clockwise
        else return 0;//collinear
    }
    public double getCos(Point o1){
        return (this.getX()-o1.getX())/(Math.sqrt(Math.pow((double)(o1.getX()-this.getX()),2)+Math.pow((double)(o1.getY()-this.getY()),2)));
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
