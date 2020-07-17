package com.mobileisaccframework.GameObject.bullet;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.mobileisaccframework.GameObject.GameObject;
import com.mobileisaccframework.GameObject.GameObjectState;
import com.mobileisaccframework.Manager.AppManager;
import com.mobileisaccframework.R;
import com.mobileisaccframework.Vector2D;

public class Bullet extends GameObject {
    int m_gapX = 25 * 4;
    int m_gapY = 23 * 4;

    int m_speed = 15;

    public Bullet(boolean _isPlayer, int _posX, int _posY, Vector2D _vecDir) {
        Bitmap bitmap;
        if(_isPlayer)
            bitmap = AppManager.getInstance().getBitmap(R.drawable.bullet_player);
        else
            bitmap = AppManager.getInstance().getBitmap(R.drawable.bullet_enemy);

        m_imgWidth =  AppManager.getInstance().getBitmapWidth(R.drawable.bullet_player) * 4;
        m_imgHeight =  AppManager.getInstance().getBitmapWidth(R.drawable.bullet_player) * 4;

        m_vecPos = new Vector2D(_posX,_posY);
        m_vecDir = _vecDir;

        // No Animation
        m_objectState = new GameObjectState(this, bitmap, m_imgWidth, m_imgHeight,1, 1, false);

        Initialize();
    }

    @Override
    public void Initialize() {
        // 이미지 크기와 충돌박스의 크기에 차이를 둘 것임(이미지가 너무 큼)
        m_gapX = 25 * 4;
        m_gapY = 23 * 4;

        m_boundBox = new Rect();
        // 15 -> 실제 Bullet 의 Width, Height
        m_boundBox.set(m_vecPos.x + m_gapX, m_vecPos.y + m_gapY,
                m_vecPos.x + m_gapX + (15 * 4), m_vecPos.y + m_gapY + (15 * 4));
    }

    @Override
    public int Update(long _gameTime) {
        if(m_isDead)
            return DEAD_OBJ;

        // GameObjectState 업데이트
        if(m_objectState != null)
            m_objectState.Update(_gameTime);

        // bondBox 위치 업데이트
        m_boundBox.set(m_vecPos.x + m_gapX, m_vecPos.y + m_gapY,
                m_vecPos.x + m_gapX + (15 * 4), m_vecPos.y + m_gapY + (15 * 4));

        m_vecPos.x += m_vecDir.x * m_speed;
        m_vecPos.y += m_vecDir.y * m_speed;

        return NO_EVENT;
    }

    @Override
    public void Render(Canvas canvas) {
        super.Render(canvas);
    }
}