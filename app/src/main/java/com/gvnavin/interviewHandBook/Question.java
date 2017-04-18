package com.gvnavin.interviewHandBook;


/**
 * 
 */

/**
 * @author gnavin
 *
 */
public class Question {

	private String question;
	private String[] answers;
	private boolean[] answers_flag;
	private int correct_answer;
	private String explanation;

	public Question() {
	}

	public String getQuestion() {
		//android.util.Log.d("Navin", question);
		//String str = question;
		android.util.Log.d("Navin", question);
		return question; 
	}
	
	public String getOption(int i) {
		return answers[i];
	}
	
	public String getOption_0() {
		return answers[0];
	}
		
	public String getOption_1() {
		return answers[1];
	}
	
	public String getOption_2() {
		return answers[2];
	}
	
	public String getOption_3() {
		return answers[3];
	}
	
	public int getCorrectAnswerIndex() {
		return correct_answer;
	}
	
	public String getCorrectAnswerText() {
		return answers[correct_answer];
	}
	
	public String getExplanation() {
		return explanation;
	}
	
	public static String replace_slash_n(String str) {
		return str.replace("\\n", "\n");
	}
}
