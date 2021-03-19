package com.example.hashsettreesethomework;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {
    Button addBut, refBut;
    EditText addField;
    TextView treeSet, hashSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addBut = findViewById(R.id.addBut);
        refBut = findViewById(R.id.refBut);
        addField = findViewById(R.id.addField);
        treeSet = findViewById(R.id.treeSet);
        hashSet = findViewById(R.id.hashSet);
        TreeSet<String> animalsTree = new TreeSet<>();
        HashSet<String> animalsHash = new HashSet<>();
        animalsTree.add("Кошка");
        animalsHash.add("Кошка");
        treeSet.setText("Кошка");
        hashSet.setText("Кошка");
        addBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!"".equals(addField.getText().toString())) {
                    animalsTree.add(addField.getText().toString());
                    animalsHash.add(addField.getText().toString());
//                    addField.setBackgroundColor(Color.WHITE);
                    Toast.makeText(getApplicationContext(), "Запись добавлена", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Запись не добавлена. Отстуствуют данные в отмеченном поле", Toast.LENGTH_SHORT).show();
                    addField.setBackgroundColor(Color.RED);
                }
            }
        });
        refBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                treeSet.setText("");
                hashSet.setText("");
                Iterator<String> hashIterator = animalsHash.iterator();
                while (hashIterator.hasNext()) {
                    hashSet.append(hashIterator.next());
                    if (hashIterator.hasNext()) {
                        hashSet.append(", ");
                    }
                }
                Iterator<String> treeIterator = animalsTree.iterator();
                while (treeIterator.hasNext()) {
                    treeSet.append(treeIterator.next());
                    if (treeIterator.hasNext()) {
                        treeSet.append(", ");
                    }
                }
            }
        });
        addField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addField.setBackgroundColor(Color.WHITE);
            }
        });
    }
}