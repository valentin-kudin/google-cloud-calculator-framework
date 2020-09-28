package edu.epam.automatedtesting.google_cloud_calculator_testing_framework.main.model;

import java.util.Objects;

public class CloudServer {

    private String numberOfInstances;
    private String operatingSystem;
    private String machineClass;
    private String machineType;
    private String numberOfGPUs;
    private String typeOfGPU;
    private String localSSD;
    private String datacenterLocation;
    private String committedUsage;

    private CloudServer() {

    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public void setMachineClass(String machineClass) {
        this.machineClass = machineClass;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public String getTypeOfGPU() {
        return typeOfGPU;
    }

    public void setTypeOfGPU(String typeOfGPU) {
        this.typeOfGPU = typeOfGPU;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CloudServer that = (CloudServer) o;
        return Objects.equals(numberOfInstances, that.numberOfInstances) &&
                Objects.equals(operatingSystem, that.operatingSystem) &&
                Objects.equals(machineClass, that.machineClass) &&
                Objects.equals(machineType, that.machineType) &&
                Objects.equals(numberOfGPUs, that.numberOfGPUs) &&
                Objects.equals(typeOfGPU, that.typeOfGPU) &&
                Objects.equals(localSSD, that.localSSD) &&
                Objects.equals(datacenterLocation, that.datacenterLocation) &&
                Objects.equals(committedUsage, that.committedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, operatingSystem, machineClass, machineType, numberOfGPUs, typeOfGPU, localSSD, datacenterLocation, committedUsage);
    }

    @Override
    public String toString() {
        return "\nGoogleCloudServer build:" +
                "\n\tNumber Of Instances: " + numberOfInstances +
                "\n\tOperating System: " + operatingSystem +
                "\n\tMachine Class: " + machineClass +
                "\n\tMachine Type: " + machineType +
                "\n\tNumber Of GPUs: " + numberOfGPUs +
                "\n\tType Of GPU: " + typeOfGPU +
                "\n\tLocal SSD: " + localSSD +
                "\n\tDatacenter Location: " + datacenterLocation +
                "\n\tCommitted Usage: " + committedUsage;
    }

    public static CloudServerBuilder newCloudServerBuilder() {
        return new CloudServer().new CloudServerBuilder();
    }

    public class CloudServerBuilder {

        private CloudServer newCloudServer;

        private CloudServerBuilder() {
            newCloudServer = new CloudServer();
        }

        public CloudServerBuilder setNumberOfInstances(String numberOfInstances) {
            newCloudServer.setNumberOfInstances(numberOfInstances);
            return this;
        }

        public CloudServerBuilder setOperatingSystem(String operatingSystem) {
            newCloudServer.setOperatingSystem(operatingSystem);
            return this;
        }

        public CloudServerBuilder setMachineClass(String machineClass) {
            newCloudServer.setMachineClass(machineClass);
            return this;
        }

        public CloudServerBuilder setMachineType(String machineType) {
            newCloudServer.setMachineType(machineType);
            return this;
        }

        public CloudServerBuilder setNumberOfGPUs(String numberOfGPUs) {
            newCloudServer.setNumberOfGPUs(numberOfGPUs);
            return this;
        }

        public CloudServerBuilder setTypeOfGPU(String typeOfGPU) {
            newCloudServer.setTypeOfGPU(typeOfGPU);
            return this;
        }

        public CloudServerBuilder setLocalSSD(String localSSD) {
            newCloudServer.setLocalSSD(localSSD);
            return this;
        }

        public CloudServerBuilder setDatacenterLocation(String datacenterLocation) {
            newCloudServer.setDatacenterLocation(datacenterLocation);
            return this;
        }

        public CloudServerBuilder setCommittedUsage(String committedUsage) {
            newCloudServer.setCommittedUsage(committedUsage);
            return this;
        }

        public CloudServer build() {
            return newCloudServer;
        }
    }
}
