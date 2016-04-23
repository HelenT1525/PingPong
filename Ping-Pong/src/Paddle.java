import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Paddle extends Sprite implements Commons {

    private int dx;
    public int movingAxis; // 0 for x-axis and 1 for y-axis

    public Paddle (int axis, int initX, int initY) {

    	ImageIcon ii;
    	if (axis==0)
    		ii = new ImageIcon("res/paddleH.png");
    	else 
    		ii = new ImageIcon("res/paddleV.png");
        image = ii.getImage();

        i_width = image.getWidth(null);
        i_heigth = image.getHeight(null);
        
        movingAxis = axis;
        x = initX;
        y = initY;
    }

    public void move() {

        x += dx;

        if (x <= BORDER + SIZE) {
            x = BORDER + SIZE;
        }

        if (x >= WIDTH - i_width - BORDER - SIZE) {
            x = WIDTH - i_width - BORDER - SIZE;
        }
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }
    
    public void setPosition(int position){
    	
    	if (movingAxis==0)
    		setX(position);
    	else
    		setY(position);
    }
}