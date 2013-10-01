package ch.hsr.appquest.quickdemo.ui.frag;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceFragment;

public class SettingsFragment extends PreferenceFragment {
	
	public static final String ARG_PREF_RESOUCE = "pref-resource";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Context context = getActivity();
		// get the xml to show
		int res = context.getResources().getIdentifier(
				getArguments().getString(ARG_PREF_RESOUCE), "xml", context.getPackageName()
				);

		addPreferencesFromResource(res);
	}
}
