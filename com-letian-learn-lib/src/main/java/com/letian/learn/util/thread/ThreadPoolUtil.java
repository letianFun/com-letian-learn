package com.letian.learn.util.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author : lh
 * @version : 1.0.0
 * @description :
 * @date :  2019-08-04 18:23
 */
public class ThreadPoolUtil {

    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("sync-pool-%d").build();
    private static ExecutorService threadPool = new ThreadPoolExecutor(50, Integer.MAX_VALUE,
            100L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    public static void start(Runnable runnable) {
        threadPool.execute(runnable);
    }

}
