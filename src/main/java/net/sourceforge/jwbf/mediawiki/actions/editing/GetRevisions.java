package net.sourceforge.jwbf.mediawiki.actions.editing;

import net.sourceforge.jwbf.core.actions.Get;
import net.sourceforge.jwbf.core.actions.util.HttpAction;
import net.sourceforge.jwbf.core.actions.util.ProcessException;
import net.sourceforge.jwbf.mediawiki.actions.util.MWAction;

/**
 * Created with IntelliJ IDEA.
 * User: luiza
 * Date: 18/03/13
 * Time: 11:30
 */
public class GetRevisions extends MWAction {
// ------------------------------ FIELDS ------------------------------

    private final Get msg;
    private String articleName;
    private String json = null;

// --------------------------- CONSTRUCTORS ---------------------------

    public GetRevisions(String articleName) {
        this.articleName = articleName;
        this.msg = new Get(String.format("/api.php?action=query&prop=revisions&rvlimit=1000&titles=%s&format=json", articleName));
    }

// --------------------- GETTER / SETTER METHODS ---------------------

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface ContentProcessable ---------------------

    public HttpAction getNextMessage() {
        return this.msg;
    }

// --------------------- Interface ReturningText ---------------------

    @Override
    public String processReturningText(final String s, HttpAction ha) throws ProcessException {
        this.json = s;
        return null; //Sorry!
    }
}
