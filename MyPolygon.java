import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Position;

public class MyPolygon {
    /**  */
    List<MyPoint> Points;

    /**
     * konstruktor
     * 
     * @return
     */
    public MyPolygon() {
        this.Points = new ArrayList<MyPoint>();
    }

    /**
     * [5a,6a,7a] masukin titik
     * 
     * @param p
     * @return
     */
    boolean addPoint(MyPoint p) {
        return true;
    }

    /**
     * [5b] konveks ato bukan
     * 
     * @return
     */
    boolean isConvex() {
        boolean convex = true;

        return convex;
    }

    /**
     * [6b] luas poligon ini
     * 
     * @return
     */
    double area() {
        double area = 0.0;

        return area;
    }

    /**
     * [7b] titik p di dalem ato luar,
     * jika berimpitan dengan titik atau segmen, di dalam
     * 
     * @param p
     * @return
     */
    boolean isPointInside(MyPoint p) {
        boolean inside = true;
        for (int i = 0; i < this.Points.size() && inside == true; i++) {
            MyPoint p1 = Points.get(i);
            MyPoint p2 = Points.get((i + 1) % Points.size());
            MyLineSegment vector = new MyLineSegment(p1, p2);
            double direction = vector.leftTurnToPoint(p);
            if (direction == 0) {
                if (vector.distanceToPoint(p) != 0)
                    inside = false;
            } else if (direction > 0)
                inside = false;
        }
        return inside;
    }

}
