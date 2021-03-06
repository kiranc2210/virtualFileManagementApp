/**
 * 
 */
package com.LockedMeDotCom.bussinessObject.implimentations;

import java.io.File;

import com.LockedMeDotCom.bussinessObject.LockedMeBOInterface;
import com.LockedMeDotCom.dataAccessObject.LockedMeDaoInterface;
import com.LockedMeDotCom.dataAccessObject.implimentaions.LockedMeDaoImpl;

/**
 * @author kiran
 *
 */
public class LockedMeBoImpl implements LockedMeBOInterface {

	private LockedMeDaoInterface lmd;

	private LockedMeDaoInterface getLMD() {
		if (lmd == null) {
			lmd = new LockedMeDaoImpl();
		}
		return lmd;
	}

	public File addUserFile(String fileName) throws Exception {

		String userFileName = "";
		String[] filename = fileName.split(" ");
		for (String name : filename) {
			userFileName = name.substring(0, 1).toUpperCase() + name.substring(1);
		}

		File fn = getLMD().addUserFile(userFileName);

		return fn;
	}

	public String getFileByName(String fileName) throws Exception {

		String file = "";
		String fname = getLMD().getFileByName(fileName);

		if (fname.equals(fileName)) {
			file = fname;
			System.out.println("File Found is: " + file);

		} else {
			System.out.println(fileName + " " + "does not exist");
		}

		return file;
	}

	public void updateFile(String fileName, String fileContents) throws Exception {
		boolean updatesuccess = false;
		getLMD().updateFile(fileName, fileContents);
		updatesuccess = true;

		if (updatesuccess) {
			System.out.println("Update Success full");
			System.out.println("\n");
		} else {
			System.out.println("Update Fail");
			System.out.println("\n");
		}
	}

	public void deleteUserFile(String fileName) throws Exception {

		getLMD().deleteUserFile(fileName).delete();

		System.out.println("File has been Deleted");

	}

	public void getAllFileNames() throws Exception {

		// java.util.List<File>
		// fileName=(getLMD().getAllFileNames()).stream().sorted().collect(Collectors.toList());
		// fileName.stream().forEach(System.out::println);
		java.util.List<String> fileName = getLMD().getAllFileNames();

		int listSize = fileName.size();
		if (listSize == 0) {
			System.out.println("Directory is Empty");

		} else {
			for (String file : fileName) {
				String name = file.toString();

				System.out.print(name + "\n");

			}

		}
		System.out.println("Totoal number of file Available in the Directory:" + listSize);

	}
}
