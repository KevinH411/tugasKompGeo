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
        this.Points.add(p);
        return true;
    }

    /**
     * [5b] konveks ato bukan
     * 
     * @return
     */
    boolean isConvex() {
        boolean convex = true;
        int n = this.Points.size();
        
        if (n < 3) return false;

        // Cek setiap triplet titik yang berurutan: (p_i, p_{i+1}, p_{i+2})
        for (int i = 0; i < n; i++) {
            MyPoint p1 = this.Points.get(i);
            MyPoint p2 = this.Points.get((i + 1) % n);
            MyPoint p3 = this.Points.get((i + 2) % n); 
            double res = CG.ccw(p1, p2, p3);
            
            // jika ada satu saja belokan ke kanan (res < 0), poligon adalah concave.
            if (res < 0.0) {
                convex = false;
                break; 
            }
        }
        return convex;
    }

    /**
     * [6b] luas poligon ini
     * * @return
     */
    double area() {
        double area = 0.0;
        int n = this.Points.size();
        
        if (n < 3) return 0.0;

        // Akumulasi (x_i * y_{i+1}) - (y_i * x_{i+1})
        for (int i = 0; i < n; i++) {
            MyPoint p1 = this.Points.get(i);
            MyPoint p2 = this.Points.get((i + 1) % n); // Operasi modulo agar titik terakhir terhubung ke titik ke 0
            
            area += (p1.x * p2.y) - (p1.y * p2.x);
        }
        
        // Luas adalah setengah dari total akumulasi, dan harus bernilai absolut
        area = Math.abs(area) / 2.0;

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
        /**
         * akan loop dari p0 ke pn, buat vektor pi pi+1, lalu cek arah ke p.
         * jika kanan berarti p sudah pasti di luar.
         * jika searah akan di cek dengan menghitung distance line ke point, jika bukan
         * 0 maka p diluar.
         */
        for (int i = 0; i < this.Points.size() && inside == true; i++) {
            MyPoint p1 = Points.get(i);
            MyPoint p2 = Points.get((i + 1) % Points.size());
            MyLineSegment vector = new MyLineSegment(p1, p2);
            double direction = vector.leftTurnToPoint(p);
            if (direction == 0) {
                if (vector.distanceToPoint(p) != 0)
                    inside = false;
            } else if (direction < 0)
                inside = false;
        }
        return inside;
    }

}
