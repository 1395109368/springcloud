package com.song.abstrthread;

import lombok.extern.slf4j.Slf4j;

/**
 * @Auther: sf
 * @Date: 2020/8/4
 * @version: 1.0
 */
@Slf4j
public abstract class ThreadAbs extends Thread{
    /** 线程运行标志 */
    protected boolean runningFlag = true;
    protected abstract long execute() throws Throwable;

    @Override
    public void run() {
        Thread.currentThread().setName("BaseThread-" + Thread.getAllStackTraces());
        try{
            while (runningFlag) {
                try{
                    long temp= execute();

                    log.info("走到父类Thread");
                    if ( temp == 0) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();

                        }
                    }

                }catch(Throwable e){
                    e.printStackTrace();
                    log.error("处理过程中出现异常," + Thread.currentThread().getName() +e);

                }finally{
                    log.info("走到finally方法里");
                }
            }
        }finally{
           log.info("走到finally方法里");
        }
    }
    /** 线程运行标志 */
    public void setRunningFlag(boolean runningFlag) {
        this.runningFlag = runningFlag;
    }

    public boolean isRunningFlag() {
        return runningFlag;
    }

}
