public class Paddle extends Block {

    private double speed;
    private float xoff;

    public Paddle(double x) {
        super(x, (Runner.pro.height/2) - 25, 10, 50);
        this.speed = 3.5;
        xoff = 0;
    }

    public void update(double Y) {
        double pos = Y;
        double h = getH();
        if (pos < 10 + h/2) {
            pos = 10 + h / 2;
        } else if (pos > Runner.pro.height - 10 - h/2) {
            pos = Runner.pro.height - 10 - h/2;
        }
        setY(pos - h / 2);
    }

    public void aiUpdate(Ball ball) {
        xoff = xoff + (float)0.05;
        if (ball.getXV() > 0 && ball.getX() > Runner.pro.width / 2) {
            double centre = getY() + (getH() / 2);
            if (centre > ball.getY()) {
                setY(getY() - speed);
            } else {
                setY(getY() + speed);
            }
        } else {
            float n = (Runner.pro.noise(xoff) * 8) - 4;
            setY(getY() + n);
        }
        update(getY() + getH()/2);
    }

    public void collide(Ball ball) {
        double bx = ball.getX();
        double by = ball.getY();
        double byv = ball.getYV();
        if (bx >= getX() && bx <= getX() + getW() && by >= getY() && by <= getY() + getH()) {
            ball.flipXv();
            if ( (byv < 0 && by > getY() + (getH() / 2)) || (byv > 0 && by < getY() + (getH() / 2 )) ) {
                ball.flipYv();
            }
        }
    }

    public void increaseSpeed() {
        this.speed += 0.05;
    }


}
