package yinlei.com.httpencapsulation;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * REQUEST接口回调类
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: ICallBack.java
 * @author: 若兰明月
 * @date: 2016-06-18 12:07
 */

public interface ICallBack <T>{
    void onSuccess(T result);
    void onFailure(Exception e);

    T parse(HttpURLConnection conn) throws  Exception;

}
