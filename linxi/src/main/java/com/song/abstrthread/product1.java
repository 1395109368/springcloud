package com.song.abstrthread;

import lombok.extern.slf4j.Slf4j;

/**
 * @Auther: sf
 * @Date: 2020/8/4
 * @version: 1.0
 */
@Slf4j
public class product1 extends  ThreadAbs {

    public static void main(String[] args) {
        ThreadAbs  c =new product2();
        c.start();

    }
    @Override
    protected long execute() throws Throwable {

        log.info("走到product1");

        return 0;
    }

}
