package com.hit.server;


import java.io.IOException;

import com.hit.util.CLI;

class CacheUnitServerDriver {

    public static void main(String[] args) throws IOException {

        CLI cli = new CLI(System.in, System.out);
        Server server = new Server();
        cli.addObserver(server);
        new Thread(cli).start();

    }

}
