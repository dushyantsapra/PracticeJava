package com.cassandraSampleCode;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

public class CRUDOperations {
    private String keySpaceName;
    CassandraConnector connector = null;

    public CRUDOperations() {
        connector = new CassandraConnector();
        keySpaceName = "cassandra_db";
    }

    public void createKeySpace() {
        String query = "CREATE KEYSPACE " + keySpaceName + " WITH replication "
                + "= {'class':'SimpleStrategy', 'replication_factor':1}; ";

        connector.connect(null, "localhost");

        ResultSet rows = connector.getSession().execute(query);
        for (Row row : rows) {
            System.out.println(row.getColumnDefinitions());
        }
        connector.close();
    }

    public void alterKeySpace() {
        String query = "ALTER KEYSPACE " + keySpaceName + " WITH replication " + "= {'class':'NetworkTopologyStrategy', 'datacenter1':3}"
                + "AND DURABLE_WRITES = true;";

        connector.connect(null, "localhost");

        ResultSet rows = connector.getSession().execute(query);
        for (Row row : rows) {
            System.out.println(row.getColumnDefinitions());
        }
        connector.close();
    }

    public void deleteKeySpace() {
        String query = "Drop KEYSPACE " + keySpaceName;

        connector.connect(null, "localhost");

        ResultSet rows = connector.getSession().execute(query);
        for (Row row : rows) {
            System.out.println(row.getColumnDefinitions());
        }
        connector.close();
    }

    public void createCoulmnFamily() {
        
    }

    public static void main(String[] args) {
//        "SELECT * FROM system_schema.keyspaces;"

        CRUDOperations crudOperations = new CRUDOperations();
        crudOperations.createKeySpace();

//        crudOperations.alterKeySpace();
//
//        crudOperations.deleteKeySpace();
    }
}
