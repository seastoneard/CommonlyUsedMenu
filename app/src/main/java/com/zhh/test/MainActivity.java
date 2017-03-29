package com.zhh.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zhh.test.menu.ClipActivity;
import com.zhh.test.menu.MoveActivity;
import com.zhh.test.menu.NormalActivity;
import com.zhh.test.menu.QihooActivity;

/**
 * Created by zhh on 2017/1/18.
 * 个人
 * csdn网站：http://blog.csdn.net/zhh_csdn_ard
 * devstore网站：http://www.devstore.cn/user_home/zhanghai_ardapp.html
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnNormal;
    private Button mBtnMove;
    private Button mBtnRipple;
    private Button mBtnClip;

    private void assignViews() {
        mBtnNormal = (Button) findViewById(R.id.btn_normal);
        mBtnMove = (Button) findViewById(R.id.btn_move);
        mBtnRipple = (Button) findViewById(R.id.btn_ripple);
        mBtnClip = (Button) findViewById(R.id.btn_clip);
        mBtnNormal.setOnClickListener(this);
        mBtnMove.setOnClickListener(this);
        mBtnRipple.setOnClickListener(this);
        mBtnClip.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_normal:
                startActivity(new Intent(this, NormalActivity.class));//系统自带
                break;
            case R.id.btn_clip:
                startActivity(new Intent(this, ClipActivity.class));//上移
                break;
            case R.id.btn_ripple:
                startActivity(new Intent(this, QihooActivity.class));//360波纹菜单
                break;
            case R.id.btn_move:
                startActivity(new Intent(this, MoveActivity.class));//动画展开菜单
                break;
        }
    }
}
