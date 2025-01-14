import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;

/**
 * MyFrame is a Class that creates a frame for the zuul game
 *
 * @author Antoine MARMOL
 * @version 11 / 21/05/2024
 */
public class MyFrame extends JFrame
{
    private ImageIcon aLogo;
    /**
     * prints the action of eatingConstructs a MyFrame Object
     */
    MyFrame()
    {
        this.setTitle("Zuul : Combat Evolved");
        this.setResizable(false);
        this.setSize(1725,1000);
        this.getContentPane().setBackground(new Color(0x383A59));
        
        this.aLogo = new ImageIcon("Images\\Interface\\ZuulCeLogo.png");
        this.setIconImage(this.aLogo.getImage());
    }
}
