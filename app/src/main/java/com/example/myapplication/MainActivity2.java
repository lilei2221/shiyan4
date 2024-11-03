package com.example.myapplication;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shiyan3);

        // 数据源
        String[] animalNames = {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};
        int[] animalImages = {R.drawable.lion, R.drawable.tiger, R.drawable.monkey,
                R.drawable.dog, R.drawable.cat, R.drawable.elephant};

        // 将数据源放入 List 中
        List<HashMap<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < animalNames.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("name", animalNames[i]);
            map.put("image", animalImages[i]);
            data.add(map);
        }

        // 创建 SimpleAdapter
        String[] from = {"name", "image"};
        int[] to = {R.id.name, R.id.image};
        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.list_item, from, to);

        // 获取 ListView 并设置适配器
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        // 为 ListView 设置点击事件
        listView.setOnItemClickListener((AdapterView<?> parent, android.view.View view, int position, long id) -> {
            // 获取点击的动物名称
            String selectedAnimal = animalNames[position];
            // 显示 Toast
            Toast.makeText(MainActivity2.this, selectedAnimal, Toast.LENGTH_SHORT).show();
        });
    }
}
