package com.lyr.demo.util;

import lombok.Data;
import java.util.HashMap;

/**
 * @description 结果返回类
 * @author  lyr
 * @date  2021-05-07
 */
@Data
public class Result extends HashMap<String, Object> {

    private int code=0; //0-成功 1-失败
    private String msg="";
    public Object data="";

    public Result(){
        super();
        this.put("code",code);
        this.put("msg",msg);
        this.put("data",data);
    }

    @Override
    public Result put(String key, Object value){
        super.put(key,value);
        return this;
    }

    public Result putData(Object data) {
        this.put("data", data);
        return this;
    }

    public Result putMsg(String msg) {
        this.put("msg", msg);
        return this;
    }

    public Result putCode(int code) {
        this.put("code", code);
        return this;
    }

}
