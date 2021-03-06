package com.hermit.btreprap;

import com.hermit.btreprap.R;
import com.hermit.btreprap.service.RepRapConnectionService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class ManualActivity extends Activity {

    private Messenger mServiceMessenger;
    
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.print_layout);
        mServiceMessenger = getIntent().getParcelableExtra("Messenger");
        
        final Button buttonGoX = (Button) findViewById(R.id.buttonGoX);
        final EditText textPositionX = (EditText) findViewById(R.id.textPositionX);
        buttonGoX.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Message msg = Message.obtain(null,
                        RepRapConnectionService.MSG_COMMAND);
                msg.obj = "G1 X" + textPositionX.getText().toString() + " F10000";
                try {
        			mServiceMessenger.send(msg);
        		} catch (RemoteException e) {
        		}
            }
        });
        
        final Button button0X = (Button) findViewById(R.id.button0X);
        button0X.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Message msg = Message.obtain(null,
                        RepRapConnectionService.MSG_COMMAND);
                msg.obj = "G92 X0";
                try {
        			mServiceMessenger.send(msg);
        		} catch (RemoteException e) {
        		}
            }
        });
        
        final Button buttonHomeX = (Button) findViewById(R.id.buttonHomeX);
        buttonHomeX.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Message msg = Message.obtain(null,
                        RepRapConnectionService.MSG_COMMAND);
                msg.obj = "G28 X";
                try {
        			mServiceMessenger.send(msg);
        		} catch (RemoteException e) {
        		}
            }
        });
        
        final Button buttonGoY = (Button) findViewById(R.id.buttonGoY);
        final EditText textPositionY = (EditText) findViewById(R.id.textPositionY);
        buttonGoY.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Message msg = Message.obtain(null,
                        RepRapConnectionService.MSG_COMMAND);
                msg.obj = "G1 Y" + textPositionY.getText().toString() + " F10000";
                try {
        			mServiceMessenger.send(msg);
        		} catch (RemoteException e) {
        		}
            }
        });
        
        final Button button0Y = (Button) findViewById(R.id.button0Y);
        button0Y.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Message msg = Message.obtain(null,
                        RepRapConnectionService.MSG_COMMAND);
                msg.obj = "G92 Y0";
                try {
        			mServiceMessenger.send(msg);
        		} catch (RemoteException e) {
        		}
            }
        });
        
        final Button buttonHomeY = (Button) findViewById(R.id.buttonHomeY);
        buttonHomeY.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Message msg = Message.obtain(null,
                        RepRapConnectionService.MSG_COMMAND);
                msg.obj = "G28 Y";
                try {
        			mServiceMessenger.send(msg);
        		} catch (RemoteException e) {
        		}
            }
        });
        
        final Button buttonGoZ = (Button) findViewById(R.id.buttonGoZ);
        final EditText textPositionZ = (EditText) findViewById(R.id.textPositionZ);
        buttonGoZ.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Message msg = Message.obtain(null,
                        RepRapConnectionService.MSG_COMMAND);
                msg.obj = "G1 Z" + textPositionZ.getText().toString() + " F10000";
                try {
        			mServiceMessenger.send(msg);
        		} catch (RemoteException e) {
        		}
            }
        });
        
        final Button button0Z = (Button) findViewById(R.id.button0Z);
        button0Z.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Message msg = Message.obtain(null,
                        RepRapConnectionService.MSG_COMMAND);
                msg.obj = "G92 Z0";
                try {
        			mServiceMessenger.send(msg);
        		} catch (RemoteException e) {
        		}
            }
        });
        
        final Button buttonHomeZ = (Button) findViewById(R.id.buttonHomeZ);
        buttonHomeZ.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Message msg = Message.obtain(null,
                        RepRapConnectionService.MSG_COMMAND);
                msg.obj = "G28 Z";
                try {
        			mServiceMessenger.send(msg);
        		} catch (RemoteException e) {
        		}
            }
        });
        
        final Button buttonSetTemp = (Button) findViewById(R.id.buttonSetTemp);
        final EditText textTemp = (EditText) findViewById(R.id.textTemp);
        buttonSetTemp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Message msg = Message.obtain(null,
                        RepRapConnectionService.MSG_COMMAND);
            	msg.obj = "M104 S" + textTemp.getText().toString();
                try {
        			mServiceMessenger.send(msg);
        		} catch (RemoteException e) {
        		}
            }
        });
        
        final Button buttonSetBedTemp = (Button) findViewById(R.id.buttonSetBedTemp);
        final EditText textBedTemp = (EditText) findViewById(R.id.textBedTemp);
        buttonSetBedTemp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Message msg = Message.obtain(null,
                        RepRapConnectionService.MSG_COMMAND);
            	msg.obj = "M140 S" + textBedTemp.getText().toString();
                try {
        			mServiceMessenger.send(msg);
        		} catch (RemoteException e) {
        		}
            }
        });
        
        final ToggleButton buttonFanToggle = (ToggleButton) findViewById(R.id.buttonFanToggle);
        buttonFanToggle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Message msg = Message.obtain(null,
                        RepRapConnectionService.MSG_COMMAND);
            	if(buttonFanToggle.isChecked())
            	{
            		msg.obj = "M106";
            	}
            	else
            	{
            		msg.obj = "M107";
            	}
                try {
        			mServiceMessenger.send(msg);
        		} catch (RemoteException e) {
        		}
            }
        });
        
        final Button buttonFiles = (Button) findViewById(R.id.buttonFiles);
        final Intent intent = new Intent().setClass(this, SDFiles.class);
        buttonFiles.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	startActivity(intent);
            }
        });
        
        final Button buttonUpload = (Button) findViewById(R.id.buttonUpload);
        final Intent intentUpload = new Intent().setClass(this, LocalFilesActivity.class);
        buttonUpload.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	startActivity(intentUpload);
            }
        });
    }
	
}
