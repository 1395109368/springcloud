package com.song.designmodel.creationalpatterns.buildmodule;

/**
 *  主类
 * @author songfeng
 * @date 2020/12/14
 */
public class MealBuilder {

  public static Meal prepareVegMeal() {
    Meal meal = new Meal();
    meal.addItem(new Akkd());
    return meal;
  }

  public static void main(String[] args) {
    MealBuilder.prepareVegMeal().showItems();
    System.out.println();

  }
}
