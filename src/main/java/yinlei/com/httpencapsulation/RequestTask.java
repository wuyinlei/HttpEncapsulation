package yinlei.com.httpencapsulation;

import android.os.AsyncTask;

import java.io.IOException;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: yinlei.com.httpencapsulation.RequestTask.java
 * @author: myName
 * @date: 2016-06-18 12:02
 */

public class RequestTask extends AsyncTask<Void, Integer, Object> {

    private Request request;

    public RequestTask(Request request) {
        this.request = request;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Object doInBackground(Void... params) {
        try {
            return HttpUrlConnectionUtils.execute(request);
        } catch (IOException e) {
            return e;
        }
    }

    @Override
    protected void onPostExecute(Object o) {
        if (o instanceof Exception) {
            request.mICallBack.onFailure((Exception) o);
        } else {
            request.mICallBack.onSuccess((String) o);
        }
    }
}
