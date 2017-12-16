package retrofit.longzhu.com.buidertoobar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import retrofit.longzhu.com.buidertoobar.navigation.imp.HomeNavagation;

public class MainActivity extends AppCompatActivity{
    LinearLayout toolBarContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolBarContainer = findViewById(R.id.ll_toolbarContainer);

        HomeNavagation.Builders build = new HomeNavagation.Builders(this,toolBarContainer);
        build.setRightImageLeftRes(R.mipmap.ic_launcher);
        build.setRightImageLeftOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"点击第一个图片",Toast.LENGTH_LONG).show();
            }
        });
        build.setRightImageRightRes(R.mipmap.ic_launcher);
        build.setRightImageRightOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"点击第二个图片",Toast.LENGTH_LONG).show();
            }
        });
        build.builder().build();
    }

}
