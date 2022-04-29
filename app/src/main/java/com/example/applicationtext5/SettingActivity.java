package com.example.applicationtext5;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SettingActivity extends ListActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        int[] list_image = {0, R.drawable.img01, R.drawable.img02, R.drawable.img03, R.drawable.img04
                , R.drawable.img05, R.drawable.img06, R.drawable.img07, R.drawable.img08, R.drawable.img09
                , R.drawable.img10, R.drawable.img11, R.drawable.img12, R.drawable.img13
                , R.drawable.img14, R.drawable.img15};
        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();
        String name = intent.getStringExtra("name");
        System.out.println(name);
        String[] list_title = {"  " + name, "流量管理", "WLAN", "蓝牙", "个性化定制", "桌面", "显示与亮度", "声音", "通知", "隐私"
                , "电池", "应用管理", "用户与账号", "云服务", "软件更新", "关于手机"};
        List<Map<String, Object>> item = new ArrayList<>();
        for (int i = 0; i < list_title.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("image", list_image[i]);
            map.put("title", list_title[i]);
            item.add(map);
        }
        SimpleAdapter ad = new SimpleAdapter(this, item, R.layout.items_main, new String[]{"image", "title"}, new int[]{R.id.item_image, R.id.item_title});
        this.setListAdapter(ad);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(SettingActivity.this, l.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
    }
}