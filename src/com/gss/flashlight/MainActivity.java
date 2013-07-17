package com.gss.flashlight;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {
	private utils mUtils = utils.GetInstance();
	private Drawable mBtnDrawable_on;
	private Drawable mBtnDrawable_off;
	private Paint mPaint;
	private FlashLightView mFlashLightView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mFlashLightView = (FlashLightView)findViewById(R.id.flashlightview);
		
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		 int width = dm.widthPixels;
		 int height = dm.heightPixels;
		 
		 // 绝对布局,计算button 位置
		AbsoluteLayout layout = new AbsoluteLayout(this);
		AbsoluteLayout.LayoutParams params = new AbsoluteLayout.LayoutParams(
				AbsoluteLayout.LayoutParams.WRAP_CONTENT,
				AbsoluteLayout.LayoutParams.WRAP_CONTENT, 
				width*4/9 - width/35, height*7/11);
		
		Button btn = new Button(this);
		btn.setOnClickListener(this);
		
		mBtnDrawable_on = getResources().getDrawable(R.drawable.btn_led_on);
		mBtnDrawable_off = getResources().getDrawable(R.drawable.btn_led_off);
		btn.setBackground(mUtils.FlashLight_getStatus()?mBtnDrawable_on:mBtnDrawable_off);
		layout.addView(btn, params);
		this.addContentView(layout, new AbsoluteLayout.LayoutParams(width, height, 0, 0));
		btn.setBackground(mUtils.FlashLight_getStatus()?mBtnDrawable_on:mBtnDrawable_off);
	}

	@Override
	public void onClick(View v) {
		mUtils.FlashLight_opt(!mUtils.FlashLight_getStatus());
		v.setBackground(mUtils.FlashLight_getStatus()?mBtnDrawable_on:mBtnDrawable_off);
		mFlashLightView.invalidate();
	}
}
