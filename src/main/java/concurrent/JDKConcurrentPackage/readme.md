该节介绍JDK并发包，主要包括三部分：
1.介绍同步控制工具，之前介绍的synchronized关键字就是同步的一种手段，在这里将看到更加丰富的多线程控制方法
2.介绍JDK对线程池的支持，使用线程池将能很大程度提高线程调度的性能
3.介绍JDK的一些并发容器，这些容器专为并行访问所设计，绝对的高效

3.1 多线程团队协作：同步控制
- 重入锁 ReentrantLock
- 重入锁的好搭档：Condition条件
- 允许多个线程同事访问：信号量 Semaphore
- 读写锁 ReadWriteLock
- 倒计时器 CountDownLatch
- 循环栅栏 CyclicBarrier
- 线程阻塞工具类 LockSupport

3.2 线程复用：线程池

3.3 不要重发发明轮子：JDK的并发容器