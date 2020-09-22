package com.relationalai.client.api;

import com.relationalai.client.ApiException;
import com.relationalai.client.builder.DataLoader;
import com.relationalai.client.builder.SourceInstall;
import com.relationalai.client.builder.Query;
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

    public LocalConnection(Connection conn) {
        this(conn.getDbName(), conn.getDefaultOpenMode(), conn.getScheme(), conn.getHost(), conn.getPort());
    }

    public LocalConnection(
            String dbname,
            Transaction.ModeEnum defaultOpenMode,
            String scheme,
            String host,
            int port) {
        super(scheme, host, port);
        this.defaultOpenMode = defaultOpenMode;
        this.dbName = dbname;

        if(this.getClass() == LocalConnection.class) {
            client = new DelveClient(this); //to register the connection with a client
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

    public boolean branchDatabase(String sourceDbName) throws ApiException {
        setConnectionOnClient();
        return client.branchDatabase(sourceDbName);
    }

    public boolean createDatabase(boolean overwrite) throws ApiException {
        setConnectionOnClient();
        return client.createDatabase(overwrite);
    }

    public boolean installSource(SourceInstall sourceInstall) throws IOException, ApiException {
        setConnectionOnClient();
        return client.installSource(sourceInstall);
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

    public QueryActionResult query(Query query) throws ApiException {
        setConnectionOnClient();
        return client.query(query);
    }

    public boolean updateEdb(
            RelKey relKey,
            List<PairAnyValueAnyValue> updates,
            List<PairAnyValueAnyValue> delta
    ) throws ApiException {
        setConnectionOnClient();
        return client.updateEdb(relKey, updates, delta);
    }

    public LoadData jsonString(DataLoader dataLoader) {
        setConnectionOnClient();
        return client.jsonString(dataLoader);
    }

    public LoadData jsonFile(DataLoader dataLoader) {
        setConnectionOnClient();
        return client.jsonFile(dataLoader);
    }

    public LoadData csvString(DataLoader dataLoader) {
        setConnectionOnClient();
        return client.csvString(dataLoader);
    }

    public LoadData csvFile(DataLoader dataLoader) {
        setConnectionOnClient();
        return client.csvFile(dataLoader);
    }

    public boolean loadEdb(DataLoader dataLoader) throws IOException, ApiException {
        setConnectionOnClient();
        return client.loadEdb(dataLoader);
    }

    public boolean loadCSV(DataLoader dataLoader) throws IOException, ApiException {
        setConnectionOnClient();
        return client.loadCSV(dataLoader);
    }

    public boolean loadJSON(DataLoader dataLoader) throws IOException, ApiException {
        setConnectionOnClient();
        return client.loadJSON(dataLoader);
    }

    public List<RelKey> listEdb(String relName) throws ApiException {
        setConnectionOnClient();
        return client.listEdb(relName);
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
    public List<AbstractProblem> collectProblems(String relName) throws ApiException {
        setConnectionOnClient();
        return client.collectProblems(relName);
    }

    public boolean configure(
            boolean debug,
            boolean debugTrace,
            boolean broken,
            boolean silent,
            boolean abortOnError
    ) throws ApiException {
        setConnectionOnClient();
        return client.configure(debug, debugTrace, broken, silent, abortOnError);
    }
}
