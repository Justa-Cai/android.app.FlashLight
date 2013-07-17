package com.gss.flashlight;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;

public class FlashLightView extends View {
	private Bitmap mBitmap_Light;
	private Bitmap mBitmap_Body;
	private Bitmap mBitmap_Led_on;
	private Bitmap mBitmap_Led_off;
	private Paint mPaint;
	private utils mUtils = utils.GetInstance();

	public FlashLightView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mPaint = new Paint();
		mBitmap_Body = BitmapFactory.decodeResource(this.getResources(), R.drawable.flashlight_led_body_bg);
		mBitmap_Light = BitmapFactory.decodeResource(this.getResources(), R.drawable.flashlight_light);
	//	mBitmap_Led_on = BitmapFactory.decodeResource(this.getResources(), R.drawable.btn_led_on);
	//	mBitmap_Led_off = BitmapFactory.decodeResource(this.getResources(), R.drawable.btn_led_off);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		mUtils.Logx("OnDraw...");
		mPaint.setAntiAlias(true); // ´ò¿ª¿¹¾â³Ý
		mPaint.setColor(Color.WHITE);
		mPaint.setTextSize(80);
		//canvas.drawText("test", 50, 50, mPaint);
		if (mUtils.FlashLight_getStatus())
			canvas.drawBitmap(mBitmap_Light, 0, 0, mPaint);
		canvas.drawBitmap(mBitmap_Body, 0, 0, mPaint);
		//canvas.drawBitmap(mBitmap_Led_off, 0, 0, mPaint);
	}
}
