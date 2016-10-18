package tat.bsu.ip;

import java.util.Random;

/**
 * Server entity thas has IP and ping as private fields
 */
public class Server {
    private String ip;
    private int ping;
    private final int maxPossiblePing = 500;
    private final int minPossiblePing = 20;

    /**
     * create Server entity and give for each server
     * ip address and random ping
     * @param ip
     */
    public Server(String ip) {
        Random random = new Random();
        this.ping = random.nextInt(maxPossiblePing - minPossiblePing + 1) + minPossiblePing;
        this.ip = ip;
    }

    /**
     * @return ip of the server
     */
    public String getIp() {
        return ip;
    }

    /**
     * @return ping of the server
     */
    public int getPing() {
        return ping;
    }
}
