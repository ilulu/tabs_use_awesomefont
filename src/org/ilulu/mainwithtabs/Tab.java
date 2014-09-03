package org.ilulu.mainwithtabs;

import android.support.v4.app.Fragment;

/**
 * Created by ilulu on 14-9-3.
 */
public class Tab {
    Class tabFragmet;
    String label;
    String icon;

    public Tab(Class tabFragmet, String label, String icon) {
        this.tabFragmet = tabFragmet;
        this.label = label;
        this.icon = icon;
    }

    public Tab() {

    }

    public Class getTabFragmet() {
        return tabFragmet;
    }

    public void setTabFragmet(Class tabFragmet) {
        this.tabFragmet = tabFragmet;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
