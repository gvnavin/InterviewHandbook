package com.gvnavin.interviewHandBook;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;

import com.gvnavin.interviewHandBook.R;

public class QuestionsActivity extends Activity {
	private Question[] mQuestions;
	private SparseIntArray mChosenAnswers;
	private View mContent;
	private QuestionView mQuesView;
	private ActionBar mActionBar;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//ViewServer.get(this).addWindow(this);
		 
		setContentView(R.layout.question_activity_layout);
		
		//mActionBar = getActionBar();
		//mActionBar.setIcon(null);
		//mActionBar.setDisplayShowTitleEnabled(false);
		//mActionBar.setDisplayUseLogoEnabled(false);
		
		mContent = findViewById(R.id.scrollView1);
		
		mQuestions = InterviewHandBook.getQuestions();
		mChosenAnswers = new SparseIntArray();
		mQuesView = new QuestionView(QuestionsActivity.this, mQuestions); 
		
		((ScrollView) mContent).removeAllViews();
		((ScrollView) mContent).addView(mQuesView.getQuestionsView());	
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.questions_activity_menu, menu);
		return true;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			return true;
		} else if (item.getItemId() == R.id.action_reset) {
			onReset();
		} else if (item.getItemId() == R.id.action_submit) {
			onSubmit();
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void onSubmit() {
		mQuesView.validateAnswers(mChosenAnswers, mContent, QuestionsActivity.this);
	}


	private void onReset() {
		UIUtil.makeViewGone(QuestionsActivity.this, R.id.total_no_of_questions_holder);
		UIUtil.makeViewGone(QuestionsActivity.this, R.id.no_of_questions_answered_holder);
		UIUtil.makeViewGone(QuestionsActivity.this, R.id.no_of_correct_answers_holder);
		UIUtil.makeViewGone(QuestionsActivity.this, R.id.status_bar);
		mChosenAnswers.clear();
		((ScrollView) mContent).removeAllViews();
		((ScrollView) mContent).addView(mQuesView.getQuestionsView());	
	}


	@SuppressLint("InlinedApi")
	public void onSubmit(View view) {
		
	}
	
	public void onReset(View view) {
		
	}

	public void onRadioButtonClicked(View view) {
		ChosenAnswer chosenAnswer = new ChosenAnswer((String) view.getTag());
		mChosenAnswers.put(chosenAnswer.getmQuestionNumber(), chosenAnswer.getmChosenAnswer());
	}
	
	public void onDestroy() {
		super.onDestroy();
		//ViewServer.get(this).removeWindow(this);
	}

	public void onResume() {
		super.onResume();
		//ViewServer.get(this).setFocusedWindow(this);
	}

}
