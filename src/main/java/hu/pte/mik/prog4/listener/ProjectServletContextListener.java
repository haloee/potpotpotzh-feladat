package hu.pte.mik.prog4.listener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
public class ProjectServletContextListener implements ServletContextListener {
    // Java system property key for JAAS config file
    private static final String JAVA_SECURITY_PROPERTY ="java.security.auth.login.config";

    // Called when the web application's context is initialized (i.e., on startup)
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Set the JAAS configuration file location if it's not already set
        if(System.getProperty(JAVA_SECURITY_PROPERTY) == null) {
            String jaasConfigFile = this.getClass().getClassLoader().getResource("jaas.config").getFile();
            System.setProperty(JAVA_SECURITY_PROPERTY, jaasConfigFile);
        }
    }
}
