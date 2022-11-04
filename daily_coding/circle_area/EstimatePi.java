package daily_coding.circle_area;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EstimatePi {
    public static void main(String[] args) {
        System.out.println("How to EstimatePi");
        System.out.println(estimatePi());
    }

    static float estimatePi() {
        int count = 10000;
        List<Point> points = generatePoints(count);
        float withinCircleCount = 0.0f;
        for (Point p : points) {
            if (Math.pow(p.x, 2) + Math.pow(p.y, 2) <= 1.0f) {
                withinCircleCount += 1.0f;
            }
        }

        return withinCircleCount / count * 4;
    }

    static List<Point> generatePoints(int num) {
        List<Point> points = new ArrayList<>();

        if (num > 0) {
            Random random = new Random();
            for (int i = 0; i < num; i++) {
                float x = random.nextFloat();
                float y = random.nextFloat();
                Point point = new Point(x, y);
                points.add(point);
            }
        }

        return points;
    }

    private static class Point {
        float x;
        float y;

        Point(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }
}
