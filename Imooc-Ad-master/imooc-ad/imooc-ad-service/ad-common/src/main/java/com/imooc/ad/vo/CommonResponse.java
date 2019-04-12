package com.imooc.ad.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//get set
@Data
//无参构造函数
@NoArgsConstructor
//全参构造函数
@AllArgsConstructor
public class CommonResponse <T> implements Serializable{

	private Integer code;
	private String message;
	private T data;
	
	public CommonResponse(Integer code ,String message){
		this.code = code;
		this.message = message;
	}
}
