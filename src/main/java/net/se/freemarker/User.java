package net.se.freemarker;

/**
 * 用户类
 **/
public class User {
    public User() { }

    public User(String name, String password, String lastTime) {
        this.name = name;
        this.password = password;
        this.lastTime = lastTime;
    }

    //用户名
    private String name;
    //密码
    private String password;
    //最后登录时间
    private String lastTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }
}
