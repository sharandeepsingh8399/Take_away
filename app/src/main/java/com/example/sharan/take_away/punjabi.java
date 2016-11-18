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

public class punjabi extends AppCompatActivity {

    String titles3[];
    String address3[];
    int images[]={R.drawable.pal,R.drawable.khalsa,R.drawable.pashtun,R.drawable.cc,R.drawable.dd,R.drawable.katani,R.drawable.pd};
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punjabi);

        Resources res=getResources();
        titles3=res.getStringArray(R.array.titles3);
        address3=res.getStringArray(R.array.address3);

        list= (ListView) findViewById(R.id.lv3);
        customadapter3 customadapter=new customadapter3(this,titles3,images,address3);
        list.setAdapter(customadapter);
    }
}
class customadapter3 extends ArrayAdapter<String>
{
    Context context;
    int[] images;
    String[] titlesarrays;
    String[] address;
    customadapter3(Context c,String[] titles1,int[] imgs,String[] add1)
    {
        super(c,R.layout.single_row,R.id.textView,titles1);
        this.context=c;
        this.images=imgs;
        this.titlesarrays=titles1;
        this.address=add1;
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
