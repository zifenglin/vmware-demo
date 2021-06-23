package com.huafa.group;

import com.vmware.ops.api.client.Client;
import com.vmware.ops.api.model.auth.AuthToken;
import com.vmware.ops.api.model.auth.UsernamePassword;

/**
 * @author: lhw
 * @date: 2021/6/23 上午11:05
 **/
public class VmHostClient {

    public static void main(String[] args) {
//        Client client = Client.ClientConfig.builder()
//                .useJson()
//                .locale("en-us")
//                .timezone("PST")
//                .serverUrl("https://172.16.28.82/suite-api")
//                .verify("false")
//                .ignoreHostName(true)
//                .useInternalApis(true)
//                .build()
//                .newClient();
//
//        UsernamePassword userPwd = new UsernamePassword();
//        userPwd.setUsername("cmdb");
//        userPwd.setPassword("9z&EJDXsZ2uo6s4U");
//        AuthToken token = client.userAndAuthManagementClient().acquireToken(userPwd);
//        System.out.println(token);


        Client client = Client.ClientConfig.builder()
                .useJson()
                .locale("en-us")
                .timezone("PST")
                .serverUrl("https://172.16.34.111/suite-api")
                .verify("false")
                .ignoreHostName(true)
                .useInternalApis(true)
                .build()
                .newClient();

        UsernamePassword userPwd = new UsernamePassword();
        userPwd.setUsername("admin");
        userPwd.setPassword("P@ssw0rd");
        AuthToken token = client.userAndAuthManagementClient().acquireToken(userPwd);
        System.out.println(token);
    }
}
