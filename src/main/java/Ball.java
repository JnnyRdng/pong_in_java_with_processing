import java.util.HashMap;

public class Ball  {

    private double x;
    private double y;
    private double xv;
    private double yv;
    private double r;

    public Ball(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.xv = -5;
        this.yv = -4;
    }

    public void update(HashMap<String, Integer> scores, Paddle aiPaddle) {
        x += xv;
        y += yv;

        if (x < 0) {
            int old = scores.get("aiScore");
            scores.replace("aiScore", old + 1);
        }
        if (x > Runner.pro.width) {
            int old = scores.get("pScore");
            scores.replace("pScore", old + 1);
            aiPaddle.increaseSpeed();
        }

        if (x > Runner.pro.width || x < 0) {
            x = Runner.pro.width / 2;
            flipXv();
        }

    }

    public void draw() {
        Runner.pro.circle((float)x, (float)y, (float)r);
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public double getXV() {
        return xv;
    }

    public double getYV() {
        return yv;
    }

    public void flipXv() {
        xv = xv * -1;
    }

    public void flipYv() {
        yv = yv * -1;
    }

}
