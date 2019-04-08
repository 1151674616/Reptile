package util;

import java.util.ArrayList;
import java.util.List;

/*
 * 百度图片识别返回Json对象实体类
 * */
public class ImageDTO {
	public long log_id = 0; //唯一的log id，用于问题定位
	public List<ImageDTO_words_result> words_result =  new ArrayList<ImageDTO_words_result>();//定位和识别结果数组
	public int words_result_num = 0;//识别结果数，表示words_result的元素个数
	
	
	
	public long getLog_id() {
		return log_id;
	}
	public void setLog_id(long log_id) {
		this.log_id = log_id;
	}
	public List<ImageDTO_words_result> getWords_result() {
		return words_result;
	}
	public void setWords_result(List<ImageDTO_words_result> words_result) {
		this.words_result = words_result;
	}
	public int getWords_result_num() {
		return words_result_num;
	}
	public void setWords_result_num(int words_result_num) {
		this.words_result_num = words_result_num;
	}
	@Override
	public String toString() {
		return "ImageDTO [log_id=" + log_id + ", words_result=" + words_result + ", words_result_num="
				+ words_result_num + "]";
	}
	
	
	
}
