/*
 * Provides a class for a paragraph to be styled. 
 * Can addWords to paragraph, and can format it if a style is passed into it.
 */

public class Paragraph {
	private String words = "";
	
	public Paragraph(){
		
	}
	
	public void addWords(String moreWords){
			words +=  moreWords;
	}
	
	public String format(ParaStyle ps){
		int firstLineIndent = ps.getFirstLineAdjustment() + ps.getLeftIndent();
		//build string with that many spaces.
		String firstLineIndentSpaces ="";
		for(int i = 0; i < firstLineIndent; i++){
			firstLineIndentSpaces += " ";
		}
		words = firstLineIndentSpaces + words;
			
		//build string with leftIndent spaces.
		String leftIndentSpaces = "";
		for(int i = 0; i < ps.getLeftIndent(); i++){
			leftIndentSpaces += " ";
		}
		//now add newline char to each line after max number of characters per line.
		//Backup to last space if max number falls on something thats not a space.
	for(int i = 1; i <= words.length(); i++){
			if(i % ps.getLineLength() == 0){
				//space check.
				if(words.charAt(i) == ' '){
					words = words.substring(0, i+1) + "\n" + leftIndentSpaces +  words.substring(i+1, words.length());
				}else{
				 int placeToAddNewLine = i;
				 while (words.charAt(placeToAddNewLine) != ' '){
						placeToAddNewLine--;
				}
				//placeToAddNewLine--;
					words = words.substring(0, placeToAddNewLine+1) + "\n" +  leftIndentSpaces + words.substring(placeToAddNewLine+1, words.length());
				}
			}
	}
		return words + "\n";
	}
	
	
	public String toString(){
		return words;
	}
}
