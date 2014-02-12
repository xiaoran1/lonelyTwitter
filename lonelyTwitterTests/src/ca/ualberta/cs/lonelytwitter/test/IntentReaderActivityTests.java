package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import android.test.ViewAsserts;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

@SuppressLint("NewApi")
public class IntentReaderActivityTests extends
		ActivityInstrumentationTestCase2<IntentReaderActivity> {

	public IntentReaderActivityTests() {
		super(IntentReaderActivity.class);
	}
	
	public void testSendText(){
		Intent intent = new Intent();
		String text = "hello!";
		intent.putExtra(IntentReaderActivity.TEXT_KEY,text);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertNotNull(activity);
		
		assertEquals("IntentReaderAcivit should get text from intent", text, activity.getText());
	}
	
	public void testDoubleText(){
		Intent intent = new Intent();
		String text = "hello!";
		intent.putExtra(IntentReaderActivity.TEXT_KEY,text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
					
		assertNotNull(activity);
					
		assertEquals("IntentReaderAcivit should get text from intent", text + text, activity.getText());
	}
	
	public void testDisplayTex() {
		Intent intent = new Intent();
		String text = "hello!";
		intent.putExtra(IntentReaderActivity.TEXT_KEY,text);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertNotNull(activity);
		TextView textView = (TextView)activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		assertEquals("IntentReaderActivity should display text", text, textView.getText().toString());
	}
	
	public void testReverseText() {
		Intent intent = new Intent();
		String text = "hello!";
		intent.putExtra(IntentReaderActivity.TEXT_KEY,text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.REVERSE);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		char[] string = text.toCharArray();
		for (int i = 0; i < string.length / 2; i++) {
			char tmp = string[i];
			string[i] = string[string.length - i -1];
			string[string.length - i - 1] = tmp;
		}
		String haha = new String(string);
		
		assertNotNull(activity);
		
		assertEquals("IntentReaderAcivit should get text from intent", haha, activity.getText());
	}
	
	public void testNothing() {
		Intent intent = new Intent();
		String text = null;
		intent.putExtra(IntentReaderActivity.TEXT_KEY,text);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		if (activity.getText() == null){
			text = "Nothing is tansfered";
		}
		assertEquals("IntentReaderAcivit should get text from intent", "Nothing is tansfered", text);
	}
	
	public void testViewOnScreen() {
		Intent intent = new Intent();
		String text = "hello!";
		intent.putExtra(IntentReaderActivity.TEXT_KEY,text);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertNotNull(activity);
		
		TextView textView = (TextView)activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(),textView);
		
	}
}
