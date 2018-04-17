package org.sheng.zookeeper.client.zkclient;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;
import org.junit.Test;
import org.sheng.zookeeper.client.zkclient.model.User;

import java.io.IOException;

/**
 * @author shengxingyue, created on 2018/4/16
 */
public class Main {
    @Test
    public void createNodeTest() {
        ZkClient zkClient = ZkClientFactory.getZkClient();
        String path = zkClient.create("/zktest/1", "hello", CreateMode.PERSISTENT);
//        String path = zkClient.createPersistentSequential("/zktest/12", new User("xiaoming", 20));
        System.out.println("path : " + path);
    }

    @Test
    public void deleteNodeTest() {
        ZkClient zkClient = ZkClientFactory.getZkClient();
        boolean result = zkClient.delete("/zktest/1");
        if (result) {
            System.out.println("delete successful");
        }
    }

    @Test
    public void readNodeDataTest() {
        ZkClient zkClient = ZkClientFactory.getZkClient();
        User user = zkClient.readData("/zktest/120000000001");
        System.out.println(user);
    }

    @Test
    public void isNodeExistTest() {
        ZkClient zkClient = ZkClientFactory.getZkClient();
        boolean result = zkClient.exists("/zktest/120000000001");
        if (result) {
            System.out.println("node exist");
        }
    }

    @Test
    public void nodeChangeListenerTest() throws IOException {
        ZkClient zkClient = ZkClientFactory.getZkClient();
        zkClient.subscribeChildChanges("/zktest/120000000001", (parentPath, currentChilds) -> {
            System.out.printf("parentPath : %s%n", parentPath);
            System.out.printf("currentChilds : %s%n", currentChilds);
        });
        System.in.read();
    }

}
