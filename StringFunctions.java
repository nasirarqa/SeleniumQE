public class StringFunctions{

static void maxArrayNo(){
	int[] numbers = {54, 120, 14, 35, 13, 42, 111, 91, 50};
	int len = numbers.length;
	int maxNo = 0;	
	
		for(int i = 0; i < len; i++){
			if(maxNo < numbers[i]){
			maxNo = numbers[i];
			}
		}
		System.out.println(maxNo);
	
}



static void stringReverse(){
	String inputText = "My name is Khan";
	String[] splitText = inputText.split("\\s");
	int arrLength = splitText.length;
	String outputText = null;
		
		for(String word: splitText){
			if(outputText == null){
			outputText = word;
			}
			else{
			outputText = word +" "+outputText;
			}
		}
		System.out.println(outputText);
	
}



static void getCharCount(){
	String givenText = "SampleTestAditi";
	int charCount = 0;
	char charValue = 'a';
			
	
		for(int i = 0; i < givenText.length(); i++){
			char actValue = givenText.charAt(i);
			if(actValue == charValue){
			charCount++;
			}
		}
		System.out.println(charCount);
	
}

	public static void main(String[] args){
	maxArrayNo();
	stringReverse();
	getCharCount();
	}
}

