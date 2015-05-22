package hostManager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;

public class ManagerFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private ManagerController mc;

	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	private JPanel mainPanel;
	private JPanel sub1;
	private JPanel sub2;
	private JPanel sub3;
	private JPanel[] inner;

	private JTextField hostNameTf;
	private JLabel hostsTitleLb;
	private JButton removeBtn;
	private JButton regAddButton;
	private JButton regRemoveButton;

	private JButton[] hostBtns;
	private JSeparator separator;
	private JPanel flagPanel;
	private JLabel flagLabel;
	private JRadioButton browserOn;
	private JRadioButton browserOff;
	private ButtonGroup flagGroup;
	private JPanel panel;
	private JPanel gridPanel;
	private JPanel regPanel;

	/**
	 * default Constructor
	 */
	public ManagerFrame() {
		init();
	}

	/**
	 * initialize frame
	 */
	private void init() {
		this.setMc(new ManagerController(this));

		this.setTitle("Hosts Manager");

		this.setLocation(d.width - 305, 5);

		setPanels();
		setComponent();
		setEvent();

		this.setSize(300, 45 * hostBtns.length + 60);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setResizable(false);
		this.setVisible(true);

	}

	private void setEvent() {
		
		regAddButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mc.addRegFile();
			}
		});
		
		regRemoveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mc.removeRegFile();
			}
		});
		
		removeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mc.removeMainHostContents();
				mc.checkBrowserPath();
				mc.excuteBrowser();
			}
		});

		for (int i = 0; i < hostBtns.length; i++) {
			hostBtns[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					mc.checkBtnEventResource(e);
				}
			});
		}

	}

	/**
	 * setting components;
	 */
	private void setComponent() {
		
		regAddButton = new JButton("ie reg 추가");
		regRemoveButton = new JButton("ie reg 삭제");
		
		regPanel = new JPanel();
		regPanel.setLayout(new GridLayout(1, 2, 0, 0));
		regPanel.add(regAddButton);
		regPanel.add(regRemoveButton);
		gridPanel.add(regPanel);
		
		hostBtns = new JButton[mc.readingOtherHostFilesTitle().length];
		String[] otherhostTitle = mc.readingOtherHostFilesTitle();
		for (int i = 0; i < hostBtns.length; i++) {
			hostBtns[i] = new JButton(otherhostTitle[i]);
			inner[i].add(hostBtns[i]);
			sub2.add(inner[i]);
		}

		separator = new JSeparator();
		sub3.add(separator, BorderLayout.CENTER);

		removeBtn = new JButton("CLEAN HOST");
		sub3.add(removeBtn, BorderLayout.SOUTH);

	}

	/**
	 * setting panels
	 */
	private void setPanels() {
		mainPanel = new JPanel();
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout(0, 0));

		sub2 = new JPanel();
		mainPanel.add(sub2, BorderLayout.CENTER);
		sub2.setLayout(new GridLayout(mc.getOtherHostFiles().length, 1, 0, 0));

		inner = new JPanel[mc.getOtherHostFiles().length];

		for (int i = 0; i < mc.getOtherHostFiles().length; i++) {
			inner[i] = new JPanel(new BorderLayout());
		}

		sub3 = new JPanel();
		mainPanel.add(sub3, BorderLayout.SOUTH);
		sub3.setLayout(new BorderLayout(0, 0));

		flagGroup = new ButtonGroup();

		sub1 = new JPanel();

		panel = new JPanel();
		mainPanel.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		hostsTitleLb = new JLabel("Hosts : ");
		sub1.add(hostsTitleLb);

		hostNameTf = new JTextField();
		hostNameTf.setColumns(20);
		hostNameTf.setEditable(false);
		hostNameTf.setText(mc.getHostTitle());
		sub1.add(hostNameTf);

		gridPanel = new JPanel();
		panel.add(gridPanel);
		gridPanel.setLayout(new GridLayout(3, 1, 0, 0));

		flagPanel = new JPanel();
		gridPanel.add(flagPanel);

		flagLabel = new JLabel("브라우저 : ");
		flagPanel.add(flagLabel);

		browserOn = new JRadioButton("on");
		flagPanel.add(browserOn);

		browserOff = new JRadioButton("off");
		flagPanel.add(browserOff);
		browserOn.setSelected(true); // 기본 세팅
		flagGroup.add(browserOn);
		flagGroup.add(browserOff);
		
		gridPanel.add(sub1);
	}

	public ManagerController getMc() {
		return mc;
	}

	public void setMc(ManagerController mc) {
		this.mc = mc;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public JPanel getSub1() {
		return sub1;
	}

	public void setSub1(JPanel sub1) {
		this.sub1 = sub1;
	}

	public JPanel getSub2() {
		return sub2;
	}

	public void setSub2(JPanel sub2) {
		this.sub2 = sub2;
	}

	public JPanel getSub3() {
		return sub3;
	}

	public void setSub3(JPanel sub3) {
		this.sub3 = sub3;
	}

	public JTextField getHostNameTf() {
		return hostNameTf;
	}

	public void setHostNameTf(JTextField hostNameTf) {
		this.hostNameTf = hostNameTf;
	}

	public JLabel getHostsTitleLb() {
		return hostsTitleLb;
	}

	public void setHostsTitleLb(JLabel hostsTitleLb) {
		this.hostsTitleLb = hostsTitleLb;
	}

	public JButton getRemoveBtn() {
		return removeBtn;
	}

	public void setRemoveBtn(JButton removeBtn) {
		this.removeBtn = removeBtn;
	}
	
	public JButton getRegAddButton() {
		return regAddButton;
	}

	public void setRegAddButton(JButton regAddButton) {
		this.regAddButton = regAddButton;
	}

	public JButton getRegRemoveButton() {
		return regRemoveButton;
	}

	public void setRegRemoveButton(JButton regRemoveButton) {
		this.regRemoveButton = regRemoveButton;
	}

	public JButton[] getHostBtns() {
		return hostBtns;
	}

	public void setHostBtns(JButton[] hostBtns) {
		this.hostBtns = hostBtns;
	}

	public static void main(String[] args) {
		new ManagerFrame();

	}

	public JPanel[] getInner() {
		return inner;
	}

	public void setInner(JPanel[] inner) {
		this.inner = inner;
	}

	public JSeparator getSeparator() {
		return separator;
	}

	public void setSeparator(JSeparator separator) {
		this.separator = separator;
	}

	public JPanel getFlagPanel() {
		return flagPanel;
	}

	public void setFlagPanel(JPanel flagPanel) {
		this.flagPanel = flagPanel;
	}

	public JLabel getFlagLabel() {
		return flagLabel;
	}

	public void setFlagLabel(JLabel flagLabel) {
		this.flagLabel = flagLabel;
	}

	public JRadioButton getBrowserOn() {
		return browserOn;
	}

	public void setBrowserOn(JRadioButton browserOn) {
		this.browserOn = browserOn;
	}

	public JRadioButton getBrowserOff() {
		return browserOff;
	}

	public void setBrowserOff(JRadioButton browserOff) {
		this.browserOff = browserOff;
	}

	public ButtonGroup getFlagGroup() {
		return flagGroup;
	}

	public void setFlagGroup(ButtonGroup flagGroup) {
		this.flagGroup = flagGroup;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JPanel getGridPanel() {
		return gridPanel;
	}

	public void setGridPanel(JPanel gridPanel) {
		this.gridPanel = gridPanel;
	}
	
	public JPanel getRegPanel() {
		return regPanel;
	}

	public void setRegPanel(JPanel regPanel) {
		this.regPanel = regPanel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
