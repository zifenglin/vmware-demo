package com.huafa.group;

import com.vmware.common.annotations.Action;
import com.vmware.host.AcquireSessionInfo;
import com.vmware.vim25.InvalidPropertyFaultMsg;
import com.vmware.vim25.RetrieveOptions;
import com.vmware.vim25.RuntimeFaultFaultMsg;

import java.io.IOException;
import java.util.Map;

/**
 * @author: admin
 * @dateTime: 2020/11/5 16:44
 **/
public class CustomAcquireSessionInfo extends AcquireSessionInfo {

    public void acquireSessionInfo() throws RuntimeFaultFaultMsg, InvalidPropertyFaultMsg, IOException {
        Map var1 = this.getMOREFs.inFolderByType(this.serviceContent.getRootFolder(), "HostSystem", new RetrieveOptions());
        if (null != var1) {
            System.out.println(var1);
            System.out.println(var1.size());
            var1.keySet().forEach(key -> {
                System.out.println(key);
            });
        }
    }

    @Action
    public void run() throws RuntimeFaultFaultMsg, IOException, InvalidPropertyFaultMsg {
        //super.propCollectorRef = this.serviceContent.getPropertyCollector();
        this.acquireSessionInfo();
    }
}
