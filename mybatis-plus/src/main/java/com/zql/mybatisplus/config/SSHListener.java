package com.zql.mybatisplus.config;

import com.jcraft.jsch.JSchException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
@Slf4j
public class SSHListener implements ServletContextListener {

    private SSHConnection connection;

    public SSHListener() {
        super();
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("SSH初始化");
        try {
            connection = new SSHConnection();
        } catch (JSchException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("SSH关闭");
        connection.closeSSH();
    }
}
