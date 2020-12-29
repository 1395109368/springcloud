package com.song.linxi;

/**
 * @author songfeng
 * @date 2020/10/09
 */
public enum TestEnum {

  COLOR("BLUE");

  private String name;

  TestEnum(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }}
