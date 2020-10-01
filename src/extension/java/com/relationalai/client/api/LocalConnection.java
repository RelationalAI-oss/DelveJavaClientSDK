package com.relationalai.client.api;

import com.relationalai.client.ApiException;
import com.relationalai.client.builder.ConfigureArgs;
import com.relationalai.client.builder.DataLoaderArgs;
import com.relationalai.client.builder.InstallSourceArgs;
import com.relationalai.client.builder.QueryArgs;
import com.relationalai.client.model.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class LocalConnection extends Connection {
    private String dbName;
    private Transaction.ModeEnum defaultOpenMode;

    public LocalConnection(String dbName) {
        this(dbName, DEFAULT_OPEN_MODE, DEFAULT_SCHEME, DEFAULT_HOST, DEFAULT_PORT);
    }
    public LocalConnection(){}

    public LocalConnection(Connection conn) {
        this(conn.getDbName(), conn.getDefaultOpenMode(), conn.getScheme(), conn.getHost(), conn.getPort());
    }

    /**
     *
     * @param dbname database to execute transactions with
     * @param defaultOpenMode TransactionMode.OPEN`: How to open the database `dbname`
     * @param scheme `http`: The scheme used for connecting to a running server (e.g., `http`)
     * @param host `127.0.0.1`: The host of a running server
     * @param port `8010`: The port of a running server
     */
    public LocalConnection(
        String dbname,
        Transaction.ModeEnum defaultOpenMode,
        String scheme,
        String host,
        int port
    ) {
        super(scheme, host, port);
        this.defaultOpenMode = defaultOpenMode;
        this.dbName = dbname;

        if(this.getClass() == LocalConnection.class) {
            this.setClient(new DelveClient(this)); //to register the connection with a client
        } else {
            // If it's a subtype of `LocalConnection`, then its association to a `DelveClient`
            // is done separately in the leaf class.
        }
    }

    @Override
    public String getDbName() {
        return dbName;
    }

    @Override
    public Transaction.ModeEnum getDefaultOpenMode() {
        return defaultOpenMode;
    }

    public boolean cloneDatabase(String sourceDbName) throws ApiException {
        setConnectionOnClient();
        return client.cloneDatabase(sourceDbName);
    }

    public boolean createDatabase(boolean overwrite) throws ApiException {
        setConnectionOnClient();
        return client.createDatabase(overwrite);
    }

    public boolean installSource(InstallSourceArgs installSourceArgs) throws IOException, ApiException {
        setConnectionOnClient();
        return client.installSource(installSourceArgs);
    }

    public boolean deleteSource(List<String> srcNameList) throws ApiException {
        setConnectionOnClient();
        return client.deleteSource(srcNameList);
    }

    public boolean deleteSource(String srcName) throws ApiException {
        setConnectionOnClient();
        return client.deleteSource(srcName);
    }

    public Map<String, Source> listSource() throws ApiException {
        setConnectionOnClient();
        return client.listSource();
    }

    public Map<RelKey, Relation> query(QueryArgs queryArgs) throws ApiException {
        setConnectionOnClient();
        return client.query(queryArgs);
    }

    public boolean updateEdb(
            RelKey relKey,
            List<PairAnyValueAnyValue> updates,
            List<PairAnyValueAnyValue> delta
    ) throws ApiException {
        setConnectionOnClient();
        return client.updateEdb(relKey, updates, delta);
    }

    public LoadData jsonString(DataLoaderArgs dataLoaderArgs) {
        setConnectionOnClient();
        return client.jsonString(dataLoaderArgs);
    }

    public LoadData jsonFile(DataLoaderArgs dataLoaderArgs) {
        setConnectionOnClient();
        return client.jsonFile(dataLoaderArgs);
    }

    public LoadData csvString(DataLoaderArgs dataLoaderArgs) {
        setConnectionOnClient();
        return client.csvString(dataLoaderArgs);
    }

    public LoadData csvFile(DataLoaderArgs dataLoaderArgs) {
        setConnectionOnClient();
        return client.csvFile(dataLoaderArgs);
    }

    public boolean loadEdb(DataLoaderArgs dataLoaderArgs) throws IOException, ApiException {
        setConnectionOnClient();
        return client.loadEdb(dataLoaderArgs);
    }

    public boolean loadEdb(String relName, List<Object> columns) throws IOException, ApiException {
        setConnectionOnClient();
        return client.loadEdb(relName, columns);
    }

    public boolean loadEdb(String relName, Map<Object, Object> columns) throws ApiException {
        setConnectionOnClient();
        return client.loadEdb(relName, columns);
    }

    public boolean loadCSV(DataLoaderArgs dataLoaderArgs) throws IOException, ApiException {
        setConnectionOnClient();
        return client.loadCSV(dataLoaderArgs);
    }

    public boolean loadJSON(DataLoaderArgs dataLoaderArgs) throws IOException, ApiException {
        setConnectionOnClient();
        return client.loadJSON(dataLoaderArgs);
    }

    public List<RelKey> listEdb(String relName) throws ApiException {
        setConnectionOnClient();
        return client.listEdb(relName);
    }

    public List<RelKey> listEdb() throws ApiException {
        setConnectionOnClient();
        return client.listEdb();
    }

    public List<RelKey> deleteEdb(String relName) throws ApiException {
        setConnectionOnClient();
        return client.deleteEdb(relName);
    }

    public boolean enableLibrary(String srcName) throws ApiException {
        setConnectionOnClient();
        return client.enableLibrary(srcName);
    }

    public List<Relation> cardinality(String relName) throws ApiException {
        setConnectionOnClient();
        return client.cardinality(relName);
    }

    public List<AbstractProblem> collectProblems() throws ApiException {
        setConnectionOnClient();
        return client.collectProblems();
    }

    public boolean configure(ConfigureArgs configureArgs) throws ApiException {
        setConnectionOnClient();
        return client.configure(configureArgs);
    }
}
