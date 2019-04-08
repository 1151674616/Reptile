package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.baidu.aip.ocr.AipOcr;

public class ImageUtil {
	 //设置APPID/AK/SK
    public static final String APP_ID = "15937393";
    public static final String API_KEY = "MRCWs4b01Or4rKeYRbmsAo8f";
    public static final String SECRET_KEY = "91wcMTjjWo4RhaxG14MpuehQdZFhe0SL";
    
    public static ImageDTO wordsDistinguish (String path){
    	 // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("language_type", "CHN_ENG");//识别语言类型，默认为CHN_ENG
        options.put("detect_direction", "false");//是否检测图像朝向，默认不检测
        options.put("detect_language", "false");//是否检测语言，默认不检测
        options.put("probability", "false");//是否返回识别结果中每一行的置信度,默认不返回

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);//建立连接的超时时间（单位：毫秒）
        client.setSocketTimeoutInMillis(60000);//通过打开的连接传输数据的超时时间（单位：毫秒）

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        //System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        JSONObject res = client.basicGeneral(path, options);
        System.out.println(res.toString(2));
        
        //JSONObject.fromObject();
        return JSON.parseObject(res.toString(2), ImageDTO.class);
   
    }
    public static void main(String[] args) {
    	//ImageDTO dto = wordsDistinguish("C:/Users/gs/Desktop/test.png");
    	//System.out.println(dto.toString());
    	SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		String path = "F:/Verification/"+df.format(new Date())+".png";
		System.out.println(path);
	}
}
