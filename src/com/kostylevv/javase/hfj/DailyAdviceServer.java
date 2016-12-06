package com.kostylevv.javase.hfj;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by vkostylev on 06/12/16.
 */
public class DailyAdviceServer {

    public static void main(String[] args) {
        DailyAdviceServer adviceServer = new DailyAdviceServer();
        adviceServer.go();
    }

    public void go () {
        try {
            ServerSocket socket = new ServerSocket(4242);

            while (true) {
                Socket sock = socket.accept();
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                writer.write(getAdvice());
                writer.close();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    private String getAdvice() {
        String[] advices = {"adv1", "adv2", "adv3", "adv4", "adv5", "adv6", "adv7", "adv8"};

        return advices[(int)(Math.random()*advices.length)];
    }
}
