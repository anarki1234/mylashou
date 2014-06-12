package adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

public class GuideAdapter extends PagerAdapter {

	private List<View> mList;

	public GuideAdapter(List<View> mList) {
		this.mList = mList;
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg){
		return arg0 == arg;
	}

	/**
	 * 将图片从pager中移除
	 */
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		((ViewPager)container).removeView(mList.get(position));
	}

	/**
	 * 增加图片到pager中 并返回这张图片
	 */
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		((ViewPager)container).addView(mList.get(position));
		return mList.get(position);
	}
}
