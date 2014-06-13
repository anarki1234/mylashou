package com.cc.mylashou.fragment;

import com.cc.mylashou.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MineFragment extends Fragment{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.frag_my, null);
		return view;
	}
	
	/**
	 * 防止fragment叠层现象
	 */
	@Override
	public void setMenuVisibility(boolean menuVisible) {
		super.setMenuVisibility(menuVisible);
		if(this.getView()!=null){
			this.getView().setVisibility(menuVisible?View.VISIBLE:View.GONE);
		}
	}
}
