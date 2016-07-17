package com.awesomehuan.xwlbAnalyzer.thrift.proxy;

import org.apache.thrift.transport.TSocket;

/**
 * Created by huanyu on 16/7/11.
 */
public interface ConnectionProvider {
    /**
     * 取链接池中的一个链接
     * @return TSocket
     */
    TSocket getConnection();

    /**
     * 返回链接
     * @param socket
     */
    void returnCon(TSocket socket);
}
