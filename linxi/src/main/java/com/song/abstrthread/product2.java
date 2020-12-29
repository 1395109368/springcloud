package com.song.abstrthread;

import lombok.extern.slf4j.Slf4j;

/**
 * @Auther: sf
 * @Date: 2020/8/4
 * @version: 1.0
 */
@Slf4j
public class product2 extends  ThreadAbs {


    @Override
    protected long execute() throws Throwable {

        log.info("走到product2");

        return 0;
    }
}
