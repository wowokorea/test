package hostManager;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ManagerController {

	private ManagerFrame mf;

	private static String mainHostFilePath = "C:\\Windows\\System32\\drivers\\etc";
	private static String mainHostFileName = "hosts";
	private static String otherHostsFilesPath = "C:\\Windows\\System32\\drivers\\etc\\hostFiles";
	private static String explorerPath = "";

	private static String regEditPath = "C:\\Windows\\regedit.exe";
	private static String regAddFilePath = "C:\\Windows\\System32\\drivers\\etc\\ie.reg";
	private static String regRemoveFilePath = "C:\\Windows\\System32\\drivers\\etc\\ie_remove.reg";

	private static String osWindows = "Windows";
	
	File[] otherHostFiles;
	File mainHost;

	String hostTitle;
	String[] otherhostNames;

	/**
	 * default Constructor
	 */
	public ManagerController() {
		this.setMf(mf);
		this.mainHost = getMainHostFileInfo();
		getOtherHostFilesInfo();
		readingMainHostFileTitle();
		getOtherHostName();
	}

	/**
	 * user Constructor
	 */
	public ManagerController(ManagerFrame mf) {
		this.setMf(mf);
		this.mainHost = getMainHostFileInfo();
		getOtherHostFilesInfo();
		readingMainHostFileTitle();
		getOtherHostName();

	}

	/**
	 * change From OtherHostFile To Main Host File
	 * 
	 * @param f
	 */
	private void changeFromOtherToMain(File f) {
		InputStream is = null;
		OutputStream os = null;

		try {
			is = new FileInputStream(f);
			os = new FileOutputStream(mainHost);

			int fs = is.available();

			byte[] buffer = new byte[fs];

			@SuppressWarnings("unused")
			int byteDate = is.read(buffer);

			os.write(buffer);

			is.close();
			os.close();

			mf.getHostNameTf().setText(f.getName());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * checking button event resource
	 * 
	 * @param e
	 */
	public void checkBtnEventResource(ActionEvent e) {
		for (int i = 0; i < otherhostNames.length; i++) {
			if (e.getActionCommand().equals(otherhostNames[i])) {
				changeFromOtherToMain(otherHostFiles[i]);
				checkBrowserPath();
				excuteBrowser();
			}
		}
	}

	/**
	 * execute browser
	 * 
	 * @param flagGroup
	 */
	public void excuteBrowser() {
		Runtime run = Runtime.getRuntime();
		String[] exec = new String[]{explorerPath, "about:blank"};
		try {
			if (mf.getBrowserOn().isSelected()) {
				run.exec(exec);
			} else {

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * getting otherHostName
	 */
	private void getOtherHostName() {
		otherhostNames = new String[otherHostFiles.length];

		for (int i = 0; i < otherhostNames.length; i++) {
			otherhostNames[i] = otherHostFiles[i].getName();
		}
	}

	/**
	 * remove MainHostContents
	 */
	public void removeMainHostContents() {
		File f = mainHost;

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write("");

			mf.getHostNameTf().setText("CLEANED");

			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * reading OtherHostFilesTitle
	 * 
	 * @return otherHostName
	 */
	public String[] readingOtherHostFilesTitle() {
		File[] tmp = getHostFilesList();
		String[] otherHostName = new String[tmp.length];

		for (int i = 0; i < tmp.length; i++) {
			otherHostName[i] = tmp[i].getName();
		}

		return otherHostName;
	}

	/**
	 * reading MainHostFileTitle
	 */
	private void readingMainHostFileTitle() {
		FileReader fr = null;
		BufferedReader br = null;

		try {

			if (!mainHost.exists()) {
				hostTitle = "NOT EXSIT HOST, I WILL CREATE IT.";
				return;
			}

			fr = new FileReader(mainHost);
			br = new BufferedReader(fr);

			hostTitle = br.readLine();
			if (hostTitle != null) {
				hostTitle = hostTitle.replaceAll("##", "");
			} else {
				hostTitle = "CLEANED";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * getting MainHostFile Information
	 */
	private File getMainHostFileInfo() {
		return new File(mainHostFilePath + "\\" + mainHostFileName);
	}

	/**
	 * getting OtherHostFiles Information
	 */
	private void getOtherHostFilesInfo() {
		File tmp = new File(otherHostsFilesPath);

		otherHostFiles = tmp.listFiles();
	}

	public File[] getOtherHostFiles() {
		return otherHostFiles;
	}

	public void setOtherHostFiles(File[] otherHostFiles) {
		this.otherHostFiles = otherHostFiles;
	}

	public String[] getOtherhostNames() {
		return otherhostNames;
	}

	public void setOtherhostNames(String[] otherhostNames) {
		this.otherhostNames = otherhostNames;
	}

	public ManagerFrame getMf() {
		return mf;
	}

	public void setMf(ManagerFrame mf) {
		this.mf = mf;
	}

	public String getHostTitle() {
		return hostTitle;
	}

	public void setHostTitle(String hostTitle) {
		this.hostTitle = hostTitle;
	}

	public File[] getHostFilesList() {
		return otherHostFiles;
	}

	public void setHostFilesList(File[] hostFilesList) {
		this.otherHostFiles = hostFilesList;
	}

	public File getMainHost() {
		return mainHost;
	}

	public void setMainHost(File mainHost) {
		this.mainHost = mainHost;
	}

	public void checkBrowserPath() {
		String osName = System.getProperty("os.name");
		String osBits = System.getProperty("os.arch");
		System.out.println(osName);
		
		if (osName.startsWith(osWindows)) {
			if (osBits.equals("amd64")) {
				explorerPath = "C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe";
			}
			else {
				explorerPath = "C:\\Program Files\\Internet Explorer\\iexplore.exe";
			}
		}
		else {
			
		}

	}

	/**
	 * addRegFile
	 */
	public void addRegFile() {
		String[] test = new String[]{regEditPath, regAddFilePath};
		Runtime r = Runtime.getRuntime();
		try {
			r.exec(test);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * removeRegFile
	 */
	public void removeRegFile() {
		String[] test = new String[]{regEditPath, regRemoveFilePath};
		Runtime r = Runtime.getRuntime();
		try {
			r.exec(test);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
