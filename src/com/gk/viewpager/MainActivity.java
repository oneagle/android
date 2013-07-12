package com.gk.viewpager;

import myView.MyScrollLayout;
import myView.OnViewChangeListener;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements OnViewChangeListener{
	private MyScrollLayout view_pager;
	private LinearLayout view_controll;
	private ImageView[] imgs;
	int count;
	int currItem;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		view_pager = (MyScrollLayout)findViewById(R.id.view_pager);
		view_controll = (LinearLayout)findViewById(R.id.view_controll);
		count = view_pager.getChildCount();
		imgs = new ImageView[count];
		for(int i = 0; i< count;i++) {
			imgs[i] = (ImageView) view_controll.getChildAt(i);
			imgs[i].setEnabled(true);
			imgs[i].setTag(i);
		}
		currItem = 0;
		imgs[currItem].setEnabled(false);
		view_pager.SetOnViewChangeListener(this);
	}

	@Override
	public void OnViewChange(int view) {
		// TODO Auto-generated method stub
		setcurrentPoint(view);
	}

	private void setcurrentPoint(int position) {
		// TODO Auto-generated method stub
		if(position < 0 || position > count -1 || currItem == position) {
			return;
		}
		imgs[currItem].setEnabled(true);
		imgs[position].setEnabled(false);
		currItem = position;
	}

}
