package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Enemigo {
    Texture texture = new Texture("nimbus_0.png");
    float x, y, w, h, vx, vy;
    Temporizador cambioVelocidad = new Temporizador(60);

    Enemigo() {
        x = 1920;
        y = Utils.random.nextInt(1080);
        w = 64;
        h = 48;
        vx = -2;
        vy = 0;
    }

    public void update() {
        y += vy;
        x += vx;

        if (cambioVelocidad.suena()) {
            vy = Utils.random.nextInt(10) - 3;
            vx = -(Utils.random.nextInt(6)+1);
        }
        if (y > 1010) y = 1010;
        if (y < 0) y = 0;
    }

    void render(SpriteBatch batch) {
        batch.draw(texture, x, y, w, h);
    }
}
