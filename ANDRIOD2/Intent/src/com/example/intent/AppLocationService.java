package com.example.intent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;


public class AppLocationService extends Service implements LocationListener  {
	
	 protected LocationManager locationManager;
	    Location location;

	    private static final long MIN_DISTANCE_FOR_UPDATE = 10;
	    private static final long MIN_TIME_FOR_UPDATE = 1000 * 60 * 2;

	    public AppLocationService(Context context) {
	        locationManager = (LocationManager) context
	                .getSystemService(LOCATION_SERVICE);
	    }

	    public Location getLocation() {
	    	
	    	try{
	        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
	            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
	                    MIN_TIME_FOR_UPDATE, MIN_DISTANCE_FOR_UPDATE, this);
	            if (locationManager != null) {
	                location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
	                return location;
	            }
	        }
	        else if(locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER))
	        {
	        	locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
	                    MIN_TIME_FOR_UPDATE, MIN_DISTANCE_FOR_UPDATE, this);
	            if (locationManager != null) {
	                location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
	                return location;
	            }
	            
	        }
	        else{
	        	Toast.makeText(getApplicationContext(), "provider is not enabled", Toast.LENGTH_LONG).show();
	        }
	    	}
	    	catch(Exception e)
	    	{
	    		Toast.makeText(getApplicationContext(), "exception occured in applocation service", Toast.LENGTH_LONG).show();
	    	}
	    	
	    	return null;
}


@Override
public void onLocationChanged(Location location) {
}

@Override
public void onProviderDisabled(String provider) {
}

@Override
public void onProviderEnabled(String provider) {
}

@Override
public void onStatusChanged(String provider, int status, Bundle extras) {
}

@Override
public IBinder onBind(Intent arg0) {
    return null;
}
}
