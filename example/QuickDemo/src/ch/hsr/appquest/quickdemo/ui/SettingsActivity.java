package ch.hsr.appquest.quickdemo.ui;

import java.util.List;

import ch.hsr.appquest.quickdemo.R;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.MenuItem;
// make sure that every new activity is defined in the AndroidManifest.xml
public class SettingsActivity extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// set '<' in action bar
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}
	
	
	@Override
	protected void onStart() {
		super.onStart();
	}
	
	@Override
	public void onBuildHeaders(List<Header> target) {
		loadHeadersFromResource(R.xml.pref_headers, target);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem arg0) {
		int id = arg0.getItemId();
		switch(id) {
		case android.R.id.home:
			finish();
			return true;
		}
		
		return false;
	}
	
	@Override
	public void onBackPressed() {
		finish();
	}
	
}