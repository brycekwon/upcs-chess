package com.cs301.chessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.chessapp.R;

public class ChessMainActivity extends AppCompatActivity {
    private static final String TAG = "ChessMainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
