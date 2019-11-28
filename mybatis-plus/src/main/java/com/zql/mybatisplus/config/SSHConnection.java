package com.zql.mybatisplus.config;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.util.Properties;

public class SSHConnection {

    private final static int LOCAL_PORT = 3307;
    private final static String MYSQL_REMOTE_SERVER = "54.199.136.117";
    private final static int REMOTE_PORT = 7384;
    private final static int SSH_REMOTE_PORT = 22;
    private final static String SSH_USER = "dboard";
    private final static String SSH_PASSWORD = "nKRVgr9P4zunQeRvMwdjXT8q";
    private final static String SSH_REMOTE_SERVER = "47.75.250.235";

    private Session session;

    public void closeSSH() {
        session.disconnect();
    }

    public SSHConnection() throws JSchException {
        JSch jsch = null;

        jsch = new JSch();

        session = jsch.getSession(SSH_USER, SSH_REMOTE_SERVER, SSH_REMOTE_PORT);

        session.setPassword(SSH_PASSWORD);

        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);

        session.connect(); //ssh connection established!

        session.setPortForwardingL(LOCAL_PORT, MYSQL_REMOTE_SERVER, REMOTE_PORT);

    }
}
