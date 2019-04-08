package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.baidu.aip.ocr.AipOcr;

public class ImageUtil {
	 //����APPID/AK/SK
    public static final String APP_ID = "15937393";
    public static final String API_KEY = "MRCWs4b01Or4rKeYRbmsAo8f";
    public static final String SECRET_KEY = "91wcMTjjWo4RhaxG14MpuehQdZFhe0SL";
    
    public static ImageDTO wordsDistinguish (String path){
    	 // ��ʼ��һ��AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("language_type", "CHN_ENG");//ʶ���������ͣ�Ĭ��ΪCHN_ENG
        options.put("detect_direction", "false");//�Ƿ���ͼ����Ĭ�ϲ����
        options.put("detect_language", "false");//�Ƿ������ԣ�Ĭ�ϲ����
        options.put("probability", "false");//�Ƿ񷵻�ʶ������ÿһ�е����Ŷ�,Ĭ�ϲ�����

        // ��ѡ�������������Ӳ���
        client.setConnectionTimeoutInMillis(2000);//�������ӵĳ�ʱʱ�䣨��λ�����룩
        client.setSocketTimeoutInMillis(60000);//ͨ���򿪵����Ӵ������ݵĳ�ʱʱ�䣨��λ�����룩

        // ��ѡ�����ô����������ַ, http��socket��ѡһ�����߾�������
        //client.setHttpProxy("proxy_host", proxy_port);  // ����http����
        //client.setSocketProxy("proxy_host", proxy_port);  // ����socket����

        // ��ѡ������log4j��־�����ʽ���������ã���ʹ��Ĭ������
        // Ҳ����ֱ��ͨ��jvm�����������ô˻�������
        //System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // ���ýӿ�
        JSONObject res = client.basicGeneral(path, options);
        System.out.println(res.toString(2));
        
        //JSONObject.fromObject();
        return JSON.parseObject(res.toString(2), ImageDTO.class);
   
    }
    public static void main(String[] args) {
    	//ImageDTO dto = wordsDistinguish("C:/Users/gs/Desktop/test.png");
    	//System.out.println(dto.toString());
    	SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//�������ڸ�ʽ
		String path = "F:/Verification/"+df.format(new Date())+".png";
		System.out.println(path);
	}
}
