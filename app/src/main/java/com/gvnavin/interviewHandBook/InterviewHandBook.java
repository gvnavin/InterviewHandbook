package com.gvnavin.interviewHandBook;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.gvnavin.interviewHandBook.R;

public class InterviewHandBook extends Application {

	private static Question[] mQuestions;
	private static Context mContext;
	
	@Override
	public void onCreate() {
		mContext = InterviewHandBook.this;
		try {
			extractQuestions();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void extractQuestions() throws IOException {
		String everything;
		InputStream inputStream = getResources().openRawResource(R.raw.json_10);
		try {
			everything = IOUtils.toString(inputStream);
		} finally {
			inputStream.close();
		}
		Gson gson = new Gson();
		mQuestions = gson.fromJson(everything, Question[].class);
	}

	public static Question[] getQuestions() {
		return mQuestions;
	}
	
	public static Context getContext() {
		return mContext;
	}
}