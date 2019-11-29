package tw.org.iii.android201905;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private UIHandler uiHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        uiHandler = new UIHandler();
    }

    public void test1(View view) {
        MyThread mt1 = new MyThread("A");
        mt1.start();
    }

    private class MyThread extends Thread {
        String name;
        MyThread(String name){this.name = name;}
        @Override
        public void run() {
            for (int i=0; i<10; i++){
                Log.v("brad", name + ": i = " + i);
                Message message = new Message();
                Bundle data = new Bundle();
                data.putString("name", name);
                data.putInt("i" , i);
                message.setData(data);
                uiHandler.sendMessage(message);
                try {
                    Thread.sleep(500);
                }catch (Exception e){

                }
            }
        }
    }

    private class UIHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            String name = data.getString("name");
            int i = data.getInt("i");
            tv.setText(name + ": i = " + i);
        }
    }


}
