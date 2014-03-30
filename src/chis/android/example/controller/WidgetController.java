package chis.android.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import android.util.Log;
import chis.android.example.vos.Widget;

public class WidgetController extends Observable{
	
	List<Observer> observerList = new ArrayList<Observer>();
	
	List<Widget> widgetList;
	
	public WidgetController() {
		print("new WidgetController");

		intitWidgetList();
	}
	
	@Override
	public void notifyObservers() {
		print("notifyObservers");

		synchronized (observerList) {
			for (Observer o : observerList) {
				o.update(this, "Widget");
			}
		}
	}
	
	@Override
	public void addObserver(Observer o) {
		print("addObserver");

		synchronized (observerList) {
			observerList.add(o);
		}
	}
	
	@Override
	public void deleteObserver(Observer o) {
		print("deleteObserver");

		synchronized (observerList) {
			observerList.remove(o);
		}
	}
	
	private void intitWidgetList() {
		print("intitWidgetList");

		widgetList = new ArrayList<Widget>();
		
		Widget w1 = new Widget();
		w1.setName("Widget 1");
		widgetList.add(w1);
		
		Widget w2 = new Widget();
		w2.setName("Widget 2");
		widgetList.add(w2);
		
		Widget w3 = new Widget();
		w3.setName("Widget 3");
		widgetList.add(w3);
	}
	
	public List<String> getWidgetNames() {
		print("getWidgetNames");

		List<String> nList = new ArrayList<String>();
		for (Widget w : widgetList) {
			nList.add(w.getName());
		}
		return nList;
	}
	
	public void addWidget(Widget w) {
		print("addWidget");

		widgetList.add(w);
		notifyObservers();
	}
	
	private void print(String message) {
		String cn = this.getClass().getSimpleName();
		Log.d("***" + cn + " ", message);
	}

}
