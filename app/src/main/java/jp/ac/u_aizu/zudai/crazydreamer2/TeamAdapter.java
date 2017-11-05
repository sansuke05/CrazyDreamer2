package jp.ac.u_aizu.zudai.crazydreamer2;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by user on 2017/11/05.
 */

public class TeamAdapter extends BaseAdapter{
    Context context;
    LayoutInflater layoutInflater = null;
    private ArrayList<String> teamList;

    public TeamAdapter(Context context){
        this.context = context;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setImageList(ArrayList<String> teamList){
        this.teamList = teamList;
    }

    @Override
    public int getCount(){
        return teamList.size();
    }

    @Override
    public Object getItem(int position){
        return teamList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.team_row, parent, false);

        Resources res = context.getResources();
        int imageId = res.getIdentifier(teamList.get(position), "drawable", context.getPackageName());

        ((ImageView)convertView.findViewById(R.id.teamImage)).setImageResource(imageId);

        return convertView;
    }
}
