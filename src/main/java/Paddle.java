public class Paddle extends Block {



    public Paddle(double x) {
        super(x, (Runner.pro.height/2) - 25, 10, 50);

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




}
