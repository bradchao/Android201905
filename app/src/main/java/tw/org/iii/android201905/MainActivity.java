package tw.org.iii.android201905;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private boolean isRunning;
    private Button btnLeft,btnRight;
    private Timer timer;
    private int i;
    private UIHandler uiHandler;
    private TextView clock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uiHandler = new UIHandler();
        timer = new Timer();
        timer.schedule(new MyTask(), 0, 10);
        clock = findViewById(R.id.clock);
        btnLeft = findViewById(R.id.btnLeft);
        btnRight = findViewById(R.id.btnRight);
        if (isRunning){
            btnLeft.setText("Lap");
            btnRight.setText("STOP");
        }else{
            btnLeft.setText("Reset");
            btnRight.setText("START");
        }
    }

    private class MyTask extends TimerTask {
        @Override
        public void run() {
            if (isRunning) {
                i++;
                uiHandler.sendEmptyMessage(0);
            }
        }
    }

    private class UIHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            clock.setText("" +i);
        }
    }

    @Override
    public void finish() {
        if (timer != null){
            timer.cancel();
            timer.purge();
            timer = null;
        }
        super.finish();
    }

    public void clickLeft(View view) {
    }
    public void clickRight(View view) {
        isRunning = !isRunning;
        if (isRunning){
            btnLeft.setText("Lap");
            btnRight.setText("STOP");
        }else{
            btnLeft.setText("Reset");
            btnRight.setText("START");
        }
    }
}
