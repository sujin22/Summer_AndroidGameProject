package com.mobileisaccframework.Manager;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.view.View;

import com.mobileisaccframework.GameObject.GameObject;
import com.mobileisaccframework.GameView;
import com.mobileisaccframework.State.GameState;

public class AppManager {
    public static int WIDTH = 2440;
    public static int HEIGHT = 1440;

    private GameView m_gameView;
    private Resources m_resources;
    private GameState m_curGameState; // 현재 게임 State

    public GameObject m_player;

    public boolean m_bRenderRect = false; // 충돌 박스 그릴 여부

    public void setGameView(GameView _gameView) { m_gameView = _gameView; }
    public void setResources(Resources _resources) { m_resources = _resources; }
    public void setCurGameState(GameState _state) { m_curGameState = _state; }

    public GameView getGameView() { return m_gameView; }
    public Resources getResources() { return m_resources; }
    public GameState getCurGameState() { return m_curGameState; }
    public Bitmap getBitmap(int r) {
        return BitmapFactory.decodeResource(m_resources, r);
    }

    public int getBitmapWidth(int r) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(m_resources, r, options);

        return options.outWidth;
    }

    public int getBitmapHeight(int r) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(m_resources, r, options);

        return options.outHeight;
    }

    // 싱글톤
    private static AppManager m_instance;

    public static AppManager getInstance() {
        if(m_instance == null)
            m_instance = new AppManager();
        return m_instance;
    }
}
