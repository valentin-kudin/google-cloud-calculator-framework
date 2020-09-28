package edu.epam.automatedtesting.google_cloud_calculator_testing_framework.main.service;

import edu.epam.automatedtesting.google_cloud_calculator_testing_framework.main.model.CloudServer;

public class CloudServerCreator {

    public static final String NUMBER_OF_INSTANCES = "testdata.cloudserver.numberofinstances";
    public static final String OPERATING_SYSTEM = "testdata.cloudserver.operatingsystem";
    public static final String MACHINE_CLASS = "testdata.cloudserver.machineclass";
    public static final String MACHINE_TYPE = "testdata.cloudserver.machinetype";
    public static final String NUMBER_OF_GPU = "testdata.cloudserver.numberofgpu";
    public static final String GPU_TYPE = "testdata.cloudserver.gputype";
    public static final String LOCAL_SSD = "testdata.cloudserver.localssd";
    public static final String DATACENTER_LOCATION = "testdata.cloudserver.datacenterlocation";
    public static final String COMMITTED_USAGE = "testdata.cloudserver.committedusage";

    public static CloudServer getCloudServer() {
        return CloudServer.newCloudServerBuilder()
                .setNumberOfInstances(TestDataReader.getTestData(NUMBER_OF_INSTANCES))
                .setOperatingSystem(TestDataReader.getTestData(OPERATING_SYSTEM))
                .setMachineClass(TestDataReader.getTestData(MACHINE_CLASS))
                .setMachineType(TestDataReader.getTestData(MACHINE_TYPE))
                .setNumberOfGPUs(TestDataReader.getTestData(NUMBER_OF_GPU))
                .setTypeOfGPU(TestDataReader.getTestData(GPU_TYPE))
                .setLocalSSD(TestDataReader.getTestData(LOCAL_SSD))
                .setDatacenterLocation(TestDataReader.getTestData(DATACENTER_LOCATION))
                .setCommittedUsage(TestDataReader.getTestData(COMMITTED_USAGE))
                .build();
    }
}
