package model_ap_exam;
/**
 * Keeps score
 *
 * @author (John Mortensen)
 * @version (1.0 Eclipse)
 */
public abstract class Scoring
{
    private static int totalCorrect = 0;  // class variables
    private static int totalQuestions = 0;
    
    private int correct;        // correct answers
    private int questions;      // questions attempted
    /**
     * Constructor for objects of class Counting
     */
    public Scoring()
    {
        // Initialize instance variables
        this.correct = 0;
        this.questions = 0;
    }
    
    
    /**
     * Update scoring on questions
     *
     * @param  isCorrect  answer correct
     */
    public void updateCounters(Boolean isCorrect)
    {
        if (isCorrect)
        {
            this.correct++;
            Scoring.totalCorrect++;
        }
        questions++;
        totalQuestions++;
    }
    
    /**
     * Results message
     *
     * @return    correct/total
     */
    public String getCounterMsg()
    {
        return "Results: " + this.correct + " of " + this.questions;
    }
    
    /**
     * Scoring message
     *
     * @return    scoring
     */
    public static String getCounterTotalMsg()
    {
        return "Totals:  " + Scoring.totalCorrect + " of " + Scoring.totalQuestions;
    }

}
