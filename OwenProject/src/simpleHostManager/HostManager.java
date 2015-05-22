package simpleHostManager;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class HostManager extends JFrame {
	public HostManager() {
	}
	
	public HostManagerController controller;

	public JPanel jp1;
	public JPanel jp2;
	public JPanel jp3;
	public JPanel jp4;
	
	public JTextField jtf1;
	
	public JLabel jlabel1;
	public JRadioButton jradio1;
	public JRadioButton jradio2;
	
	public JLabel jlabel2;
	public JRadioButton jradio3;
	public JRadioButton jradio4;
	public JRadioButton jradio5;
	
	public JButton jbtn1;
	public JButton jbtn2;
	public JButton jbtn3;
	public JButton jbtn4;
	public JButton jbtn5;
	public JButton jbtn6;
	
	public JList jlist1;
	public JScrollPane jscroll;
	
	public Dimension d;
	
	public File[] files;
	
	public int listSelectedIdx;
	
	public int viewWidth = 350;
	public int viewHeight = 650;
	
	public boolean browserFlag = false;
	public int browserChooseFlag = HostManagerConstants.BROWSER_IE;

	public JFrame subFrame;
	public JFrame editFrame;
	
	public int second = 0;

	public Timer tm;

	public boolean isExistChrome = false;
	
	public boolean isExistSafari = false;
	
	public static Map<String, Integer> optionMap = new HashMap<String, Integer>();
	
	public void init() {
		
		this.setTitle("Host Manager");
		
		controller = new HostManagerController(this);
		
		try {
			UIManager.setLookAndFeel(HostManagerConstants.WINDOWS_LOOK_AND_FEEL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		d = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setSize(viewWidth, viewHeight);
		
		setComponent();
		setEvent();

		this.setLocation(d.width - (viewWidth + 5), 5);
		this.setResizable(false);
		this.setVisible(true);
		
	}
	
	public void setComponent() {

		Container ct = this.getContentPane();
		
		ct.setLayout(new BorderLayout());
		
		jp1 = new JPanel();
		jp2 = new JPanel(new GridLayout(9, 1));
		jp3 = new JPanel(new FlowLayout());
		jp4 = new JPanel(new FlowLayout());
		
		jtf1 = new JTextField();
		jtf1.setColumns(15);
		jtf1.setEditable(false);
		
		String hostTitle = controller.getHostTitle();
		jtf1.setText(hostTitle);
		
		jlabel1 = new JLabel("Host 변경 후 브라우저 새로 열기");
		jradio1 = new JRadioButton("ON");
		jradio2 = new JRadioButton("OFF");
		jradio2.setSelected(true);
		
		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(jradio1);
		bg1.add(jradio2);
		
		jlabel2 = new JLabel("브라우저 선택");
		jradio3 = new JRadioButton("EXPLORER");
		jradio4 = new JRadioButton("CHROME");
		jradio5 = new JRadioButton("SAFARI");
		jradio3.setSelected(true);
		
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(jradio3);
		bg2.add(jradio4);
		bg2.add(jradio5);
		
		jbtn1 = new JButton("브라우저 열기");
		jbtn2 = new JButton("midas 운영업무요청");
		jbtn3 = new JButton("midas 배포요청");
		jbtn4 = new JButton("호스트 확인");
		jbtn5 = new JButton("호스트 폴더");
		jbtn6 = new JButton("호스트 제거");
		
		jp3.add(jlabel1);
		jp3.add(jradio1);
		jp3.add(jradio2);
		
		jp4.add(jlabel2);
		jp4.add(jradio3);
		
		if (isExistChrome) {
			jp4.add(jradio4);
		}
		
		if (isExistSafari) {
			jp4.add(jradio5);
		}
		
		jp2.add(jtf1);
		jp2.add(jp3);
		jp2.add(jp4);
		jp2.add(jbtn1);
		jp2.add(jbtn2);
		jp2.add(jbtn3);
		jp2.add(jbtn4);
		jp2.add(jbtn5);
		jp2.add(jbtn6);
		
		DefaultListModel dml = new DefaultListModel();
		
		for (File file : controller.getOtherHostFolder()) {
			dml.addElement(file.getName());
		}
		
		jlist1 = new JList(dml);
		jscroll = new JScrollPane(jlist1);
		
		jp1.add(jp2, BorderLayout.CENTER);
		
		ct.setLayout(new GridLayout(2, 1));
		ct.add(jp1);
		ct.add(jscroll);
		
	}
	
	public void setEvent() {

		jbtn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.gc();
				
				controller.browserOn(browserChooseFlag, "about:blank");
				
			}
			
		});
		
		jbtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.gc();
				
				controller.browserOn(browserChooseFlag, "http://smartchecker.lotte.com/csr/lecs2.0/_layouts/15/start.aspx#/Lists/lecs/PersonalViews.aspx?PageView=Personal&ShowWebPart={112D5DA9-8B61-4C7C-AD27-5D9468604B1E}");
				
			}
			
		});
		
		jbtn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.gc();
				
				controller.browserOn(browserChooseFlag, "http://smartchecker.lotte.com/csr/lecs2.0/_layouts/15/start.aspx#/Lists/2/PersonalViews.aspx?PageView=Personal&ShowWebPart={7B547521-1687-4D24-9A8F-8CD53964592A}");
				
			}
			
		});
		
		jbtn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.gc();
				
				String hostContents = controller.getHostContents(HostManagerConstants.WINDOWS_HOST_PATH + "\\hosts");
				File hostFile = controller.getSelectedHostFile(listSelectedIdx);
				String hostFileName = hostFile.getName();
				showEditFrame(hostContents, hostFileName);
				
			}
			
		});

		jbtn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.gc();
				
				controller.hostFolderOn();
				
			}
			
		});
		
		jbtn6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.gc();
				
				int result = JOptionPane.showConfirmDialog(rootPane, "호스트정보를 제거 하시겠습니까?");
				
				if (JOptionPane.OK_OPTION == result) {
					
					controller.cleanningHost();
					jtf1.setText("CLEANED");
					
					if (browserFlag) {
						showSignFrame("CLEANED");
					}
				}
				
			}
			
		});
		
		jradio1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.gc();
				
				browserFlag = true;
				
			}
			
		});
		
		jradio2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.gc();
				
				browserFlag = false;
				
			}
			
		});
		
		jradio3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				System.gc();
				
				browserChooseFlag = HostManagerConstants.BROWSER_IE;
				
			}
		});
		
		jradio4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				System.gc();
				
				browserChooseFlag = HostManagerConstants.BROWSER_CHROME;
				
			}
		});
		
		jradio5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.gc();
				
				browserChooseFlag = HostManagerConstants.BROWSER_SAFARI;
				
			}
		});
		
		jlist1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.gc();
				
				if (e.getClickCount() == 2) {
					
					listSelectedIdx = jlist1.getSelectedIndex();
	
					String[] optionNames = {"변경", "보기", "편집"};

					optionMap.put("변경", 0);
					optionMap.put("보기", 1);
					optionMap.put("편집", 2);
					optionMap.put(null, 3);
					
					String result = (String) JOptionPane.showInputDialog(rootPane, "원하는 작업을 선택하세요.", "옵션 선택", JOptionPane.QUESTION_MESSAGE, null, optionNames, optionNames[0]);
					int flag = optionMap.get(result);
					
					if (HostManagerConstants.ALERT_MESSAGE_CHANGE == flag) {
						
						controller.changeHost(listSelectedIdx);
						String hostTitle = controller.getHostTitle();
						jtf1.setText(hostTitle);
						
						if (browserFlag) {
							controller.browserOn(browserChooseFlag, "about:blank");
							showSignFrame(hostTitle);
						}
						
					} else if (HostManagerConstants.ALERT_MESSAGE_CHECK == flag) {
						String hostContents = controller.getHostContents(listSelectedIdx);
						File hostFile = controller.getSelectedHostFile(listSelectedIdx);
						String hostFileName = hostFile.getName();
						showEditFrame(hostContents, hostFileName);
						
					} else if (HostManagerConstants.ALERT_MESSAGE_EDIT == flag) {
						
						File hostFile = controller.getSelectedHostFile(listSelectedIdx);
						
						Runtime rt = Runtime.getRuntime();

						try {
							rt.exec(new String[]{HostManagerConstants.EDITPLUS_64_PATH, hostFile.getPath()});
						} catch (IOException ie1) {
							ie1.printStackTrace();
						
							try {
								rt.exec(new String[]{HostManagerConstants.EDITPLUS_32_PATH, hostFile.getPath()});
							} catch (IOException ie2) {
								ie2.printStackTrace();
							}
							
						}
					}
					
				}
				
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
		});
		
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.gc();
				System.exit(EXIT_ON_CLOSE);
			}
			
			@Override
			public void windowOpened(WindowEvent e) {}
			
			@Override
			public void windowIconified(WindowEvent e) {}
			
			@Override
			public void windowDeiconified(WindowEvent e) {}
			
			@Override
			public void windowDeactivated(WindowEvent e) {}
			
			@Override
			public void windowClosed(WindowEvent e) {}
			
			@Override
			public void windowActivated(WindowEvent e) {}
		
		});
		
	}
	
	public void showSignFrame(String title) {

		subFrame = new JFrame();
		
		Container ct = subFrame.getContentPane();
		
		JLabel subLabel = new JLabel(title);
		
		Font f = new Font("굴림", Font.BOLD, 20);
		subLabel.setFont(f);
		
		ct.add(subLabel);
		
		subFrame.setSize(200, 70);
		subFrame.setLocation(d.width / 2 - 100, d.height / 2 - 35);
		subFrame.setResizable(false);
		subFrame.setAlwaysOnTop(true);
		subFrame.setVisible(true);
	
		tm = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				second++;
				timeoutCheck();
			}
		});
		
		tm.setInitialDelay(0);
		tm.start();
		
	}
	
	public void timeoutCheck() {
		if (second == 2) {
			subFrame.setVisible(false);
			second = 0;
			tm.stop();
			
			System.gc();
		}
	}
	
	public static void main(String[] args) {
		
		HostManager t1 = new HostManager();
		t1.init();
		
	}
	
	public void showEditFrame(String hostContents, String hostFileName) {

		new HostEditManager(hostContents, hostFileName);
		
	}
	
}
