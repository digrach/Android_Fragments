package chis.android.example.modelproject.datasources;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;
import chis.android.example.controller.WidgetController;

public class MyDataSourceManager {
	
	private WidgetController widgetController;
	
	public MyDataSourceManager() {
		print("new MyDataSourceManager");

		initControllers();
	}
	
	private void initControllers() {
		print("initControllers");

		widgetController = new WidgetController();
	}
	
	public WidgetController getWidgetController() {
		print("getWidgetController");

		return widgetController;
	}
	
	private void print(String message) {
		String cn = this.getClass().getSimpleName();
		Log.d("***" + cn + " ", message);
	}

	

}
