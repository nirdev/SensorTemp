package example.com.sensortemp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startPlayer(View v) {
        Intent start = new Intent(this, AccelerometerRecorder.class);
        startService(start);
    }

    public void stopPlayer(View v) {
        Intent stop = new Intent(this, AccelerometerRecorder.class);
        stopService(stop);
    }
}


