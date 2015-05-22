package file;

import java.io.File;

public class FileDeleter {

	public void deleteFolder(String parentPath) {
		
		File file = new File(parentPath);
		String[] fnameList = file.list();
		int fCnt = fnameList.length;
		String childPath = "";

		for (int i = 0; i < fCnt; i++) {
			childPath = parentPath + "/" + fnameList[i];
			File f = new File(childPath);
			if (!f.isDirectory()) {
				f.delete(); // 파일이면 바로 삭제
			} else {
				deleteFolder(childPath);
			}
		}

		File f = new File(parentPath);
		f.delete(); // 폴더는 맨 나중에 삭제

	}

	public static void main(String[] args) {

		FileDeleter deleter = new FileDeleter();
		deleter.deleteFolder("C:\\usr3");

	}

}
