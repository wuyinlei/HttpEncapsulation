package yinlei.com.httpencapsulation;

/**
 * User  javabean
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: User.java
 * @author: 若兰明月
 * @date: 2016-06-18 12:26
 */

public class User {
    public String id;
    public String account;
    public String email;
    public String username;
    public String token;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }
}
