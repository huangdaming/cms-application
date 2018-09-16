package com.hdm.cms.common.util;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;

public class PasswordUtil {

    /**
     * 生成md5加密密码
     * @param password 输入的明文密码
     * @return 加密后字符串
     */
    public static String makeMD5(String password) {
        String pwd = null;
        try {
            MessageDigest md;
            // 生成一个MD5加密计算摘要
            md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(password.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            pwd = new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pwd;
    }

    /**
     *
     * @param str
     * @return 返回不带等号base64编码
     */
    public static String base64Encode(String str){
    	return new String(Base64.encodeBase64(str.getBytes())).replaceAll("=", "_e_q_");
    }

    /**
     *
     * @param str
     * @return base64 解码 不带等号的
     */
    public static String base64Decode(String str){
    	return new String(Base64.decodeBase64(str.replaceAll("_e_q_", "=").getBytes()));
    }
}