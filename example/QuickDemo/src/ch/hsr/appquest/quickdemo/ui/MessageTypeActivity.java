package ch.hsr.appquest.quickdemo.ui;

import ch.hsr.appquest.quickdemo.R;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MessageTypeActivity extends Activity {

	private Button btnToast, btnAlert;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message_type);
		
		// set '<' in action bar
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		btnToast = (Button)findViewById(R.id.btn_toast);
		btnToast.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
				// Toasts are to be used for Information perposes only
				// that DO NOT effect user's current task
				// e.g. "Phone is now connected to 'Home'"
				
				// get bread ready
				Toast bread = Toast.makeText(MessageTypeActivity.this, "Toast...", Toast.LENGTH_SHORT);
				// toast the bread!
				bread.show();
			}
		});
		
		btnAlert = (Button)findViewById(R.id.btn_alert);
		btnAlert.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						MessageTypeActivity.this);
				
				// set title
				alertDialogBuilder.setTitle("Your Title");
	 
				// set dialog message
				alertDialogBuilder
					.setMessage("Click yes to exit!")
					.setCancelable(false)
					.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// if this button is clicked, 
							// exit the current activity
							MessageTypeActivity.this.finish();
						}
					})
					.setNegativeButton("No",new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int id) {
							// if this button is clicked, just close
							// the dialog box and do nothing
							dialog.cancel();
						}
					});
	 
					// create alert dialog
					AlertDialog alertDialog = alertDialogBuilder.create();
	 
					// show it
					alertDialog.show();
				}
		});
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
