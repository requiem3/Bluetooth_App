package com.example.bluetooth_app;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Handler;

public class Chat {
	private Constants constants;
	private BluetoothAdapter mBluetoothAdapter; 
	private int state; //Current state of the class(none, listening, connected, or connecting)
	private final Handler chatHandle; //Handle to the chat

	
	/**
	 * Initialize Chat object with the state of the chat set to none, and the handle equal to the handle we passed it, also get the default
	 * bluetooth adapter that we need for everything
	 * @param context
	 * @param handler
	 */
	public Chat(Context context, Handler handler) {
		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		state = constants.SNONE; //Current state is nothing, just initialized, derp
		chatHandle = handler; 
	}
	
	public int getState() { //Return the current state of the chat object
		return state;
	}
}
