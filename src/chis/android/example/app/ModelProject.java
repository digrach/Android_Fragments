package chis.android.example.app;

import android.app.Application;
import android.util.Log;
import chis.android.example.modelproject.datasources.MyDataSourceManager;

public class ModelProject extends Application{

	private MyDataSourceManager dsManager;
	
	public ModelProject() {
		print("new ModelProject");
		
		intiDataSourceManager();
	}
	
	private void intiDataSourceManager() {
		print("intiDataSourceManager");

		dsManager = new MyDataSourceManager();
	}

	public MyDataSourceManager getDataSourceManager() {
		print("MyDataSourceManager");

		return dsManager;
	}
	
	private void print(String message) {
		String cn = this.getClass().getSimpleName();
		Log.d("***" + cn + " ", message);
	}
	
	

}
