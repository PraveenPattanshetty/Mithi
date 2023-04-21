package mywork;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;

public class ReadMultipleFiles {
	static String Page1 = "";
	static String Page2 = "";
	static String Page3 = "";
	static String exclude = "";

	public static void main(String[] args) {
		File directory = new File("C:\\Users\\Admin\\OneDrive\\Desktop\\Misthi Tech");
		//the location differs based on the system folders
		String[] filenames1 = { "Page1.txt" };
		String[] filenames2 = { "Page2.txt" };
		String[] filenames3 = { "Page3.txt" };
		String[] excludeWords = { "exclude-words.txt" };

		TreeSet<String> set = new TreeSet<String>();
		TreeSet<String> set1 = new TreeSet<String>();
		TreeSet<String> set2 = new TreeSet<String>();
		TreeSet<String> set3 = new TreeSet<String>();
		TreeSet<String> set4 = new TreeSet<String>();

		// exclude-words
		for (String filename : excludeWords) {
			File file = new File(directory, filename);

			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = reader.readLine()) != null) {

					exclude = exclude + " " + line;
				}
				String[] s1 = exclude.split(" ");

				for (int i = 0; i < s1.length; i++) {
					set4.add(s1[i].toLowerCase());
				}

				reader.close();
			}
			catch (IOException e) {
				System.err.println("Error reading file: " + file.getAbsolutePath());
			}
		}

		// Page1.txt
		for (String filename : filenames1) {
			File file = new File(directory, filename);

			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = reader.readLine()) != null) {

					line = line.replace(",", " ").replace(".", " ").replace("&", " ").replace("-", " ").replace(":", "")
							.replace("\"", " ").replace("(", " ").replace(")", " ").replace("/", " ");
					line = line.replace("1", "").replace("2", "").replace("3", "").replace("4", "").replace("5", "")
							.replace("6", "").replace("7", "").replace("8", "").replace("9", "").replace("0", "");

					Page1 = Page1 + " " + line;
				}
				String[] s1 = Page1.split(" ");
				for (int i = 0; i < s1.length; i++) {
					set.add(s1[i].toLowerCase());
					set1.add(s1[i].toLowerCase());
				}

				reader.close();
			} catch (IOException e) {
				System.err.println("Error reading file: " + file.getAbsolutePath());
			}
		}
		// Page2.txt
		for (String filename : filenames2) {
			File file = new File(directory, filename);

			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = reader.readLine()) != null) {

					line = line.replace(",", " ").replace(".", " ").replace("&", " ").replace("-", " ").replace(":", "")
							.replace("\"", " ").replace("(", " ").replace(")", " ").replace("/", " ");
					line = line.replace("1", "").replace("2", "").replace("3", "").replace("4", "").replace("5", "")
							.replace("6", "").replace("7", "").replace("8", "").replace("9", "").replace("0", "");

					Page2 = Page2 + " " + line;
				}
				String[] s2 = Page2.split(" ");
				for (int i = 0; i < s2.length; i++) {
					set.add(s2[i].toLowerCase());
					set2.add(s2[i].toLowerCase());
				}

				reader.close();
			} catch (IOException e) {
				System.err.println("Error reading file: " + file.getAbsolutePath());
			}
		}

		// Page3.txt
		for (String filename : filenames3) {
			File file = new File(directory, filename);

			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = reader.readLine()) != null) {

					line = line.replace(",", " ").replace(".", " ").replace("&", " ").replace("-", " ").replace(":", "")
							.replace("\"", " ").replace("(", " ").replace(")", " ").replace("/", " ");
					line = line.replace("", "").replace("1", "").replace("2", "").replace("3", "").replace("4", "")
							.replace("5", "").replace("6", "").replace("7", "").replace("8", "").replace("9", "")
							.replace("0", "");
					Page3 = Page3 + " " + line;
				}
				String[] s3 = Page3.split(" ");
				for (int i = 0; i < s3.length; i++) {
					set.add(s3[i].toLowerCase());
					set3.add(s3[i].toLowerCase());
				}
				reader.close();
			} catch (IOException e) {
				System.err.println("Error reading file: " + file.getAbsolutePath());
			}
		}

		ArrayList<String> al = new ArrayList<>(set);
		ArrayList<String> al1 = new ArrayList<>(set1);
		ArrayList<String> al2 = new ArrayList<>(set2);
		ArrayList<String> al3 = new ArrayList<>(set3);
		ArrayList<String> al4 = new ArrayList<>(set4);

		for (String string : al4) {
			if (al.contains(string)) {
				al.remove(string);
			}
		}
		
		// boolean containsAll = al1.containsAll(al);

		// if (containsAll==false) {

		File directories = new File("C:\\Users\\Admin\\OneDrive\\Desktop\\Misthi Tech\\index.txt");

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(directories))) {
			bw.write("Word : Page Numbers");
			bw.newLine();
			bw.write("-------------------");
			bw.newLine();

			for (String obj : al) {
				if (al1.contains(obj) && al2.contains(obj) && al3.contains(obj)) {
					bw.write(obj + " : 1,2,3");
					bw.newLine();
					// System.out.println(obj + ":1,2,3");
				} else if (al1.contains(obj) && al2.contains(obj)) {
					bw.write(obj + " : 1,2");
					bw.newLine();
					// System.out.println(obj + ":1,2");
				} else if (al1.contains(obj) && al3.contains(obj)) {
					bw.write(obj + " : 1,3");
					bw.newLine();
					// System.out.println(obj + ":1,3");
				} else if (al2.contains(obj) && al3.contains(obj)) {
					bw.write(obj + " : 2,3");
					bw.newLine();
					// System.out.println(obj + ":2,3");
				} else if (al1.contains(obj)) {
					bw.write(obj + " : 1");
					bw.newLine();
					// System.out.println(obj + ":1");
				} else if (al2.contains(obj)) {
					bw.write(obj + " : 2");
					bw.newLine();
					// System.out.println(obj + ":2");
				} else if (al3.contains(obj)) {
					bw.write(obj + " : 3");
					bw.newLine();
					// System.out.println(obj + ":3");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
