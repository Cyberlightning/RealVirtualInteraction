
package com.cyberlightning.android.coap.service;

import java.util.ArrayList;
import java.util.UUID;




import com.cyberlightning.android.coapclient.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;



public class MainActivity extends Activity implements DialogInterface.OnClickListener {
   
    private boolean isBound = false;
	private boolean isExitDialog = false;
	private boolean hasServiceStopped = false;
	
	
	
	private ArrayList<String> channels;

	
	private Messenger messengerService = null;
	private int retryCount = 0;
	public int currentIndex = 0;
	public int currentPointer = 0;
	public int saveableId;
	
	

	
	final int NOTIFICATION_DELAY = 12000;
	

    final Messenger mMessenger = new Messenger(new IncomingHandler()); //Based on code by Lance Lefebure : http://stackoverflow.com/questions/4300291/example-communication-between-activity-and-service-using-messaging
	 
	private ServiceConnection serviceConnection = new ServiceConnection() { 
		
		public void onServiceConnected(ComponentName className, IBinder service) {
	        	
			messengerService= new Messenger(service);
	            
			try {
	                Message msg = Message.obtain(null, ConnectionService.MSG_REGISTER_CLIENT);
	                msg.replyTo = mMessenger;
	                messengerService.send(msg);
	               
	        } catch (RemoteException e) {
	        
	        }
	        
		}

	    public void onServiceDisconnected(ComponentName className) {
	        messengerService = null;
	    }
	}; //End of quote


   
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //setContentView(R.layout.main);
        //this.getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);
      
        this.initNetworkConnection();

    }
    
    @Override
    public void onPause() { 
    	super.onPause();
    }
  
    @Override
    public void onBackPressed() {
    	this.showExitDialog();
    }
  
    @Override
    protected void onDestroy() {
    	super.onDestroy(); 
    	Debug.stopMethodTracing();
    }
    
 
    
    private void initNetworkConnection() { //setup network connection listener
    	
    	ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    	boolean hasInternet = false;
    	NetworkInfo[] netInfo = connectivityManager.getAllNetworkInfo();
    	
    	for (NetworkInfo ni : netInfo) { 
            if (ni.getTypeName().equalsIgnoreCase("WIFI")) {
            	if (ni.isConnected()) hasInternet = true;       	
            }
                
            if (ni.getTypeName().equalsIgnoreCase("MOBILE")) {
            	if (ni.isConnected()) hasInternet = true;	
            }  
    	}
    	
    	if (hasInternet == false) {
    		
    		//Toast.makeText(this, R.string.main_no_connection_notification, this.NOTIFICATION_DELAY); //maybe create a dialog here
    		Intent myIntent = new Intent( Settings.ACTION_WIFI_SETTINGS); 
    		startActivity(myIntent);
    		this.finish();
    		
    	} else {
    		if(!ConnectionService.isRunning()) {
    			startService(new Intent(MainActivity.this, ConnectionService.class));
        		this.doBindService();
    		} else {
    			this.doBindService();
    			((NotificationManager)getSystemService(NOTIFICATION_SERVICE)).cancelAll();
    			 Notification notification = new Notification(R.drawable.ic_launcher, "getText(R.string.connection_service_started_notification)",System.currentTimeMillis());
    		     PendingIntent contentIntent = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);
    			 notification.setLatestEventInfo(this, "getText(R.string.connection_service_label)", "getText(R.string.connection_service_started_notification)", contentIntent);
    			 ((NotificationManager)getSystemService(NOTIFICATION_SERVICE)).notify(ConnectionService.getNotificationId(), notification);
    		   
    		}
    		
	
    	}
	
    }

    
    private int generateId() {
    	return UUID.randomUUID().hashCode();
    }
    
    public void prepareMessage(int type, int value1, int value2){
    	this.sendMessageToService(type, value1, value2);
    }
    
   
    
    private void exitApplication() {
    	this.finish();
    }

   
    
    private void showExitDialog() { 
    	
    	this.isExitDialog = true;
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	if(this.hasServiceStopped) {
    		builder.setMessage(getString(R.string.dialog_exit_program_notification_no_service));
    		
    	} else {
    	
        	builder.setNeutralButton(R.string.dialog_no_button, this);
    		builder.setMessage(getString(R.string.dialog_exit_program_notification));
    	}

    	builder.setCancelable(false);
    	builder.setPositiveButton(getString(R.string.dialog_cancel_button),this);
    	builder.setNegativeButton(getString(R.string.dialog_yes_button),this); 
    	builder.setTitle(R.string.dialog_title_exit);
    	AlertDialog alert = builder.create();
    	alert.show();
    }
    
  private void showConnectionDialog() { 
    	
	  
    	this.isExitDialog = false;
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setMessage(getString(R.string.connection_service_server_down_message));
    	builder.setCancelable(false);
    	builder.setPositiveButton(getString(R.string.dialog_ok_button),this);
    	builder.setTitle(R.string.connection_error);
    	AlertDialog alert = builder.create();
    	alert.show();
    }
    
    
    private void sendMessageToService(int type, int value1, int value2) {
        
    	if (this.isBound && this.messengerService != null) {
   
    		try {
    			
    			Message msg;
    			if(type == ConnectionService.FREQUENCY_CHANGE) {
    				msg = Message.obtain(null, ConnectionService.FREQUENCY_CHANGE, value1, 0);
    			} else if (type == ConnectionService.ACTIVITY_STATUS) {
    				msg = Message.obtain(null, ConnectionService.ACTIVITY_STATUS, value1, value2);
    			} else {
    				msg = Message.obtain(null, ConnectionService.MESSAGE_SEND, value1, value2);
    			}
    			
                msg.replyTo = mMessenger;
                this.messengerService.send(msg);
                
    		} catch (RemoteException e) {
                //Binder invocation error
    		}  
        }
    }
    
    private void doBindService() { //Method based on code by Lance Lefebure : http://stackoverflow.com/questions/4300291/example-communication-between-activity-and-service-using-messaging
        bindService(new Intent(this, ConnectionService.class), serviceConnection, Context.BIND_AUTO_CREATE);
        this.isBound = true;
      
    }
    
    private void doUnbindService() { //Method based on code by Lance Lefebure : http://stackoverflow.com/questions/4300291/example-communication-between-activity-and-service-using-messaging

    	if (this.isBound) {

        	if (this.messengerService != null) {
                try {
                    Message msg = Message.obtain(null, ConnectionService.MSG_UNREGISTER_CLIENT);
                    msg.replyTo = mMessenger;
                    this.messengerService.send(msg);
                } catch (RemoteException e) {
                    // There is nothing special we need to do if the service has crashed.
                }
            }
            
            unbindService(serviceConnection);
            this.isBound = false;
           
        }
    }
    
    
    
   
    
 
 	private void stopService() {
 		this.hasServiceStopped = true;
 		this.doUnbindService();
        stopService(new Intent(MainActivity.this, ConnectionService.class));
 	}
    
 
   class IncomingHandler extends Handler { 
        
		@Override
        public void handleMessage(Message msg) {
            
        	switch (msg.what) {

            case ConnectionService.MESSAGE_RECEIVED:  //remember to make logic that this message is not shown if user has decided to change channel
            	//receiverView.receiveMessageBuffer(msg.getData());
            	break;
            case ConnectionService.FREQUENCY_CHANGE:
            	//receiveNewChannel(msg.arg1);
            	
            	break;
            case ConnectionService.CONNECTION_STATUS:
            		
            	if(msg.arg1 == ConnectionService.NO_REPLY_FROM_SERVER) {
            		stopService();
            		showConnectionDialog();
            	}if(msg.arg1 == ConnectionService.CONNECTION_TIMEOUT) {
            		if (channels.size() > 1 && retryCount < 2) {
            			//prepareMessage(ConnectionService.ACTIVITY_STATUS, ConnectionService.RETRY_CONNECTION, getNextChannel());
            			retryCount++;
            		} else {
            			stopService();
                		showConnectionDialog();
            		}

            	} 
            	
            	break;
            default:
                super.handleMessage(msg);
            }
        }
    }



	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
	}
	

}

