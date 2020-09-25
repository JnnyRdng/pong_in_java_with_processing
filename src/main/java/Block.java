public abstract class Block {

    private double x;
    private double y;
    private double w;
    private double h;

    public Block(double x, double y, double w, double h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void draw() {
        Runner.pro.noStroke();
        Runner.pro.fill(255);
        Runner.pro.rect((float)x, (float)y, (float)w, (float)h);
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getW() {
        return w;
    }

    public double getH() {
        return h;
    }

    public void collide(Ball ball) {
        double bx = ball.getX();
        double by = ball.getY();
        if (bx > x && bx < x + w && by > y && by < y + h) {
            ball.flipYv();
        }
    }
}
