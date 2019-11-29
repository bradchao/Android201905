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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
