package com.awesomehuan.xwlbAnalyzer.thrift.proxy;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TTransport;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by huanyu on 16/7/11.
 */
public class ThriftClientProxy {

    private ConnectionManager connectionManager;

    public ConnectionManager getConnectionManager() {
        return connectionManager;
    }
    public void setConnectionManager(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }
    public Object getClient(Class clazz) {
        Object result = null;
        try {
            TTransport transport = connectionManager.getSocket();
            TProtocol protocol = new TBinaryProtocol(transport);
            Class client = Class.forName(clazz.getName() + "$Client");
            Constructor con = client.getConstructor(TProtocol.class);
            result = con.newInstance(protocol);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }
}
