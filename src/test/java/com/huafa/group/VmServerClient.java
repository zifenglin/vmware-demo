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
 * @dateTime: 2020/11/11 17:12
 **/
public class VmServerClient extends VCenterSampleBase {

    private static final List<String> hostSystemAttributesArr = new ArrayList();

    private void setHostSystemAttributesList() {
        hostSystemAttributesArr.add("name");
        hostSystemAttributesArr.add("config.product.productLineId");
        hostSystemAttributesArr.add("summary.hardware.cpuMhz");
        hostSystemAttributesArr.add("summary.hardware.numCpuCores");
        hostSystemAttributesArr.add("summary.hardware.cpuModel");
        hostSystemAttributesArr.add("summary.hardware.uuid");
        hostSystemAttributesArr.add("summary.hardware.vendor");
        hostSystemAttributesArr.add("summary.hardware.model");
        hostSystemAttributesArr.add("summary.hardware.memorySize");
        hostSystemAttributesArr.add("summary.hardware.numNics");
        hostSystemAttributesArr.add("summary.config.name");
        hostSystemAttributesArr.add("summary.config.product.osType");
        hostSystemAttributesArr.add("summary.config.vmotionEnabled");
        hostSystemAttributesArr.add("summary.quickStats.overallCpuUsage");
        hostSystemAttributesArr.add("summary.quickStats.overallMemoryUsage");
        hostSystemAttributesArr.add("summary.runtime.powerState");
        hostSystemAttributesArr.add("summary.runtime.connectionState");
        hostSystemAttributesArr.add("network");
        hostSystemAttributesArr.add("capability.maxRunningVMs");
        hostSystemAttributesArr.add("vm");

    }

    @Action
    public List<Map> getHostProductDetails() throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg {
        this.setHostSystemAttributesList();
        Map var1 = this.getMOREFs.inContainerByType(this.serviceContent.getRootFolder(), "HostSystem", (String[]) hostSystemAttributesArr.toArray(new String[0]));
        Iterator var2 = var1.keySet().iterator();
        List<Map> vmHosts = new ArrayList<>();
        while (var2.hasNext()) {
            ManagedObjectReference var3 = (ManagedObjectReference) var2.next();
            Map host = (Map) var1.get(var3);
            vmHosts.add(host);
        }
        return vmHosts;
    }

    public List<Map> getVmProductDetails() throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg {
        List<String> names = new ArrayList<>();
        names.add("resourcePool");
        names.add("resourceConfig");
        names.add("name");
        names.add("summary.runtime.powerState");
        names.add("datastore");
        names.add("parent");
        names.add("summary.storage");
        names.add("summary.runtime.host");
        names.add("summary.runtime.host");
        names.add("storage.perDatastoreUsage");
        names.add("capability.diskSharesSupported");
        names.add("config.cpuAllocation.limit");
        names.add("config.cpuAllocation.reservation");
        names.add("config.cpuAllocation.shares.shares");
        names.add("config.datastoreUrl");
        names.add("config.extraConfig");
        names.add("config.guestFullName");
        names.add("config.hardware.memoryMB");
        names.add("config.hardware.numCPU");
        names.add("config.hardware.numCoresPerSocket");
        names.add("config.locationId");
        names.add("config.maxMksConnections");
        names.add("config.memoryAllocation.expandableReservation");
        names.add("config.memoryAllocation.limit");
        names.add("config.memoryAllocation.reservation");
        names.add("config.memoryAllocation.shares.level");
        names.add("config.memoryAllocation.shares.shares");
        names.add("storage.perDatastoreUsage");
        names.add("storage.timestamp");
        names.add("summary.config.instanceUuid");
        names.add("summary.quickStats.compressedMemory");
        names.add("summary.quickStats.consumedOverheadMemory");
        names.add("summary.quickStats.guestMemoryUsage");
        names.add("summary.quickStats.hostMemoryUsage");
        names.add("summary.quickStats.overallCpuDemand");
        names.add("summary.quickStats.overallCpuUsage");
        names.add("guest.ipAddress");
        names.add("network");


        Map var1 = this.getMOREFs.inContainerByType(this.serviceContent.getRootFolder(), "VirtualMachine", (String[]) names.toArray(new String[0]));
        Iterator var2 = var1.keySet().iterator();
        List<Map> vmList = new ArrayList<>();
        while (var2.hasNext()) {
            ManagedObjectReference var3 = (ManagedObjectReference) var2.next();
            Map host = (Map) var1.get(var3);
            vmList.add(host);
        }
        return vmList;
    }
}
