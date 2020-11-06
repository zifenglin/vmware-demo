package com.huafa.group;

import com.vmware.common.annotations.Action;
import com.vmware.connection.VCenterSampleBase;
import com.vmware.vim25.InvalidPropertyFaultMsg;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFaultFaultMsg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author: admin
 * @dateTime: 2020/11/6 15:24
 **/
public class CustomHost extends VCenterSampleBase {
    private static final List<String> hostSystemAttributesArr = new ArrayList();

    public CustomHost() {
    }

    public void setHostSystemAttributesList() {
//        hostSystemAttributesArr.add("name");
//        hostSystemAttributesArr.add("config.product.productLineId");
//        hostSystemAttributesArr.add("summary.hardware.cpuMhz");
//        hostSystemAttributesArr.add("summary.hardware.numCpuCores");
//        hostSystemAttributesArr.add("summary.hardware.cpuModel");
//        hostSystemAttributesArr.add("summary.hardware.uuid");
//        hostSystemAttributesArr.add("summary.hardware.vendor");
//        hostSystemAttributesArr.add("summary.hardware.model");
//        hostSystemAttributesArr.add("summary.hardware.memorySize");
//        hostSystemAttributesArr.add("summary.hardware.numNics");
//        hostSystemAttributesArr.add("summary.config.name");
//        hostSystemAttributesArr.add("summary.config.product.osType");
//        hostSystemAttributesArr.add("summary.config.vmotionEnabled");
//        hostSystemAttributesArr.add("summary.quickStats.overallCpuUsage");
//        hostSystemAttributesArr.add("summary.quickStats.overallMemoryUsage");
//        hostSystemAttributesArr.add("summary.hardware.numCpuPkgs");
        hostSystemAttributesArr.add("summary.capacity");
        hostSystemAttributesArr.add("summary.freeSpace");
    }

    @Action
    public void printHostProductDetails() throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg {
        this.setHostSystemAttributesList();

        this.serviceContent.getRootFolder()

        Map var1 = this.getMOREFs.inContainerByType(this.serviceContent.getRootFolder(), "HostSystem", (String[]) hostSystemAttributesArr.toArray(new String[0]));
        Map test1 = this.getMOREFs.inFolderByType(this.serviceContent.getRootFolder(), "HostSystem");

        Iterator var2 = var1.keySet().iterator();

        while (var2.hasNext()) {
            ManagedObjectReference var3 = (ManagedObjectReference) var2.next();
            Map var4 = (Map) var1.get(var3);
            Iterator var5 = var4.keySet().iterator();

            while (var5.hasNext()) {
                String var6 = (String) var5.next();
                System.out.println(var6 + " : " + var4.get(var6));
            }

            System.out.println("\n\n***************************************************************");
        }

    }


}
