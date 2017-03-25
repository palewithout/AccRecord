package matrix.accrecord;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Environment;
import android.text.format.DateFormat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private TextView Acc_x, Acc_y, Acc_z;
    private TextView StatusView;
    private Button button0, button1,button2, button3, button4, button5, button6, button7, button8;
    private SensorManager sm = null;
    private Sensor ACC;
    private String TimeStr;
    String timedata,Sensordata_Acc="";
    private int[] TouchCount = new int[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Acc_x = (TextView) findViewById(R.id.TextView0);
        Acc_y = (TextView) findViewById(R.id.TextView1);
        Acc_z = (TextView) findViewById(R.id.TextView2);
        StatusView = (TextView) findViewById(R.id.StatusView);

        button0 = (Button)findViewById(R.id.button0);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button7 = (Button)findViewById(R.id.button7);
        button8 = (Button)findViewById(R.id.button8);

        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        ACC = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        CheckSdcard();

        View.OnTouchListener ButtonListener = new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                System.out.println("AAAAAAAAA");
                switch (v.getId()){
                    case R.id.button0:
                        if(event.getAction() == MotionEvent.ACTION_DOWN){
                            TouchCount[0]++;
                            TouchCount[9] = TouchCount[0];
                            TimeStr=GetTime();
                            RegisterForAcc();
                        }
                        else if(event.getAction() == MotionEvent.ACTION_UP){
                            new Handler().postDelayed(new Runnable(){
                                public void run() {
                                    unRegisterForAcc();
                                }
                            }, 500);
                        }
                        break;

                    case R.id.button1:
                        if(event.getAction() == MotionEvent.ACTION_DOWN){
                            TouchCount[1]++;
                            TouchCount[9] = TouchCount[1];
                            TimeStr=GetTime();
                            RegisterForAcc();
                        }
                        else if(event.getAction() == MotionEvent.ACTION_UP){
                            new Handler().postDelayed(new Runnable(){
                                public void run() {
                                    unRegisterForAcc();
                                }
                            }, 500);
                        }
                        break;

                    case R.id.button2:
                        if(event.getAction() == MotionEvent.ACTION_DOWN){
                            TouchCount[2]++;
                            TouchCount[9] = TouchCount[2];
                            TimeStr=GetTime();
                            RegisterForAcc();
                        }
                        else if(event.getAction() == MotionEvent.ACTION_UP){
                            new Handler().postDelayed(new Runnable(){
                                public void run() {
                                    unRegisterForAcc();
                                }
                            }, 500);
                        }
                        break;

                    case R.id.button3:
                        if(event.getAction() == MotionEvent.ACTION_DOWN){
                            TouchCount[3]++;
                            TouchCount[9] = TouchCount[3];
                            TimeStr=GetTime();
                            RegisterForAcc();
                        }
                        else if(event.getAction() == MotionEvent.ACTION_UP){
                            new Handler().postDelayed(new Runnable(){
                                public void run() {
                                    unRegisterForAcc();
                                }
                            }, 500);
                        }
                        break;

                    case R.id.button4:
                        if(event.getAction() == MotionEvent.ACTION_DOWN){
                            TouchCount[4]++;
                            TouchCount[9] = TouchCount[4];
                            TimeStr=GetTime();
                            RegisterForAcc();
                        }
                        else if(event.getAction() == MotionEvent.ACTION_UP){
                            new Handler().postDelayed(new Runnable(){
                                public void run() {
                                    unRegisterForAcc();
                                }
                            }, 500);
                        }
                        break;

                    case R.id.button5:
                        if(event.getAction() == MotionEvent.ACTION_DOWN){
                            TouchCount[5]++;
                            TouchCount[9] = TouchCount[5];
                            TimeStr=GetTime();
                            RegisterForAcc();
                        }
                        else if(event.getAction() == MotionEvent.ACTION_UP){
                            new Handler().postDelayed(new Runnable(){
                                public void run() {
                                    unRegisterForAcc();
                                }
                            }, 500);
                        }
                        break;

                    case R.id.button6:
                        if(event.getAction() == MotionEvent.ACTION_DOWN){
                            TouchCount[6]++;
                            TouchCount[9] = TouchCount[6];
                            TimeStr=GetTime();
                            RegisterForAcc();
                        }
                        else if(event.getAction() == MotionEvent.ACTION_UP){
                            new Handler().postDelayed(new Runnable(){
                                public void run() {
                                    unRegisterForAcc();
                                }
                            }, 500);
                        }
                        break;

                    case R.id.button7:
                        if(event.getAction() == MotionEvent.ACTION_DOWN){
                            TouchCount[7]++;
                            TouchCount[9] = TouchCount[7];
                            TimeStr=GetTime();
                            RegisterForAcc();
                        }
                        else if(event.getAction() == MotionEvent.ACTION_UP){
                            new Handler().postDelayed(new Runnable(){
                                public void run() {
                                    unRegisterForAcc();
                                }
                            }, 500);
                        }
                        break;

                    case R.id.button8:
                        if(event.getAction() == MotionEvent.ACTION_DOWN){
                            TouchCount[8]++;
                            TouchCount[9] = TouchCount[8];
                            TimeStr=GetTime();
                            RegisterForAcc();
                        }
                        else if(event.getAction() == MotionEvent.ACTION_UP){
                            new Handler().postDelayed(new Runnable(){
                                public void run() {
                                    unRegisterForAcc();
                                }
                            }, 500);
                        }
                        break;
                    default:
                        break;
                }
                return true;
            }
        };
        button0.setOnTouchListener(ButtonListener);
        button1.setOnTouchListener(ButtonListener);
        button2.setOnTouchListener(ButtonListener);
        button3.setOnTouchListener(ButtonListener);
        button4.setOnTouchListener(ButtonListener);
        button5.setOnTouchListener(ButtonListener);
        button6.setOnTouchListener(ButtonListener);
        button7.setOnTouchListener(ButtonListener);
        button8.setOnTouchListener(ButtonListener);

    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
// TODO Auto-generated method stub

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
// TODO Auto-generated method stub
        synchronized (this) {
            setAccelerometer(event);
            if(Sensordata_Acc!=""){
                writedata(GetTime());
                writedata(Sensordata_Acc);
            }
        }
    }

    public void CheckSdcard(){
        //  boolean mExternalStorageAvailable = false;
        //boolean mExternalStorageWriteable = false;
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            // 对SD 卡上的存储可以进行读/写操作
            StatusView.setText("Can read and write SD card now");
            //   mExternalStorageAvailable = mExternalStorageWriteable = true;
        } else
        if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY))
        {
            //对SD 卡上的存储可以进行读操作
            StatusView.setText("Can only read SD card now");
            //    mExternalStorageAvailable = true;
            //     mExternalStorageWriteable = false;
        } else {
            //对SD 卡上的存储不可用
            StatusView.setText("SD card disabled!");
            //    mExternalStorageAvailable = mExternalStorageWriteable = false;
        }
    }

    public void writedata(String string){
        String str=TimeStr;
        String fileName =String.valueOf(TouchCount[9])+"_"+str.trim()+".txt";
//        File dir = Environment.getExternalStorageDirectory();
        File dir = new File("/storage/emulated/0/AccRecord");
        if (dir.exists()&& dir.canWrite()) {
            File newFile = new File(dir.getAbsolutePath() + "/" + fileName);
            FileOutputStream fos = null;
            try {
                newFile.createNewFile();
                if (newFile.exists() && newFile.canWrite()) {
                    fos = new FileOutputStream(newFile,true);

                    fos.write(string.getBytes());
                    //  fos.write("写入的内容".getBytes());
                    //  labelView.setText(fileName + "文件写入SD 卡");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fos != null) {
                    try{
                        fos.flush();
                        fos.close();
                    }
                    catch (IOException e) { }
                }
            }
        }
    }

    public String GetTime() {
        Calendar ca = Calendar.getInstance();
	/*      int year = ca.get(Calendar.YEAR);//Get year
	        int month = ca.get(Calendar.MONTH)+1;//Get month
	        int day = ca.get(Calendar.DAY_OF_MONTH);//Get day
	        int minute = ca.get(Calendar.MINUTE);//get minute
	        int hour = ca.get(Calendar.HOUR_OF_DAY);//get hour
	        int second = ca.get(Calendar.SECOND);//get second	*/
        timedata=DateFormat.format("yyyyMMddkkmmss",ca.getTime()).toString()+" ";
        StatusView.setText(timedata);
        return timedata;
    }

    private void RegisterForAcc() {
        // TODO Auto-generated method stub
        sm.registerListener(this, ACC, sm.SENSOR_DELAY_GAME);
    }

    private void unRegisterForAcc() {
        // TODO Auto-generated method stub
        sm.unregisterListener(this);
    }

    private void setAccelerometer(SensorEvent event) {
        // TODO Auto-generated method stub
        float ac_x = event.values[sm.DATA_X];
        float ac_y = event.values[sm.DATA_Y];
        float ac_z = event.values[sm.DATA_Z];
        Acc_x.setText("X = " + ac_x);
        Acc_y.setText("Y = " + ac_y);
        Acc_z.setText("Z = " + ac_z);
        Sensordata_Acc=ac_x+" "+ac_y+" "+ac_z+" ";
        //writedata("Acc",gettime());
        //writedata( "Acc",Sensordata_Acc);
    }
}
