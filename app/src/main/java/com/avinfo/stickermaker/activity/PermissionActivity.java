package com.avinfo.stickermaker.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.avinfo.stickermaker.R;
import com.avinfo.stickermaker.utils.FileUtils;
import com.avinfo.stickermaker.utils.PermissionsHelper;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class PermissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
//        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_request_permission);
        FileUtils.initializeDirectories(this);
        if (PermissionsHelper.verifyPermissions(this)) {
            startActivity(new Intent(this, HomeActivity.class));
            this.finish();
        } else {
            PermissionsHelper.requestPermissions(this);
        }
        findViewById(R.id.grant_permissions_button).setOnClickListener(v -> PermissionsHelper.requestPermissions(this));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        FileUtils.initializeDirectories(this);
        if (PermissionsHelper.verifyPermissions(this)) {//If the app has all the required permissions we pass to HomeActivity to get started
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        } else {
            Toast.makeText(this, "We need access to write and read files in your phone", Toast.LENGTH_SHORT).show();
        }
    }
}
