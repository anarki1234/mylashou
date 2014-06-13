package com.cc.mylashou;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.cc.mylashou.fragment.IndexFragment;
import com.cc.mylashou.fragment.MineFragment;
import com.cc.mylashou.fragment.MoreFragment;
import com.cc.mylashou.fragment.NearbyFragment;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnRadioGroupCheckedChange;

public class MainActivity extends FragmentActivity {

	@ViewInject(R.id.bottom_bar)
	private RadioGroup bottom_bar;
	@ViewInject(R.id.layout_content)
	private FrameLayout layout_content;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ViewUtils.inject(this);
		
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		bottom_bar.check(R.id.radio0);
	}

	@OnRadioGroupCheckedChange({R.id.bottom_bar})
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		int index = 0;
		switch (checkedId) {
		case R.id.radio0:
			index = 0;
			break;
		case R.id.radio1:
			index = 1;
			break;
		case R.id.radio2:
			index = 2;
			break;
		case R.id.radio3:
			index = 3;
			break;
		default:
			index = 0;
		}
		Fragment fragment=(Fragment) fragments.instantiateItem(layout_content, index);
		//设置显示的fragment
		fragments.setPrimaryItem(layout_content, 0,fragment);
		fragments.finishUpdate(layout_content);
	}

	final int FRAGMENT_SIZE = 4;
	FragmentStatePagerAdapter fragments = new FragmentStatePagerAdapter(
			getSupportFragmentManager()) {
		@Override
		public int getCount() {
			return FRAGMENT_SIZE;
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragment;
			switch (position) {
			case 0: // 首页
				fragment = new IndexFragment();
				break;
			case 1: // 附件
				fragment = new NearbyFragment();
				break;
			case 2: // 我的
				fragment = new MineFragment();
				break;
			case 3: // 更多
				fragment = new MoreFragment();
				break;
			default:
				fragment = new IndexFragment();
			}
			return fragment;
		}
	};

}
