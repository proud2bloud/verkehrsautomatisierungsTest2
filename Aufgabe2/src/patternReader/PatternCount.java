package patternReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternCount {
	public static void main(String args[]) throws IOException {
		System.out.println(getCount(args[0], args[1])); // args[0] --> Path of Lorepsum.txt, args[1] --> pattern string
														// to be searched in the text file
	}

	public static Integer getCount(String filePath, String patternString) throws IOException {
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		byte[] data = new byte[(int) file.length()];
		fis.read(data);
		fis.close();

		String fullString = new String(data, "UTF-8");

		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(fullString);

		int count = 0;
		while (matcher.find())
			count++;
		return count;
	}
}