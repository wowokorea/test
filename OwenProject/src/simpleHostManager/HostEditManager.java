package simpleHostManager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class HostEditManager extends JFrame {
	
	public Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	public JPanel jp1;
	
	public JTextArea jta1;
	public JScrollPane jscroll;
	
	public HostEditManager() {}
	
	public HostEditManager(String hostContents, String hostFileName) {
		init(hostContents, hostFileName);
	}
	
	public void init(String hostContents, String hostFileName) {

		jta1 = new JTextArea();
		jta1.setText(hostContents);
		jta1.setCaretPosition(0);

		jscroll = new JScrollPane(jta1);
		
		jp1 = new JPanel(new BorderLayout());
		
		jp1.add(jscroll, BorderLayout.CENTER);
		
		this.add(jp1);
		
		this.setTitle(hostFileName);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setSize(700, 800);
		this.setLocation(d.width / 2 - 300, d.height / 2 - 350);
		this.setVisible(true);
		
	}
	
}
