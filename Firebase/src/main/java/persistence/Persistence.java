package persistence;

import java.io.IOException;
//import persistence.admin.Admin;

public interface Persistence {

    public DataOut put(long id) throws IOException;

    public DataIn get(long id) throws IOException;

}
