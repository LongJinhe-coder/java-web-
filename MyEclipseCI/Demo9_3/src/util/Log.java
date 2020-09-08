package util;

import java.io.File;
import java.io.FileWriter;

public class Log {
	public static void writeLog(String info) throws Exception {
		File f = new File("d:/error.txt");
		FileWriter fw = new FileWriter(f, true);
		fw.write(info + "\r\n");
		fw.close();
	}

}
