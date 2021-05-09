package es.termibus;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import es.termibus.database.DBManager;
import es.termibus.gui.VentanaInicioSesion;
import es.termibus.gui.VentanaSalidas;

public class Main {	 // Execute server command: " mvn exec:java -Dexec.args="--server" "
	
	private static final String LOG_FILE = "src/main/resources/log4j.properties";
	
    public static final String BASE_URI = "http://localhost:8080/";
	private static Logger log;

    public static HttpServer startServer() {
    	
        final ResourceConfig rc = new ResourceConfig().packages(true, "es", "es.termibus", "es.termibus.server");
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) throws IOException {
  
    	log = Logger.getLogger(Main.class.getName());
    	
    	Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(LOG_FILE));
			PropertyConfigurator.configure(prop);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        if (args.length == 1 && args[0].equals("--server")) {
        	
            final HttpServer server = startServer();
            log.info(String.format(
                    "Jersey app started with WADL available at " + "%sapplication.wadl\n Hit enter to stop it...",
                    BASE_URI));
            
            System.in.read();
            server.shutdownNow();
        } else {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                    	new VentanaInicioSesion().setVisible(true);
                    } catch (Exception e) {
                    }
                }
            });
        }
    }
}
