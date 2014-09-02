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
     * 定义TAB对应的Fragment的class
     * @return
     */
    public abstract LinkedList<Class> getTabsFragmentClass();

    /**
     * 定义tab的label和icon
     * 其显示顺序和tabsFragmentClass对应
     * label和icon使用map的形式书写，例如{"label":"xxxxx","icon","xxxx"}
     * 为了在不同分辨率上显示的效果相同，这里ICON使用的是图标字体，比如fontawesome
     * @return
     */
    public abstract LinkedList<Map<String,String>> getTabsLableAndIcon();

    /**
     * 返回图标字体。通常字体文件放置在项目根目录的asset/fonts下
     * 使用Typeface.createFromAsset方法来创建Typeface即可。
     * @return
     */
    public abstract Typeface getTypeface();

    private void prepareTabItem(FragmentTabHost tabHost) {
        for (int i = 0; i < getTabsFragmentClass().size(); i++) {
            Map<String,String> labesAndIcon=getTabsLableAndIcon().get(i);
            String label=labesAndIcon.get("label");
            String icon=labesAndIcon.get("icon");
            //为每一个Tab按钮设置图标、文字和内容
            TabHost.TabSpec tabSpec = tabHost.newTabSpec(label).setIndicator(createTabItemView(label,icon));
            //将Tab按钮添加进Tab选项卡中
            tabHost.addTab(tabSpec, getTabsFragmentClass().get(i), null);
        }
    }
    private View createTabItemView(String label,String icon) {
        View view = getLayoutInflater().inflate(R.layout.tab_item_view, null);
        // set tab item label
        TextView textView = (TextView) view.findViewById(R.id.tab_item_label);
        textView.setText(label);

        // set tab item icon
        TextView imageView = (TextView) view.findViewById(R.id.tab_item_icon);
        imageView.setTypeface(getTypeface());
        imageView.setText(icon);

        return view;
    }
}
