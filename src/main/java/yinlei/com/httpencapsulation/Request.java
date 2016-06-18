package yinlei.com.httpencapsulation;

import java.util.Map;

/**
 * HTTP请求参数
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: Request.java
 * @author: 若兰明月
 * @date: 2016-06-18 11:45
 */

public class Request {
    public String url;
    public String content;
    public Map<String, String> headers;
    public ICallBack mICallBack;

    public void setCallBack(ICallBack iCallBack) {
        this.mICallBack = iCallBack;
    }

    public enum RequestMethod {POST, GET, DELETE, PUT}

    RequestMethod mMetohd;

    public Request(String url) {
        this.url = url;
        this.mMetohd = RequestMethod.GET;
    }

    public Request(String url, RequestMethod method) {
        this.url = url;
        this.mMetohd = method;
    }

}
