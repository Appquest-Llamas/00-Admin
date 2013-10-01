package ch.hsr.appquest.quickdemo.ui;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import ch.hsr.appquest.quickdemo.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

@SuppressLint("SimpleDateFormat")
public class FrameLayoutActivity extends Activity {
	// this tag is used in all of LogCat calls
	private static final String TAG = "FrameLayoutActivity";
	
	// by using a field instead of local variable
	// this field can be set once instead of finding for each use
	private TextView txtTime;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        
        // set '<' in action bar
 		getActionBar().setDisplayHomeAsUpEnabled(true);
        
        txtTime = (TextView)findViewById(R.id.txt_time);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		// this method is called every-time the Activity is restarted
		// or created.
		// Try switching apps and after a minute switch back,
		// the time will update
		updateTime();
	}
	
	// set time
	private void updateTime() {
		Calendar cal = Calendar.getInstance(); 
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		
		txtTime.setText(sdf.format(cal.getTime()));
		
		Log.i(TAG, "Current Time: " + txtTime.getText());
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem arg0) {
		int id = arg0.getItemId();
		switch(id) {
		case android.R.id.home:
			// '<' was pressed
			finish();
			return true;
		}
		
		return false;
	}
	
	@Override
	public void onBackPressed() {
		// close if back button (hardware) is pressed
		finish();
	}
}
