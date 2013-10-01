package ch.hsr.appquest.quickdemo;

import ch.hsr.appquest.quickdemo.ui.FrameLayoutActivity;
import ch.hsr.appquest.quickdemo.ui.MessageTypeActivity;
import ch.hsr.appquest.quickdemo.ui.SettingsActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final Button btnFrameLayout = (Button)findViewById(R.id.btn_frame_layout);
        btnFrameLayout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// this is how you go from one activity to another
				// do not forget to add the the Activity definition in AndroidManifest.xml 
				Intent intent = new Intent(MainActivity.this, FrameLayoutActivity.class);
				startActivity(intent);
			}
		});
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	// check pressed item
    	switch(item.getItemId()) {
    	case R.id.action_settings:
    		Intent intent = new Intent(this, SettingsActivity.class);
    		startActivity(intent);
    		return true;
    	}
    	
    	return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void clickMessage(View view) {
    	Intent intent = new Intent(this, MessageTypeActivity.class);
		startActivity(intent);
    }
    
}
