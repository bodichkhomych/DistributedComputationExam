package com.university.server;

import com.university.calculator.СomputationParams;
import com.university.calculator.Сomputation;
import com.university.calculator.Сomputate;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {
    private ServerSocket server = null;
    private Socket sock = null;
    private ObjectInputStream objectInputStream = null;
    private ObjectOutputStream objectOutputStream = null;
    private DataOutputStream out = null;
    private Сomputate calculator;

    public void start(int port) throws IOException, ClassNotFoundException {
        server = new ServerSocket(port);
        calculator = new Сomputation();
        while (true) {
            sock = server.accept();
            objectInputStream = new ObjectInputStream(sock.getInputStream());
            objectOutputStream = new ObjectOutputStream(sock.getOutputStream());
            while (true) {
                processQuery();
            }
        }
    }

    private void processQuery() throws IOException, ClassNotFoundException {
        СomputationParams params = (СomputationParams) objectInputStream.readObject();
        List<Double> result = calculator.calculate(params.a,params.xFom,params.xTo,params.step);
        objectOutputStream.writeObject(result);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Server server = new Server();
        server.start(12345);
    }

}