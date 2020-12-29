package com.song.linxi;

import io.swagger.annotations.ApiModel;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenpeng
 * @version 1.0
 * @date 2020/09/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "表格列名")
public class TableColumn {

  /**
   * 名称
   */
  private String label;

  /**
   * 类型
   */
  private String prop;

  /**
   * 子节点
   */
  private List<TableColumn> children = new ArrayList<>();

  public TableColumn(String label, String prop) {
    this.label = label;
    this.prop = prop;
  }
}