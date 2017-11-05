package jp.ac.u_aizu.zudai.crazydreamer2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class UserProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private final int TOP = 0;

    private int[] buttonIds = new int[]{
            R.id.homeButton,
            R.id.userListButton,
            R.id.teamListButton,
            R.id.partyButton,
            R.id.profileButton
    };

    ImageButton[] button = new ImageButton[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);

        for (int i = 0; i < buttonIds.length; i++){
            button[i] = (ImageButton)findViewById(buttonIds[i]);
            button[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.homeButton:
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.userListButton:
                Intent intent2 = new Intent(this, UserListActivity.class);
                startActivity(intent2);
                break;
            case R.id.teamListButton:
                Intent intent3 = new Intent(this, TeamListActivity.class);
                startActivity(intent3);
                break;
            case R.id.partyButton:
                Intent intent4 = new Intent(this, ChatActivity.class);
                startActivity(intent4);
                break;
            case R.id.profileButton:
                break;
        }
    }
}
