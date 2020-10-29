/*
 * Delve Client SDK
 * This is a Client SDK for Delve API
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: support@relational.ai
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.relationalai.client.api;

import com.relationalai.client.ApiException;
import com.relationalai.client.builder.*;
import com.relationalai.client.model.*;
import com.relationalai.cloudclient.model.ComputeData;
import com.relationalai.cloudclient.model.CreateComputeResponseProtocol;
import com.relationalai.cloudclient.model.DeleteComputeResponseProtocol;
import com.relationalai.cloudclient.model.DeleteComputeStatus;
import com.relationalai.cloudclient.model.ListComputesResponseProtocol;
import com.relationalai.infra.config.InfraMetadataConfig;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static com.relationalai.test.ExtendedTestCase.*;

/**
 * API tests for DefaultApi
 */
public class IntegrationTestsCommons {

    private final static String DATABSE_NAME = "testdb";

    public static LocalConnection createConnection() {
        return new LocalConnection(DATABSE_NAME);
    }

    public static boolean testInstallSource(LocalConnection conn, String name, String value, String path) throws IOException, ApiException {
        InstallSourceArgs args = InstallSourceArgs.builder()
                .name(name)
                .value(value)
                .build();
        return conn.installSource(args);
    }

    public static boolean testInstallSource(LocalConnection conn, Source src) throws IOException, ApiException {
        InstallSourceArgs args = InstallSourceArgs.builder()
                .sources(Arrays.asList(src))
                .build();
        return conn.installSource(args);
    }

    public static Map<RelKey, Relation> toRelation(String name, List<Object> columns, String key) {
        RelKey relKey = new RelKey()
                .name(name)
                .keys(Arrays.asList(key))
                .values(new ArrayList<>());

        Relation relation = new Relation()
                .columns(Arrays.asList(columns))
                .relKey(relKey);

        return new HashMap<>() {{ put(relKey, relation); }};
    }

    public static Map<RelKey, Relation> testQuery(LocalConnection conn, String srcStr, String output) throws ApiException {
        QueryArgs args = QueryArgs.builder()
                .value(srcStr)
                .outputs(Arrays.asList(output))
                .build();
        return conn.query(args);
    }

    public static Map<RelKey, Relation> toRelation(String name, Map<Object, Object> columns, List<String> keys) {
        Relation relation = new Relation();
        RelKey relKey = new RelKey();
        relKey.setName(name);
        List<Object> dataKeys = new ArrayList<Object>(columns.keySet());
        List<Object> dataValues = new ArrayList<Object>(columns.values());

        relKey.setKeys(keys);
        relKey.setValues(new ArrayList<>());

        relation.setRelKey(relKey);
        relation.columns(Arrays.asList(dataKeys, dataValues));
        return new HashMap<>() {{ put(relKey, relation); }};
    }

    public static void runAllTest() throws ApiException, IOException, InterruptedException {
        // create connection
        LocalConnection conn = createConnection();

        // status
        // ============================================================================
        assertTrue( conn.status() );

        // create database
        // ============================================================================
        assertTrue( conn.createDatabase(true) );
        assertThrows( RuntimeException.class, () -> conn.createDatabase(false) );

        // install source
        // ============================================================================
        assertTrue(testInstallSource(conn, "name", "def foo = 1", null));

        Source src3 = new Source().name("name").value("def foo = 1");
        assertTrue(testInstallSource(conn, src3));

        File tempfile = File.createTempFile("temp", null);
        Files.write(Path.of(tempfile.getPath()), "def foo = 1\n".getBytes(StandardCharsets.UTF_8));
        assertTrue(testInstallSource(conn, "name", null, tempfile.getPath()));

        // delete source
        // =============================================================================
        conn.createDatabase(true);
        assertTrue(conn.deleteSource("stdlib"));

        // list source
        conn.createDatabase(true);
        assertTrue(Arrays.asList("intrinsics", "stdlib", "ml").equals(new ArrayList<>(conn.listSource().keySet())));

        // query
        // ==============================================================================
        assertTrue(testQuery(conn, "def bar = 2", "bar").equals(
                toRelation("bar", Arrays.asList(2.0), "Int64")));
        assertTrue(testQuery(conn, "def p = {(1,); (2,); (3,)}", "p").equals(
                toRelation("p", Arrays.asList(1.0, 2.0, 3.0), "Int64")));
        assertTrue(testQuery(conn, "def p = {(1.1,); (2.2,); (3.4,)}", "p").equals(
                toRelation("p", Arrays.asList(1.1, 2.2, 3.4), "Float64")));
        assertTrue(testQuery(conn, "def p = {(parse_decimal[64, 2, \"1.1\"],); (parse_decimal[64, 2, \"2.2\"],); (parse_decimal[64, 2, \"3.4\"],)}", "p").equals(
                toRelation("p", Arrays.asList(1.1, 2.2, 3.4), "FixedPointDecimals.FixedDecimal{Int64,2}")));
        assertTrue(testQuery(conn, "def p = {(1, 5); (2, 7); (3, 9)}", "p").equals(
                toRelation("p", new HashMap<>(){{put(1.0, 5.0); put(2.0, 7.0); put(3.0, 9.0);}}, Arrays.asList("Int64", "Int64"))));

        // clone database
        // ===============================================================================
        LocalConnection conn2 = new LocalConnection(DATABSE_NAME + "2");
        LocalConnection conn3 = new LocalConnection(DATABSE_NAME + "3");

        conn.createDatabase(true);
        testInstallSource(conn, "name", "def x = {(1,); (2,); (3,)}", null);
        assertTrue(testQuery(conn, null, "x").equals(
                toRelation("x", Arrays.asList(1.0, 2.0, 3.0), "Int64")));

        // clone from conn to conn2
        assertTrue(conn2.cloneDatabase(conn.getDbName(), true));
        assertTrue(testQuery(conn2, null, "x").equals(
                toRelation("x", Arrays.asList(1.0, 2.0, 3.0), "Int64")));

        testInstallSource(conn, "name", "def x = {(1,); (2,); (3,); (4,)}", null);
        assertTrue(testQuery(conn, null, "x").equals(
                toRelation("x", Arrays.asList(1.0, 2.0, 3.0, 4.0), "Int64")));
        assertTrue(testQuery(conn2, null, "x").equals(
                toRelation("x", Arrays.asList(1.0, 2.0, 3.0), "Int64")));

        testInstallSource(conn2, "name", "def x = {(1,); (2,); (3,); (5,)}", null);
        assertTrue(testQuery(conn, null, "x").equals(
                toRelation("x", Arrays.asList(1.0, 2.0, 3.0, 4.0), "Int64")));
        assertTrue(testQuery(conn2, null, "x").equals(
                toRelation("x", Arrays.asList(1.0, 2.0, 3.0, 5.0), "Int64")));

        // DBConnection overload, cloning from conn to conn3
        assertTrue(conn3.cloneDatabase(conn.getDbName(), true));
        assertTrue(testQuery(conn, null, "x").equals(
                toRelation("x", Arrays.asList(1.0, 2.0, 3.0, 4.0), "Int64")));
        assertTrue(testQuery(conn2, null, "x").equals(
                toRelation("x", Arrays.asList(1.0, 2.0, 3.0, 5.0), "Int64")));
        assertTrue(testQuery(conn3, null, "x").equals(
                toRelation("x", Arrays.asList(1.0, 2.0, 3.0, 4.0), "Int64")));

        // Try clone from conn to conn2, without passing overwrite=true
        //assertThrows( RuntimeException.class, () -> conn2.cloneDatabase(conn.getDbName()) );
        assertTrue(testQuery(conn, null, "x").equals(
                toRelation("x", Arrays.asList(1.0, 2.0, 3.0, 4.0), "Int64")));
        assertTrue(testQuery(conn2, null, "x").equals(
                toRelation("x", Arrays.asList(1.0, 2.0, 3.0, 5.0), "Int64")));
        assertTrue(testQuery(conn3, null, "x").equals(
                toRelation("x", Arrays.asList(1.0, 2.0, 3.0, 4.0), "Int64")));

        // clone from conn2 to conn3, overwriting conn3 in the process
        conn3.cloneDatabase(conn2.getDbName(), true);
        assertTrue(testQuery(conn, null, "x").equals(
                toRelation("x", Arrays.asList(1.0, 2.0, 3.0, 4.0), "Int64")));
        assertTrue(testQuery(conn2, null, "x").equals(
                toRelation("x", Arrays.asList(1.0, 2.0, 3.0, 5.0), "Int64")));
        assertTrue(testQuery(conn3, null, "x").equals(
                toRelation("x", Arrays.asList(1.0, 2.0, 3.0, 5.0), "Int64")));

        // clone database
        // =========================================================================
        conn.createDatabase(true);
        conn2.createDatabase(true);

        testInstallSource(conn, "name", "def x = {(1,)}", null);
        testInstallSource(conn2, "name", "def x = {(2,)}", null);

        conn2.cloneDatabase(conn.getDbName(), true);
        assertTrue(testQuery(conn, null, "x").equals(
                toRelation("x", Arrays.asList(1.0), "Int64")));
        assertTrue(testQuery(conn2, null, "x").equals(
                toRelation("x", Arrays.asList(1.0), "Int64")));

        // update edb
        // ========================================================================
        conn.createDatabase(true);
        conn.loadEdb("p", Arrays.asList(1, 2, 3));
        Map<RelKey, Relation> qQuery = testQuery(conn, null, "p");
        assertTrue(qQuery.equals(toRelation("p", Arrays.asList(1.0, 2.0, 3.0), "Int64")));

        RelKey pRelKey = new ArrayList<RelKey>(qQuery.keySet()).get(0);
        List<Pair> updates = new ArrayList<>(){
            {
                add(new Pair(1, +1));
                add(new Pair(3, -1));
                add(new Pair(8, -1));
                add(new Pair(4, +1));
                add(new Pair(4, -1));
                add(new Pair(0, -1));
                add(new Pair(5, +1));
            }
        };
        assertTrue(conn.updateEdb(pRelKey, updates, null));

        // load_csv
        // ===========================================================================
        conn.createDatabase(true);
        CSVFileSchemaArgs csvFileSchemaArgs = CSVFileSchemaArgs.builder()
                .types(Arrays.asList("Int64", "Int64", "Int64"))
                .build();
        CSVFileSyntaxArgs csvFileSyntaxArgs = CSVFileSyntaxArgs.builder()
                .delim("|")
                .build();
        DataLoaderArgs dataLoaderArgs = DataLoaderArgs.builder()
                .rel("csv")
                .data("A,B,C\n1,2,3\n4,5,6")
                .schema(csvFileSchemaArgs)
                .build();

        assertTrue(conn.loadCSV(dataLoaderArgs));
        assertTrue(testQuery(conn, "def result = count[pos: csv[pos, :A]]", "result").equals(
                toRelation("result", Arrays.asList(2.0), "Int64")));

        dataLoaderArgs = DataLoaderArgs.builder()
                .rel("bar")
                .schema(csvFileSchemaArgs)
                .syntax(csvFileSyntaxArgs)
                .data("D|E|F\n1|2|3\n1|2|3\n1|2|3\n1|2|3")
                .build();

        assertTrue(conn.loadCSV(dataLoaderArgs));
        assertTrue(testQuery(conn, "def result = count[pos: bar[pos, :D]]", "result").equals(
                toRelation("result", Arrays.asList(4.0), "Int64")));

        PairSymbolString credentialsPair = new PairSymbolString();
        credentialsPair.setFirst("azure_sas_token");
        credentialsPair.setSecond("SAS_TOKEN");


        AzureIntegration azureIntegration = new AzureIntegration()
            .credentials(List.of(credentialsPair))
            .tenantId("<tenant_id>")
            .name("my_integration")
            .storageAllowedLocations(List.of("azure://myaccount.blob.core.windows.net/mycontainer1/mypath1/"))
            .storageBlockedLocations(List.of("azure://myaccount.blob.core.windows.net/mycontainer1/mypath1/sensitive/"));

        dataLoaderArgs = DataLoaderArgs.builder()
                .rel("baz")
                .schema(csvFileSchemaArgs)
                .syntax(csvFileSyntaxArgs)
                .integration(azureIntegration)
                .data("D|E|F\n1|2|3\n1|2|3\n1|2|3\n1|2|3")
                .build();

        assertTrue(conn.loadCSV(dataLoaderArgs));
        assertTrue(testQuery(conn, "def result = count[pos: baz[pos, :D]]", "result").equals(
                toRelation("result", Arrays.asList(4.0), "Int64")));

        // load json
        // =====================================================================
        conn.createDatabase(true);
        dataLoaderArgs = DataLoaderArgs.builder()
                .rel("json")
                .data("{ \"address\": { \"city\": \"Vancouver\", \"state\": \"BC\" } }")
                .build();
        conn.loadJSON(dataLoaderArgs);
        assertTrue(conn.listEdb().size() == 2);

        assertTrue(testQuery(conn, "def cityRes(x) = exists(pos: json(:address, :city, x))", "cityRes").equals(
                toRelation("cityRes", Arrays.asList("Vancouver"), "DelveFixedSizeStrings.FixedSizeString{100}")
        ));

        dataLoaderArgs = DataLoaderArgs.builder()
                .rel("json")
                .data("{ \"name\": \"Martin\", \"height\": 185.5 }")
                .build();
        assertTrue(conn.loadJSON(dataLoaderArgs));
        assertTrue(conn.listEdb().size() == 4);

        // list edb
        // =======================================================================
        conn.createDatabase(true);
        assertTrue(conn.listEdb().size() == 0);

        // enable library
        // =======================================================================
        conn.createDatabase(true);
        assertTrue(conn.enableLibrary("stdlib"));

        // cardinality
        // =======================================================================
        conn.createDatabase(true);
        QueryArgs queryArgs = QueryArgs.builder()
                .value("def p = {(1,); (2,); (3,)}")
                .persist(Arrays.asList("p"))
                .build();

        Map<RelKey, Relation> queryRes = conn.query(queryArgs);
        assertTrue(queryRes.equals(new HashMap<>()));

        List<Relation> cardRels = conn.cardinality("p");
        assertTrue(cardRels.size() == 1);

        Relation pCar = cardRels.get(0);
        assertTrue(pCar.equals(
                new Relation().relKey(new RelKey().name("p").keys(Arrays.asList("Int64")).values(new ArrayList<>())).columns(Arrays.asList(Arrays.asList(3.0)))));

        List<RelKey> deleteRes = conn.deleteEdb("p");
        assertTrue(deleteRes.size() == 1);
        assertTrue(deleteRes.get(0).equals(new RelKey().name("p").keys(Arrays.asList("Int64")).values(new ArrayList<>())));

        // collect problems
        // =====================================================================
        conn.createDatabase(true);
        assertTrue(conn.collectProblems().size() == 0);

        Source src = new Source().name("name").value("def foo =");
        InstallSourceArgs installSourceArgs = InstallSourceArgs.builder()
                .sources(Arrays.asList(src))
                .build();

        conn.installSource(installSourceArgs);
        assertTrue(conn.collectProblems().size() == 2);

        // Set options
        // =====================================================================
        conn.createDatabase(true);
        ConfigureArgs configureArgs = ConfigureArgs.builder()
                .debug(true)
                .build();
        assertTrue(conn.configure(configureArgs));
        configureArgs.setDebug(false);
        assertTrue(conn.configure(configureArgs));
    }

    public static String randomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    public static void managementTests(ManagementConnection api) throws ApiException, IOException {
        ListComputesResponseProtocol lres = api.listComputes();
        System.out.println(lres);

        String computeName = randomString();
        CreateComputeResponseProtocol cres = api.createCompute(computeName, RaiComputeSize.XS,
            InfraMetadataConfig.RaiRegion.US_EAST);
        System.out.println(cres);

        RAIComputeFilters filters = new RAIComputeFilters(null, Arrays.asList(computeName, "random"),
            Arrays.asList(RaiComputeSize.XS), null);
        lres = api.listComputes(filters);
        System.out.println(lres);
    }

}
