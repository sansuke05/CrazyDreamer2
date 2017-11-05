package jp.ac.u_aizu.zudai.crazydreamer2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class TeamListActivity extends AppCompatActivity implements View.OnClickListener {

    private final int TOP = 0;

    private int[] buttonIds = new int[]{
            R.id.homeButton,
            R.id.userListButton,
            R.id.teamListButton,
            R.id.partyButton,
            R.id.profileButton
    };

    ListView listView;
    ImageButton[] button = new ImageButton[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teamlist);

        listView = (ListView)findViewById(R.id.teams_list);

        for (int i = 0; i < buttonIds.length; i++){
            button[i] = (ImageButton)findViewById(buttonIds[i]);
            button[i].setOnClickListener(this);
        }

        initListView();
    }

    private void initListView() {

        ArrayList<String> list = new ArrayList<String>();
        TeamAdapter adapter = new TeamAdapter(this);

        list.add("team1");
        list.add("team2");
        list.add("team3");
        list.add("team4");
        list.add("team5");

        adapter.setImageList(list);
        listView.setAdapter(adapter);
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
                break;
            case R.id.partyButton:
                Intent intent3 = new Intent(this, ChatActivity.class);
                startActivity(intent3);
                break;
            case R.id.profileButton:
                Intent intent4 = new Intent(this, UserProfileActivity.class);
                intent4.putExtra("from",TOP);
                startActivity(intent4);
                break;
        }
    }
}
