package org.sheng.zookeeper.client.zkclient;

import lombok.extern.slf4j.Slf4j;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;

/**
 * @author shengxingyue, created on 2018/4/16
 */
@Slf4j
public class ZkClientFactory {

    public static final String ZK_HOST = "localhost:2181";
    public static final int DEFAULT_SESSION_TIMEOUT = 10000;
    public static final int DEFAULT_CONNECTION_TIMEOUT = 1000;

    public static ZkClient getZkClient() {
        ZkClient zkClient = new ZkClient(ZK_HOST, DEFAULT_SESSION_TIMEOUT, DEFAULT_CONNECTION_TIMEOUT, new SerializableSerializer());
        System.out.println("connected OK.");
        return zkClient;
    }
}
