package bwie.com.ndkdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.getkeepsafe.relinker.ReLinker;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ReLinker.loadLibrary(this, "str", new ReLinker.LoadListener() {
            @Override
            public void success() {
                System.out.println("success = ");


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, ""+ getKey(1), Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void failure(Throwable t) {
                System.out.println("failure = ");

            }
        });

    }
    public native String getKey(int type);
}
