package com.example.easylistenerspan;

import com.example.easylistenerspan.EasySpan.EasySpanListener;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView test = (TextView) findViewById(R.id.test);
        String text = "这个是用来测试的，TextView的跑马灯效果，想要监听他的跑完的事件用的。" ;
        SpannableString spannableString = new SpannableString(text);
        EasySpan easySpan  =new EasySpan(MainActivity.this,test);
        easySpan.setDuration(10000);
        easySpan.setEasySpanListener(new EasySpanListener() {
			@Override
			public void over() {
				Log.i("Test", "over") ;
			}
		});
        spannableString.setSpan(easySpan, 0, text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        test.setText(spannableString);
        
    }

}
