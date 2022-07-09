package com.kp.vtrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {
    static final String rNo[]={"01","02","03","04","05","06","07","08"};
    static final String stops[]={"15 Stops","20 Stops","22 Stops","15 Stops","15 Stops","15 Stops","15 Stops","15 Stops"};
    static final String BusNames[]={"AP 35 AB 4777","AP 35 AB 1234","AP 35 AB 7688","AP 35 AB 7896","AP 35 AB 7788","AP 35 AB 7744",
            "AP 35 AB 1122","AP 35 AB 4777"};
    static final String rating[]={"4.5","3.5","2.7","4.5","4.5","3.5","1.7","4.5"};
    static final String people[]={"126","75","125","125","125","125","125","125"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ListView lv=findViewById(R.id.listview);
        lv.setAdapter(new MyAdapter(this));
    }
    private class MyAdapter extends BaseAdapter {
        Context c;
        public MyAdapter(HomePage mainActivity) {
            c = mainActivity;
        }
        @Override
        public int getCount() {
            return rNo.length;
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(c).inflate(R.layout.driverlist, parent, false);
            TextView RouteNo = view.findViewById(R.id.RouteNo);
            TextView BusNo = view.findViewById(R.id.BusNo);
            TextView Stops = view.findViewById(R.id.Stops);
            TextView People = view.findViewById(R.id.People);
            TextView Rating = view.findViewById(R.id.Rating);
            RouteNo.setText(rNo[position]);
            BusNo.setText(BusNames[position]);
            Stops.setText(stops[position]);
            People.setText(people[position]);
            RelativeLayout r=findViewById(R.id.r1);
            Rating.setText(rating[position]);
           /* if(Integer.parseInt(people[position])<3){
                r.setBackgroundColor(Integer.parseInt("#dc3545"));
            }
            else if(Integer.parseInt(people[position])<4 &&Integer.parseInt(people[position])>=3){
                r.setBackgroundColor(Integer.parseInt("#ffc107"));
            }
            else{
                r.setBackgroundColor(Integer.parseInt("#28a745"));
            }*/

            return view;
        }
    }
}

/*<com.google.android.material.textfield.TextInputLayout
        android:layout_width="match_parent"
        android:hint="Search by Route no,Stop Name"
        android:layout_alignParentBottom="true"
        app:endIconMode="custom"
        style="@style/Widget.MaterialComponents.TextInputLayout.FilledBox"
        android:layout_height="wrap_content">
<com.google.android.material.textfield.TextInputEditText
        android:id="@+id/Search"
        android:layout_width="match_parent"
        android:layout_margin="25dp"
        android:layout_height="wrap_content"
        android:background="@color/white">

</com.google.android.material.textfield.TextInputEditText>
</com.google.android.material.textfield.TextInputLayout>*/