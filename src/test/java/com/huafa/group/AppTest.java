package com.huafa.group;

import com.vmware.connection.BasicConnection;
import com.vmware.general.GetCurrentTime;
import com.vmware.general.GetHostName;
import com.vmware.host.AcquireSessionInfo;
import com.vmware.sso.client.utils.SecurityUtil;
import com.vmware.vim25.HostSystemInfo;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

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

    public static void main(String[] args) throws Exception {
        String path1 = "D:\\workspace\\vmware-demo\\src\\main\\resources\\cert\\sdk.key";
        String path2 = "D:\\workspace\\vmware-demo\\src\\main\\resources\\cert\\sdk.crt";
        File file = new File(path1);
        System.out.println(file.exists());
        SecurityUtil.loadFromFiles(path1, path2);

        //  test1();
        test2();
    }

    static void test1() throws Exception {


        BasicConnection ss = new BasicConnection();
        ss.setUrl("https://172.16.34.100:443/sdk");
        ss.setUsername("developer@vsphere.local");
        ss.setPassword("Huafadev@2020");

        GetCurrentTime bb = new GetCurrentTime();
        bb.setConnection(ss);
        bb.connect();
        bb.getCurrentTime();

        GetHostName cc = new GetHostName();
        cc.setConnection(ss);
        cc.connect();
        cc.printHostProductDetails();

//        CustomAcquireSessionInfo dd = new CustomAcquireSessionInfo();
//        dd.setConnection(ss);
//        dd.connect();
//        dd.run();

//        AcquireSessionInfo dd = new AcquireSessionInfo();
//        dd.setHostname("172.16.34.101");
//        dd.setConnection(ss);
//        dd.connect();
//        dd.run();

    }

    static void test2() throws Exception {
        BasicConnection ss = new BasicConnection();
        ss.setUrl("https://172.16.44.245:443/sdk");
        ss.setUsername("administrator@vsphere.local");
        ss.setPassword("VMware1!");

        GetCurrentTime bb = new GetCurrentTime();
        bb.setConnection(ss);
        bb.connect();
        bb.getCurrentTime();

        CustomHost cc = new CustomHost();
        cc.setConnection(ss);
        cc.connect();
        cc.printHostProductDetails();
//
//
//        AcquireSessionInfo dd = new AcquireSessionInfo();
//        dd.setHostname("172.16.44.246");
//        dd.setConnection(ss);
//        dd.connect();
//        dd.run();
    }
}
