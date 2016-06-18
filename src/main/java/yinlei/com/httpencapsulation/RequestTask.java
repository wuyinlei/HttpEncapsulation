package yinlei.com.httpencapsulation;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: RequestTask.java
 * @author: 若兰明月
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
          HttpURLConnection conn = HttpUrlConnectionUtils.execute(request);
            return request.mICallBack.parse(conn);
        } catch (Exception e) {
            return e;
        }
    }

    @Override
    protected void onPostExecute(Object o) {
        if (o instanceof Exception) {
            request.mICallBack.onFailure((Exception) o);
        } else {
            request.mICallBack.onSuccess(o);
        }
    }
}
