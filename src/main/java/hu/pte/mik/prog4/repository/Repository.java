package hu.pte.mik.prog4.repository;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
public abstract class Repository {
    private static final String JNDI_DATASOURCE_NAME = "jdbc/pot-pot-potZH-MariaDB";
    private static final String ROOT_CONTEXT = "java:comp/env";

    private static DataSource dataSource;

    protected Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    private static DataSource getDataSource() {
        try {
            if (dataSource == null) {
                Context context = new InitialContext();
                Context ctx = (Context) context.lookup(ROOT_CONTEXT);
                dataSource = (DataSource) ctx.lookup(JNDI_DATASOURCE_NAME);
            }

            return dataSource;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }
}
