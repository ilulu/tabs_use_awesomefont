#Tabs_use_awesomefont
#
====================

#一个android library 项目.
快速的生成一个类似IOS的TAB的主界面。

菜单与fragment一一对应。

Demo
>
public class MyActivity extends MainViewWithTabs { 
>
     @Override
         public LinkedList<Tab> getTabs() {
             Tab tab = new Tab(TestFragment.class, "Apple", getString(R.string.fa_apple));
             Tab tab2 = new Tab(TestSndFragment.class, "Android", getString(R.string.fa_android));
             Tab tab3 = new Tab(TestFragment.class, "Apple", getString(R.string.fa_apple));
             Tab tab4 = new Tab(TestSndFragment.class, "Android", getString(R.string.fa_android));
             LinkedList<Tab> linkedList = new LinkedList<Tab>();
             linkedList.add(tab);
             linkedList.add(tab2);
             linkedList.add(tab3);
             linkedList.add(tab4);
             return linkedList;
         }
     
> 
     @Override
     public Typeface getTypeface() {
         return Typeface.createFromAsset(getAssets(),"fonts/fontawesome_webfont.ttf");
     }
>     
}