package com.example.bluetooth_app;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;

public class Bluetooth {
	private BluetoothAdapter mBluetoothAdapter;
	
	public Bluetooth() { //default constructor, initializes default bluetooth adapter.
		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
	}
	
	public boolean getAdapter() { //Check if bluetooth is enabled, if not enable it
		if (!mBluetoothAdapter.isEnabled()) {
		    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
		    //TODO: startactivity so it enables bluetooth
//		    startActivityForResult(enableBtIntent, 1);
		}
		
		return true;
	}
	
	public boolean isCompat() { //Check if device is bluetooth compatible
		if(mBluetoothAdapter == null) {
			return false; //TODO: better error handling
		} else {
			return true;
		}
	}
	
}
