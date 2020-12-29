package com.song.linxi;

/**
 * @Auther: sf
 * @Date: 2020/6/20
 * @version: 1.0
 */
public class Danli {

  private static Danli instaince;

  private Danli() {

  }

  public static synchronized Danli getInstance2() {
    if (instaince == null) {
      return instaince = new Danli();
    }
    return instaince;
  }

  private static Danli cc = new Danli();

  public static Danli getinstaince() {
    return cc;
  }

  //预示着这个对象可见性
  private static volatile Danli jj = null;

  public static Danli getInstance() {
    if (jj == null) {
      synchronized (Danli.class) {
        if (jj == null) {
          return jj = new Danli();
        }
      }

    }
    return jj;

  }

}
