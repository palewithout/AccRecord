package matrix.accrecord;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private TextView vX;
    private TextView vY;
    private TextView vZ;
    private SensorManager sm = null;
    private Sensor ACC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vX = (TextView) findViewById(R.id.editText0);
        vY = (TextView) findViewById(R.id.editText1);
        vZ = (TextView) findViewById(R.id.editText2);
        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        ACC = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onResume(){
        super.onResume();
        sm.registerListener(this, ACC, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onStop(){
        super.onStop();
        sm.unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
// TODO Auto-generated method stub

    }

    public void onSensorChanged(SensorEvent event) {
// TODO Auto-generated method stub
    }
}
