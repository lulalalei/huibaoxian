package com.bb.hbx.utils;

import android.text.TextUtils;

/**
 * 作者：Created by Administrator on 2017/3/10 16:50
 * 邮箱：
 * 描述：验证一串数字是否是手机号码
 */
public class CheckPhoneNumUtils {
    /**
     * 验证手机格式
     */
    public static boolean isMobile(String number) {
    /*
    电信号段:133/153/180/181/189/177；
    联通号段:130/131/132/155/156/185/186/145/176；
    移动号段：134/135/136/137/138/139/150/151/152/157/158/159/182/183/184/187/188/147/178。
    总结起来就是第一位必定为1，第二位必定为3或5或8或7或4，其他位置的可以为0-9
    */
        String num = "[1][34578]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(number)) {
            return false;
        } else {
            //matches():字符串是否在给定的正则表达式匹配
            return number.matches(num);
        }
    }
}
