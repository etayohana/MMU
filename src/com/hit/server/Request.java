package com.hit.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;

class Request<T> {
    private Map<String, String> headers;
    private T body;

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    @SuppressWarnings({ "resource" })
    public static void main(String argv[]) throws Exception {
        String choose;
        Socket clientSocket = new Socket("localhost",12345);
        Scanner inFromUser = new Scanner(System.in);
        ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        while (true) {
            System.out.println("Please give me the path of your json file");//choose Category
            String path=inFromUser.nextLine();
        }
    }


}