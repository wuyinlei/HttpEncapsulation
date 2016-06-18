package yinlei.com.httpencapsulation;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * HTTP请求工具类
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: HttpUrlConnectionUtils.java
 * @author: 若兰明月
 * @date: 2016-06-18 11:03
 */

public class HttpUrlConnectionUtils {


    public static String execute(Request request) throws IOException {
        switch (request.mMetohd){
            case GET:
            case DELETE:
                get(request);
                break;
            case POST:
            case PUT:
                post(request);
                break;
            default:

                break;
        }
        return null;
    }


    public static String get(Request request) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) new URL(request.url).openConnection();
        conn.setRequestMethod(request.mMetohd.name());
        conn.setConnectTimeout(15 * 3000);
        conn.setReadTimeout(15 * 3000);
        addHeaders(conn,request.headers);

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
            return new String(out.toByteArray());
        }

        return null;
    }

    public static String post(Request request) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) new URL(request.url).openConnection();
        conn.setRequestMethod(request.mMetohd.name());
        conn.setConnectTimeout(15 * 3000);
        conn.setReadTimeout(15 * 3000);
        conn.setDoInput(true);

        OutputStream os = conn.getOutputStream();
        os.write(request.content.getBytes());

        addHeaders(conn, request.headers);


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
            return new String(out.toByteArray());
        }

        return null;
    }

    private static void addHeaders(HttpURLConnection conn, Map<String, String> headers) {
        if (headers == null || headers.size() == 0)
            return;
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            conn.addRequestProperty(entry.getKey(), entry.getValue());
        }
    }
}
