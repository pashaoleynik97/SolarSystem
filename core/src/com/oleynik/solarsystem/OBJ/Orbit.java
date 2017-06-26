package com.oleynik.solarsystem.OBJ;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.oleynik.solarsystem.RES.Resources;

/**
 * Created by MATHAHAKAR on 24.11.2016.
 * vk.com/mathahakar
 * mathahakar1997@gmail.com
 */
public class Orbit extends Group {

    private float radius;
    private float center;

    private TextureAtlas.AtlasRegion region;

    public Orbit (float radius, float scale) {
        this.radius = radius;
        this.setSize((radius * scale) * 2, (radius * scale) * 2);
        this.region = Resources.ImgRes.getRegion(Resources.ImgRes.ORBIT_BIG);
        this.setTouchable(Touchable.childrenOnly);
    }

    public void setCenter(float center) {
        this.center = center;
    }

    public void setTextureForSmallOrb () {
        this.region = Resources.ImgRes.getRegion(Resources.ImgRes.ORBIT_SMALL);
    }

    public void setTextureForSatelliteOrb () {
        this.region = Resources.ImgRes.getRegion(Resources.ImgRes.ORBIT_SUPER_SMALL);
    }

    public float getCenter() {
        return center;
    }

    public float getRadius() {
        return radius;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color color = this.getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        batch.draw(region, getX(), getY(), getWidth(), getHeight());
        super.draw(batch, batch.getColor().a);
    }
}
