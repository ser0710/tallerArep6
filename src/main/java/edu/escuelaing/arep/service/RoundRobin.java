package edu.escuelaing.arep.service;

import java.util.ArrayList;
import java.util.List;

public class RoundRobin {
    private List<String> serverList = new ArrayList<>();
    private int currentIndex;

    private static RoundRobin instance;

    private RoundRobin() {
        this.serverList.add("http://ec2-54-84-103-48.compute-1.amazonaws.com:4567");
        this.serverList.add("http://ec2-44-193-82-159.compute-1.amazonaws.com:4567");
        this.serverList.add("http://ec2-54-236-24-66.compute-1.amazonaws.com:4567");
    }

    public static RoundRobin getInstance(){
        if(instance == null){
            instance = new RoundRobin();
        }
        return instance;
    }

    public String getNextServer() {
        synchronized(serverList) {
            if (currentIndex >= serverList.size()) {
                currentIndex = 0;
            }

            String server = serverList.get(currentIndex);
            currentIndex++;

            return server;
        }
    }
}
