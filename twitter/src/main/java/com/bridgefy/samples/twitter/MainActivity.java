package com.bridgefy.samples.twitter;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorLong;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bridgefy.samples.twitter.entities.Peer;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.client.BridgefyClient;
import com.bridgefy.sdk.client.Device;
import com.bridgefy.sdk.client.Message;
import com.bridgefy.sdk.client.MessageListener;
import com.bridgefy.sdk.client.RegistrationListener;
import com.bridgefy.sdk.client.Session;
import com.bridgefy.sdk.client.StateListener;
import com.bridgefy.sdk.client.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.bridgefy.samples.twitter.IntroActivity.INTENT_TARGET;
import static com.bridgefy.samples.twitter.IntroActivity.INTENT_USERNAME;
import static com.bridgefy.samples.twitter.entities.Peer.DeviceType.ANDROID;


public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    static final String INTENT_EXTRA_NAME = "peerName";
    static final String INTENT_EXTRA_UUID = "peerUuid";
    static final String INTENT_EXTRA_TYPE = "deviceType";
    static final String INTENT_EXTRA_MSG  = "message";
    static final String BROADCAST_CHAT    = "Broadcast";

    static final String PAYLOAD_DEVICE_TYPE  = "device_type";
    static final String PAYLOAD_DEVICE_NAME  = "device_name";
    static final String PAYLOAD_TEXT         = "text";
    static public String name;
    private String m_Text = "User";
    static final String INTENT_NAME = "peerName";

    PeersRecyclerViewAdapter peersAdapter =
            new PeersRecyclerViewAdapter(new ArrayList<>());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configure the Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());
        name = getIntent().getStringExtra(INTENT_USERNAME);
        //name = getIntent().getStringExtra(INTENT_USERNAME);
        RecyclerView recyclerView = findViewById(R.id.peer_list);
        recyclerView.setAdapter(peersAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getBaseContext(),
                DividerItemDecoration.VERTICAL));
        ArrayList<String> a = new ArrayList<String>();
        //String[] a= new String[3];
        if (name.equals( "CampaignManager"))
            a.add("CampaignBroadcast");
        a.add("CampaignManager");
        a.add("Abdulrahman");
        a.add("Ali");
        if (name.equals( "Abdulrahman"))
            a.add("Khaled-Brother");


        Peer peer=new Peer("","","");
        for (int i = 0; i < a.size(); ++i) {

            if (!name.equals(a.get(i)))

            {  peer=  new Peer(Integer.toString(i),a.get(i),a.get(i));
            peer.setDeviceType(ANDROID);
            peer.setNearby(true);
            peer.setOnline(true);

                peersAdapter.addPeer(peer);
            }
        }


//        if (isThingsDevice(this)) {
//            //enabling bluetooth automatically
//            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
//            bluetoothAdapter.enable();
//        }

//        Bridgefy.initialize(getApplicationContext(), new RegistrationListener() {
//            @Override
//            public void onRegistrationSuccessful(BridgefyClient bridgefyClient) {
//                // Start Bridgefy
//                startBridgefy();
//
//                Config.Builder builder = new Config.Builder();
//                builder.setEnergyProfile(BFEnergyProfile.HIGH_PERFORMANCE);
//                builder.setEncryption(false);
//
//                Bridgefy.start(messageListener, stateListener, builder.build());
//            }
//
//            @Override
//            public void onRegistrationFailed(int errorCode, String message) {
//                Toast.makeText(getBaseContext(), getString(R.string.registration_error),
//                        Toast.LENGTH_LONG).show();
//            }
//        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

//        if (isFinishing())
//            Bridgefy.stop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
//            case R.id.action_broadcast:
//                startActivity(new Intent(getBaseContext(), TimelineActivity.class)
//                        .putExtra(INTENT_USERNAME, name)
//                        .putExtra(INTENT_TARGET, "broadcast"));
//                return true;

//            case R.id.action_setname:
//                getname();
//                // startActivity(new Intent(getBaseContext(), ChatActivity.class));
//                return true;
        }
        return false;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

private void getname()
{

    AlertDialog.Builder builder = new AlertDialog.Builder(this);

    builder.setTitle("Name");

// Set up the input
    final EditText input = new EditText(this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
    input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
    builder.setView(input);

// Set up the buttons
    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            m_Text = input.getText().toString();
        }
    });
    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
        }
    });

    builder.show();
}
//    /**
//     *      BRIDGEFY METHODS
//     */
//    private void startBridgefy() {
//        Bridgefy.start(messageListener, stateListener);
//    }
//
//    // TODO change for BridgefyUtils method
//    public boolean isThingsDevice(Context context) {
//        final PackageManager pm = context.getPackageManager();
//        return pm.hasSystemFeature("android.hardware.type.embedded");
//    }
//
//    private MessageListener messageListener = new MessageListener() {
//        @Override
//        public void onMessageReceived(Message message) {
//            // direct messages carrying a Device name represent device handshakes
//            if (message.getContent().get(PAYLOAD_DEVICE_NAME) != null) {
//                Peer peer = new Peer(message.getSenderId(),
//                        (String) message.getContent().get(PAYLOAD_DEVICE_NAME));
//                peer.setNearby(true);
//                peer.setDeviceType(extractType(message));
//                peersAdapter.addPeer(peer);
//                Log.d(TAG, "Peer introduced itself: " + peer.getDeviceName());
//
//                // any other direct message should be treated as such
//            } else {
//                String incomingMessage = (String) message.getContent().get("text");
//                Log.d(TAG, "Incoming private message: " + incomingMessage);
//                LocalBroadcastManager.getInstance(getBaseContext()).sendBroadcast(
//                        new Intent(message.getSenderId())
//                                .putExtra(INTENT_EXTRA_MSG, incomingMessage));
//            }
//
//            // if it's an Android Things device, reply automatically
//            if (isThingsDevice(MainActivity.this)) {
//                Log.d(TAG, "I'm a bot. Responding message automatically.");
//                HashMap<String, Object> content = new HashMap<>();
//                content.put("text", "Beep boop. I'm a bot.");
//                Message replyMessage = Bridgefy.createMessage(message.getSenderId(), content);
//                Bridgefy.sendMessage(replyMessage);
//            }
//        }
//
//        @Override
//        public void onBroadcastMessageReceived(Message message) {
//            // we should not expect to have connected previously to the device that originated
//            // the incoming broadcast message, so device information is included in this packet
//            String incomingMsg = (String) message.getContent().get(PAYLOAD_TEXT);
//            String deviceName  = (String) message.getContent().get(PAYLOAD_DEVICE_NAME);
//            Peer.DeviceType deviceType = extractType(message);
//
//            Log.d(TAG, "Incoming broadcast message: " + incomingMsg);
//            LocalBroadcastManager.getInstance(getBaseContext()).sendBroadcast(
//                    new Intent(BROADCAST_CHAT)
//                            .putExtra(INTENT_EXTRA_NAME, deviceName)
//                            .putExtra(INTENT_EXTRA_TYPE, deviceType)
//                            .putExtra(INTENT_EXTRA_MSG,  incomingMsg));
//        }
//    };

//    private Peer.DeviceType extractType(Message message) {
//        int eventOrdinal;
//        Object eventObj = message.getContent().get(PAYLOAD_DEVICE_TYPE);
//        if (eventObj instanceof Double) {
//            eventOrdinal = ((Double) eventObj).intValue();
//        } else {
//            eventOrdinal = (Integer) eventObj;
//        }
//        return Peer.DeviceType.values()[eventOrdinal];
//    }

//    StateListener stateListener = new StateListener() {
//        @Override
//        public void onDeviceConnected(final Device device, Session session) {
//            Log.i(TAG, "onDeviceConnected: " + device.getUserId());
//            // send our information to the Device
//            HashMap<String, Object> map = new HashMap<>();
//            map.put(PAYLOAD_DEVICE_NAME,m_Text+ " "+Build.MANUFACTURER + " " + Build.MODEL);
//            map.put(PAYLOAD_DEVICE_TYPE, Peer.DeviceType.ANDROID.ordinal());
//            device.sendMessage(map);
//        }
//
//        @Override
//        public void onDeviceLost(Device device) {
//            Log.w(TAG, "onDeviceLost: " + device.getUserId());
//            peersAdapter.removePeer(device);
//        }
//
//        @Override
//        public void onStartError(String message, int errorCode) {
//            Log.e(TAG, "onStartError: " + message);
//
//            if (errorCode == StateListener.INSUFFICIENT_PERMISSIONS) {
//                ActivityCompat.requestPermissions(MainActivity.this,
//                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
//            }
//        }
//    };

//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//
//        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//            // Start Bridgefy
//            startBridgefy();
//
//        } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
//            Toast.makeText(this, "Location permissions needed to start peers discovery.", Toast.LENGTH_SHORT).show();
//            finish();
//        }
//    }


    /**
     *      RECYCLER VIEW CLASSES
     */
    class PeersRecyclerViewAdapter
            extends RecyclerView.Adapter<PeersRecyclerViewAdapter.PeerViewHolder> {

        private final List<Peer> peers;

        PeersRecyclerViewAdapter(List<Peer> peers) {
            this.peers = peers;
        }

        @Override
        public int getItemCount() {
            return peers.size();
        }

        void addPeer(Peer peer) {
            int position = getPeerPosition(peer.getUuid());
            if (position > -1) {
                peer.setOnline(true);
                peers.set(position, peer);
                notifyItemChanged(position);
            } else {
                peer.setOnline(true);
                peers.add(peer);
                notifyItemInserted(peers.size() - 1);
            }
        }

        void removePeer(Device lostPeer) {
            int position = getPeerPosition(lostPeer.getUserId());
            if (position > -1) {
                Peer peer = peers.get(position);
                peer.setNearby(false);
                peer.setOnline(false);
                peers.set(position, peer);
                notifyItemChanged(position);
            }
        }

        private int getPeerPosition(String peerId) {
            for (int i = 0; i < peers.size(); i++) {
                if (peers.get(i).getUuid().equals(peerId))
                    return i;
            }
            return -1;
        }

        @Override
        public PeerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.peer_row, parent, false);
            return new PeerViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final PeerViewHolder peerHolder, int position) {
            peerHolder.setPeer(peers.get(position));


        }

        class PeerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            final TextView mContentView;
            final ImageView mImageView,mStarView;
            Peer peer;

            PeerViewHolder(View view) {
                super(view);
                mContentView = view.findViewById(R.id.peerName);
                mImageView = view.findViewById(R.id.peerAvatar);
                mStarView = view.findViewById(R.id.peerStar);
                view.setOnClickListener(this);
            }

            void setPeer(Peer peer) {
                this.peer = peer;

                switch (peer.getDeviceType()) {
                    case ANDROID:
                        this.mContentView.setText(peer.getDeviceName());// + " (android)");
                        break;

                    case IPHONE:
                        this.mContentView.setText(peer.getDeviceName());// + " (iPhone)");
                        break;
                }

                if (peer.isNearby()) {
                    this.mContentView.setTextColor(Color.BLACK);
                } else {
                    this.mContentView.setTextColor(Color.GRAY);
                }
                if (peer.isOnline()) {
                    this.mContentView.setTextColor(Color.BLACK);
                } else {
                    this.mContentView.setTextColor(Color.BLUE);
                }

                if(peer.getDeviceName().equals("CampaignManager"))
                {
                    this.mContentView.setText("Campaign Manager");

                    //this.mContentView.setTextColor(Color.BLUE);
                    //this.mContentView.setTypeface(null, Typeface.BOLD);
                    this.mImageView.setImageDrawable(getDrawable(R.drawable.user1));
                    this.mStarView.setVisibility(View.VISIBLE);
                    this.mImageView.setImageDrawable(getDrawable(R.drawable.user1));

                }
                if(peer.getDeviceName().equals("CampaignBroadcast"))
                {
                    this.mContentView.setText("Campaign Broadcast");


                    this.mImageView.setImageDrawable(getDrawable(R.drawable.cast1));
                }

                if(peer.getDeviceName().equals("Ali"))
                {

                    this.mImageView.setImageDrawable(getDrawable(R.drawable.user2));
                }

                if(peer.getDeviceName().equals("Abdulrahman"))
                {

                    this.mImageView.setImageDrawable(getDrawable(R.drawable.user3));
                }
                if(peer.getDeviceName().equals("Khaled-Brother"))
                {

                    this.mImageView.setImageDrawable(getDrawable(R.drawable.user4));
                }

            }

            public void onClick(View v) {
//                startActivity(new Intent(getBaseContext(), ChatActivity.class)
//                        .putExtra(INTENT_EXTRA_NAME, peer.getDeviceName())
//                        .putExtra(INTENT_EXTRA_UUID, peer.getUuid()));
                startActivity(new Intent(getBaseContext(), TimelineActivity.class)
                        .putExtra(INTENT_USERNAME, name)
                        .putExtra(INTENT_TARGET, peer.getuniqueid()));
            }
        }
    }
}