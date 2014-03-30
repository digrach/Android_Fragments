package chis.android.example.modelproject;

import chis.android.example.modelproject.fragments.MyListFragment;

import com.example.test2.R;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends Activity {
	
	private MyListFragment mlf;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		print("onCreate");

		setContentView(R.layout.activity_main);
		
		// find the retained fragment on activity restarts
        FragmentManager fm = getFragmentManager();
        mlf = (MyListFragment) fm.findFragmentByTag("widgetListFrag");

        // create the fragment and data the first time
        if (mlf == null) {
            // add the fragment
        	mlf = new MyListFragment();
            fm.beginTransaction().add(mlf, "widgetListFrag").commit();
        }
		
//		MyListFragment detailFragment = (MyListFragment) getFragmentManager()
//				.findFragmentById(R.id.listFragment);

//		if (savedInstanceState == null) {
//			getFragmentManager().beginTransaction()
//					.add(R.id.container, new PlaceholderFragment()).commit();
//		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		print("onCreateOptionsMenu");

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		print("onOptionsItemSelected");
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
//	public static class PlaceholderFragment extends Fragment {
//
//		public PlaceholderFragment() {
//		}
//
//		@Override
//		public View onCreateView(LayoutInflater inflater, ViewGroup container,
//				Bundle savedInstanceState) {
//			View rootView = inflater.inflate(R.layout.fragment_main, container,
//					false);
//			return rootView;
//		}
//	}
	
	private void print(String message) {
		String cn = this.getClass().getSimpleName();
		Log.d("***" + cn + " ", message);
	}

}
