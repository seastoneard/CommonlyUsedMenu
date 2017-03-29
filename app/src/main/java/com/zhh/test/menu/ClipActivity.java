package com.zhh.test.menu;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.zhh.test.R;
import com.zhh.test.menu.library.TabItem;
import com.zhh.test.menu.library.XFragmentTabHost;


public class ClipActivity extends AppCompatActivity {

    //基于FragmentTabHost的控件
    private XFragmentTabHost mTabHost;

    String[] mTabTitle = new String[] {"首页", "软件", "游戏", "管理"};
    int[] mImageResId = new int[] {R.drawable.sel_tab_home, R.drawable.sel_tab_app,
            R.drawable.sel_tab_game, R.drawable.sel_tab_mag};

    //这是你要用到的Fragment
    Class[] mFragClass = new Class[] {TabFragment.class, TabFragment.class,
            TabFragment.class, TabFragment.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_clip);
        initTabHost();
    }

    private void initTabHost() {
        //展开样式数组
        Drawable[] drawables = new Drawable[] { ContextCompat.getDrawable(this, R.mipmap.ic_bg1),
                ContextCompat.getDrawable(this, R.mipmap.ic_bg2),
                ContextCompat.getDrawable(this, R.mipmap.ic_bg3),
                ContextCompat.getDrawable(this, R.mipmap.ic_bg4)};

        mTabHost = (XFragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.relate_tab_content);
        mTabHost.setTabMode(XFragmentTabHost.TabMode.ClipDrawable);

        for (int i = 0; i < mFragClass.length; i++) {
            Bundle bundle = new Bundle();
            bundle.putString(TabFragment.FRAG_KEY, mTabTitle[i]);
            mTabHost.addTabItem(new TabItem(mTabTitle[i], drawables[i], mImageResId[i]),
                    mFragClass[i], bundle);
        }
    }
}
