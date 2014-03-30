package chis.android.example.vos;

import android.util.Log;

public class Widget {
	
	private String name;
	
	public Widget() {
		print("new Widget");
	}
	
	public Widget(String name) {
		print("new Widget with name");
		setName(name);
	}

	public String getName() {
		print("getName");

		return name;
	}

	public void setName(String name) {
		print("setName");

		this.name = name;
	}
	
	private void print(String message) {
		String cn = this.getClass().getSimpleName();
		Log.d("***" + cn + " ", message);
	}
	
	

}
