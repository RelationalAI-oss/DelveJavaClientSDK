package com.relationalai.client.api;

import com.relationalai.client.ApiException;
import com.relationalai.client.model.*;

public class ExtendedAPI extends DefaultApi{

    public ActionResult run_action(Connection conn, String name, Action action) throws ApiException {
        Transaction xact = new Transaction();
        xact.setMode(Transaction.ModeEnum.OPEN);
        xact.setDbname(conn.dbname);

        LabeledAction labeledAction = new LabeledAction();
        labeledAction.setName(name);
        labeledAction.setAction(action);
        xact.addActionsItem(labeledAction);

        TransactionResult response = this.transactionPost(xact);

        if (!response.getAborted() && response.getProblems().isEmpty()) {
            for (LabeledActionResult act : response.getActions()) {
                if (name.equals(act.getName())) {
                    ActionResult res = (ActionResult) act.getResult();
                    return res;
                }
            }
        }
        return null;
    }

    public boolean create_database(Connection conn, boolean overwrite) throws ApiException {
        Transaction xact = new Transaction();
        xact.setMode(overwrite ? Transaction.ModeEnum.CREATE_OVERWRITE : Transaction.ModeEnum.CREATE);
        xact.setDbname(conn.dbname);
        TransactionResult response = this.transactionPost(xact);

        return !response.getAborted() && response.getProblems().isEmpty();
    }

    public InstallActionResult install_source(Connection conn, String name, String path, String src_str) throws ApiException {
        Source src = new Source();
        src.setName(name);
        src.setPath(path);
        src.setValue(src_str);

        InstallAction action = new InstallAction();
        action.addSourcesItem(src);

        return (InstallActionResult) run_action(conn, "single", action);
    }

    public QueryActionResult query(Connection conn, String name, String path, String src_str, String out) throws ApiException {
        Source src = new Source();
        src.setName(name);
        src.setPath(path);
        src.setValue(src_str);

        QueryAction action = new QueryAction();
        action.setSource(src);
        action.addOutputsItem(out);

        return (QueryActionResult) run_action(conn, "single", action);
    }
}
