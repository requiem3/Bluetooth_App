package com.example.bluetooth_app;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class Bluetooth {
	private BluetoothAdapter mBluetoothAdapter;
	private Activity activity; //Activity to store main window's activity
	private ArrayAdapter<String> arrayDeviceAdap; //Array adapter for storing discovered devices
	private IntentFilter filter; //Filter for catching bluetooth device actions
	private Button sButton; //Scan button
    
	/**
	 * default constructor, basic initializations
	 */
	public Bluetooth(Activity activity) {
		this.activity = activity; //Set class activity to the activity passed to it by the main activity window
		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		
		sButton = (Button) activity.findViewById(R.id.scanButton); //sButton = scan button
		sButton.setOnClickListener(new View.OnClickListener() { //Listener to check if button is pressed
			public void onClick(View v) { //If button is pressed start discovering and hide button
				startDiscovering();
				sButton.setVisibility(4); //Make button invisible
			}
		});
	}
	
	/**
	 * Check if bluetooth is enabled, if not enable it
	 */
	public boolean getAdapter() {
		if (!mBluetoothAdapter.isEnabled()) {
		    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
		    activity.startActivityForResult(enableBtIntent, 1);
		}
		//TODO: check if enable was successful
		return true;
	}
	
	/**
	 * Check if device is bluetooth compatible
	 */
	public boolean isCompat() {
		if(mBluetoothAdapter == null) {
			return false; //TODO: better error handling
		} else {
			return true;
		}
	}
	
	/**
	 * Close some shit so we do not eat up resources
	 */
	public void destroy() { 
		if(mBluetoothAdapter != null) {
			mBluetoothAdapter.cancelDiscovery(); //cancel discovering devices
		}
	}
	
	/**
	 * Start discovering devices with bluetooth adapter
	 */
	public void startDiscovering() {
		if(mBluetoothAdapter.isDiscovering()) {
			mBluetoothAdapter.cancelDiscovery();
		}
		
		mBluetoothAdapter.startDiscovery();
	}
	
}
