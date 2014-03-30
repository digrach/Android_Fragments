package com.example.test2;

import java.util.Observable;
import java.util.Observer;

import chis.android.example.app.ModelProject;
import chis.android.example.controller.WidgetController;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Build;

public class WidgetActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_widget);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.widget, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment implements Observer {
		
		private ModelProject a;
		private WidgetController widgetController;

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_widget,
					container, false);
			
			TextView tv = (TextView)rootView.findViewById(R.id.namelabel);
			tv.setText(getActivity().getIntent().getExtras().getString("name"));
			
			EditText et = (EditText)rootView.findViewById(R.id.editnametext);
			et.setText(getActivity().getIntent().getExtras().getString("name"));
			
			return rootView;
		}

		@Override
		public void update(Observable observable, Object data) {
			// TODO Auto-generated method stub
			
		}
	}

}
