package com.sftp;

import static com.sftp.SFTPRequest.SFTP_OPERATION.PUT;

public class SFTPMain {
    public static void main(String[] args) {
        System.out.println("SFTP TEST --> testSFTP()");
        SFTPRequest sftpRequest = new SFTPRequest(PUT, "10.186.0.220", 22, "/tmp/CENTRAL/abc",
                                                  "CENTRAL-BACKUP-1587040120817", "/bp2/data/",
                                                  "CENTRAL-BACKUP-1587040120817", "root", "G0t2BTuf");

        SFTPOperations sftpOperations = new SFTPOperations(sftpRequest);
        System.out.println("SFTP TEST --> testSFTP() --> sftpRequest PPOJO --> " + sftpRequest);
        sftpOperations.execute();
    }
}
