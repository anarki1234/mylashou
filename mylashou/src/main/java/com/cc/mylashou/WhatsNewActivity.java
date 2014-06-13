package com.cc.mylashou;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.cc.mylashou.adapter.GuideAdapter;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class WhatsNewActivity extends Activity {
	
	@ViewInject(R.id.start_btn) Button btnStart;
	@ViewInject(R.id.view_pager) ViewPager pager;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_whats_new);
		//进行注入
		ViewUtils.inject(this);
		
		btnStart.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(WhatsNewActivity.this,
						MainActivity.class));
				finish();
			}
		});
		
		//初始化ViewPager
		initViewPager();
	}
	
	private void initViewPager(){
		List<View> list = new ArrayList<>();
		ImageView img1 = new ImageView(this);
		img1.setImageResource(R.drawable.guide_1);
		ImageView img2 = new ImageView(this);
		img2.setImageResource(R.drawable.guide_2);
		ImageView img3 = new ImageView(this);
		img3.setImageResource(R.drawable.guide_3);
		list.add(img1);
		list.add(img2);
		list.add(img3);
		GuideAdapter mAdapter = new GuideAdapter(list);
		pager.setAdapter(mAdapter);
		pager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				if(position == 2){
					btnStart.setVisibility(View.VISIBLE);
				}else{
					btnStart.setVisibility(View.GONE);
				}
			}
			
			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels) {
			}
			
			@Override
			public void onPageScrollStateChanged(int state) {
			}
		});
	}
}
