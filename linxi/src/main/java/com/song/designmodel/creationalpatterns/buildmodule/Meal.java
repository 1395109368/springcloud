package com.song.designmodel.creationalpatterns.buildmodule;

import java.util.ArrayList;
import java.util.List;

/**
 * @author songfeng
 * @date 2020/12/14
 */
public class Meal {

  private List<Item> items = new ArrayList<>();

  public void addItem(Item item) {
    items.add(item);
  }

  public float getCost() {
    float cost = 0.0f;

    for (Item item : items) {
      cost += item.price();
    }

    return cost;
  }

  public void showItems() {
    for (Item item : items) {
      System.out.print("Item : " + item.name());
      System.out.println(", Price : " + item.price());
    }
  }



}
