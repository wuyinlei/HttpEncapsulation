package yinlei.com.httpencapsulation;

/**
 * REQUEST接口回调类
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: ICallBack.java
 * @author: 若兰明月
 * @date: 2016-06-18 12:07
 */

public interface ICallBack {
    void onSuccess(String result);
    void onFailure(Exception e);
}
