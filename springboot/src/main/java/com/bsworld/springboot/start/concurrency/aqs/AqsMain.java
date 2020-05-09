package com.bsworld.springboot.start.concurrency.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-04-20 14:40
 * description:
 *
 * aqs相关demo
 *
 * 1、公平锁非公平锁:
 *
 * {@link AbstractQueuedSynchronizer#unparkSuccessor(AbstractQueuedSynchronizer.Node)}
 *由代码可知，在释放时，其实是按照顺序释放的，按理来说应该是公平的，
 * 导致{@link java.util.concurrent.locks.ReentrantLock.NonfairSync}的原因是，在上一个线程释放锁的同时，
 * 很有可能有其他线程在同时竞争这把锁，也就是按顺序释放的线程与新进入的线程进行锁的竞争，这也是导致不公平的原因，
 * 而公平锁的判断是，如果当前线程不是首节点后的第一个node里的线程,则进入排队，非公平锁则会直接竞争，因为又涉及到排队操作，
 * 效率会比非公平锁要低一些
 *
 *
 * {@link AbstractQueuedSynchronizer#addWaiter(AbstractQueuedSynchronizer.Node)}
 * addWaiter就是一个在双端链表添加尾节点的操作，需要注意的是，双端链表的头结点是一个无参构造函数的头结点。
 * 这个CLH双向队列，head是虚拟出来的节点，尾结点是真实存在的等待线程
 *
 *
 *
 *
 */
public class AqsMain {

}
