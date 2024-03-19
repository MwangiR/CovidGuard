package com.test.blemonitor;

import android.content.IntentSender;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.Identifier;
import org.altbeacon.beacon.MonitorNotifier;
import org.altbeacon.beacon.Region;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class  MainActivity extends AppCompatActivity implements BeaconConsumer {
private final int REQUEST_CHECK_CODE = 8989;
    protected static final String TAG = "MonitoringActivity";
    private BeaconManager beaconManager;
    private TextView beacon1,beacon2,beacon3;
    private String currentTimestamp;
    private FirebaseAuth mAuth;
    private String userId;
    private final ArrayList<String> beaconUUID = new ArrayList<>(
            Arrays.asList("01122334-4556-6778-899a-abbccd299385",
                    "01122334-4556-6778-899a-abbccd29937b",
            "01122334-4556-6778-899a-abbccd299377"));
    Beacon Mybeacon[] = new Beacon[beaconUUID.size()];
    private LocationSettingsRequest.Builder builder;
    FirebaseFirestore rootNode;
    DocumentReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocationRequest request = new LocationRequest()
                .setFastestInterval(1500)
                .setInterval(3000)
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(request);
        Task<LocationSettingsResponse> result =
                LocationServices.getSettingsClient(this).checkLocationSettings(builder.build());

        result.addOnCompleteListener(new OnCompleteListener<LocationSettingsResponse>() {
            @Override
            public void onComplete(@NonNull Task<LocationSettingsResponse> task) {
                try {
                    task.getResult(ApiException.class);
                } catch (ApiException e) {
                    switch (e.getStatusCode()) {
                        case LocationSettingsStatusCodes
                                .RESOLUTION_REQUIRED:
                            try {
                                ResolvableApiException resolvableApiException = (ResolvableApiException) e;
                                resolvableApiException.startResolutionForResult(MainActivity.this, REQUEST_CHECK_CODE);
                            } catch (IntentSender.SendIntentException ex) {
                                ex.printStackTrace();
                            } catch (ClassCastException ex) {

                            }
                            break;
                        case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE: {
                            break;
                        }
                    }
                }
            }
        });


        for(int i=0; i<beaconUUID.size();i++)
        {
            Mybeacon[i] = new Beacon();
        }
        beacon1 = (TextView)findViewById(R.id.beacon1);
        beacon2 = (TextView)findViewById(R.id.beacon2);
        beacon3 = (TextView)findViewById(R.id.beacon3);
        beaconManager = BeaconManager.getInstanceForApplication(this);
        beaconManager.getBeaconParsers().add(new BeaconParser().
                setBeaconLayout("m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24"));
        beaconManager.bind(this);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        beaconManager.unbind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    public void onBeaconServiceConnect() {
        beaconManager.setMonitorNotifier(new MonitorNotifier() {
            @Override
            public void didEnterRegion(Region region) {
                Log.i(TAG, "I just saw an beacon for the first time!");
                switch (region.getUniqueId()){
                    case "Mybeacon1":
                        Mybeacon[0] = new Beacon();
                        Mybeacon[0].setEntryTimestamp(getCurrentTimestamp());
                        beacon1.setText("Beacon 1 Entered Region at: " + getCurrentTimestamp());
                        break;
                    case  "Mybeacon2":
                        Mybeacon[1] = new Beacon();
                        Mybeacon[1].setEntryTimestamp(getCurrentTimestamp());
                        beacon2.setText("Beacon 2 Entered Region at: " + getCurrentTimestamp());
                        break;
                    case "Mybeacon3":
                        Mybeacon[2] = new Beacon();
                        Mybeacon[2].setEntryTimestamp(getCurrentTimestamp());
                        beacon3.setText("Beacon 3 Entered Region at: " + getCurrentTimestamp());
                        break;
                }
            }

            @Override
            public void didExitRegion(Region region) {
                mAuth = FirebaseAuth.getInstance();
                userId = mAuth.getCurrentUser().getUid();
                rootNode = FirebaseFirestore.getInstance();
                reference = rootNode.collection("user").document(userId);
                Log.i(TAG, "I no longer see an beacon");
                switch (region.getUniqueId()){
                    case "Mybeacon1":
                        Mybeacon[0].setExitTimestamp(getCurrentTimestamp());
                        Mybeacon[0].setVenueId(region.getId1().toString());
                        beacon1.setText("Beacon 1 - Entry Timestamp: "+ Mybeacon[0].getEntryTimestamp() +
                                "Exited Timestamp: " + Mybeacon[0].getExitTimestamp() +
                                "VenueId : " + Mybeacon[0].getVenueId());
                        //Helperclass helperClass = new Helperclass(Mybeacon[0].getVenueId(), Mybeacon[0].getEntryTimestamp(), Mybeacon[0].getExitTimestamp());
                        //reference.child(Mybeacon[0].getEntryTimestamp()).setValue(helperClass);
                        break;
                    case  "Mybeacon2":
                        Mybeacon[1].setExitTimestamp(getCurrentTimestamp());
                        Mybeacon[1].setVenueId(region.getId1().toString());
                        beacon2.setText("Beacon 2 - Entry Timestamp: "+ Mybeacon[1].getEntryTimestamp() +
                                "Exit Timestamp: " + Mybeacon[1].getExitTimestamp() +
                                "VenueId : " + Mybeacon[1].getVenueId());
                        //user.put("UserId",userId);
                        Map<String, Object> user = new HashMap<>();
                        user.put("VenueId",Mybeacon[1].getVenueId());
                        user.put("EntryTime",Mybeacon[1].getEntryTimestamp());
                        user.put("ExitTime",Mybeacon[1].getExitTimestamp());
                        reference.collection(Mybeacon[1].getEntryTimestamp()).add(user);

                        //Helperclass helperClass1 = new Helperclass(Mybeacon[1].getVenueId(), Mybeacon[1].getEntryTimestamp(), Mybeacon[1].getExitTimestamp());
                        //reference.child(Mybeacon[1].getEntryTimestamp()).setValue(helperClass1);
                        break;
                    case "Mybeacon3":
                        Mybeacon[2].setExitTimestamp(getCurrentTimestamp());
                        Mybeacon[2].setVenueId(region.getId1().toString());
                        beacon3.setText("Beacon 3 - Entry Timestamp: "+ Mybeacon[2].getEntryTimestamp() +
                                "Exit Timestamp: " + Mybeacon[2].getExitTimestamp() +
                                "VenueId : " + Mybeacon[2].getVenueId());
                        //Helperclass helperClass2 = new Helperclass(Mybeacon[2].getVenueId(), Mybeacon[2].getEntryTimestamp(), Mybeacon[2].getExitTimestamp());
                        //reference.child(Mybeacon[2].getEntryTimestamp()).setValue(helperClass2);
                        break;
                }
            }

            @Override
            public void didDetermineStateForRegion(int state, Region region) {
                Log.i(TAG, "I have just switched from seeing/not seeing beacons: "+ state);
            }
        });
        try {
           beaconManager.startMonitoringBeaconsInRegion(new Region("Mybeacon1", Identifier.parse(beaconUUID.get(0)),null,null));
           beaconManager.startMonitoringBeaconsInRegion(new Region("Mybeacon2", Identifier.parse(beaconUUID.get(1)),null,null));
           beaconManager.startMonitoringBeaconsInRegion(new Region("Mybeacon3", Identifier.parse(beaconUUID.get(2)),null,null));
        }
        catch (RemoteException e) {
        }
    }

    public String getCurrentTimestamp(){
        Format f = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        currentTimestamp = f.format(new Date());

        return currentTimestamp;
    }
}