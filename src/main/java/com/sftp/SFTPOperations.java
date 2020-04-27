package com.sftp;

import com.jcraft.jsch.*;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import static com.jcraft.jsch.ChannelSftp.OVERWRITE;

public class SFTPOperations {
    private SFTPRequest request;

    private Session jschSession;

    public SFTPOperations(SFTPRequest request) {
        this.request = request;
    }

    private ChannelSftp sftpConnect() throws JSchException {
        System.out.println("INSIDE setupJsch()");
        JSch jsch = new JSch();
        jschSession = jsch.getSession(request.getUserName(), request.getHost(), request.getPort());
        jschSession.setPassword(request.getPassword());

        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        jschSession.setConfig(config);

        jschSession.connect();
        System.out.printf("INSIDE setupJsch() --> Session Connected");
        return (ChannelSftp) jschSession.openChannel("sftp");
    }

    public FutureTask<Boolean> sftpPut() {
        FutureTask<Boolean> sftpProgressTask = null;
        ChannelSftp channelSftp = null;
        try {
            channelSftp = sftpConnect();
            System.out.printf("channelSftp PUT--> " + channelSftp);
            channelSftp.connect();
            try {
                SftpProgressMonitor monitor = new SftpProgressMonitor();
                sftpProgressTask = new FutureTask(monitor);
                Thread t = new Thread(sftpProgressTask);
                t.start();

                channelSftp
                        .put(request.getLocalFileLocation() + request.getLocalFileName(), request.getRemoteLocation(),
                             monitor, OVERWRITE);
            } catch (SftpException e) {
                e.printStackTrace();
            }
        } catch (JSchException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (jschSession != null)
                jschSession.disconnect();
        }
        return sftpProgressTask;
    }

    public FutureTask<Boolean> sftpGet() {
        System.out.println("SFTP TEST --> sftpGet()");
        FutureTask<Boolean> sftpProgressTask = null;
        ChannelSftp channelSftp = null;
        try {
            channelSftp = sftpConnect();
            System.out.println("SFTP TEST --> sftpGet() --> channelSftp --> " + channelSftp);
            channelSftp.connect();
            System.out.println("SFTP TEST --> sftpGet() --> channelSftp connected");
            try {
                SftpProgressMonitor monitor = new SftpProgressMonitor();
                sftpProgressTask = new FutureTask(monitor);
                Thread t = new Thread(sftpProgressTask);
                t.start();
                System.out.println("SFTP TEST --> sftpGet() --> CD --> " + request.getRemoteLocation());
                channelSftp.cd(request.getRemoteLocation());
                System.out.println("SFTP TEST --> sftpGet() --> going to download");
                channelSftp.get(request.getRemoteFileName(), request.getLocalFileLocation(), monitor, OVERWRITE);
            } catch (SftpException e) {
                e.printStackTrace();
            }
        } catch (JSchException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (jschSession != null)
                jschSession.disconnect();
        }
        return sftpProgressTask;
    }

    public boolean execute() {
        System.out.println("SFTP TEST --> execute() -> " + request);
        switch (request.getOperation()) {
        case GET:
            System.out.println("SFTP TEST --> execute() --> Calling get");
            sftpGet();
            break;
        case PUT:
            sftpPut();
            break;
        }
        return false;
    }

    public class SftpProgressMonitor implements com.jcraft.jsch.SftpProgressMonitor, Callable<Boolean> {
        long count = 0;
        long max = 0;

        public void init(int op, String src, String dest, long max) {
            this.max = max;
            count = 0;
            percent = -1;
        }

        private long percent = -1;

        public boolean count(long count) {
            this.count += count;

            if (percent >= this.count * 100 / max) {
                return true;
            }
            percent = this.count * 100 / max;
            System.out.println("SFTP TEST --> Completed " + this.count + "(" + percent + "%) out of " + max + ".");
            synchronized (this) {
                notifyAll();
            }
            return true;
        }

        public void end() {
            System.out.println("SFTP TEST --> File Operation Complete");
        }

        @Override
        public Boolean call() throws Exception {
            if (percent < 100) {
                synchronized (this) {
                    wait();
                }
            }
            return true;
        }
    }
}
