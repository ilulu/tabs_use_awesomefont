package org.ilulu.mainwithtabs;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Map;

/**
 * Created by ilulu on 14-9-1.
 */
public abstract class MainViewWithTabs extends FragmentActivity {
    private FragmentTabHost tabHost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tabHost = (FragmentTabHost) findViewById(R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        prepareTabItem(tabHost);
    }

    /**
     * 定义TAB
     * @return
     */
    public abstract LinkedList<Tab> getTabs();



    /**
     * 返回图标字体。通常字体文件放置在项目根目录的asset/fonts下
     * 使用Typeface.createFromAsset方法来创建Typeface即可。
     * @return
     */
    public abstract Typeface getTypeface();

    /**
     * 初始化tabHost
     * @param tabHost
     */
    private void prepareTabItem(FragmentTabHost tabHost) {
        for(Tab tab:getTabs()){
            String label=tab.getLabel();
            String icon=tab.getIcon();
            //为每一个Tab按钮设置图标、文字和内容
            TabHost.TabSpec tabSpec = tabHost.newTabSpec(label).setIndicator(createTabItemView(label,icon));
            //将Tab按钮添加进Tab选项卡中
            tabHost.addTab(tabSpec, tab.getTabFragmet(), null);
        }
    }

    /**
     * 分别创建每一个Tab的内容。
     * @param label
     * @param icon
     * @return
     */
    private View createTabItemView(String label,String icon) {
        View view = getLayoutInflater().inflate(R.layout.tab_item_view, null);
        // set tab item label
        TextView labelTextView = (TextView) view.findViewById(R.id.tab_item_label);
        labelTextView.setText(label);

        // set tab item icon
        TextView iconTextView = (TextView) view.findViewById(R.id.tab_item_icon);
        iconTextView.setTypeface(getTypeface());
        iconTextView.setText(icon);

        return view;
    }
}
