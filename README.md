# CommonlyUsedMenu
<!-- Baidu Button BEGIN -->

<div id="article_content" class="article_content">

<p><br>
</p>
<p><strong>前言</strong>：<span style="font-family:'Microsoft YaHei',Arial; font-size:14px; line-height:20px; background-color:rgb(255,255,255)">android菜单集合：FragmentTabHost系统菜单、上移式菜单、360波纹菜单、展开式菜单。详解注释，可直接拿来用！</span></p>
<p><span style="font-family:'Microsoft YaHei',Arial; font-size:14px; line-height:20px; background-color:rgb(255,255,255)"><br>
</span></p>
<p><span style="font-family:'Microsoft YaHei',Arial; font-size:14px; line-height:20px; background-color:rgb(255,255,255)"><strong>效果：</strong></span></p>
<p><span style="font-family:'Microsoft YaHei',Arial; font-size:14px; line-height:20px; background-color:rgb(255,255,255)"><strong>&nbsp;
<img src="http://img.blog.csdn.net/20170309140422521?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvemhoX2NzZG5fYXJk/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center" width="200" height="280" alt="">&nbsp;<img src="http://img.blog.csdn.net/20170309140458428?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvemhoX2NzZG5fYXJk/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center" width="200" height="280" alt="">&nbsp;
 &nbsp; &nbsp; &nbsp;&nbsp;<img src="http://img.blog.csdn.net/20170309140319316?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvemhoX2NzZG5fYXJk/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center" height="280" width="200" alt=""><br>
</strong></span></p>
<p><span style="font-family:'Microsoft YaHei',Arial; font-size:14px; line-height:20px; background-color:rgb(255,255,255)"><strong><br>
</strong></span></p>
<p><span style="font-family:'Microsoft YaHei',Arial; font-size:14px; line-height:20px; background-color:rgb(255,255,255)"><strong>开发环境：AndroidStudio2.1.2</strong></span></p>
<p><span style="font-family:'Microsoft YaHei',Arial; font-size:14px; line-height:20px; background-color:rgb(255,255,255)"><strong><br>
</strong></span></p>
<p><span style="font-family:Microsoft YaHei,Arial"><span style="font-size:14px; line-height:20px"><strong>部分代码(Activity)</strong></span></span></p>
<p><span style="font-family:Microsoft YaHei,Arial"><span style="font-size:14px; line-height:20px"><strong></strong></span></span><pre name="code" class="java">public class NormalActivity extends AppCompatActivity {

    private FragmentTabHost mTabHost;

    private String[] mTabTitle = new String[]{&quot;首页&quot;, &quot;软件&quot;, &quot;游戏&quot;, &quot;管理&quot;};

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

        for (int i = 0; i &lt; mFragClass.length; i++) {
            //Bundle传值到Fragment中，不传值，则第三个参数为null
            Bundle bundle = new Bundle();

            bundle.putString(TabFragment.FRAG_KEY, mTabTitle[i]);

            //第一参数：菜单的文字&amp;样式 第二个参数：需要加载Fragment,第三个参数：需要传到Fragment中的值
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
    }</pre><br>
<br>
</p>
<br>

   
</div>






<!-- Baidu Button END -->

