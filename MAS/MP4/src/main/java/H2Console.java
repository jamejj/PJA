package MAS.MP4.src.main.java;

import org.h2.tools.Server;

public class H2Console {
    public static void main(String[] args) throws Exception {
        Server server = Server.createWebServer(
                "-web",
                "-webAllowOthers",
                "-webPort", "3000"
        ).start();

        System.out.println(server.getURL());
    }
}