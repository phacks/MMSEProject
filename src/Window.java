import javax.swing.JFrame;
import javax.swing.JPanel;


public class Window extends JFrame{
	
	public Window(int width, int height){
	
		this.setSize(width, height);
		this.setTitle("Hello world");
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MainPanel mainPanel = new MainPanel(width, height);
		
		this.setContentPane(mainPanel);
		this.setVisible(true);
	}
}
