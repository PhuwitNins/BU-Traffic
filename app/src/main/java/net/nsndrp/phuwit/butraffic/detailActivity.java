package net.nsndrp.phuwit.butraffic;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class detailActivity extends AppCompatActivity {

    // Explicit

    private TextView titleTextView, detailTextView;
    private ImageView TtrafficImageView;
    private int position;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        bindWidget();
        //Receive Value from Inten
        receiveFromIntent();





    } //Main method

    private void receiveFromIntent() {

        String strTitle = getIntent().getStringExtra("Title");
        titleTextView.setText(strTitle);

        int intImage = getIntent().getIntExtra("Image",/*Default*/R.drawable.traffic_01);
        TtrafficImageView.setImageResource(intImage);

        String[] strDetail = getResources().getStringArray(R.array.detail);
        int position = getIntent().getIntExtra("Index",0);
        detailTextView.setText(strDetail[position]);

    }


    private void bindWidget() {
        titleTextView = (TextView) findViewById(R.id.textView3);
        detailTextView = (TextView) findViewById(R.id.textView4);
        TtrafficImageView = (ImageView) findViewById(R.id.imageView2);




    }



}// Main class
