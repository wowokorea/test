package sub.hostManager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class HostMaker extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	private int width = 600;
	private int height = 800;
	
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	
	private JTextArea jta;
	private JScrollPane jsp;
	private JButton save;
	private JButton cancel;
	
	private HostMakerController hmc;
	
	public HostMaker() {
		setTitle("Editor");
		setLocation(d.width / 2 - width / 2, d.height / 2 - height / 2);
		setSize(width, height);
		
		init();
		setVisible(true);
		setResizable(false);
	}
	
	
	private void init() {
		hmc = new HostMakerController();
		
		initLayout();
		initComponent();
		initEvent();
		
	}


	private void initEvent() {
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				hmc.test();
			}
		});
		
	}


	private void initComponent() {
		jta = new JTextArea();
		jsp = new JScrollPane(jta);
		jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
		validate();
		panel2.add(jsp);
		
		
		
		save = new JButton("SAVE");	
		panel3.add(save);
	
		cancel = new JButton("CANCEL");
		panel3.add(cancel);
		
	}


	private void initLayout() {
		panel1 = new JPanel();
		getContentPane().add(panel1, BorderLayout.NORTH);
		panel1.setLayout(new BorderLayout(0, 0));
		
		panel2 = new JPanel();
		getContentPane().add(panel2, BorderLayout.CENTER);
		panel2.setLayout(new BorderLayout(0, 0));
		
		panel3 = new JPanel();
		getContentPane().add(panel3, BorderLayout.SOUTH);
		panel3.setLayout(new FlowLayout());
		
	}


	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		String laf = UIManager.getSystemLookAndFeelClassName();
		
		try {
			UIManager.setLookAndFeel(laf);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		new HostMaker();
		
	}
	
}
