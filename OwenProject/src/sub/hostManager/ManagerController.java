package sub.hostManager;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

public class ManagerController {

	private ManagerFrame mf;

	private static String mainHostFilePath = "C:\\Windows\\System32\\drivers\\etc";
	private static String mainHostFileName = "hosts";
	private static String otherHostsFilesPath = "C:\\Windows\\System32\\drivers\\etc\\hostFiles";
	private static String explorer32Path = "C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe";
	private static String explorerPath = "C:\\Program Files\\Internet Explorer\\iexplore.exe";

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
		
		File f = new File(explorer32Path);
		
		if (f.exists()) {
			if (mf.getBrowserOn().isSelected()) {
				try {
					Runtime rt = Runtime.getRuntime();
					rt.exec(explorer32Path);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {

			}
			
		} else {
			Desktop desktop = Desktop.getDesktop();

			if (mf.getBrowserOn().isSelected()) {
				URI uri;
				try {
					uri = new URI("about:blank");
					desktop.browse(uri);
				} catch (URISyntaxException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				
			}
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

		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} finally {
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
		File tmpFile = new File(explorer32Path);

		if (tmpFile.exists()) {

		} else {

		}

	}

}
