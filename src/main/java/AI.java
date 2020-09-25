public class AI extends Paddle {

    private double speed;
    private float xOff;

    public AI(double x) {
        super(x);
        this.speed = 3.5;
        xOff = 0;
    }

    public void update(Ball ball) {
        xOff = xOff + (float)0.05;
        if (ball.getXV() > 0 && ball.getX() > Runner.pro.width / 2f) {
            double centre = getY() + (getH() / 2);
            if (centre > ball.getY()) {
                setY(getY() - speed);
            } else {
                setY(getY() + speed);
            }
        } else {
            float n = (Runner.pro.noise(xOff) * 8) - 4;
            setY(getY() + n);
        }
        super.update(getY() + getH()/2);
    }

    public void increaseSpeed() {
        this.speed += 0.05;
    }
}
