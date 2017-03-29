package com.zhh.test.menu;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhh.test.R;


public class NormalActivity extends AppCompatActivity {

    private FragmentTabHost mTabHost;

    private String[] mTabTitle = new String[]{"首页", "软件", "游戏", "管理"};

    //菜单图片样式
    private int[] mImageResId = new int[]{R.drawable.sel_tab_home, R.drawable.sel_tab_app,
            R.drawable.sel_tab_game, R.drawable.sel_tab_mag};
    //要加载的Fragment
    private Class[] mFragClass = new Class[]{TabFragment.class, TabFragment.class,
            TabFragment.class, TabFragment.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_normal);
        initTabHost();
    }

    private void initTabHost() {
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);

        mTabHost.setup(this, getSupportFragmentManager(), R.id.relate_tab_content);

        for (int i = 0; i < mFragClass.length; i++) {
            //Bundle传值到Fragment中，不传值，则第三个参数为null
            Bundle bundle = new Bundle();

            bundle.putString(TabFragment.FRAG_KEY, mTabTitle[i]);

            //第一参数：菜单的文字&样式 第二个参数：需要加载Fragment,第三个参数：需要传到Fragment中的值
            mTabHost.addTab(mTabHost.newTabSpec(mTabTitle[i]).setIndicator(getIndicator(i)), mFragClass[i], bundle);
        }
        //去掉间隔线
        mTabHost.getTabWidget().setDividerDrawable(android.R.color.transparent);
    }

    //菜单的布局样式
    private View getIndicator(int index) {
        View view = LayoutInflater.from(this).inflate(R.layout.tabhost_indicator, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.tab_icon);
        TextView title = (TextView) view.findViewById(R.id.tab_title);
        imageView.setImageResource(mImageResId[index]);
        title.setText(mTabTitle[index]);
        return view;
    }
}
