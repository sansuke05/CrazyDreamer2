package jp.ac.u_aizu.zudai.crazydreamer2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity implements View.OnClickListener {

    private final int TOP = 0;

    private int[] buttonIds = new int[]{
            R.id.homeButton,
            R.id.userListButton,
            R.id.teamListButton,
            R.id.partyButton,
            R.id.profileButton
    };

    private String[][] users = new String[][]{
            {"山田　太郎","@Tarou_Yamada","エンジニア志望の大学生です！ Abdroidアプリを制作中です。","face_icon1"},
            {"頭野　悪人","@Crazy","あたまがわるいです\nLINE スタンプ発売中","face_icon2"},
            {"羽武　太郎","@hamutaro_san","Webデザインの仕事をしています。\n趣味でアプリのデザインもしています。","face_icon3"},
            {"あかべこ","@red_cow","レッドブルが好きです。\nweb制作会社に勤めてます。","face_icon4"},
            {"敦賀　城","@turu_kame","プログラミング言語は全て分かります。\nよろしくお願いします。","face_icon5"},
            {"USAKO","@rubbitUSA","アメリカ在住です。\n自転車とラズパイをいじるのが趣味。","face_icon6"}
    };

    ListView listView;
    ImageButton[] button = new ImageButton[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);

        listView = (ListView)findViewById(R.id.users_list);

        for (int i = 0; i < buttonIds.length; i++){
            button[i] = (ImageButton)findViewById(buttonIds[i]);
            button[i].setOnClickListener(this);
        }

        initUserListView();
    }

    public void initUserListView() {

        ArrayList<UserData> userList = new ArrayList<UserData>();
        UserAdapter adapter = new UserAdapter(this);

        for (String[] user : users){
            UserData userData = new UserData();
            userData.setName(user[0]);
            userData.setUserId(user[1]);
            userData.setDescription(user[2]);
            userData.setIcon(user[3]);

            userList.add(userData);
        }

        adapter.setUserList(userList);
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
                break;
            case R.id.teamListButton:
                Intent intent2 = new Intent(this, TeamListActivity.class);
                startActivity(intent2);
                break;
            case R.id.partyButton:
                Intent intent3 = new Intent(this, PartyActivity.class);
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
