package com.wxq.mybatis.batch.core;

import com.wxq.mybatis.batch.exception.MybatisBatchException;
import java.sql.Statement;

/**
 * @param <M> type of the mapper class
 * @author weixiaoqiang
 * @date 2024/5/14
 **/
public interface BatchExecutor<M> {

    /**
     * get a proxy object generated by the mapper class
     * @return a mapper proxy object
     */
    M getMapper();

    /**
     * call {@link Statement#executeBatch()} to submit the batch
     * @throws MybatisBatchException if execution fails
     */
    void executeBatch() throws MybatisBatchException;

    /**
     * commit current transaction
     * @throws MybatisBatchException If the current transaction is managed by spring
     * or the transaction fails to be committed
     */
    void commit() throws MybatisBatchException;

    /**
     * rollback current transaction
     * @throws MybatisBatchException If the current transaction is already managed by spring
     * or the rollback of the transaction fails
     */
    void rollback() throws MybatisBatchException;
}
