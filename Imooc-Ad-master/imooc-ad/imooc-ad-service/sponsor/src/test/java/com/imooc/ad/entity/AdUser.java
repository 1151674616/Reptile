package com.imooc.ad.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.imooc.ad.constant.CommonStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ad_user")
public class AdUser {
	 	@Id //标注为主键
	    @GeneratedValue(strategy = GenerationType.IDENTITY) //表示主键生成策略，GenerationType.IDENTITY 是自增策略
	    @Column(name = "id", nullable = false) //不能为null 不可以为空
	    private Long id;

	    @Basic //标注为数据库表的基本属性 默认属性
	    	   //与之相反的 Transient 标注为不是数据库表的字段
	    @Column(name = "username", nullable = false)
	    private String username;

	    @Basic
	    @Column(name = "token", nullable = false)
	    private String token;

	    @Basic
	    @Column(name = "user_status", nullable = false)
	    private Integer userStatus;

	    @Basic
	    @Column(name = "create_time", nullable = false)
	    private Date createTime;

	    @Basic
	    @Column(name = "update_time", nullable = false)
	    private Date updateTime;

	    public AdUser(String username, String token) {

	        this.username = username;
	        this.token = token;
	        //拿到枚举
	        this.userStatus = CommonStatus.VALID.getStatus();
	        this.createTime = new Date();
	        this.updateTime = this.createTime;
	    }
}
