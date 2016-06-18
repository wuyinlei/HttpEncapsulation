package yinlei.com.httpencapsulation;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;

/**
 * Callback回调类
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: Callback.java
 * @author: 若兰明月
 * @date: 2016-06-18 12:35
 */

public abstract class Callback <T>implements ICallBack<T> {

    private Class<T> clz;

    @Override
    public T parse(HttpURLConnection conn) throws Exception {
        int status = conn.getResponseCode();
        if (status == HttpURLConnection.HTTP_OK) {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream is = conn.getInputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            is.close();
            out.flush();
            out.close();
            String result = new String(out.toByteArray());
            JSONObject json = new JSONObject(result);
            JSONObject data = json.optJSONObject("data");
            Gson gson = new Gson();
            return gson.fromJson(data.toString(),clz);
        }
        return null;
    }

    public ICallBack setReturnType(Class<T> clz) {
        this.clz = clz;
        return this;
    }
}
