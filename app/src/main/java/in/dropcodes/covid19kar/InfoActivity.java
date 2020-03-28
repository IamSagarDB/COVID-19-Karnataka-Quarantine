package in.dropcodes.covid19kar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class InfoActivity extends AppCompatActivity {

    private static final int REQUEST_CALL = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getSupportActionBar().setTitle("About Us");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makeCall();
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void HelpLine(View view) {
        makeCall();
    }

    private void makeCall() {
        if (ActivityCompat.checkSelfPermission(InfoActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(InfoActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);

        } else {
            String dial = "tel:01123978046";
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }
    }
}
