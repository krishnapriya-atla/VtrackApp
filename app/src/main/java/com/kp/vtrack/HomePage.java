package com.kp.vtrack;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.squareup.picasso.Picasso;

public class HomePage extends AppCompatActivity {
    static final String rNo[]={"01","02","03","04","05","06","07","08"};
    static final String stops[]={"15 Stops","20 Stops","22 Stops","15 Stops","15 Stops","15 Stops","15 Stops","15 Stops"};
    static final String BusNames[]={"AP 35 AB 4777","AP 35 AB 1234","AP 35 AB 7688","AP 35 AB 7896","AP 35 AB 7788","AP 35 AB 7744",
            "AP 35 AB 1122","AP 35 AB 4777"};
    static final double rating[]={4.5,3.5,2.7,4.5,4.5,3.5,1.7,4.5};
    static final String people[]={"126","75","125","125","125","125","125","125"};
    //final ArrayList <String> rNo=new ArrayList<>();
    DatabaseReference reference;
    String email, name, uid;
    TextView PName;
    TextView pno;
    ImageView profileImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        PName=findViewById(R.id.txtName);
        pno=findViewById(R.id.txtNum);
        profileImg=findViewById(R.id.profile_image);
        ListView lv=findViewById(R.id.listview);
        lv.setAdapter(new MyAdapter(this));
        /*lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(HomePage.this,DriverInfoActivity.class);
                intent.putExtra("rNO",String.valueOf(rNo[i]));
                intent.putExtra("stops",String.valueOf(stops[i]));
                intent.putExtra("BusNames",String.valueOf(BusNames[i]));
                intent.putExtra("rating",rating[i]);
                intent.putExtra("people",String.valueOf(people[i]));
                startActivity(intent);
            }
        });*/
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        /*Uri photoUrl = null;
        if (user != null) {
            email = user.getEmail();
            photoUrl = user.getPhotoUrl();
            uid = user.getUid();
        }
        profileImg.setImageTintMode(null);
        if (!photoUrl.equals("null")){
            Picasso.get()
                    .load(photoUrl)
                    .into(profileImg);
        }
        profileImg.setImageURI(photoUrl);*/
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
            View view = LayoutInflater.from(c).inflate(R.layout.driverlist,parent, false);
            TextView RouteNo = view.findViewById(R.id.RouteNo);
            TextView BusNo = view.findViewById(R.id.BusNo);
            TextView Stops = view.findViewById(R.id.Stops);
            TextView People = view.findViewById(R.id.People);
            TextView Rating = view.findViewById(R.id.Rating);
            RouteNo.setText(rNo[position]);
           BusNo.setText(BusNames[position]);
            Stops.setText(stops[position]);
            People.setText(people[position]);
            RelativeLayout r=view.findViewById(R.id.r1);
            Rating.setText(String.valueOf(rating[position]));
            //System.out.println(Integer.parseInt(rating[position]));
            if(rating[position]<3.0){
                r.setBackgroundColor(getResources().getColor(R.color.red));
            }
            else if(rating[position]<4.0 && rating[position]>=3.0){
                r.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{
                r.setBackgroundColor(getResources().getColor(R.color.green));
            }

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