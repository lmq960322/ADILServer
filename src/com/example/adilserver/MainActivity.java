package com.example.adilserver;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
  
	private Button getData;
	private EditText name,author;
	private Song songBinder;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getData=(Button)findViewById(R.id.getData);
		name=(EditText)findViewById(R.id.name);
		author=(EditText)findViewById(R.id.author);
		final.setAction("iet.jxufe.cn.android.ADILServer");
		bindService(intent,conn,Service.BIND_AUTO_CREATE);
		getData.setOnClickListener(new setOnClickListener(){
			public void onClick(View v){
				try{
					name.setText(songBidner.getName());
					author.setText(songBinder.getAutor());
					}catch(Exception ex){
						ex.printStackTrace();+
					}
			}
		});
	}
  private ServiceConnection conn=new ServiceConnection(){
	  public void onServiceDisconnected(ComponentName name){
		  songBinder=null;
	  }
	  public void onServiceConnected(ComponentName name,IBinder service)
  {
		  songBinder=song.stub.asInterface(service);
		  
  }
	  
  };
  protected void odDestroy(){
	  super.onDestroy();
	  unbindService(conn);
  };

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
