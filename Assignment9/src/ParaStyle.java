/*
 * Provides a class for inputting a style sheet to format a document.
 * has getters for parts of the style sheet.
 */
public class ParaStyle {
	private String name;
	private int leftIndent; //indent of all lines.
	private int lineLength; //max length of lines.
	private int firstLineAdjustment; //can be neg + leftIndent
	
	
	public ParaStyle(String name, int leftIndent, int lineLength, int firstLineAdjustment){
		this.name = name;
		this.leftIndent = leftIndent;
		this.lineLength = lineLength;
		this.firstLineAdjustment = firstLineAdjustment;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getLeftIndent(){
		return this.leftIndent;
	}
	
	public int getLineLength(){
		return this.lineLength;
	}
	
	public int getFirstLineAdjustment(){
		return this.firstLineAdjustment;
	}
	
	public String toString(){
		return "Style: "  + this.name + " " + this.leftIndent + " " + this.lineLength + " " + this.firstLineAdjustment;
	}
	
}
