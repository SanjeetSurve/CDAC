package app;

import java.io.File;

import org.apache.catalina.startup.Tomcat;

public class Program {
    
    @SuppressWarnings({"CallToPrintStackTrace", "UseSpecificCatch"})
    public static void main(String[] args) throws Exception {
        String dir = System.getProperty("java.io.tmpdir");
        var tomcat = new Tomcat();
        tomcat.setPort(Integer.parseInt(System.getProperty("server.http.port", "3232")));
        tomcat.setBaseDir(dir);
        tomcat.getHost().setAppBase(dir);
        
        // Check if the WAR file exists
        File warFile = new File("target/deploy.war");
        if (!warFile.exists()) {
            System.err.println("WAR file not found at: " + warFile.getAbsolutePath());
            System.exit(1);  // Exit the program if file not found
        }

        tomcat.addWebapp("", warFile.getAbsolutePath());
        
        // Add a shutdown hook to properly stop the server
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                tomcat.stop();
                tomcat.destroy();
                System.out.println("Tomcat server stopped successfully.");
            } catch (Exception e) {
                e.printStackTrace(); // Print stack trace for troubleshooting
            }
        }));
        
        tomcat.getConnector();
        tomcat.start();
        System.out.println("Tomcat server started on port: " + tomcat.getConnector().getPort());
        tomcat.getServer().await();
    }
}