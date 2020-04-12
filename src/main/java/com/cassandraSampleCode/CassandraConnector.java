package com.cassandraSampleCode;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class CassandraConnector {
    private Cluster cluster;

    private Session session;

    public void connect(Integer port, String... ipAddresses) {
        Cluster.Builder b = Cluster.builder().addContactPoints(ipAddresses);
        if (port != null) {
            b.withPort(port);
        }
        cluster = b.build();

        session = cluster.connect();
    }

    public Session getSession() {
        return this.session;
    }

    public void close() {
        session.close();
        cluster.close();
    }
}
