package com.supercwn.player;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

/**
 *
 * 类描述：首页
 *
 * @author Super南仔
 * @time 2016-9-19
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_demand_play).setOnClickListener(this);//点播
        findViewById(R.id.tv_live_play).setOnClickListener(this);//直播
        findViewById(R.id.tv_recycleview_player).setOnClickListener(this);//recycleView
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tv_demand_play) {
            Intent demandIntent = new Intent(this,SuperVideoDetailsActivity.class);
            demandIntent.putExtra("isLive",false);

            //String url = "http://g2.live.360.cn/vodplay?channel=live_huajiao_v2&sn=_LC_ps1_non_3178177314763226031071838_SX&ts=1476324615&dtype=non&stype=m3u8&sid=f8bb4ac28db65ee6ff4e8ea7a554dfc2&_rate=sd&_sign=4b166ae8aa921b77a86165fad1ce1396&_tag=.m3u8";

            demandIntent.putExtra("url","http://baobab.wandoujia.com/api/v1/playUrl?vid=2614&editionType=normal");
           // demandIntent.putExtra("url",url);
            startActivity(demandIntent);

        } else if (view.getId() == R.id.tv_live_play) {
            Intent liveIntent = new Intent(this,SuperVideoDetailsActivity.class);
            liveIntent.putExtra("isLive",true);
            liveIntent.putExtra("url","rtmp://live.hkstv.hk.lxdns.com/live/hks");
            startActivity(liveIntent);
        } else if (view.getId() == R.id.tv_recycleview_player) {
            Intent listViewIntent = new Intent(this,SuperVideoRecycleViewActivity.class);
            startActivity(listViewIntent);
        }
    }
}
