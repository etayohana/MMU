package com.hit.auth;

import java.io.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public class AuthManager {
    private User u = new User();
    private HashSet<User> usersAndPassword;
    public HashSet<Session> sessionIds;

    private static AuthManager manager = null;

    private AuthManager() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fis = new FileInputStream("users.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            usersAndPassword = (HashSet<User>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static AuthManager getInstance() throws IOException, ClassNotFoundException {
        if (AuthManager.manager == null)
            AuthManager.manager = new AuthManager();

        return AuthManager.manager;
    }

    public String login(User user) {
        if (!usersAndPassword.get(user.getUser()).equals(user.getPassword()))
            return null;
        String session = UUID.randomUUID().toString() + "_" + System.currentTimeMillis();
        sessionIds.add(new Session(session));
        return session;
    }

    public boolean validateSession(String session) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, -1);
        long oneHourBack = calendar.getTimeInMillis();

        if(getMillisecondsFromSessionId(session) > oneHourBack ) return true;
        return false;
    }


    private long getMillisecondsFromSessionId(String sessionId) {
        return Long.parseLong(sessionId.split("_")[1]);
    }

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("users.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        HashSet<User> usersAndPassword = new HashSet<>();

        oos.writeObject(usersAndPassword);
        oos.flush();
        oos.close();
        fos.close();

    }}





//We Used Desing pattern (Singletone)

// Maor Elisha - 203814751