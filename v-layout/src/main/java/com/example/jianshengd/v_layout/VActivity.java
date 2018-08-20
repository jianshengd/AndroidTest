package com.example.jianshengd.v_layout;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.example.jianshengd.ndk.HelloNdk;

import java.util.ArrayList;
import java.util.List;

public class VActivity extends AppCompatActivity {
    List<String> items=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v);
        initData();
        Toast.makeText(this,new HelloNdk().getMaxInt(1,2),Toast.LENGTH_SHORT).show();

        RecyclerView rv_content=findViewById(R.id.rv_content);
        VirtualLayoutManager virtualLayoutManager=new VirtualLayoutManager(this);
        rv_content.setLayoutManager(virtualLayoutManager);
        DelegateAdapter adapter = new DelegateAdapter(virtualLayoutManager, true);
//LinearLayout
        LinearLayoutHelper linearLayoutHelper=new LinearLayoutHelper(10);
        linearLayoutHelper.setBgColor(Color.LTGRAY);
        adapter.addAdapter(new DelegateRecyclerAdapter(this,linearLayoutHelper,items));
//staggered
        StaggeredGridLayoutHelper staggeredGridLayoutHelper=new StaggeredGridLayoutHelper();
        adapter.addAdapter(new DelegateRecyclerAdapter(this,staggeredGridLayoutHelper,items));

//GridLayout
        GridLayoutHelper gridLayoutHelper=new GridLayoutHelper(3);
        gridLayoutHelper.setAutoExpand(false);
        adapter.addAdapter(new DelegateRecyclerAdapter(this,gridLayoutHelper,items));

        rv_content.setAdapter(adapter);
    }

    private void initData(){
        for (int i=0;i<20;i++){
            items.add("序号:"+i);
        }
    }
}
