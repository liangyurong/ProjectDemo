package com.lyr.demo.utils;

import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import lombok.Data;

/**
 * @description 结果返回类
 * @author  lyr
 * @date  2021-05-07
 * 说明： 操作成功会返回0 ，操作会返回1
 */
@Data
public class Result extends HashMap<String, Object> {

    @ApiModelProperty(value = "0-成功 1-失败")
    private int code=0;
    @ApiModelProperty(value = "描述信息")
    private String msg="";
    @ApiModelProperty(value = "传递的数据")
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

