package com.jr.level.level37.task3709.connectors;

import com.jr.level.level37.task3709.security.SecurityChecker;
import com.jr.level.level37.task3709.security.SecurityCheckerImpl;

public class SecurityProxyConnector implements Connector {
    private SimpleConnector connector;
    private SecurityChecker securityChecker;


    public SecurityProxyConnector(String s) {
        connector = new SimpleConnector(s);
        securityChecker = new SecurityCheckerImpl();
    }

    @Override
    public void connect() {
        if (securityChecker.performSecurityCheck()){
            connector.connect();
        }
    }
}
