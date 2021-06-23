package com.huafa.group;

import com.vmware.connection.BasicConnection;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {

    public static final List<String> hostSystemAttributesArr = new ArrayList<>();

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    public static void main(String[] args) throws Exception {


        BasicConnection ss = new BasicConnection();
        ss.setUrl("https://172.16.30.10:443/sdk");
        ss.setUsername("cmdb@vsphere.local");
        ss.setPassword("9z&EJDXsZ2uo6s4U");

        VmServerClient client = new VmServerClient();
        client.setConnection(ss);
        client.connect();
           List<Map> list1 = client.getVmProductDetails();


       // client.getHostSystemDetail();
        client.disconnect();
    }


}
