import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class ParagraphDriver {
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<ParaStyle> styleList = new ArrayList<ParaStyle>();
	private static ArrayList<Paragraph> document = new ArrayList<Paragraph>();
	
	public static void main(String[] args){
		System.out.println("Welcome to the Document Formatter!");
		styleList = readStyles(input);
		//System.out.println(styleList);
		document = buildDocument(input);
		
	}
	
	public static ArrayList<ParaStyle> readStyles(Scanner styleScanner){
		ArrayList<ParaStyle> styles = new ArrayList<ParaStyle>();
		System.out.print("Enter Style filename: ");
		try {
			styleScanner = new Scanner(new FileReader(input.nextLine()));
			while(styleScanner.hasNextLine()){
				String paraStyleLine = styleScanner.nextLine();
				String[] subWords = paraStyleLine.split(" ");
				styles.add(new ParaStyle(subWords[0], Integer.parseInt(subWords[1]), Integer.parseInt(subWords[2]), Integer.parseInt(subWords[3])));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return styles;
	}
	
	public static void formatDocument(Scanner docScanner, PrintWriter outputFileScanner, ArrayList<ParaStyle> styles){
		
	}	
	
	public static ArrayList<Paragraph> buildDocument(Scanner docScanner){
		int paragraphCount = 0;
	
		System.out.print("Please enter in Document filename: ");
		try {
			docScanner = new Scanner(new FileReader(input.nextLine()));
			while(docScanner.hasNextLine()){
				String docLine = docScanner.nextLine();
				if(docLine.substring(0,2).compareTo(".P") == 0){
					paragraphCount++;
					document.add(new Paragraph());
				}
				document.get(paragraphCount-1).addWords(docLine);
			}
		}catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return document;
	}
	

}