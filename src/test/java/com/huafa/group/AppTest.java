package com.huafa.group;

import static org.junit.Assert.assertTrue;

import com.vmware.connection.BasicConnection;
import com.vmware.connection.ConnectedVimServiceBase;
import com.vmware.connection.SsoConnection;
import com.vmware.general.Connect;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    public static void main(String[] args) {
//        BasicConnection connection = new BasicConnection();
//        connection.setUrl("https://172.16.34.111:443/sdk");
//        connection.setUsername("admin");
//        connection.setPassword("P@ssw0rd");
//
//        System.out.println("bbb");
//        System.out.println(connection.isConnected());
//        System.out.println(connection.connect().getServiceContent().getRootFolder());
//        System.out.println(connection.isConnected());
        System.out.println("aaa");

        BasicConnection ss = new BasicConnection();
        ss.setUrl("https://172.16.34.111:443/sdk");
        ss.setUsername("admin");
        ss.setPassword("P@ssw0rd");
        ss.connect();
        System.out.println("bbb");


    }
}
