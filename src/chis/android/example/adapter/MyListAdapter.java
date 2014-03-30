package chis.android.example.adapter;

import java.util.List;

import com.example.test2.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MyListAdapter extends ArrayAdapter{
	
	private Context c;
	private List<String> l;

	public MyListAdapter(Context context, int textViewResourceId , List<String> list ) {
		super(context, textViewResourceId, list);
		print("new MyListAdapter");

		c = context;
		l = list;
	}
	
	@Override
	public View getView(int i, View v, ViewGroup vg) {
		print("getView");
	LayoutInflater	inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		 View vi=v;
	        if(v==null) {
	            vi = inflater.inflate(R.layout.my_list_layout, null);
	            
	            TextView text1 = (TextView) vi.findViewById(R.id.list_text1);
	            text1.setText(l.get(i));
	            
	            
	            
	            TextView text2 = (TextView) vi.findViewById(R.id.list_text2);
	            text2.setText(l.get(i));
	        }
	 
		return vi;
	}
	
	private void print(String message) {
		String cn = this.getClass().getSimpleName();
		Log.d("***" + cn + " ", message);
	}

}
