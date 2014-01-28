package com.example.luminious;

import java.io.IOException;

import android.media.Image;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	ImageView image;
	boolean flashON=false;
	
	Camera camera = Camera.open();
	Parameters p = camera.getParameters();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		image = (ImageView) findViewById(R.id.flashlight_off);
		image.setOnClickListener(imgButtonHandler);
	
	}
	
	ImageView.OnClickListener imgButtonHandler = new ImageView.OnClickListener(){
		
		public void onClick(View v){
			
			if(flashON == false){
				image.setBackgroundResource(R.drawable.flashlight_on);
				
				p.setFlashMode(Parameters.FLASH_MODE_TORCH);
				camera.setParameters(p);
				camera.startPreview();
				flashON = true;
			}
			else{
				image.setBackgroundResource(R.drawable.flashlight_off);
				
				p.setFlashMode(Parameters.FLASH_MODE_OFF);
				camera.setParameters(p);
				camera.stopPreview();
				flashON = false;
			}
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);	;
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		//Handle presses on the action bar items
		switch(item.getItemId()) {
		
		case R.id.action_overflow:
			//openOverflow();
			return true;
		
		case R.id.action_settings:
			//openSettings();
			return true;
			
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	

}
