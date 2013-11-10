import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanelWindow extends JFrame {

	JPanel searchPanel;
	JPanel rightPanel;
	JPanel topPanel;
	JFrame jf;
	
	public JPanelWindow() throws IOException {
		jf = this;
		searchPanel = new JPanel();
		rightPanel = new JPanel();
		topPanel = new JPanel();
		
		JLabel title = new JLabel();
		title.setFont(new Font("Impact", Font.PLAIN, 34));
		title.setText("NUDYBASE");

		topPanel.add(title);
		
		rightPanel.setBackground(Color.yellow);
		topPanel.setBackground(Color.cyan);
		searchPanel.setBackground(Color.orange);
		
		rightPanel.setPreferredSize(new Dimension(300, 280));
		searchPanel.setPreferredSize(new Dimension(260, 280));
		
		

		JPanel jCard = new JPanel();
		jCard.setPreferredSize(new Dimension(180, 120));
		
		JLabel wIcon;
		try {
			BufferedImage wPic = ImageIO.read(this.getClass().getResource("titanic.jpg"));
			wIcon = new JLabel(new ImageIcon(wPic));
		} catch(Exception e) {
			wIcon = new JLabel("IMAGE");
		}
		

		String filmDescription = "NUDITY: BREIF ACTORS / ACTORESSES Year: (1998)";
		
		JLabel filmLabel = new JLabel("<html><div style=\"text-align: center;\">Titanic</div></html>");
				
		filmLabel.setHorizontalTextPosition(JLabel.CENTER);
		
		jCard.add(wIcon);
		jCard.add(filmLabel);
		jCard.add(new JLabel(""));
		
		JLabel description = new JLabel(filmDescription);
		description.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		jCard.add(description);
		
		rightPanel.add(jCard);
		
		jCard.setPreferredSize(new Dimension(640, 120));
		
		makeSearchBox(searchPanel);
		jf.add(topPanel,BorderLayout.NORTH);
		jf.add(searchPanel,BorderLayout.WEST);
		jf.add(rightPanel,BorderLayout.CENTER);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void showMovieCard(JLabel jl) {
		
	}
	
	public void makeSearchBox(JPanel jp) {
		
		jp.setLayout(new GridLayout(8,1));
	
		// SEARCH BAR
		//***************************************
		JPanel searchBarPanel = new JPanel();
		searchBarPanel.setBackground(Color.orange);
		JLabel searchMovieLabel = new JLabel("                 Search Movie");
		searchMovieLabel.setFont(new Font("Impact", Font.PLAIN, 24));
		searchMovieLabel.setHorizontalTextPosition(JLabel.CENTER);
		
		jp.add(searchMovieLabel);
		searchBarPanel.add(new JTextField(20));
		jp.add(searchBarPanel);
		
		// SEARCH BUTTON
		//***************************************	
		JPanel searchMoviePanel = new JPanel();
		searchMoviePanel.setBackground(Color.orange);
		searchMoviePanel.add(new JButton("SEARCH"));
		jp.add(searchMoviePanel);
		
		// CHOOSE YEAR
		//***************************************
		JPanel yearPanel = new JPanel();
		yearPanel.setBackground(Color.orange);
		yearPanel.add(new JLabel("YEAR"));
		yearPanel.add(new JTextField(4));
		jp.add(yearPanel);
		
		// SELECT NUDITY
		//***************************************
		JPanel nudityPanel = new JPanel();
		nudityPanel.setBackground(Color.orange);
		nudityPanel.add(new JCheckBox("NUDITY"));
		jp.add(nudityPanel);
		
		// SELECT GENRE
		//***************************************
		
		String[] petStrings = { "Select Genre", "Action", "Advenure", "Crime", "Comedy", "Drama", "Horror",
				"Romance", "Pornographic", "Science Fiction", "Documentry", "Historical",
				"Musical", "Thriller", "War", "Western"};

		JPanel genrePanel = new JPanel();
		genrePanel.setBackground(Color.orange);
		
		genrePanel.add(new JLabel("GENRE: "));
		JComboBox petList = new JComboBox(petStrings);
		//petList.setSelectedIndex(4);
		genrePanel.add(petList);
		jp.add(genrePanel);
	}
}
