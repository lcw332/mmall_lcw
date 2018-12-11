package com.mmall.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//保证序列化JSON的时候，如果对象是null的对象，key也会消失
public class ServerResponse<T> implements Serializable {

    private int status;
    private String  meg;
    private  T data;

    private ServerResponse(int status){
        this.status=status;
    }

    private ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status,String meg,T data){
        this.status=status;
        this.meg=meg;
        this.data=data;
    }

    private ServerResponse(int status, String meg) {
        this.status = status;
        this.meg=meg;
    }

    @JsonIgnore
    //使之不在JSON序列化结果当中
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus(){
        return  status;
    }
    public T getData(){
        return data;
    }
    public String getMeg(){
        return meg;
    }

    public static  <T>ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }
    public static  <T>ServerResponse<T> createBySuccessMessage(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }
    public static <T>ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }
    public static  <T>ServerResponse<T> createBySuccess(String msg,T data){
        return new  ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }
    public static  <T>ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }
    public static <T>ServerResponse<T> createByErrorMessage(String errorMessage){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMessage);
    }
    public static <T>ServerResponse<T> createByErrorCodeMessage(int errocode,String errorMessage){
        return new ServerResponse<T>(errocode,errorMessage);
    }
}
