
public class Paragraph {
	private String words = "";
	
	public Paragraph(){
		
	}
	
	public void addWords(String moreWords){
		words += " " + moreWords;
	}
	
	public String format(ParaStyle ps){
		String paragraphSelector = ps.getName();
		
		return "";
	}
	
	public String toString(){
		return "Yes: " + words;
	}
}
