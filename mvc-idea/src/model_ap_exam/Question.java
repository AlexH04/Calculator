package model_ap_exam;

import util.ConsoleMethods;

/**
 * Question class is intended to support asking question on test
 *
 * @author (John Mortensen)
 * @version (1.0)
 */
public class Question extends Scoring
{
	// question id or number
	private int ID;

	// question setup values
	protected String question, choiceA, choiceB, choiceC, choiceD, choiceE, answer;
	protected char answerKey;
    
    // internal control values, these are never change
    protected final char charA = 'A', charB = 'B', charC = 'C', charD = 'D', charE = 'E'; 	// Multiple choice default letters
	protected final char[] answers = {charA, charB, charC, charD, charE};					// Multiple choice default order
   	protected int aOffset = 0, bOffset = 1, cOffset = 2, dOffset = 3, eOffset = 4;			// Multiple choice index value
    
    // defaults for choice
   	protected int choiceOffset;				// choiceOffset is used when scrambled to move answers around
    protected boolean choiceEfixed;			// used to keep choice E fixed versus randomization
	protected String[] choices = {"", "", "", "", ""};

    
    /**
     * Constructor for objects of class Question
     * 
     */
    public Question()
    {
    	// This outputs constructor being run
        ConsoleMethods.println("Question class constructor");
        
        // turn scrambled off for backward compatibility
        choiceOffset = 0;
        choiceEfixed = true;  
    }
    
      
    /**
     * setup question choices and answer
     * 
     */
     protected void setupQuestion() {
    	// This outputs constructor being run
        ConsoleMethods.println("Question class setupQuestion method");
    	setupQuestionData();
        
    	// choice assignment
    	choices[aOffset] = choiceA;
    	choices[bOffset] = choiceB;
    	choices[cOffset] = choiceC;
    	choices[dOffset] = choiceD;
    	choices[eOffset] = choiceE;   	
    }
 
     /**
      * setup question data default, expectation is this will changed through polymorphism
      *
      */
    protected void setupQuestionData() {
    	// This outputs constructor being run
        ConsoleMethods.println("Question class setupQuestionData method");
        
    	question = "What type of programming language is Java?";
		choiceA = "Data-oriented";
		choiceB = "Iterative";
		choiceC = "Object-oriented";
		choiceD = "Imperative";
		answer = choiceC;
		answerKey = charC;
    }
    /**
     * Question ID setter
     *
     * @param  id question id or number
     */
	public void setID(int id) {
		this.ID = id;
	}
	
	/**
     * Question ID getter
     *
     * @return ID
     */
	public int getID() {
		return ID;
	}
	
	/**
     * Question getter
     *
     * @return String	contents of question
     */
	public String getQuestion() {
		return question;
	}
	
	/**
     * Choices getter for Multiple Choice
     *
     * @return String 	content of choices with ABCDEF formatting
     */
	public String getChoices() {
		return (
            charA + ": " + choices[0] + "\n"  + 
    	    charB + ": " + choices[1] + "\n"  + 
    	    charC + ": " + choices[2] + "\n"  + 
    	    charD + ": " + choices[3] + "\n"  + 
    	    charE + ": " + choices[4] + "\n"
            );    
	}
	
	/**
     * Answer getter with formatting to correspond to getChoices
     *
     * @return String 	correct answer with letter prefex of right answer (A or B or C...)
     */
	public String getAnswer() {	
		
		// This outputs randomization of letters
    	ConsoleMethods.println("Answer:" + answerKey);
		
		return answerKey + ": " + answer;
	}
    
	/**
     * Console support wrapper for asking question, getting result, and calculating results
     *
     */
    public void  askQuestionConsole()
    {
        // getAnswer return true if question is correct
        updateCounters ( getAnswerConsole() );
    }
    
    /**
     * Console support for asking question and getting result
     *
     */
    private boolean getAnswerConsole()
    {
        char choice;
        
        // Implement this to randomize order
        ConsoleMethods.println(getQuestion());
        ConsoleMethods.println(getChoices());
        
        // IO logic of getting answer from console
        do {
            choice = ConsoleMethods.inputChar("Enter selection (A-E) --> ");
            choice = Character.toUpperCase(choice); // Convert to upper case
            if (choice >= charA && choice <= charE) break;
            ConsoleMethods.println(" (invalid) ");
        } while ( true );                                               // until valid input
        
        if (choice == answerKey) ConsoleMethods.print("(correct) ");
        else ConsoleMethods.print("(missed it!) ");
        ConsoleMethods.println(answer);
        ConsoleMethods.println();

        return (choice == answerKey);
    }

    public String toString()
    {
		return getID() + ". " + getQuestion() + "\n" + getChoices() + "\nAnswer: " + getAnswer() + "\n\n";
    }
  
}
