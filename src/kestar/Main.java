package kestar;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;

import kestar.ui.MainWindow;

public class Main {
	public static void main(String [ ] args) {
		setSystemLookAndFeel();
		
		// Read data
		File dataFolder = new File("data");
		File[] folderFileArray = dataFolder.listFiles();
		List<File> fileList = new ArrayList<File>();
		for (File file: folderFileArray) {
			if (file.isFile()) {
				fileList.add(file);
			}
		}
		
		DataManager dataManager = new DataManager();
		dataManager.readData(fileList);
		
		// Open main window
		MainWindow testWindow = new MainWindow(dataManager);
		testWindow.setVisible(true);
	}
	
	public static void setSystemLookAndFeel() {
		try {
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println("Error setting system look and feel");
		}
	}
}
