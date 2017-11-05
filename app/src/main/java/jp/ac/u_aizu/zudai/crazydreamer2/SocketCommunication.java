package jp.ac.u_aizu.zudai.crazydreamer2;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by user on 2017/11/04.
 */

public class SocketCommunication {

    //Make new task for another thread
    ExecutorService executor = Executors.newSingleThreadExecutor();


    //public SocketCommunication(){}


    public void send(final String message){
        executor.submit(new Runnable() {
            @Override
            public void run() {
                sendMessage(message);
            }
        });
    }


    //send message to server
    private void sendMessage(String message){
        Socket connection = null;
        BufferedWriter writer = null;

        try {
            connection = new Socket("127.0.0.1", 8888);
            connection.setSoTimeout(1000);

            writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
            writer.write(message);

            Log.d("SocketCommunication","sending message done!");
        } catch (UnknownHostException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                writer.close();
                connection.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
