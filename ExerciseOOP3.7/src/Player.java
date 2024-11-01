public class Player {
    private int number;
    private float x;
    private float y;
    private float z = 0.0f; // Default z is 0

    public Player(int number, float x, float y) {
        this.number = number;
        this.x = x;
        this.y = y;
    }

    public void move(float xDisp, float yDisp) {
        this.x += xDisp;
        this.y += yDisp;
    }

    public void jump(float zDisp) {
        this.z += zDisp;
    }

    public boolean near(Ball ball) {
        float distance = (float) Math.sqrt(
                Math.pow(ball.getX() - this.x, 2) +
                        Math.pow(ball.getY() - this.y, 2) +
                        Math.pow(ball.getZ() - this.z, 2)
        );
        return distance < 8;
    }

    public void kick(Ball ball) {
        if (near(ball)) {
            ball.setXYZ(ball.getX() + 10, ball.getY() + 10, ball.getZ()); // Example: Kick the ball 10 units in x and y
            System.out.println("Player " + number + " kicked the ball to " + ball);
        } else {
            System.out.println("Player " + number + " is too far to kick the ball.");
        }
    }

    @Override
    public String toString() {
        return "Player " + number + " at (" + x + "," + y + "," + z + ")";
    }
}


