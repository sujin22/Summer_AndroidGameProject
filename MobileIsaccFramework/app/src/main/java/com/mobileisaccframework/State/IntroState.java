package com.mobileisaccframework.State;

import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.mobileisaccframework.GameObject.GameObject;
import com.mobileisaccframework.Manager.AppManager;
import com.mobileisaccframework.R;

public class IntroState extends GameState {
    GameObject m_introUI;


    @Override
    public void Initialize() {
        AddObject();
    }

    @Override
    public void Update(long _gameTime) {
        m_backGround.Update(_gameTime);
        m_introUI.Update(_gameTime);
    }

    @Override
    public void Render(Canvas canvas) {
        super.Render(canvas);

        if(canvas == null)
            return;

        m_backGround.Render(canvas);
        m_introUI.Render(canvas);
    }

    @Override
    public void AddObject() {
        // iterator 패턴 사용 안한 버전
        m_backGround = new GameObject(AppManager.getInstance().getBitmap(R.drawable.title_background),
                AppManager.getInstance().getBitmapWidth(R.drawable.title_background),
                AppManager.getInstance().getBitmapHeight(R.drawable.title_background));
        m_introUI = new GameObject(AppManager.getInstance().getBitmap(R.drawable.title),
                AppManager.getInstance().getBitmapWidth(R.drawable.title),
                AppManager.getInstance().getBitmapHeight(R.drawable.title),
                (AppManager.WIDTH / 2) - 300, (AppManager.HEIGHT / 2) - 150, 5, 2, true);
    }

    @Override
    public boolean onKeyDown(int _keyCode, KeyEvent _event) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        AppManager.getInstance().getGameView().changeGameState(new StageTestState());
        return true;
    }

    @Override
    public void Destroy() {

    }
}
