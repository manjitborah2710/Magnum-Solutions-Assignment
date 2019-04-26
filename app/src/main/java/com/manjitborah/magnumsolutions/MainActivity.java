package com.manjitborah.magnumsolutions;

import android.Manifest;
import android.app.usage.NetworkStats;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.manjitborah.magnumsolutions.model.Message;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RVAdapter adapter;
    List<Message> messages;
    ArrayList<String> permissions;
    LinearLayout linearLayout,retryLayout;
    Button btn;
    SimpleDateFormat sdf;
    SimpleDateFormat sdf2;
    Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout=findViewById(R.id.ll);
        retryLayout=findViewById(R.id.retry_ll);
        btn=findViewById(R.id.retry_btn);
        sdf=new SimpleDateFormat("hh:mm a");
        sdf2=new SimpleDateFormat("dd-MMM-yyyy");

        calendar=Calendar.getInstance();

        checkForPermission();

        recyclerView=findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        messages=new ArrayList<>();

        messages.add(new Message(sdf2.format(calendar.getTime())+"\nThis is a center aligned message",getCurrentTime(),Message.TYPE_TEXT,Message.DATE));
        messages.add(new Message("Hey let's discuss something about blackholes",getCurrentTime(),Message.TYPE_TEXT,Message.RECEIVE));
        messages.add(new Message("Okay :)",getCurrentTime(),Message.TYPE_TEXT,Message.SEND));
        messages.add(new Message("A black hole is a region of spacetime exhibiting such strong gravitational effects that nothing—not even particles and electromagnetic radiation such as light—can escape from inside it.",getCurrentTime(),Message.TYPE_TEXT,Message.RECEIVE));
        messages.add(new Message("The theory of general relativity predicts that a sufficiently compact mass can deform spacetime to form a black hole. The boundary of the region from which no escape is possible is called the event horizon. ",getCurrentTime(),Message.TYPE_TEXT,Message.RECEIVE));
        messages.add(new Message("Although the event horizon has an enormous effect on the fate and circumstances of an object crossing it, no locally detectable features appear to be observed. In many ways, a black hole acts like an ideal black body, as it reflects no light.Moreover, quantum field theory in curved spacetime predicts that event horizons emit Hawking radiation, with the same spectrum as a black body of a temperature inversely proportional to its mass. This temperature is on the order of billionths of a kelvin for black holes of stellar mass, making it essentially impossible to observe.",getCurrentTime(),Message.TYPE_TEXT,Message.SEND));


        messages.add(new Message("",getCurrentTime(),Message.TYPE_IMAGE,Message.SEND));

        calendar.add(Calendar.DATE,2);
        messages.add(new Message(sdf2.format(calendar.getTime())+"\nThis is a center aligned message",getCurrentTime(),Message.TYPE_TEXT,Message.DATE));
        messages.add(new Message("How are you?",getCurrentTime(),Message.TYPE_TEXT,Message.RECEIVE));
        messages.add(new Message("I am fine. You?",getCurrentTime(),Message.TYPE_TEXT,Message.SEND));
        messages.add(new Message("I am good too",getCurrentTime(),Message.TYPE_TEXT,Message.RECEIVE));

        messages.add(new Message("",getCurrentTime(),Message.TYPE_IMAGE,Message.RECEIVE));

        messages.add(new Message("",getCurrentTime(),Message.TYPE_IMAGE,Message.SEND));

        messages.add(new Message("How are you?",getCurrentTime(),Message.TYPE_TEXT,Message.RECEIVE));
        messages.add(new Message("I am fine. You?",getCurrentTime(),Message.TYPE_TEXT,Message.SEND));
        messages.add(new Message("I am good too",getCurrentTime(),Message.TYPE_TEXT,Message.RECEIVE));

        messages.add(new Message("",getCurrentTime(),Message.TYPE_IMAGE,Message.RECEIVE));

        messages.add(new Message("",getCurrentTime(),Message.TYPE_IMAGE,Message.SEND));
        calendar.add(Calendar.DATE,2);
        messages.add(new Message(sdf2.format(calendar.getTime())+"\nThis is a center aligned message",getCurrentTime(),Message.TYPE_TEXT,Message.DATE));
        messages.add(new Message("How are you?",getCurrentTime(),Message.TYPE_TEXT,Message.RECEIVE));
        messages.add(new Message("I am fine. You?",getCurrentTime(),Message.TYPE_TEXT,Message.SEND));
        messages.add(new Message("I am good too",getCurrentTime(),Message.TYPE_TEXT,Message.RECEIVE));

        messages.add(new Message("",getCurrentTime(),Message.TYPE_IMAGE,Message.RECEIVE));

        messages.add(new Message("",getCurrentTime(),Message.TYPE_IMAGE,Message.SEND));
        calendar.add(Calendar.DATE,2);
        messages.add(new Message(sdf2.format(calendar.getTime())+"\nThis is a center aligned message",getCurrentTime(),Message.TYPE_TEXT,Message.DATE));
        messages.add(new Message("How are you?",getCurrentTime(),Message.TYPE_TEXT,Message.RECEIVE));
        messages.add(new Message("I am fine. You?",getCurrentTime(),Message.TYPE_TEXT,Message.SEND));
        messages.add(new Message("I am good too",getCurrentTime(),Message.TYPE_TEXT,Message.RECEIVE));

        messages.add(new Message("",getCurrentTime(),Message.TYPE_IMAGE,Message.RECEIVE));
        messages.add(new Message("",getCurrentTime(),Message.TYPE_IMAGE,Message.SEND));
        calendar.add(Calendar.DATE,2);
        messages.add(new Message(sdf2.format(calendar.getTime())+"\nThis is a center aligned message",getCurrentTime(),Message.TYPE_TEXT,Message.DATE));
        messages.add(new Message("How are you?",getCurrentTime(),Message.TYPE_TEXT,Message.RECEIVE));
        messages.add(new Message("I am fine. You?",getCurrentTime(),Message.TYPE_TEXT,Message.SEND));
        messages.add(new Message("I am good too",getCurrentTime(),Message.TYPE_TEXT,Message.RECEIVE));

        messages.add(new Message("",getCurrentTime(),Message.TYPE_IMAGE,Message.RECEIVE));

        messages.add(new Message("",getCurrentTime(),Message.TYPE_IMAGE,Message.SEND));
        calendar.add(Calendar.DATE,2);
        messages.add(new Message(sdf2.format(calendar.getTime())+"\nThis is a center aligned message",getCurrentTime(),Message.TYPE_TEXT,Message.DATE));
        messages.add(new Message("How are you?",getCurrentTime(),Message.TYPE_TEXT,Message.RECEIVE));
        messages.add(new Message("I am fine. You?",getCurrentTime(),Message.TYPE_TEXT,Message.SEND));
        messages.add(new Message("I am good too",getCurrentTime(),Message.TYPE_TEXT,Message.RECEIVE));

        messages.add(new Message("",getCurrentTime(),Message.TYPE_IMAGE,Message.RECEIVE));
        messages.add(new Message("",getCurrentTime(),Message.TYPE_IMAGE,Message.SEND));
        calendar.add(Calendar.DATE,2);
        messages.add(new Message(sdf2.format(calendar.getTime())+"\nThis is a center aligned message",getCurrentTime(),Message.TYPE_TEXT,Message.DATE));
        messages.add(new Message("How are you?",getCurrentTime(),Message.TYPE_TEXT,Message.RECEIVE));
        messages.add(new Message("I am fine. You?",getCurrentTime(),Message.TYPE_TEXT,Message.SEND));
        messages.add(new Message("I am good too",getCurrentTime(),Message.TYPE_TEXT,Message.RECEIVE));

        messages.add(new Message("",getCurrentTime(),Message.TYPE_IMAGE,Message.RECEIVE));

        messages.add(new Message("",getCurrentTime(),Message.TYPE_IMAGE,Message.SEND));
        calendar.add(Calendar.DATE,2);
        messages.add(new Message(sdf2.format(calendar.getTime())+"\nThis is a center aligned message",getCurrentTime(),Message.TYPE_TEXT,Message.DATE));
        messages.add(new Message("How are you?",getCurrentTime(),Message.TYPE_TEXT,Message.RECEIVE));
        messages.add(new Message("I am fine. You?",getCurrentTime(),Message.TYPE_TEXT,Message.SEND));
        messages.add(new Message("I am good too",getCurrentTime(),Message.TYPE_TEXT,Message.RECEIVE));

        messages.add(new Message("",getCurrentTime(),Message.TYPE_IMAGE,Message.RECEIVE));

        adapter=new RVAdapter(this,messages,this);

        recyclerView.setAdapter(adapter);
        recyclerView.scrollToPosition(messages.size()-1);


    }
    public void checkForPermission(){
        permissions=new ArrayList<>();
        int permission= ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if(permission!=PackageManager.PERMISSION_GRANTED){
            permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
        if(!permissions.isEmpty()){
            ActivityCompat.requestPermissions(this,permissions.toArray(new String[permissions.size()]),1234);
        }
        else{
            return;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==1234){
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                return;
            }
        }
    }

    public void addNewRandomMessages() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState()== NetworkInfo.State.CONNECTED || connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState()==NetworkInfo.State.CONNECTED){
            Random random = new Random();
            int r = random.nextInt(5) + 1;
            switch (r) {
                case 1: {
                    messages.add(new Message("sent text message", getCurrentTime(), Message.TYPE_TEXT, Message.SEND));
                    adapter.notifyDataSetChanged();
                    recyclerView.scrollToPosition(messages.size() - 1);
                    break;
                }
                case 2: {
                    messages.add(new Message("received text message", getCurrentTime(), Message.TYPE_TEXT, Message.RECEIVE));
                    adapter.notifyDataSetChanged();
                    recyclerView.scrollToPosition(messages.size() - 1);
                    break;
                }
                case 3: {
                    messages.add(new Message("received text message", getCurrentTime(), Message.TYPE_IMAGE, Message.SEND));
                    adapter.notifyDataSetChanged();
                    recyclerView.scrollToPosition(messages.size() - 1);
                    break;
                }
                case 4: {
                    messages.add(new Message("received text message", getCurrentTime(), Message.TYPE_IMAGE, Message.RECEIVE));
                    adapter.notifyDataSetChanged();
                    recyclerView.scrollToPosition(messages.size() - 1);
                    break;
                }
                case 5:{
                    messages.add(new Message("this is a center aligned message", getCurrentTime(), Message.TYPE_TEXT, Message.DATE));
                    adapter.notifyDataSetChanged();
                    recyclerView.scrollToPosition(messages.size() - 1);
                    break;
                }
                default: {

                }
            }
        }
        else{
            recyclerView.setVisibility(View.GONE);
            retryLayout.setVisibility(View.VISIBLE);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    retryLayout.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                }
            });
        }
    }
    public String getCurrentTime(){
        return sdf.format(Calendar.getInstance().getTime());
    }
}
