package processTest;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

@SuppressWarnings("serial")
public class ProcessTest extends JFrame{
	
	public Process proc;
	public List<Process> procList;
	public Runtime rt;
	
	public JFrame jf;
	public JPanel jp1;
	public JButton jbtn1;
	public JButton jbtn2;
	public JButton jbtn3;
	
	public void init() {
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jf = new JFrame("test");
		jf.setBounds(100, 100, 300, 200);

		jp1 = new JPanel(new GridLayout(1, 3));
		
		jbtn1 = new JButton("눌러봐");
		jbtn2 = new JButton("닫기");
		jbtn3 = new JButton("모두 닫기");
		
		//jp1.add(jbtn1);
		jp1.add(jbtn1);
		jp1.add(jbtn2);
		jp1.add(jbtn3);
		
		jf.add(jp1);
		
		jf.setVisible(true);

		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setEvent();
			
	}
	
	public void setEvent() {

		procList = new ArrayList<Process>();
		
		rt = Runtime.getRuntime();

		jbtn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String[] execPath1 = new String[]{"C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe", "http://www.mujikorea.net"};
					String[] execPath2 = new String[]{"C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe", "http://www.nikestore.co.kr"};
					String[] execPath3 = new String[]{"C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe", "http://shop.puma.co.kr"};
					String[] execPath4 = new String[]{"C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe", "http://www.uniqlo.kr"};
					String[] execPath5 = new String[]{"C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe", "http://www.kiehls.co.kr"};
					//proc = new ProcessBuilder("C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe").start();
					
					List<String[]> urlList = new ArrayList<String[]>();
					urlList.add(execPath1);
					urlList.add(execPath2);
					urlList.add(execPath3);
					urlList.add(execPath4);
					urlList.add(execPath5);
					
					for (String[] path : urlList) {
						Process proc2 = rt.exec(path);
						procList.add(proc2);
						System.out.println("프로세스 추가 : " + proc2.toString());
					}
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		jbtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Process proc2 = procList.get(procList.size()-1);
				System.out.println("프로세스 정보 : " + proc2.toString());
				proc2.destroy();
				procList.remove(proc2);
				Runtime.getRuntime().gc();
				System.out.println("닫기 결과 : " + procList.size());
			}
		});
		
		jbtn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for (Process proc2 : procList) {
					System.out.println("프로세스 정보 : " + proc2.toString());
					proc2.destroy();
				}
				procList.removeAll(procList);
				Runtime.getRuntime().gc();
				System.out.println("모두 닫기 결과 : " + procList.size());
			}
		});
		
	}
	
	public static void main(String[] args) {
		
		ProcessTest pt = new ProcessTest();
		pt.init();
		
	}
	
}
