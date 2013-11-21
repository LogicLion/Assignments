
public class ParaStyle {
	private String name;
	private int leftIndent;
	private int lineLength;
	private int firstLineAdjustment;
	
	
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
