package ca.udem.maville;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static boolean isPortAvailable(int port) {
        try (ServerSocket ignored = new ServerSocket(port)) {
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        int port=7000;
        int maxPort=8000;

        while(port <= maxPort && !isPortAvailable(port)){
            port++;
        }

        if(port > maxPort){
            System.out.println("Aucun port libre trouvé entre 7000 et " + maxPort + ".");
            return;
        }

        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("/public", Location.CLASSPATH);
        }).start(port);

        System.out.println("Serveur établi sur http://localhost:" + port);

        app.get("/", context -> context.redirect("/index.html"));
    }
}