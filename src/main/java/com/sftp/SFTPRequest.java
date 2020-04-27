package com.sftp;

public class SFTPRequest {
    public static enum SFTP_OPERATION {GET, PUT}

    private SFTP_OPERATION operation;
    private String host;
    private int port;
    private String remoteLocation;
    private String remoteFileName;
    private String localFileLocation;
    private String localFileName;
    private String userName;
    private String password;

    public SFTPRequest(SFTP_OPERATION operation, String host, int port, String remoteLocation, String remoteFileName,
            String localFileLocation, String localFileName, String userName, String password) {
        this.operation = operation;
        this.host = host;
        this.port = port;
        this.remoteLocation = remoteLocation;
        this.remoteFileName = remoteFileName;
        this.localFileLocation = localFileLocation;
        this.localFileName = localFileName;
        this.userName = userName;
        this.password = password;
    }

    public SFTP_OPERATION getOperation() {
        return operation;
    }

    public void setOperation(SFTP_OPERATION operation) {
        this.operation = operation;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getRemoteLocation() {
        return remoteLocation;
    }

    public void setRemoteLocation(String remoteLocation) {
        this.remoteLocation = remoteLocation;
    }

    public String getRemoteFileName() {
        return remoteFileName;
    }

    public void setRemoteFileName(String remoteFileName) {
        this.remoteFileName = remoteFileName;
    }

    public String getLocalFileLocation() {
        return localFileLocation;
    }

    public void setLocalFileLocation(String localFileLocation) {
        this.localFileLocation = localFileLocation;
    }

    public String getLocalFileName() {
        return localFileName;
    }

    public void setLocalFileName(String localFileName) {
        this.localFileName = localFileName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SFTPRequest{" + "operation=" + operation + ", host='" + host + '\'' + ", port=" + port
                + ", remoteLocation='" + remoteLocation + '\'' + ", remoteFileName='" + remoteFileName + '\''
                + ", localFileLocation='" + localFileLocation + '\'' + ", localFileName='" + localFileName + '\''
                + ", userName='" + userName + '\'' + ", password='" + password + '\'' + '}';
    }
}
