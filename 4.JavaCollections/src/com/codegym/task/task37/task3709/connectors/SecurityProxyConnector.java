package com.codegym.task.task37.task3709.connectors;

import com.codegym.task.task37.task3709.security.SecurityChecker;

public class SecurityProxyConnector implements Connector {
    private SimpleConnector connector;
    private SecurityChecker checker = new SecurityChecker() {
        @Override
        public boolean performSecurityCheck() {
            return false;
        }
    };
    public SecurityProxyConnector(String resourceString) {
        connector = new SimpleConnector(resourceString);
    }



    @Override
    public void connect() {
        if(checker.performSecurityCheck())
            connector.connect();

    }
}
