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

public class nveg extends AppCompatActivity {

    String titles1[];
    String address1[];
    int images[]={R.drawable.pal,R.drawable.yo,R.drawable.mc,R.drawable.nf,R.drawable.kfc,R.drawable.mcd,R.drawable.sj};
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nveg);

        Resources res=getResources();
        titles1=res.getStringArray(R.array.titles1);
        address1=res.getStringArray(R.array.address1);

        list= (ListView) findViewById(R.id.lv2);
        customadapter1 customadapter=new customadapter1(this,titles1,images,address1);
        list.setAdapter(customadapter);
    }
}
class customadapter1 extends ArrayAdapter<String>
{
    Context context;
    int[] images;
    String[] titlesarrays;
    String[] address;
    customadapter1(Context c,String[] titles1,int[] imgs,String[] add1)
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
