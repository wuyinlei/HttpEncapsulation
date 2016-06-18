package yinlei.com.httpencapsulation;

import android.test.InstrumentationTestCase;
import android.util.Log;

/**
 * HTTP测试类
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: TestHttp.java
 * @author: 若兰明月
 * @date: 2016-06-18 11:31
 */

public class TestHttp extends InstrumentationTestCase {

    public void testHttpGet() throws Throwable {
        String url = "http://www.baidu.com";
        Request request = new Request(url);
        request.url = url;
        String result = HttpUrlConnectionUtils.get(request);
        Log.e("ruolan", "testHttpGet" + result);
    }

    public void testHttpPost() throws Throwable {
        String url = "http://api.www.com/core/?service=user.login";
        String content = "account=ruolan&password=123456";
        Request request = new Request(url, Request.RequestMethod.POST);
        request.url = url;
        request.content = content;
        String result = HttpUrlConnectionUtils.post(request);
        Log.e("ruolan", "testHttpPost" + result);
    }

    public void testHttpPostOnSubThread() throws Throwable {
        String url = "http://api.www.com/core/?service=user.login";
        String content = "account=ruolan&password=123456";
        Request request = new Request(url, Request.RequestMethod.POST);
        request.url = url;
        request.content = content;
        request.setCallBack(new ICallBack() {
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

}
