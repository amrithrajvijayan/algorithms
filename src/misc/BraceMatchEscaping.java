package misc;

import java.util.Stack;

public class BraceMatchEscaping {

	public static void main(String[] args) {
		

		
		String[] lines = {"<h1>Nayeem loves counseling</h1>",
				"<h1><h1><h1>Sanjay has no watch</h1></h1></h1><par>So wait for a while<par>",
		"<Amee>safat codes like a ninja</amee>",
		"<SA premium>Imtiaz has a secret crash</SA premium>"
				};
				

		
        Stack<String> stack = new Stack<>();
        int testCases = lines.length;
        int i = 0;
		while(testCases>0){
			String line = lines[i];
			i++;
			
          	//Write your code here
            int startIndex = -1;
            int endIndex = -1;
            String tag = null;
            stack.clear();
            int wordStart = 0;
            int wordEnd= -1;
            do {
            
            startIndex = line.indexOf("<", startIndex +1);
            if (startIndex != -1) {
                endIndex = line.indexOf(">", startIndex+1);

                if (endIndex != -1) {

                    tag = line.substring(startIndex + 1, endIndex);
                    
                    //System.out.println("tag = " + tag);
                    if (tag.startsWith("/")) {
                        tag = tag.substring(1, tag.length());
                        if (wordEnd == -1) {
                        	wordEnd = startIndex;
                        }
                        if (stack.isEmpty()) {
                            System.out.println("None");
                            wordEnd = -1;
                            break;
                        } else {
                            String poppedTag = stack.pop();

                        //System.out.println("### popped tag from stack " + poppedTag);

                        //System.out.println("### comparing with tag " + tag);

                            if (poppedTag != null && poppedTag.equals(tag)) {
                                if (stack.isEmpty()) {
                                    System.out.println(line.substring(wordStart, wordEnd));
                                    wordEnd = -1;
                                } else {
                                	
                                    //System.out.println("None");
                                	boolean allMatched = true;
                                	while(!stack.isEmpty()) {
                                		poppedTag = stack.pop();
                                		
                                        startIndex = line.indexOf("<", endIndex);
                                        if (startIndex != -1) {
                                            endIndex = line.indexOf(">", startIndex+1);
                                            if (endIndex != -1) {
                                                tag = line.substring(startIndex + 1, endIndex);
                                                if (tag.startsWith("/")) {
                                                    tag = tag.substring(1, tag.length());
                                                    if (!tag.equals(poppedTag)) {
                                                    	allMatched = false;
                                                    	break;
                                                    }
                                                } else {
                                                	allMatched = false;
                                                	break;
                                                }

                                            }
                                        }
                                	}
                                	if (allMatched) {
                                        System.out.println(line.substring(wordStart, wordEnd));
                                	} else {
                                        System.out.println("None");
                                	}


                                }
                            } else {
                                System.out.println("None");
                                wordEnd = -1;
                                break;
                            }
                        }
                    } else {
                        wordStart = endIndex + 1;
                        //System.out.println("### pushing tag to stack " + tag);
                        stack.push(tag);
                    }
                }
            }
            }while(startIndex > -1  && endIndex > -1);
          



			
			testCases--;
		}		

	}

}
