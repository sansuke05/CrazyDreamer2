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
 * Created by user on 2017/11/04.
 */

public class PickUpAdapter extends BaseAdapter{
    Context context;
    LayoutInflater layoutInflater = null;
    ArrayList<String> imageList;

    public PickUpAdapter(Context context){
        this.context = context;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setImageList(ArrayList<String> imageList){
        this.imageList = imageList;
    }

    @Override
    public int getCount(){
        return imageList.size();
    }

    @Override
    public Object getItem(int position){
        return imageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.pickup_image_row, parent, false);

        Resources res = context.getResources();
        int imageId = res.getIdentifier(imageList.get(position), "drawable", context.getPackageName());

        ((ImageView)convertView.findViewById(R.id.pic_up_image)).setImageResource(imageId);

        return convertView;
    }
}
