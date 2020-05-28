package com.hit.server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hit.auth.AuthManager;
import com.hit.auth.User;
import com.hit.dm.DataModel;
import com.hit.services.CacheUnitController;

import java.io.*;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.Map;

public class HandleRequest<T> implements Runnable {
    Socket socket;
    CacheUnitController<T> controller;
    public HandleRequest(java.net.Socket socket, CacheUnitController<T> controller){
        this.socket = socket;
        this.controller=controller;
    }

    @Override
    public void run() {
        String str;
        InputStream is = null;
        OutputStream os = null;

        try {
            is = socket.getInputStream();
            os = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Reader req;
        Writer res;
        Type ref;
        Request<DataModel<T>[]> request;
        Map<String, String> headers;

        while (true) {
            try {
                char[] buffer = new char[1000];
                req = new InputStreamReader(is);
                res = new OutputStreamWriter(os);
                ref = new TypeToken<Request<DataModel<T>[]>>() {}.getType();
                req.read(buffer);
                request = new Gson().fromJson(new String(buffer).trim(), ref);
                headers = request.getHeaders();
                if (headers.get("action").equals("LOGIN")) {
                    User user = new User();
                    user.setUser(headers.get("username"));
                    user.setPassword(headers.get("password")) ;
                    String sessionId = AuthManager.getInstance().login(user);
                    res.write(sessionId);
                    res.flush();
                } else if (headers.containsKey("sessionId")) {
                    String sessionId = headers.get("sessionId");

                    if (sessionId != null && AuthManager.getInstance().validateSession(sessionId)) {
                        if (headers.get("action").equals("DELETE")) {
                            if (controller.delete(request.getBody())) res.write("OK");
                            else res.write("Not OK");
                        }
                        if (headers.get("action").equals("GET")) {
                            res.write(controller.get(request.getBody()).toString());
                        }
                        if (headers.get("action").equals("UPDATE")) {
                            if (controller.update(request.getBody())) res.write("OK");
                            else res.write("Not OK");
                        }

                        res.flush();
                    } else {
                        res.write("No SessionId");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
