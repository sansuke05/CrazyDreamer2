package jp.ac.u_aizu.zudai.crazydreamer2;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 2017/11/05.
 */

public class UserAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater = null;
    ArrayList<UserData> userList;

    public UserAdapter(Context context){
        this.context = context;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setUserList(ArrayList<UserData> userList){
        this.userList = userList;
    }

    @Override
    public int getCount(){
        return userList.size();
    }

    @Override
    public Object getItem(int position){
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return userList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.user_row, parent, false);

        Resources res = context.getResources();
        int imageId = res.getIdentifier(userList.get(position).getIcon(), "drawable", context.getPackageName());

        ((ImageView)convertView.findViewById(R.id.imageUserIcon)).setImageResource(imageId);

        ((TextView)convertView.findViewById(R.id.textName)).setText(userList.get(position).getName());
        ((TextView)convertView.findViewById(R.id.textId)).setText("\\" + userList.get(position).getUserId());
        ((TextView)convertView.findViewById(R.id.textDescription)).setText(userList.get(position).getDescription());

        return convertView;
    }
}
