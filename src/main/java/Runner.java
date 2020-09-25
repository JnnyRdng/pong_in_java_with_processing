import processing.core.PApplet;

import java.util.ArrayList;
import java.util.HashMap;

public class Runner extends PApplet {
    public static PApplet pro;
    public static void main(String[] args) {
        PApplet.main("Runner", args);
    }

    ArrayList<Wall> walls;
    Paddle paddle;
    AI aiPaddle;
    Ball ball;

    public HashMap<String, Integer> scores;



    public void settings() {
        size(740, 400);
    }

    public void setup() {
        pro = this;

        walls = new ArrayList<>();
        walls.add(new Wall(0, 0, width, 10));
        walls.add(new Wall(0, height - 10, width, 10));
        paddle = new Paddle(10);
        aiPaddle = new AI(width - 20);
        ball = new Ball(width/2, height/3, 10);

        scores = new HashMap<>();
        scores.put("aiScore", 0);
        scores.put("pScore", 0);
    }

    public void draw() {
        background(0);
        stroke(255);
        line(width/2, 0, width/2, height);

        ball.update(scores, aiPaddle);
        ball.draw();

        for (Block wall : walls) {
            wall.draw();
            wall.collide(ball);
        }

        text(String.format("%d", scores.get("pScore")), width/4, 40);
        text(String.format("%d", scores.get("aiScore")), 3*width/4, 40);

        paddle.update(mouseY);
        paddle.collide(ball);
        paddle.draw();

        aiPaddle.update(ball);
        aiPaddle.collide(ball);
        aiPaddle.draw();

    }
}