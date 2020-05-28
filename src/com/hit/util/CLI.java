package com.hit.util;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Observable;
import java.util.Scanner;

public class CLI extends Observable implements Runnable
{
    InputStream in;
    OutputStream out;
    Scanner reader;

    public CLI(InputStream in , OutputStream out)
    {
        reader = new Scanner (new InputStreamReader(in));
        this.in = in;
        this.out = out;
    }

    @Override
    public void run()
    {

        System.out.println("Please enter Command:");
        String UserInput;
        while (true)
        {
            UserInput = reader.nextLine().toLowerCase();
            switch (UserInput)
            {
                case "start":
                {

                    setChanged();
                    notifyObservers(UserInput);
                    break;
                }
                case "shutdown":
                {
                    setChanged();
                    notifyObservers(UserInput);
                    break;
                }
                default:
                {
                    System.out.println("Please enter start / shutdown only");
                    break;
                }
            }
        }

    }
}