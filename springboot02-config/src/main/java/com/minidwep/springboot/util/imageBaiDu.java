package com.minidwep.springboot.util;


import com.baidu.aip.imageclassify.AipImageClassify;
import org.json.JSONObject;

import java.util.HashMap;

public class imageBaiDu {
    //设置APPID/AK/SK
    public static final String APP_ID = "17877847";
    public static final String API_KEY = "IAR6N5GLVavFLe554RyYDswL";
    public static final String SECRET_KEY = "UP6lNhKulPqqcGnn9idIm7iyGpkmWl3T";

    public static void main(String[] args) {
        // 初始化一个AipImageClassify
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
//
//        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
////        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
////        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理
//
//        // 调用接口
//        String path = "C:\\Users\\minidwep\\Desktop\\yu.jpg";
//        JSONObject res = client.objectDetect(path, new HashMap<String, String>());
//        System.out.println(res.toString(2));
//

        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("baike_num", "5");


        // 参数为本地路径
        String image = "C:\\Users\\minidwep\\Desktop\\jitui.jpg";
        JSONObject res = client.advancedGeneral(image, options);
        System.out.println(res.toString(2));

//        // 参数为二进制数组
//        byte[] file = readFile("test.jpg");
//        res = client.advancedGeneral(file, options);
//        System.out.println(res.toString(2));

    }
}
