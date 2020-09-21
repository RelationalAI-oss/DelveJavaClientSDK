package com.relationalai.client.api;

import com.relationalai.client.ApiException;
import com.relationalai.client.model.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LocalConnection extends Connection {
    private String dbName;
    private Transaction.ModeEnum defaultOpenMode;

    public LocalConnection(String dname) {
        super(DEFAULT_SCHEME, DEFAULT_HOST, DEFAULT_PORT);
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
            new DelveClient(this); //to register the connection with a client
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

    public boolean installSource(Source src) throws IOException, ApiException {
        setConnectionOnClient();
        return client.installSource(src);
    }

    public boolean installSource(String name, String srcStr) throws ApiException, IOException {
        setConnectionOnClient();
        return client.installSource(name, null, srcStr);
    }

    public boolean installSource(String name, String path, String srcStr) throws IOException, ApiException {
        setConnectionOnClient();
        return client.installSource(name, path, srcStr);
    }

    public boolean installSource(List<Source> srcList) throws IOException, ApiException {
        setConnectionOnClient();
        return client.installSource(srcList);
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

    public QueryActionResult query(
            String name,
            String path,
            String srcStr,
            List<Relation> inputs,
            List<String> outputs,
            List<String> persist,
            boolean isReadOnly,
            Transaction.ModeEnum mode
    ) throws ApiException {
        setConnectionOnClient();
        return client.query(name, path, srcStr,inputs, outputs, persist, isReadOnly, mode);
    }

    public QueryActionResult query(
            Source src,
            List<Relation> inputs,
            List<String> outputs,
            List<String> persist,
            boolean isReadOnly,
            Transaction.ModeEnum mode
    ) throws ApiException {
        setConnectionOnClient();
        return client.query(src, inputs, outputs, persist, isReadOnly, mode);
    }

    // TODO
    public void updateEdb(){
        setConnectionOnClient();
    }

    public LoadData jsonString(
            String data,
            Object key,
            FileSyntax syntax,
            FileSchema schema
    ) {
        setConnectionOnClient();
        return client.jsonString(data, key, syntax, schema);
    }

    public LoadData jsonFile(
            String filePath,
            Object key,
            FileSyntax syntax,
            FileSchema schema
    ) {
        setConnectionOnClient();
        return client.jsonFile(filePath, key, syntax, schema);
    }

    public LoadData csvString(
            String data,
            Object key,
            FileSyntax syntax,
            FileSchema schema
    ) {
        setConnectionOnClient();
        return client.csvString(data, key, syntax, schema);
    }

    public LoadData csvFile(
            String filePath,
            Object key,
            FileSyntax syntax,
            FileSchema schema
    ) {
        setConnectionOnClient();
        return client.csvFile(filePath, key, syntax, schema);
    }

    public boolean loadEdb(
            String rel,
            String contentType,
            String data,
            String path,
            Object key,
            FileSyntax syntax,
            FileSchema schema
    ) throws IOException, ApiException {
        setConnectionOnClient();
        return client.loadEdb(rel, contentType, data, path, key, syntax, schema);
    }

    public boolean loadEdb(String rel, LoadData value) throws IOException, ApiException {
        setConnectionOnClient();
        return client.loadEdb(rel, value);
    }

    public boolean loadCSV(
            String rel,
            String data,
            String path,
            Object key,
            FileSyntax syntax,
            FileSchema schema
    ) throws IOException, ApiException {
        setConnectionOnClient();
        return client.loadCSV(rel, data, path, key, syntax, schema);
    }

    public boolean loadJSON(
            String rel,
            String data,
            String path,
            Object key
    ) throws IOException, ApiException {
        setConnectionOnClient();
        return client.loadJSON(rel, data, path, key);
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
