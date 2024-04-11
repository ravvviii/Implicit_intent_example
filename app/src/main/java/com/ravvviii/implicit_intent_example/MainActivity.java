package com.ravvviii.implicit_intent_example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    Button btnDial,btnMsg,btnEmail,btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMsg = findViewById(R.id.btnMsg);
        btnDial = findViewById(R.id.btnDial);
        btnEmail = findViewById(R.id.btnEmail);
        btnShare = findViewById(R.id.btnShare);



        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iDial = new Intent(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel: +917782042988"));
                startActivity(iDial);
            }
        });


        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iMsg = new Intent();
                iMsg.setAction(Intent.ACTION_SENDTO);
                iMsg.setData(Uri.parse("smsto: "+Uri.encode("+917782042988")));
                iMsg.putExtra("sms_body", "Hii, new thing learn !!");
                startActivity(iMsg);
            }
        });


        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iShare = new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT, "Hii , I am sharing this app because i loved it https://play.google.com/store/apps/details?id=com.netmarble.tog&pcampaignid=merch_published_cluster_promotion_battlestar_browse_all_games&hl=en_IN&gl=US");
                startActivity(Intent.createChooser(iShare,"Share via"));
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iEmail = new Intent(Intent.ACTION_SEND);
                iEmail.setType("mesage/rfc822");
                iEmail.putExtra(Intent.EXTRA_EMAIL,new String[]{"rs9625645@gmail.com"} );
                iEmail.putExtra(Intent.EXTRA_SUBJECT,"Query reagarding App");
                iEmail.putExtra(Intent.EXTRA_TEXT,"Hi am iam body of the app");

                startActivity(Intent.createChooser(iEmail,"Email via"));
            }
        });
    }
}