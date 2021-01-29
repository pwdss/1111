package com.liu.Tools;

/**
 * @author 独狼Kiss
 * @title: UserTokenVO
 * @projectName testdemo
 * @description: TODO
 * @date 2021/1/298:49
 */
public class UserTokenVO {
    //用户认证凭据
    private String token;
    //过期时间
    private long expTime;
    //生成时间
    private long genTime;
    //SETGET

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public long getExpTime() {
        return expTime;
    }
    public void setExpTime(long expTime) {
        this.expTime = expTime;
    }
    public long getGenTime() {
        return genTime;
    }
    public void setGenTime(long genTime) {
        this.genTime = genTime;
    }
    //有参无参
    public UserTokenVO(){}
    public UserTokenVO(String token,long expTime,long genTime){
        this.token = token;
        this.expTime = expTime;
        this.genTime = genTime;
    }
}
