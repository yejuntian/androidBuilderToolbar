package retrofit.longzhu.com.buidertoobar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import retrofit.longzhu.com.buidertoobar.navigation.imp.HomeNavagation;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout toolBarContainer;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        toolBarContainer = findViewById(R.id.ll_toolbarContainer);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:

                HomeNavagation.Builders build = new HomeNavagation.Builders(this,toolBarContainer);
                build.setRightImageRightRes(R.mipmap.ic_launcher);
                build.setRightImageRightOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"setRightImageRightOnClickListener",Toast.LENGTH_LONG).show();
                    }
                });
                build.builder().build();
                break;
        }
    }
}
