package com.lyr.shirodemo.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Shiro中MD5+salt的工具类
 */
public class MD5 {

    /**
     * @param source 原密码
     * @param salt 盐
     * @param hashIterations 散列次数，即加密的次数
     * @return 加密之后的密码
     */
    public static String encrypt(String source,String salt,int hashIterations){
        Md5Hash md5Hash = new Md5Hash(source, salt, hashIterations);
        return md5Hash.toString();
    }

    // 测试
    public static void main(String[] args) {
        System.out.println(encrypt("3","salt",1024));
        System.out.println(encrypt("4","salt",1024));
    }

}
