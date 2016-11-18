package com.example.sharan.take_away;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class dis extends AppCompatActivity {

    String titles[];
    String address[];
    int images[]={R.drawable.khalsa,R.drawable.sagar,R.drawable.sindhi,R.drawable.karthiks,R.drawable.sankalp,R.drawable.sundarams,R.drawable.fatu,R.drawable.cfood};
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dis);

        Resources res=getResources();
        titles=res.getStringArray(R.array.titles);
        address=res.getStringArray(R.array.address);

        list= (ListView) findViewById(R.id.lv);
        customadapter customadapter=new customadapter(this,titles,images,address);
        list.setAdapter(customadapter);
    }
}
class customadapter extends ArrayAdapter<String>
{
    Context context;
    int[] images;
    String[] titlesarrays;
    String[] address;
    customadapter(Context c,String[] titles,int[] imgs,String[] add)
    {
        super(c,R.layout.single_row,R.id.textView,titles);
        this.context=c;
        this.images=imgs;
        this.titlesarrays=titles;
        this.address=add;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.single_row,parent,false);

        ImageView imageView= (ImageView) row.findViewById(R.id.imageView2);
        TextView titles= (TextView) row.findViewById(R.id.textView);
        TextView adress= (TextView) row.findViewById(R.id.textView2);

        imageView.setImageResource(images[position]);
        titles.setText(titlesarrays[position]);
        adress.setText(address[position]);

        return row;
    }
}