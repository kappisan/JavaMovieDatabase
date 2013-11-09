import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelWindow extends JFrame {

	JPanel centerPanel;
	JPanel rightPanel;
	JPanel topPanel;
	JFrame jf;
	
	public JPanelWindow() {
		jf = this;
		centerPanel = new JPanel();
		rightPanel = new JPanel();
		topPanel = new JPanel();
		
		JLabel title = new JLabel();
		title.setFont(new Font("Impact", Font.PLAIN, 34));
		title.setText("NUDYBASE");

		topPanel.add(title);
		
		rightPanel.setBackground(Color.yellow);
		topPanel.setBackground(Color.cyan);
		centerPanel.setBackground(Color.orange);
		
		rightPanel.setPreferredSize(new Dimension(480, 80));
		
		jf.add(topPanel,BorderLayout.NORTH);
		jf.add(centerPanel,BorderLayout.CENTER);
		jf.add(rightPanel,BorderLayout.EAST);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,450);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
