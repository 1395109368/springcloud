package com.song.excel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 司法安全隐患Dto类
 *
 * @author songfeng
 * @date 2020/11/05
 */
@Data
@ApiModel("司法安全隐患列表")
@AllArgsConstructor
@NoArgsConstructor
public class JudicialInsecurityDto implements Serializable {
  @ApiModelProperty("id")
  private Long id;
  @ApiModelProperty("身份证号")
  private String card;
  @ApiModelProperty("事件发生日期")
  private Date happenTime;
  @ApiModelProperty("执行单位")
  private String executeUnit;
  @ApiModelProperty("事件发生地点")
  private String happenSite;
  @ApiModelProperty("内容")
  private String content;
  @ApiModelProperty("执行人姓名")
  private String executeName;
  @ApiModelProperty("来源 1 - 聚众闹事 2 - 缠访绕访 3 - 扬言报复 ")
  private String source;
  @ApiModelProperty("类别")
  private String category;
  @ApiModelProperty("省份代码")
  private String provinceCode;
  @ApiModelProperty("省份")
  private String provinceName;
  @ApiModelProperty("市代码")
  private String cityCode;
  @ApiModelProperty("市名称")
  private String cityName;
  @ApiModelProperty("区代码")
  private String areaCode;
  @ApiModelProperty("区名称")
  private String areaName;
  @ApiModelProperty("备用")
  private String reserve;
  @ApiModelProperty("创建人")
  private Long createUser;
  @ApiModelProperty("创建时间")
  private Date createTime;
  @ApiModelProperty("修改人")
  private Long updateUser;
  @ApiModelProperty("修改时间")
  private Date updateTime;
  @ApiModelProperty("是否逻辑删除（0:否，1:是）")
  private Short deleted;

}