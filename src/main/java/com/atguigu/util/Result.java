package com.atguigu.util;

import java.io.Serializable;

//无论最后向客户端返回一个什么样的数据,都会将数据封装成一个统一的bean对象Result(结果bean)
public class Result implements Serializable {
    private boolean status;//响应状态，请求是成功还是失败(true/false)
    private String msg;//响应信息()
    private Object data;//成功之后返回的数据(数据类型是不同的,所以是Object)

    /**
     * 当进行结果查询时，直接调用get/set方法即可
     * @param status
     * @param msg
     * @param data
     * @return
     */

    //封装一个静态的方法
    public static Result ok(boolean status,String msg,Object data){
        Result result = new Result();
        result.setStatus(true);
        result.setData(data);//响应成功,返回数据
        return result;

    }

    public static Result error(boolean status,String msg,Object data){
        Result result = new Result();
        result.setStatus(false);
        result.setMsg(msg);//响应失败，返回信息
        return result;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public Result(boolean status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Result() {
    }
}
