package com.oleynik.solarsystem.OBJ;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.oleynik.solarsystem.Const;

/**
 * Created by MATHAHAKAR on 25.11.2016.
 * vk.com/mathahakar
 * mathahakar1997@gmail.com
 */
public class SolarSys extends Group {

    private float sysSize;
    private float planetScale;
    private float orbitScale;

    private boolean isPause = true;

    private float heliocenter;

    private float speedMultiplier;

    /* MAIN */
    public Planet sun, mercury, venus, earth, mars, jupiter, saturn, uranus, neptune;
    public Orbit mercuryOrbit, venusOrbit, earthOrbit, marsOrbit, jupiterOrbit, saturnOrbit, uranusOrbit, neptuneOrbit;

    /* ADDITIONAL */
    public Orbit
            moonOrbit,
            sMarsOrbit1, sMarsOrbit2, sJupiterOrbit1, sJupiterOrbit2, sJupiterOrbit3, sJupiterOrbit4,
            sSaturnOrbit1, sSaturnOrbit2, sSaturnOrbit3, sSaturnOrbit4, sSaturnOrbit5, sSaturnOrbit6, sSaturnOrbit7,
            sUranusOrbit1, sUranusOrbit2, sUranusOrbit3, sUranusOrbit4, sUranusOrbit5,
            sNeptuneOrbit1, sNeptuneOrbit2, sNeptuneOrbit3, sNeptuneOrbit4, sNeptuneOrbit5, sNeptuneOrbit6,
                sNeptuneOrbit7, sNeptuneOrbit8;
    public Planet
            moon,
            sMars1, sMars2,
            sJupiter1, sJupiter2, sJupiter3, sJupiter4,
            sSaturn1, sSaturn2, sSaturn3, sSaturn4, sSaturn5, sSaturn6, sSaturn7,
            sUranus1, sUranus2, sUranus3, sUranus4, sUranus5,
            sNeptune1, sNeptune2, sNeptune3, sNeptune4, sNeptune5, sNeptune6, sNeptune7, sNeptune8;

    public SolarSys (float size) {
        this.sysSize = size;
        this.setSize(this.sysSize, this.sysSize);
        this.heliocenter = this.sysSize * 0.5f;
        this.orbitScale = sysSize / ((Const.ORB_NEPTUNE_RADIUS * 2) + (Const.RADIUS_NEPTUNE));
        this.planetScale = orbitScale * 5000;
        this.speedMultiplier = 100.0f; //10000000.0f;

        initObjects();

        sun.setPosition(this.heliocenter - (sun.getWidth() / 2), this.heliocenter - (sun.getHeight() / 2));
        this.addActor(sun);

        /* PLANETS ORBITS */

        mercuryOrbit.setPosition(mercuryOrbit.getCenter() - mercuryOrbit.getWidth() / 2 ,
                mercuryOrbit.getCenter() - mercuryOrbit.getHeight() / 2);
        this.addActor(mercuryOrbit);

        venusOrbit.setPosition(venusOrbit.getCenter() - venusOrbit.getWidth() / 2 ,
                venusOrbit.getCenter() - venusOrbit.getHeight() / 2);
        this.addActor(venusOrbit);

        earthOrbit.setPosition(earthOrbit.getCenter() - earthOrbit.getWidth() / 2 ,
                earthOrbit.getCenter() - earthOrbit.getHeight() / 2);
        this.addActor(earthOrbit);

        marsOrbit.setPosition(marsOrbit.getCenter() - marsOrbit.getWidth() / 2 ,
                marsOrbit.getCenter() - marsOrbit.getHeight() / 2);
        this.addActor(marsOrbit);

        jupiterOrbit.setPosition(jupiterOrbit.getCenter() - jupiterOrbit.getWidth() / 2 ,
                jupiterOrbit.getCenter() - jupiterOrbit.getHeight() / 2);
        this.addActor(jupiterOrbit);

        saturnOrbit.setPosition(saturnOrbit.getCenter() - saturnOrbit.getWidth() / 2 ,
                saturnOrbit.getCenter() - saturnOrbit.getHeight() / 2);
        this.addActor(saturnOrbit);

        uranusOrbit.setPosition(uranusOrbit.getCenter() - uranusOrbit.getWidth() / 2 ,
                uranusOrbit.getCenter() - uranusOrbit.getHeight() / 2);
        this.addActor(uranusOrbit);

        neptuneOrbit.setPosition(neptuneOrbit.getCenter() - neptuneOrbit.getWidth() / 2 ,
                neptuneOrbit.getCenter() - neptuneOrbit.getHeight() / 2);
        this.addActor(neptuneOrbit);

        /* SATELLITES ORBITS */

        moonOrbit.setPosition(earth.getX() + earth.getWidth() / 2- (moonOrbit.getWidth() / 2),
                earth.getY() + earth.getHeight() / 2 - (moonOrbit.getHeight() / 2));
        earthOrbit.addActor(moonOrbit);

        sMarsOrbit1.setPosition(mars.getX() + (mars.getWidth() / 2- (sMarsOrbit1.getWidth() / 2)),
                mars.getY() + (mars.getHeight() / 2 - (sMarsOrbit1.getHeight() / 2)));
        marsOrbit.addActor(sMarsOrbit1);

        sMarsOrbit2.setPosition(mars.getX() + (mars.getWidth() / 2- (sMarsOrbit2.getWidth() / 2)),
                mars.getY() + (mars.getHeight() / 2 - (sMarsOrbit2.getHeight() / 2)));
        marsOrbit.addActor(sMarsOrbit2);

        sJupiterOrbit1.setPosition(jupiter.getX() + (jupiter.getWidth() / 2- (sJupiterOrbit1.getWidth() / 2)),
                jupiter.getY() + (jupiter.getHeight() / 2 - (sJupiterOrbit1.getHeight() / 2)));
        jupiterOrbit.addActor(sJupiterOrbit1);

        sJupiterOrbit2.setPosition(jupiter.getX() + (jupiter.getWidth() / 2- (sJupiterOrbit2.getWidth() / 2)),
                jupiter.getY() + (jupiter.getHeight() / 2 - (sJupiterOrbit2.getHeight() / 2)));
        jupiterOrbit.addActor(sJupiterOrbit2);

        sJupiterOrbit3.setPosition(jupiter.getX() + (jupiter.getWidth() / 2- (sJupiterOrbit3.getWidth() / 2)),
                jupiter.getY() + (jupiter.getHeight() / 2 - (sJupiterOrbit3.getHeight() / 2)));
        jupiterOrbit.addActor(sJupiterOrbit3);

        sJupiterOrbit4.setPosition(jupiter.getX() + (jupiter.getWidth() / 2- (sJupiterOrbit4.getWidth() / 2)),
                jupiter.getY() + (jupiter.getHeight() / 2 - (sJupiterOrbit4.getHeight() / 2)));
        jupiterOrbit.addActor(sJupiterOrbit4);

        sSaturnOrbit1.setPosition(saturn.getX() + (saturn.getWidth() / 2- (sSaturnOrbit1.getWidth() / 2)),
                saturn.getY() + (saturn.getHeight() / 2 - (sSaturnOrbit1.getHeight() / 2)));
        saturnOrbit.addActor(sSaturnOrbit1);

        sSaturnOrbit2.setPosition(saturn.getX() + (saturn.getWidth() / 2- (sSaturnOrbit2.getWidth() / 2)),
                saturn.getY() + (saturn.getHeight() / 2 - (sSaturnOrbit2.getHeight() / 2)));
        saturnOrbit.addActor(sSaturnOrbit2);

        sSaturnOrbit3.setPosition(saturn.getX() + (saturn.getWidth() / 2- (sSaturnOrbit3.getWidth() / 2)),
                saturn.getY() + (saturn.getHeight() / 2 - (sSaturnOrbit3.getHeight() / 2)));
        saturnOrbit.addActor(sSaturnOrbit3);

        sSaturnOrbit4.setPosition(saturn.getX() + (saturn.getWidth() / 2- (sSaturnOrbit4.getWidth() / 2)),
                saturn.getY() + (saturn.getHeight() / 2 - (sSaturnOrbit4.getHeight() / 2)));
        saturnOrbit.addActor(sSaturnOrbit4);

        sSaturnOrbit5.setPosition(saturn.getX() + (saturn.getWidth() / 2- (sSaturnOrbit5.getWidth() / 2)),
                saturn.getY() + (saturn.getHeight() / 2 - (sSaturnOrbit5.getHeight() / 2)));
        saturnOrbit.addActor(sSaturnOrbit5);

        sSaturnOrbit6.setPosition(saturn.getX() + (saturn.getWidth() / 2- (sSaturnOrbit6.getWidth() / 2)),
                saturn.getY() + (saturn.getHeight() / 2 - (sSaturnOrbit6.getHeight() / 2)));
        saturnOrbit.addActor(sSaturnOrbit6);

        sSaturnOrbit7.setPosition(saturn.getX() + (saturn.getWidth() / 2- (sSaturnOrbit7.getWidth() / 2)),
                saturn.getY() + (saturn.getHeight() / 2 - (sSaturnOrbit7.getHeight() / 2)));
        saturnOrbit.addActor(sSaturnOrbit7);

        sUranusOrbit1.setPosition(uranus.getX() + (uranus.getWidth() / 2- (sUranusOrbit1.getWidth() / 2)),
                uranus.getY() + (uranus.getHeight() / 2 - (sUranusOrbit1.getHeight() / 2)));
        uranusOrbit.addActor(sUranusOrbit1);

        sUranusOrbit2.setPosition(uranus.getX() + (uranus.getWidth() / 2- (sUranusOrbit2.getWidth() / 2)),
                uranus.getY() + (uranus.getHeight() / 2 - (sUranusOrbit2.getHeight() / 2)));
        uranusOrbit.addActor(sUranusOrbit2);

        sUranusOrbit3.setPosition(uranus.getX() + (uranus.getWidth() / 2- (sUranusOrbit3.getWidth() / 2)),
                uranus.getY() + (uranus.getHeight() / 2 - (sUranusOrbit3.getHeight() / 2)));
        uranusOrbit.addActor(sUranusOrbit3);

        sUranusOrbit4.setPosition(uranus.getX() + (uranus.getWidth() / 2- (sUranusOrbit4.getWidth() / 2)),
                uranus.getY() + (uranus.getHeight() / 2 - (sUranusOrbit4.getHeight() / 2)));
        uranusOrbit.addActor(sUranusOrbit4);

        sUranusOrbit5.setPosition(uranus.getX() + (uranus.getWidth() / 2- (sUranusOrbit5.getWidth() / 2)),
                uranus.getY() + (uranus.getHeight() / 2 - (sUranusOrbit5.getHeight() / 2)));
        uranusOrbit.addActor(sUranusOrbit5);

        sNeptuneOrbit1.setPosition(neptune.getX() + (neptune.getWidth() / 2- (sNeptuneOrbit1.getWidth() / 2)),
                neptune.getY() + (neptune.getHeight() / 2 - (sNeptuneOrbit1.getHeight() / 2)));
        neptuneOrbit.addActor(sNeptuneOrbit1);

        sNeptuneOrbit2.setPosition(neptune.getX() + (neptune.getWidth() / 2- (sNeptuneOrbit2.getWidth() / 2)),
                neptune.getY() + (neptune.getHeight() / 2 - (sNeptuneOrbit2.getHeight() / 2)));
        neptuneOrbit.addActor(sNeptuneOrbit2);

        sNeptuneOrbit3.setPosition(neptune.getX() + (neptune.getWidth() / 2- (sNeptuneOrbit3.getWidth() / 2)),
                neptune.getY() + (neptune.getHeight() / 2 - (sNeptuneOrbit3.getHeight() / 2)));
        neptuneOrbit.addActor(sNeptuneOrbit3);

        sNeptuneOrbit4.setPosition(neptune.getX() + (neptune.getWidth() / 2- (sNeptuneOrbit4.getWidth() / 2)),
                neptune.getY() + (neptune.getHeight() / 2 - (sNeptuneOrbit4.getHeight() / 2)));
        neptuneOrbit.addActor(sNeptuneOrbit4);

        sNeptuneOrbit5.setPosition(neptune.getX() + (neptune.getWidth() / 2- (sNeptuneOrbit5.getWidth() / 2)),
                neptune.getY() + (neptune.getHeight() / 2 - (sNeptuneOrbit5.getHeight() / 2)));
        neptuneOrbit.addActor(sNeptuneOrbit5);

        sNeptuneOrbit6.setPosition(neptune.getX() + (neptune.getWidth() / 2- (sNeptuneOrbit6.getWidth() / 2)),
                neptune.getY() + (neptune.getHeight() / 2 - (sNeptuneOrbit6.getHeight() / 2)));
        neptuneOrbit.addActor(sNeptuneOrbit6);

        sNeptuneOrbit7.setPosition(neptune.getX() + (neptune.getWidth() / 2- (sNeptuneOrbit7.getWidth() / 2)),
                neptune.getY() + (neptune.getHeight() / 2 - (sNeptuneOrbit7.getHeight() / 2)));
        neptuneOrbit.addActor(sNeptuneOrbit7);

        sNeptuneOrbit8.setPosition(neptune.getX() + (neptune.getWidth() / 2- (sNeptuneOrbit8.getWidth() / 2)),
                neptune.getY() + (neptune.getHeight() / 2 - (sNeptuneOrbit8.getHeight() / 2)));
        neptuneOrbit.addActor(sNeptuneOrbit8);

    }

    private void initObjects () {

        sun = new Planet(Const.RADIUS_SUN, planetScale * 2);

        mercuryOrbit = new Orbit(Const.ORB_MERCURY_RADIUS, orbitScale * 13f);
        mercuryOrbit.setCenter(this.heliocenter);
        mercuryOrbit.setTextureForSmallOrb();
        mercury = new Planet(Planet.MERCURY, Const.RADIUS_MERCURY, planetScale * 5, mercuryOrbit);

        venusOrbit = new Orbit(Const.ORB_VENUS_RADIUS, orbitScale * 9f);
        venusOrbit.setCenter(this.heliocenter);
        venusOrbit.setTextureForSmallOrb();
        venus = new Planet(Planet.VENUS, Const.RADIUS_VENUS, planetScale * 4,  venusOrbit);

        earthOrbit = new Orbit(Const.ORB_EARTH_RADIUS, orbitScale * 9.5f);
        earthOrbit.setCenter(this.heliocenter);
        earthOrbit.setTextureForSmallOrb();
        earth = new Planet(Planet.EARTH, Const.RADIUS_EARTH, planetScale * 7,  earthOrbit);

            moonOrbit = new Orbit(earth.getWidth() * 0.8f, 1);
            moonOrbit.setCenter(earth.getWidth() / 2);
            moonOrbit.setTextureForSatelliteOrb();
            moon = new Planet(Planet.MOON, earth.getWidth() * 0.15f, 1, moonOrbit);

        marsOrbit = new Orbit(Const.ORB_MARS_RADIUS, orbitScale * 9f);
        marsOrbit.setCenter(this.heliocenter);
        mars = new Planet(Planet.MARS, Const.RADIUS_MARS, planetScale * 6,  marsOrbit);

            sMarsOrbit1 = new Orbit(mars.getWidth() * 0.85f, 1);
            sMarsOrbit1.setCenter(mars.getWidth() / 2);
            sMarsOrbit1.setTextureForSatelliteOrb();
            sMars1 = new Planet(Planet.ASTEROID, mars.getWidth() * 0.15f, 1, sMarsOrbit1);

            sMarsOrbit2 = new Orbit(mars.getWidth() * 1.1f, 1);
            sMarsOrbit2.setCenter(mars.getWidth() / 2);
            sMarsOrbit2.setTextureForSatelliteOrb();
            sMars2 = new Planet(Planet.ASTEROID, mars.getWidth() * 0.2f, 1, sMarsOrbit2);

        jupiterOrbit = new Orbit(Const.ORB_JUPITER_RADIUS, orbitScale * 3.4f);
        jupiterOrbit.setCenter(this.heliocenter);
        jupiter = new Planet(Planet.JUPITER, Const.RADIUS_JUPITER, planetScale,  jupiterOrbit);

            sJupiterOrbit1 = new Orbit(jupiter.getWidth() * 0.65f, 1);
            sJupiterOrbit1.setCenter(jupiter.getWidth() / 2);
            sJupiterOrbit1.setTextureForSatelliteOrb();
            sJupiter1 = new Planet(Planet.ASTEROID, jupiter.getWidth() * 0.05f, 1, sJupiterOrbit1);

            sJupiterOrbit2 = new Orbit(jupiter.getWidth() * 0.75f, 1);
            sJupiterOrbit2.setCenter(jupiter.getWidth() / 2);
            sJupiterOrbit2.setTextureForSatelliteOrb();
            sJupiter2 = new Planet(Planet.ASTEROID, jupiter.getWidth() * 0.06f, 1, sJupiterOrbit2);

            sJupiterOrbit3 = new Orbit(jupiter.getWidth() * 0.85f, 1);
            sJupiterOrbit3.setCenter(jupiter.getWidth() / 2);
            sJupiterOrbit3.setTextureForSatelliteOrb();
            sJupiter3 = new Planet(Planet.ASTEROID, jupiter.getWidth() * 0.07f, 1, sJupiterOrbit3);

            sJupiterOrbit4 = new Orbit(jupiter.getWidth() * 0.95f, 1);
            sJupiterOrbit4.setCenter(jupiter.getWidth() / 2);
            sJupiterOrbit4.setTextureForSatelliteOrb();
            sJupiter4 = new Planet(Planet.ASTEROID, jupiter.getWidth() * 0.08f, 1, sJupiterOrbit4);

        saturnOrbit = new Orbit(Const.ORB_SATURN_RADIUS, orbitScale * 3.95f);
        saturnOrbit.setCenter(this.heliocenter);
        saturn = new Planet(Planet.SATURN, Const.RADIUS_SATURN, planetScale,  saturnOrbit);

            sSaturnOrbit1 = new Orbit(saturn.getWidth() * 0.6f, 1);
            sSaturnOrbit1.setCenter(saturn.getWidth() / 2);
            sSaturnOrbit1.setTextureForSatelliteOrb();
            sSaturn1 = new Planet(Planet.ASTEROID, saturn.getWidth() * 0.03f, 1, sSaturnOrbit1);

            sSaturnOrbit2 = new Orbit(saturn.getWidth() * 0.75f, 1);
            sSaturnOrbit2.setCenter(saturn.getWidth() / 2);
            sSaturnOrbit2.setTextureForSatelliteOrb();
            sSaturn2 = new Planet(Planet.ASTEROID, saturn.getWidth() * 0.02f, 1, sSaturnOrbit2);

            sSaturnOrbit3 = new Orbit(saturn.getWidth() * 0.9f, 1);
            sSaturnOrbit3.setCenter(saturn.getWidth() / 2);
            sSaturnOrbit3.setTextureForSatelliteOrb();
            sSaturn3 = new Planet(Planet.ASTEROID, saturn.getWidth() * 0.03f, 1, sSaturnOrbit3);

            sSaturnOrbit4 = new Orbit(saturn.getWidth() * 1.05f, 1);
            sSaturnOrbit4.setCenter(saturn.getWidth() / 2);
            sSaturnOrbit4.setTextureForSatelliteOrb();
            sSaturn4 = new Planet(Planet.ASTEROID, saturn.getWidth() * 0.04f, 1, sSaturnOrbit4);

            sSaturnOrbit5 = new Orbit(saturn.getWidth() * 1.2f, 1);
            sSaturnOrbit5.setCenter(saturn.getWidth() / 2);
            sSaturnOrbit5.setTextureForSatelliteOrb();
            sSaturn5 = new Planet(Planet.ASTEROID, saturn.getWidth() * 0.04f, 1, sSaturnOrbit5);

            sSaturnOrbit6 = new Orbit(saturn.getWidth() * 1.35f, 1);
            sSaturnOrbit6.setCenter(saturn.getWidth() / 2);
            sSaturnOrbit6.setTextureForSatelliteOrb();
            sSaturn6 = new Planet(Planet.ASTEROID, saturn.getWidth() * 0.08f, 1, sSaturnOrbit6);

            sSaturnOrbit7 = new Orbit(saturn.getWidth() * 1.50f, 1);
            sSaturnOrbit7.setCenter(saturn.getWidth() / 2);
            sSaturnOrbit7.setTextureForSatelliteOrb();
            sSaturn7 = new Planet(Planet.ASTEROID, saturn.getWidth() * 0.04f, 1, sSaturnOrbit7);

        uranusOrbit = new Orbit(Const.ORB_URANUS_RADIUS, orbitScale * 1.35f);
        uranusOrbit.setCenter(this.heliocenter);
        uranus = new Planet(Planet.URANUS, Const.RADIUS_URANUS, planetScale,  uranusOrbit);

            sUranusOrbit1 = new Orbit(uranus.getWidth() * 1.0f, 1);
            sUranusOrbit1.setCenter(uranus.getWidth() / 2);
            sUranusOrbit1.setTextureForSatelliteOrb();
            sUranus1 = new Planet(Planet.ASTEROID, uranus.getWidth() * 0.1f, 1, sUranusOrbit1);

            sUranusOrbit2 = new Orbit(uranus.getWidth() * 1.5f, 1);
            sUranusOrbit2.setCenter(uranus.getWidth() / 2);
            sUranusOrbit2.setTextureForSatelliteOrb();
            sUranus2 = new Planet(Planet.ASTEROID, uranus.getWidth() * 0.08f, 1, sUranusOrbit2);

            sUranusOrbit3 = new Orbit(uranus.getWidth() * 2.0f, 1);
            sUranusOrbit3.setCenter(uranus.getWidth() / 2);
            sUranusOrbit3.setTextureForSatelliteOrb();
            sUranus3 = new Planet(Planet.ASTEROID, uranus.getWidth() * 0.2f, 1, sUranusOrbit3);

            sUranusOrbit4 = new Orbit(uranus.getWidth() * 2.4f, 1);
            sUranusOrbit4.setCenter(uranus.getWidth() / 2);
            sUranusOrbit4.setTextureForSatelliteOrb();
            sUranus4 = new Planet(Planet.ASTEROID, uranus.getWidth() * 0.1f, 1, sUranusOrbit4);

            sUranusOrbit5 = new Orbit(uranus.getWidth() * 3.0f, 1);
            sUranusOrbit5.setCenter(uranus.getWidth() / 2);
            sUranusOrbit5.setTextureForSatelliteOrb();
            sUranus5 = new Planet(Planet.ASTEROID, uranus.getWidth() * 0.15f, 1, sUranusOrbit5);

        neptuneOrbit = new Orbit(Const.ORB_NEPTUNE_RADIUS, orbitScale);
        neptuneOrbit.setCenter(this.heliocenter);
        neptune = new Planet(Planet.NEPTUNE, Const.RADIUS_NEPTUNE, planetScale,  neptuneOrbit);

            sNeptuneOrbit1 = new Orbit(neptune.getWidth() * 0.75f, 1);
            sNeptuneOrbit1.setCenter(neptune.getWidth() / 2);
            sNeptuneOrbit1.setTextureForSatelliteOrb();
            sNeptune1 = new Planet(Planet.ASTEROID, neptune.getWidth() * 0.1f, 1, sNeptuneOrbit1);

            sNeptuneOrbit2 = new Orbit(neptune.getWidth() * 1.0f, 1);
            sNeptuneOrbit2.setCenter(neptune.getWidth() / 2);
            sNeptuneOrbit2.setTextureForSatelliteOrb();
            sNeptune2 = new Planet(Planet.ASTEROID, neptune.getWidth() * 0.15f, 1, sNeptuneOrbit2);

            sNeptuneOrbit3 = new Orbit(neptune.getWidth() * 1.25f, 1);
            sNeptuneOrbit3.setCenter(neptune.getWidth() / 2);
            sNeptuneOrbit3.setTextureForSatelliteOrb();
            sNeptune3 = new Planet(Planet.ASTEROID, neptune.getWidth() * 0.1f, 1, sNeptuneOrbit3);

            sNeptuneOrbit4 = new Orbit(neptune.getWidth() * 1.5f, 1);
            sNeptuneOrbit4.setCenter(neptune.getWidth() / 2);
            sNeptuneOrbit4.setTextureForSatelliteOrb();
            sNeptune4 = new Planet(Planet.ASTEROID, neptune.getWidth() * 0.18f, 1, sNeptuneOrbit4);

            sNeptuneOrbit5 = new Orbit(neptune.getWidth() * 1.75f, 1);
            sNeptuneOrbit5.setCenter(neptune.getWidth() / 2);
            sNeptuneOrbit5.setTextureForSatelliteOrb();
            sNeptune5 = new Planet(Planet.ASTEROID, neptune.getWidth() * 0.1f, 1, sNeptuneOrbit5);

            sNeptuneOrbit6 = new Orbit(neptune.getWidth() * 2.0f, 1);
            sNeptuneOrbit6.setCenter(neptune.getWidth() / 2);
            sNeptuneOrbit6.setTextureForSatelliteOrb();
            sNeptune6 = new Planet(Planet.ASTEROID, neptune.getWidth() * 0.19f, 1, sNeptuneOrbit6);

            sNeptuneOrbit7 = new Orbit(neptune.getWidth() * 2.25f, 1);
            sNeptuneOrbit7.setCenter(neptune.getWidth() / 2);
            sNeptuneOrbit7.setTextureForSatelliteOrb();
            sNeptune7 = new Planet(Planet.ASTEROID, neptune.getWidth() * 0.1f, 1, sNeptuneOrbit7);

            sNeptuneOrbit8 = new Orbit(neptune.getWidth() * 2.5f, 1);
            sNeptuneOrbit8.setCenter(neptune.getWidth() / 2);
            sNeptuneOrbit8.setTextureForSatelliteOrb();
            sNeptune8 = new Planet(Planet.ASTEROID, neptune.getWidth() * 0.1f, 1, sNeptuneOrbit8);

    }

    /* DEGREE EVERY DELTA */
    private float getScaledSpeed (float realSpeed, float multiplier) {
        double bPeriod = realSpeed * 24 * 60; // rotation period in minutes
        double uPeriod = bPeriod / 360; // time to rotate on 1 degree in minutes
        double minDegree = 1 / uPeriod; // degrees in 1 minute
        double secDegree = minDegree / 60; // degrees in 1 sec // todo E-5
        double fps = Gdx.graphics.getFramesPerSecond(); // FPS
        if (fps == 0.0) {
            fps = 60; // очень жёсткий костыль
        }
        double delta = Gdx.graphics.getDeltaTime(); // delta
        double deltaFPS = fps * delta; // time for all frames in FPS
        double deltaDegree = secDegree / deltaFPS; // degrees per delta

//        System.out.println(bPeriod + " "  // debug
//                        + uPeriod + " "  // debug
//                        + minDegree + " "  // debug
//                        + secDegree + " "  // debug
//                        + fps + " "  // debug
//                        + delta + " "  // debug
//                        + deltaFPS + " "  // debug
//                        + deltaDegree); // debug

        return  (float) (deltaDegree * (double) multiplier);

    }

    public void setSatellitesVisible (boolean visible) {
        moonOrbit.setVisible(visible);
        sMarsOrbit1.setVisible(visible);
        sMarsOrbit2.setVisible(visible);
        sJupiterOrbit1.setVisible(visible);
        sJupiterOrbit2.setVisible(visible);
        sJupiterOrbit3.setVisible(visible);
        sJupiterOrbit4.setVisible(visible);
        sSaturnOrbit1.setVisible(visible);
        sSaturnOrbit2.setVisible(visible);
        sSaturnOrbit3.setVisible(visible);
        sSaturnOrbit4.setVisible(visible);
        sSaturnOrbit5.setVisible(visible);
        sSaturnOrbit6.setVisible(visible);
        sSaturnOrbit7.setVisible(visible);
        sUranusOrbit1.setVisible(visible);
        sUranusOrbit2.setVisible(visible);
        sUranusOrbit3.setVisible(visible);
        sUranusOrbit4.setVisible(visible);
        sUranusOrbit5.setVisible(visible);
        sNeptuneOrbit1.setVisible(visible);
        sNeptuneOrbit2.setVisible(visible);
        sNeptuneOrbit3.setVisible(visible);
        sNeptuneOrbit4.setVisible(visible);
        sNeptuneOrbit5.setVisible(visible);
        sNeptuneOrbit6.setVisible(visible);
        sNeptuneOrbit7.setVisible(visible);
        sNeptuneOrbit8.setVisible(visible);
    }

    public void setPause (boolean pause) {
        if (pause) {
            isPause = true;
        } else {
            isPause = false;
        }
    }

    public String getStateString () {
        if (isPause) {
            return "PAUSED";
        } else {
            return "WORKING";
        }
    }

    public void setSpeedMultiplier(float increment) {
        this.speedMultiplier += increment;
    }

    public float getSpeedMultiplier() {
        return speedMultiplier;
    }

    public void update () {

        if (!isPause) {

            sun.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_SUN, speedMultiplier));

        /* PLANETS */

            mercury.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MERCURY, speedMultiplier));
            venus.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_VENUS, speedMultiplier));
            earth.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_EARTH, speedMultiplier));
            mars.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MARS, speedMultiplier));
            jupiter.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_JUPITER, speedMultiplier));
            saturn.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_SATURN, speedMultiplier));
            uranus.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_URANUS, speedMultiplier));
            neptune.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_NEPTUNE, speedMultiplier));

            mercury.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MERCURY, speedMultiplier));
            venus.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_VENUS, speedMultiplier));
            earth.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_EARTH, speedMultiplier));
            mars.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MARS, speedMultiplier));
            jupiter.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_JUPITER, speedMultiplier));
            saturn.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_SATURN, speedMultiplier));
            uranus.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_URANUS, speedMultiplier));
            neptune.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_NEPTUNE, speedMultiplier));

        /* SATELLITES */

            moonOrbit.setPosition(earth.getX() + earth.getWidth() / 2 - (moonOrbit.getWidth() / 2),
                    earth.getY() + earth.getHeight() / 2 - (moonOrbit.getHeight() / 2));
            sMarsOrbit1.setPosition(mars.getX() + (mars.getWidth() / 2 - (sMarsOrbit1.getWidth() / 2)),
                    mars.getY() + (mars.getHeight() / 2 - (sMarsOrbit1.getHeight() / 2)));
            sMarsOrbit2.setPosition(mars.getX() + (mars.getWidth() / 2 - (sMarsOrbit2.getWidth() / 2)),
                    mars.getY() + (mars.getHeight() / 2 - (sMarsOrbit2.getHeight() / 2)));
            sJupiterOrbit1.setPosition(jupiter.getX() + (jupiter.getWidth() / 2 - (sJupiterOrbit1.getWidth() / 2)),
                    jupiter.getY() + (jupiter.getHeight() / 2 - (sJupiterOrbit1.getHeight() / 2)));
            sJupiterOrbit2.setPosition(jupiter.getX() + (jupiter.getWidth() / 2 - (sJupiterOrbit2.getWidth() / 2)),
                    jupiter.getY() + (jupiter.getHeight() / 2 - (sJupiterOrbit2.getHeight() / 2)));
            sJupiterOrbit3.setPosition(jupiter.getX() + (jupiter.getWidth() / 2 - (sJupiterOrbit3.getWidth() / 2)),
                    jupiter.getY() + (jupiter.getHeight() / 2 - (sJupiterOrbit3.getHeight() / 2)));
            sJupiterOrbit4.setPosition(jupiter.getX() + (jupiter.getWidth() / 2 - (sJupiterOrbit4.getWidth() / 2)),
                    jupiter.getY() + (jupiter.getHeight() / 2 - (sJupiterOrbit4.getHeight() / 2)));
            sSaturnOrbit1.setPosition(saturn.getX() + (saturn.getWidth() / 2 - (sSaturnOrbit1.getWidth() / 2)),
                    saturn.getY() + (saturn.getHeight() / 2 - (sSaturnOrbit1.getHeight() / 2)));
            sSaturnOrbit2.setPosition(saturn.getX() + (saturn.getWidth() / 2 - (sSaturnOrbit2.getWidth() / 2)),
                    saturn.getY() + (saturn.getHeight() / 2 - (sSaturnOrbit2.getHeight() / 2)));
            sSaturnOrbit3.setPosition(saturn.getX() + (saturn.getWidth() / 2 - (sSaturnOrbit3.getWidth() / 2)),
                    saturn.getY() + (saturn.getHeight() / 2 - (sSaturnOrbit3.getHeight() / 2)));
            sSaturnOrbit4.setPosition(saturn.getX() + (saturn.getWidth() / 2 - (sSaturnOrbit4.getWidth() / 2)),
                    saturn.getY() + (saturn.getHeight() / 2 - (sSaturnOrbit4.getHeight() / 2)));
            sSaturnOrbit5.setPosition(saturn.getX() + (saturn.getWidth() / 2 - (sSaturnOrbit5.getWidth() / 2)),
                    saturn.getY() + (saturn.getHeight() / 2 - (sSaturnOrbit5.getHeight() / 2)));
            sSaturnOrbit6.setPosition(saturn.getX() + (saturn.getWidth() / 2 - (sSaturnOrbit6.getWidth() / 2)),
                    saturn.getY() + (saturn.getHeight() / 2 - (sSaturnOrbit6.getHeight() / 2)));
            sSaturnOrbit7.setPosition(saturn.getX() + (saturn.getWidth() / 2 - (sSaturnOrbit7.getWidth() / 2)),
                    saturn.getY() + (saturn.getHeight() / 2 - (sSaturnOrbit7.getHeight() / 2)));
            sUranusOrbit1.setPosition(uranus.getX() + (uranus.getWidth() / 2 - (sUranusOrbit1.getWidth() / 2)),
                    uranus.getY() + (uranus.getHeight() / 2 - (sUranusOrbit1.getHeight() / 2)));
            sUranusOrbit2.setPosition(uranus.getX() + (uranus.getWidth() / 2 - (sUranusOrbit2.getWidth() / 2)),
                    uranus.getY() + (uranus.getHeight() / 2 - (sUranusOrbit2.getHeight() / 2)));
            sUranusOrbit3.setPosition(uranus.getX() + (uranus.getWidth() / 2 - (sUranusOrbit3.getWidth() / 2)),
                    uranus.getY() + (uranus.getHeight() / 2 - (sUranusOrbit3.getHeight() / 2)));
            sUranusOrbit4.setPosition(uranus.getX() + (uranus.getWidth() / 2 - (sUranusOrbit4.getWidth() / 2)),
                    uranus.getY() + (uranus.getHeight() / 2 - (sUranusOrbit4.getHeight() / 2)));
            sUranusOrbit5.setPosition(uranus.getX() + (uranus.getWidth() / 2 - (sUranusOrbit5.getWidth() / 2)),
                    uranus.getY() + (uranus.getHeight() / 2 - (sUranusOrbit5.getHeight() / 2)));
            sNeptuneOrbit1.setPosition(neptune.getX() + (neptune.getWidth() / 2 - (sNeptuneOrbit1.getWidth() / 2)),
                    neptune.getY() + (neptune.getHeight() / 2 - (sNeptuneOrbit1.getHeight() / 2)));
            sNeptuneOrbit2.setPosition(neptune.getX() + (neptune.getWidth() / 2 - (sNeptuneOrbit2.getWidth() / 2)),
                    neptune.getY() + (neptune.getHeight() / 2 - (sNeptuneOrbit2.getHeight() / 2)));
            sNeptuneOrbit3.setPosition(neptune.getX() + (neptune.getWidth() / 2 - (sNeptuneOrbit3.getWidth() / 2)),
                    neptune.getY() + (neptune.getHeight() / 2 - (sNeptuneOrbit3.getHeight() / 2)));
            sNeptuneOrbit4.setPosition(neptune.getX() + (neptune.getWidth() / 2 - (sNeptuneOrbit4.getWidth() / 2)),
                    neptune.getY() + (neptune.getHeight() / 2 - (sNeptuneOrbit4.getHeight() / 2)));
            sNeptuneOrbit5.setPosition(neptune.getX() + (neptune.getWidth() / 2 - (sNeptuneOrbit5.getWidth() / 2)),
                    neptune.getY() + (neptune.getHeight() / 2 - (sNeptuneOrbit5.getHeight() / 2)));
            sNeptuneOrbit6.setPosition(neptune.getX() + (neptune.getWidth() / 2 - (sNeptuneOrbit6.getWidth() / 2)),
                    neptune.getY() + (neptune.getHeight() / 2 - (sNeptuneOrbit6.getHeight() / 2)));
            sNeptuneOrbit7.setPosition(neptune.getX() + (neptune.getWidth() / 2 - (sNeptuneOrbit7.getWidth() / 2)),
                    neptune.getY() + (neptune.getHeight() / 2 - (sNeptuneOrbit7.getHeight() / 2)));
            sNeptuneOrbit8.setPosition(neptune.getX() + (neptune.getWidth() / 2 - (sNeptuneOrbit8.getWidth() / 2)),
                    neptune.getY() + (neptune.getHeight() / 2 - (sNeptuneOrbit8.getHeight() / 2)));

            moon.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MOON, speedMultiplier));
            sMars1.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MOON * 3, speedMultiplier));
            sMars2.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MOON * 2.5f, speedMultiplier));
            sJupiter1.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MOON * 2f, speedMultiplier));
            sJupiter2.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MOON * 0.8f, speedMultiplier));
            sJupiter3.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MOON * 0.7f, speedMultiplier));
            sJupiter4.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MOON * 0.6f, speedMultiplier));
            sSaturn1.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MOON * 2f, speedMultiplier));
            sSaturn2.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MOON * 1.1f, speedMultiplier));
            sSaturn3.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MOON * 2.1f, speedMultiplier));
            sSaturn4.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MOON * 0.5f, speedMultiplier));
            sSaturn5.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MOON * 0.6f, speedMultiplier));
            sSaturn6.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MOON * 2f, speedMultiplier));
            sSaturn7.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MOON * 0.9f, speedMultiplier));
            sUranus1.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MOON * 0.9f, speedMultiplier));
            sUranus2.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MOON * 0.8f, speedMultiplier));
            sUranus3.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MOON * 0.7f, speedMultiplier));
            sUranus4.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MOON * 0.6f, speedMultiplier));
            sUranus5.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MOON * 0.5f, speedMultiplier));
            sNeptune1.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MOON * 0.56f, speedMultiplier));
            sNeptune2.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MOON * 0.58f, speedMultiplier));
            sNeptune3.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MOON * 0.95f, speedMultiplier));
            sNeptune4.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MOON * 0.85f, speedMultiplier));
            sNeptune5.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MOON * 0.35f, speedMultiplier));
            sNeptune6.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MOON * 0.85f, speedMultiplier));
            sNeptune7.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MOON * 0.65f, speedMultiplier));
            sNeptune8.updateAxisPosition(getScaledSpeed(Const.AXIS_TIME_MOON * 0.75f, speedMultiplier));

            moon.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MOON, speedMultiplier));
            sMars1.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MOON * 0.8f, speedMultiplier));
            sMars2.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MOON * 0.6f, speedMultiplier));
            sJupiter1.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MOON * 0.7f, speedMultiplier));
            sJupiter2.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MOON * 0.8f, speedMultiplier));
            sJupiter3.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MOON * 0.9f, speedMultiplier));
            sJupiter4.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MOON * 1.1f, speedMultiplier));
            sSaturn1.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MOON * 1.1f, speedMultiplier));
            sSaturn2.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MOON * 0.8f, speedMultiplier));
            sSaturn3.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MOON * 0.6f, speedMultiplier));
            sSaturn4.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MOON * 1.4f, speedMultiplier));
            sSaturn5.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MOON * 0.9f, speedMultiplier));
            sSaturn6.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MOON * 0.75f, speedMultiplier));
            sSaturn7.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MOON * 1.1f, speedMultiplier));
            sUranus1.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MOON * 0.5f, speedMultiplier));
            sUranus2.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MOON * 0.6f, speedMultiplier));
            sUranus3.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MOON * 0.7f, speedMultiplier));
            sUranus4.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MOON * 0.85f, speedMultiplier));
            sUranus5.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MOON * 0.9f, speedMultiplier));
            sNeptune1.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MOON * 0.9f, speedMultiplier));
            sNeptune2.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MOON * 1.9f, speedMultiplier));
            sNeptune3.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MOON * 0.8f, speedMultiplier));
            sNeptune4.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MOON * 0.75f, speedMultiplier));
            sNeptune5.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MOON * 0.9f, speedMultiplier));
            sNeptune6.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MOON * 0.6f, speedMultiplier));
            sNeptune7.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MOON * 1.2f, speedMultiplier));
            sNeptune8.updateOrbitPosition(getScaledSpeed(Const.ORB_TIME_MOON * 1.15f, speedMultiplier));

        }

    }

    public static final int
            P_MER = 1,
            P_VEN = 2,
            P_EAR = 3,
            P_MAR = 4,
            P_JUP = 5,
            P_SAT = 6,
            P_URA = 7,
            P_NEP = 8;

    public double getPlanetAngle (int planet) {
        double x1, y1;
        double x2, y2;

        switch (planet) {
            case P_MER:
                x1 = mercury.getX() + (mercury.getWidth() / 2);
                y1 = mercury.getY() + (mercury.getHeight() / 2);
                x2 = mercuryOrbit.getWidth() / 2;
                y2 = mercuryOrbit.getHeight();
                break;
            case P_VEN:
                x1 = venus.getX() + (venus.getWidth() / 2);
                y1 = venus.getY() + (venus.getHeight() / 2);
                x2 = venusOrbit.getWidth() / 2;
                y2 = venusOrbit.getHeight();
                break;
            case P_EAR:
                x1 = earth.getX() + (earth.getWidth() / 2);
                y1 = earth.getY() + (earth.getHeight() / 2);
                x2 = earthOrbit.getWidth() / 2;
                y2 = earthOrbit.getHeight();
                break;
            case P_MAR:
                x1 = mars.getX() + (mars.getWidth() / 2);
                y1 = mars.getY() + (mars.getHeight() / 2);
                x2 = marsOrbit.getWidth() / 2;
                y2 = marsOrbit.getHeight();
                break;
            case P_JUP:
                x1 = jupiter.getX() + (jupiter.getWidth() / 2);
                y1 = jupiter.getY() + (jupiter.getHeight() / 2);
                x2 = jupiterOrbit.getWidth() / 2;
                y2 = jupiterOrbit.getHeight();
                break;
            case P_SAT:
                x1 = saturn.getX() + (saturn.getWidth() / 2);
                y1 = saturn.getY() + (saturn.getHeight() / 2);
                x2 = saturnOrbit.getWidth() / 2;
                y2 = saturnOrbit.getHeight();
                break;
            case P_URA:
                x1 = uranus.getX() + (uranus.getWidth() / 2);
                y1 = uranus.getY() + (uranus.getHeight() / 2);
                x2 = uranusOrbit.getWidth() / 2;
                y2 = uranusOrbit.getHeight();
                break;
            case P_NEP:
                x1 = neptune.getX() + (neptune.getWidth() / 2);
                y1 = neptune.getY() + (neptune.getHeight() / 2);
                x2 = neptuneOrbit.getWidth() / 2;
                y2 = neptuneOrbit.getHeight();
                break;
            default:
                x1 = 1; x2 = 1; y1 = 1; y2 = 1;
                break;
        }

        return Math.atan2(y2-y1,x2-x1) / Math.PI * 360;

    }

}
