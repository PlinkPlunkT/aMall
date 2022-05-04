package com.tien.amall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.tien.common.validator.ListValue;
import com.tien.common.validator.group.AddGroup;
import com.tien.common.validator.group.UpdateGroup;
import com.tien.common.validator.group.UpdateStatusGroup;
import lombok.Data;
import org.hibernate.validator.constraints.URL;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

/**
 * 品牌
 * 
 * @author AcmeTien
 * @email bhappy1314i@gmail.com
 * @date 2022-04-25 20:33:52
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@NotNull(message = "修改品牌必须指定品牌ID！", groups = {UpdateGroup.class})
	@Null(message = "新增品牌不能指定ID！", groups = {AddGroup.class})
	@TableId
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(message = "品牌名不能为空！", groups = {UpdateGroup.class, AddGroup.class})
	private String name;
	/**
	 * 品牌logo地址
	 */
	@URL(message = "logo 必须为 URL 地址！", groups = {UpdateGroup.class, AddGroup.class})
	@NotBlank(groups = {AddGroup.class})
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	@NotNull(groups = {AddGroup.class, UpdateStatusGroup.class})
	@ListValue(vals = {0, 1}, groups = {AddGroup.class, UpdateGroup.class, UpdateStatusGroup.class})
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z]$", message = "检索首字母必须是一个字母！")
	private String firstLetter;
	/**
	 * 排序
	 */
	@NotNull
	@Min(value = 0, message = "排序不能小于 0")
	private Integer sort;

}
