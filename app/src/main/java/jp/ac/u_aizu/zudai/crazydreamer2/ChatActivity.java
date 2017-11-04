package jp.ac.u_aizu.zudai.crazydreamer2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.bassaer.chatmessageview.models.User;
import com.github.bassaer.chatmessageview.utils.ChatBot;
import com.github.bassaer.chatmessageview.views.ChatView;
import com.github.bassaer.chatmessageview.models.Message;

import java.util.Random;

/**
 * Created by user on 2017/11/04.
 */

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {

    User me;
    User you;

    private ChatView mChatView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        //user id
        int myId = 0;

        //user icon
        Bitmap myIcon = BitmapFactory.decodeResource(getResources(), R.drawable.face_sample);

        //user name
        String myName = "Taki";

        int yourId = 1;
        Bitmap yourIcon = BitmapFactory.decodeResource(getResources(), R.drawable.face_2);
        String yourName = "Mituha";

        me = new User(myId, myName, myIcon);
        you = new User(yourId, yourName, yourIcon);

        mChatView = (ChatView)findViewById(R.id.chat_view);

        //リスナセット
        mChatView.setOnClickSendButtonListener(this);
    }

    @Override
    public void onClick(View v){
        //New message
        Message message = new Message.Builder()
                .setUser(me)
                .setRightMessage(true)
                .setMessageText(mChatView.getInputText())
                .hideIcon(true)
                .build();

        //Set to chat view
        mChatView.send(message);
        //Reset edit text
        mChatView.setInputText("");

        //Receive message
        final Message receiveMessage = new Message.Builder()
                .setUser(you)
                .setRightMessage(false)
                .setMessageText(ChatBot.talk(me.getName(), message.getMessageText()))
                .build();

        //Demo bot
        int sendDelay = (new Random().nextInt(4) + 1) * 1000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mChatView.receive(receiveMessage);
            }
        }, sendDelay);

    }
}
