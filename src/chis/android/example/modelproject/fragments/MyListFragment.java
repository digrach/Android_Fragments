package chis.android.example.modelproject.fragments;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import chis.android.example.adapter.MyListAdapter;
import chis.android.example.app.ModelProject;
import chis.android.example.controller.WidgetController;
import chis.android.example.vos.Widget;

import com.example.test2.R;
import com.example.test2.WidgetActivity;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MyListFragment extends Fragment implements Observer{

	private ModelProject a;
	private WidgetController widgetController;
	private List<String> widgetNameList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		print("onCreate");

		a = (ModelProject) this.getActivity().getApplication();
		widgetController = a.getDataSourceManager().getWidgetController();
		widgetController.addObserver(this);
		refreshWidgetNames();

		// retain this fragment
		setRetainInstance(true);
	}


	private void refreshWidgetNames() {
		print("refreshWidgetNames");

		widgetNameList = widgetController.getWidgetNames();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		print("onCreateView");

		View view = inflater.inflate(R.layout.list_fragment,
				container, false);
		return view;
	}

	@Override
	public void onStart() {
		print("onStart");

		super.onStart();
		bindList();
	}

	public void bindList() {
		print("bindList");

		if (this.getView() != null) {
			print("bindList: View not null");
		} else {
			print("bindList: View NULL");
		}

		ListView l = (ListView)this.getView().findViewById(R.id.string_list);
		l.setOnItemClickListener(new AdapterView.OnItemClickListener() {

//			public void onItemClick(AdapterView<?> av, View view, int i, long l) {
//				print("bindList: onItemClick");
//				Toast.makeText(getActivity(), "myPos "+i, Toast.LENGTH_LONG).show();
//				widgetController.addWidget(new Widget("click widget"));
//			}
			
			public void onItemClick(AdapterView<?> av, View view, int i, long l) {
				print("bindList: onItemClick");
				
				String selected = ((TextView) view.findViewById(R.id.list_text1)).getText().toString();

				
				Intent intent = new Intent(view.getContext(),WidgetActivity.class);
				intent.putExtra("name", selected);
				startActivity(intent);
			}
			
		});
		// The layout being passed is basically overwritten in the adapter
		l.setAdapter(new MyListAdapter(getActivity(), android.R.layout.simple_list_item_1, widgetNameList));
	}

	@Override
	public void update(Observable observable, Object data) {
		print("update");
		if(data.equals("Widget")) {
			refreshWidgetNames();
			bindList();
		}

	}

	private void print(String message) {
		String cn = this.getClass().getSimpleName();
		Log.d("***" + cn + " ", message);
	}





}
