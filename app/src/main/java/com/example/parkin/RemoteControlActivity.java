package com.example.parkin;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//I added a line here by Github
//I added this line by Android Studio

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) by style.xml.
 */
public class RemoteControlActivity extends AppCompatActivity{

    private static final String TAG = "FullscreenActivity";
    private ImageButton imageButton_forward,imageButton_backward;
    private TextView speedTextView;
    private ScalableImageView wheel;
    public static final int UPDATE_TEXT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.remote_control_vehicle);
        wheel=findViewById(R.id.steering_wheel);
        speedTextView=findViewById(R.id.speedTextView);

        imageButton_forward=findViewById(R.id.forward);
        imageButton_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Forward");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what=UPDATE_TEXT;
                        handler.sendMessage(message);
                    }
                }).start();
            }
        });

        imageButton_backward=findViewById(R.id.backward);
        imageButton_backward.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_POINTER_DOWN:
                        Log.d(TAG, "onTouch: backward");
                    case MotionEvent.ACTION_MOVE:
                        Log.d(TAG, "onTouch: backwarding");
                    case MotionEvent.ACTION_UP:
                        Log.d(TAG, "onTouch: Up");
                }
                return true;
            }
        });



    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    private Handler handler=new Handler(){
    public void handleMessage(Message msg){
        switch (msg.what){
            case UPDATE_TEXT:
                String text=wheel.getDegree()+"";
                speedTextView.setText(text);
                break;
            default:
                break;
        }
    }};


}
