package yinlei.com.httpencapsulation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void testHttpPostOnSubThread() throws Throwable {
        String url = "http://api.www.com/core/?service=user.login";
        String content = "account=ruolan&password=123456";
        Request request = new Request(url, Request.RequestMethod.POST);
        request.url = url;
        request.content = content;
        request.setCallBack(new Callback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("ruolan", "testHttpPost" + result);
            }

            @Override
            public void onFailure(Exception e) {
                e.printStackTrace();
            }
        });
        RequestTask task = new RequestTask(request);
        task.execute();
    }

    public void testHttpPostOnSubThreadForGeneric() throws Throwable {
        String url = "http://api.www.com/core/?service=user.login";
        String content = "account=ruolan&password=123456";
        Request request = new Request(url, Request.RequestMethod.POST);
        request.url = url;
        request.content = content;
        request.setCallBack(new Callback<User>() {

            @Override
            public void onSuccess(User result) {

            }

            @Override
            public void onFailure(Exception e) {

            }
        }.setReturnType(User.class));
        RequestTask task = new RequestTask(request);
        task.execute();
    }
}
