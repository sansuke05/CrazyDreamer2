package jp.ac.u_aizu.zudai.crazydreamer2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.pic_up_list);

        for (int i = 0; i < buttonIds.length; i++){
            button[i] = (ImageButton)findViewById(buttonIds[i]);
            button[i].setOnClickListener(this);
        }

        initListView();

    }


    public void initListView() {

        ArrayList<String> list = new ArrayList<String>();
        PickUpAdapter adapter = new PickUpAdapter(this);

        list.add("pickup1");
        list.add("pickup2");
        list.add("pickup3");

        adapter.setImageList(list);
        listView.setAdapter(adapter);
    }


    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.homeButton:
                break;
            case R.id.userListButton:
                break;
            case R.id.teamListButton:
                break;
            case R.id.partyButton:
                break;
            case R.id.profileButton:
                break;
        }
    }
}
