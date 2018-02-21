import java.util.ArrayList;

public class LongestWord {

	public static void main(String[] args) {
		
		 Result result;
		 
		 result = findLongestWord("The cow jumped over the moon.");
		 result.print();
		 result = findLongestWord("The cow jumped-over the moon tonight.");
		 result.print();
		 result = findLongestWord("can't");
		 result.print();
		 result = findLongestWord("The");
		 result.print();
		 result = findLongestWord("The      cow jumped jumped");
		 result.print();
		 result = findLongestWord("The The The The @#$@#$");
		 result.print();
		 result = findLongestWord(null);
		 result.print();
		 
	}
	
	
	private static Result findLongestWord(String sentence){
		if(sentence == null){
			System.out.println("Input sentence was null.");
			return new Result(0,null);
		}
		else{
			System.out.println("Finding the longestasdad word in the sentence: \"" + sentence + "\"");
			
			//Lets replace any non alphabetic character so we only end up with words.
			//Things like cant't become cant, and post-game become post game.
			sentence = sentence.replaceAll("[']", "");
			sentence = sentence.replaceAll("[^a-zA-Z]", " ");
			//Making an assumption that words in this sentence will be split by spaces like a normal sentence.
			String [] words = sentence.split(" ");
			
			ArrayList<String> longestWords = new ArrayList();
			int longestWordLength = 0;
			
			for(String word : words){
				
				//Trim the word to avoid double spaces counting in word length;
				word = word.trim();
	
				if(word.length() > longestWordLength){
					longestWordLength = word.length();					
					longestWords.clear();
					longestWords.add(word);
				}
				else if(word.length() == longestWordLength){
					longestWords.add(word);
				}
			}
			return new Result(longestWordLength,longestWords);
		}
	}
	
	static class Result{
		int length;
		ArrayList<String> words;
		
		public Result(int length, ArrayList<String> words){
			this.length = length;
			this.words = words;
		}
		
		public void print(){
			if(this.words == null){
				System.out.println("\tImpossible to have a result here");
			}
			else{
				System.out.println(String.format("\tLongest words were: %s\n\tWord length was: %d", words.toString(), this.length));
			}
		}
	}
	
	
	

}
