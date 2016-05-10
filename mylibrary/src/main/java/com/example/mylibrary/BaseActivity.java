package com.example.mylibrary;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by PC on 2016/4/15.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Context mContext;
    public Toolbar mToolBar;

    protected void onCreate(Bundle savedInstanceState,int layoutID) {
        super.onCreate(savedInstanceState);
        setContentView(layoutID);
        mContext = this;
        StatusBarCompat.compat(this);
        initToolBar();
        initView();
        addListener();
        setData();
    }

    /**
     * 新状态栏颜色
     * @param savedInstanceState
     * @param layoutID
     */
    protected void onCreate(Bundle savedInstanceState,int layoutID,int color) {
        super.onCreate(savedInstanceState);
        setContentView(layoutID);
        mContext = this;
        StatusBarCompat.compat(this,color);
        initToolBar();
        initView();
        addListener();
        setData();
    }

    public void setmToolBarCanBack() {
        if (mToolBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * 设置标题和副标题 自动完成
     * @param title
     * @param subTitle
     */
    public void initToolbar(String title,String subTitle) {
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mToolBar.setTitle(title);
        setSupportActionBar(mToolBar);
    }

    /**
     * 初始化标题栏 在这之后你可以 设置标题栏返回按钮 setmToolBarCanBack 实现返回 并在optionmenuitemseletor 中监听 android.R.id.home 实现返回 id == android.R.id.home
     */
    public abstract void initToolBar();
    /*
    初始化布局 在这之前你可以设置 标题栏 initToolBar实现标题的设置
     */
    public abstract void initView();

    /**
     * 添加事件监听
     */
    public abstract void addListener();

    /**
     * 设置数据
     */
    public abstract void setData();

    /**
     * h获取上下文
     * @return
     */
    public Context getContext() {
        return mContext;
    }
}
