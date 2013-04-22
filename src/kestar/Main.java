package kestar;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kestar.data.Client;
import kestar.data.Discount;
import kestar.data.SocialGroup;
import kestar.data.TransportTimeLimit;
import kestar.data.Vehicle;
import kestar.ui.MainWindow;

public class Main {
	public static void main(String [ ] args) {
		// Read data
		File dataFolder = new File("data");
		File[] folderFileArray = dataFolder.listFiles();
		List<File> fileList = new ArrayList<File>();
		for (File file: folderFileArray) {
			if (file.isFile()) {
				fileList.add(file);
			}
		}
		
		DataHelper dataHelper = new DataHelper();
		dataHelper.readData(fileList);
		
		// Open main window
		MainWindow testWindow = new MainWindow();
		testWindow.setDataHelper(dataHelper);
		testWindow.setVisible(true);
	}
}
