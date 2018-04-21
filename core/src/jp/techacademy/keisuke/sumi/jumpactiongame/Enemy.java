package jp.techacademy.keisuke.sumi.jumpactiongame;

import com.badlogic.gdx.graphics.Texture;


public class Enemy extends GameObject {
    // 横幅、高さ
    public static final float Enemy_WIDTH = 2.0f;
    public static final float Enemy_HEIGHT = 1.0f;

    // タイプ（通常と動くタイプ）
    public static final int Enemy_TYPE_STATIC = 0;
    public static final int Enemy_TYPE_MOVING = 1;

    // 状態（通常と消えた状態）
    public static final int STEP_STATE_NORMAL = 0;
    public static final int STEP_STATE_VANISH = 1;

    // 速度
    public static final float STEP_VELOCITY = 2.0f;

    int mType;
    int mState;

    public Enemy(int type,Texture texture, int srcX, int srcY, int srcWidth, int srcHeight) {
        super(texture, srcX, srcY, srcWidth, srcHeight);
        setSize(Enemy_WIDTH, Enemy_HEIGHT);
        mType = type;
        if (mType == Enemy_TYPE_MOVING) {
            velocity.x = STEP_VELOCITY;
        }
    }

    // 座標を更新する
    public void update(float deltaTime) {
        if (mType == Enemy_TYPE_MOVING) {
            setX(getX() + velocity.x * deltaTime);

            if (getX() < Enemy_WIDTH / 2) {
                velocity.x = -velocity.x;
                setX(Enemy_WIDTH / 2);
            }
            if (getX() > GameScreen.WORLD_WIDTH - Enemy_WIDTH / 2) {
                velocity.x = -velocity.x;
                setX(GameScreen.WORLD_WIDTH - Enemy_WIDTH / 2);
            }
        }
    }


}