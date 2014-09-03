#Tabs_use_awesomefont
#
====================

#一个android library 项目.
快速的生成一个类似IOS的TAB的主界面。

菜单与fragment一一对应。
>
public class MyActivity extends MainViewWithTabs { 
>
     @Override
     public LinkedList<Class> getTabsFragmentClass() {
         LinkedList<Class> aa=new LinkedList<Class>();
         aa.add(TestFragment.class);
         aa.add(TestSndFragment.class);
         return aa;
     }
> 
     @Override
     public LinkedList<Map<String, String>> getTabsLableAndIcon() {
         Map<String,String> record1=new HashMap<String,String>();
         record1.put("label","Android");
         record1.put("icon",getString(R.string.fa_android));
         Map<String,String> record2=new HashMap<String,String>();
         record2.put("label","Apple");
         record2.put("icon",getString(R.string.fa_apple));
         LinkedList<Map<String,String>> linkedList=new LinkedList<Map<String, String>>();
         linkedList.add(record1);
         linkedList.add(record2);
         return linkedList;
     }
> 
     @Override
     public Typeface getTypeface() {
         return Typeface.createFromAsset(getAssets(),"fonts/fontawesome_webfont.ttf");
     }
>     
}