package tw.com.pcschool.dd2018011003;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //實作一個handler
    Handler handler = new Handler(){
        @Override
        //override handler message 方法
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.d("MSG", "取得一個 Message");
            Bundle b = msg.getData();
            String str = b.getString("data");

            //在log寫入一個message測試 收到的時候會在log寫"取得一個 Message"
            Log.d("MSG", "data:" + str);
        }
    };
    public void click1(View v)
    {
        //實作message
        Message msg = new Message();
        //Bundle放入資料
        Bundle b = new Bundle();
        b.putString("data","mydata");
        //
        msg.setData(b);
        //等三秒再傳
        handler.sendMessageDelayed(msg,3000);
        //傳出message
        //handler.sendMessage(msg);
    }
}
