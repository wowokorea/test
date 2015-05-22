package simpleHostManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class HostManagerController {

	public File[] files;
	
	Runtime rt = Runtime.getRuntime();
	
	public HostManagerController() {

	}
	
	public HostManagerController(HostManager manager) {
		
		this();
		manager.isExistChrome = checkChrome();
		manager.isExistSafari = checkSafari();
		
	}
	
	public boolean checkSafari() {
		
		boolean result = false;
		
		File f1 = new File(HostManagerConstants.WINDOWS7_SAFARI32_PATH);

		if (f1.exists()) {
			result = true;
		} else {
			File f2 = new File(HostManagerConstants.WINDOWS7_SAFARI64_PATH);
			if (f2.exists()) {
				result = true;
			}
		}
		
		return result;
		
	}
	
	public boolean checkChrome() {
		
		boolean result = false;
		
		File f1 = new File(HostManagerConstants.WINDOWS7_CHROME32_PATH);

		if (f1.exists()) {
			result = true;
		} else {
			File f2 = new File(HostManagerConstants.WINDOWS7_CHROME64_PATH);
			if (f2.exists()) {
				result = true;
			}
		}
		
		return result;
				
	}
	
	public void browserOn(int browserFlag, String url) {
		
		try {
			
			if (HostManagerConstants.BROWSER_IE == browserFlag) {
				try {
					rt.exec(new String[]{HostManagerConstants.WINDOWS7_IE32_PATH, url});
				} catch (IOException ie) {
					ie.printStackTrace();
					rt.exec(new String[]{HostManagerConstants.WINDOWS7_IE64_PATH, url});
				}
			} else if (HostManagerConstants.BROWSER_CHROME == browserFlag) {
				try {
					rt.exec(new String[]{HostManagerConstants.WINDOWS7_CHROME32_PATH, url});
				} catch (IOException ie) {
					ie.printStackTrace();
					rt.exec(new String[]{HostManagerConstants.WINDOWS7_CHROME64_PATH, url});
				}
			} else if (HostManagerConstants.BROWSER_SAFARI == browserFlag) {				
				try {
					rt.exec(new String[]{HostManagerConstants.WINDOWS7_SAFARI32_PATH, url});
				} catch (IOException ie) {
					ie.printStackTrace();
					rt.exec(new String[]{HostManagerConstants.WINDOWS7_SAFARI64_PATH, url});
				}
			} else {
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void cleanningHost() {
		
		File host = new File(HostManagerConstants.WINDOWS_HOST_PATH + File.separator + "hosts");

		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter(host));
			bw.write("");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public String getHostTitle() {
		
		String title = "";
		
		File host = new File(HostManagerConstants.WINDOWS_HOST_PATH + File.separator + "hosts");
		
		FileReader fr = null;
		try {
			fr = new FileReader(host);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(fr);
			title = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (title != null) {
			title = title.replaceAll("##", "");
		} else {
			title = "CLEANED";
		}
		
		return title;
		
	}
	
	public void changeHost(int listSelectedIdx) {
		
	    FileChannel inChannel = null;
	    FileChannel outChannel = null;
	    try {
	    	
	    	inChannel = new FileInputStream(files[listSelectedIdx]).getChannel();
	    	outChannel = new FileOutputStream(new File(HostManagerConstants.WINDOWS_HOST_PATH + File.separator + "hosts")).getChannel();
	    	
	    	inChannel.transferTo(inChannel.position(), inChannel.size(), outChannel);
	    	
	    } catch (IOException e) {
	    	e.printStackTrace();
	    } finally {
	    	try {	inChannel.close();	} catch (IOException e) {	e.printStackTrace();	}
	    	try {	outChannel.close();	} catch (IOException e) {	e.printStackTrace();	}
	    }
		
	}

	public File[] getOtherHostFolder() {
		
		File hostFolder = new File(HostManagerConstants.OTHER_HOST_PATH);
		files = hostFolder.listFiles();
		
		return files;
		
	}
	
	public void hostFolderOn() {
		try {
			rt.exec(new String[]{HostManagerConstants.WINDOWS7_EXPLORER_PATH, HostManagerConstants.WINDOWS_HOST_PATH});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getHostContents(int listSelectedIdx) {
		
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		
		try {
			br = new BufferedReader(new FileReader(files[listSelectedIdx]));
			
			int tempStr = 0;
			try {
				while ((tempStr = br.read()) != -1) {
					sb.append((char)tempStr);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return sb.toString();
		
	}
	
	public String getHostContents(String hostFilePath) {
		
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		
		try {
			br = new BufferedReader(new FileReader(new File(hostFilePath)));
			
			int tempStr = 0;
			try {
				while ((tempStr = br.read()) != -1) {
					sb.append((char)tempStr);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return sb.toString();
		
	}
	
	public File getSelectedHostFile(int listSelectedIdx) {
		
		return files[listSelectedIdx];
		
	}
	
}
