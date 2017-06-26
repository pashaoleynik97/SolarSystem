package com.oleynik.solarsystem.OBJ;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.oleynik.solarsystem.RES.Resources;
import com.oleynik.solarsystem.SCREENS.SpaceScreen;

/**
 * Created by MATHAHAKAR on 24.11.2016.
 * vk.com/mathahakar
 * mathahakar1997@gmail.com
 */
public class Planet extends Group {

    private TextureAtlas.AtlasRegion regionToDraw;

    PlanetActor planetActor;

    private float actorSize;

    private float radius;
    private Orbit orbit;

    private float x, y;
    private float x0, y0;
    private float angle;
    private float orbitRadius;

    private String information;

    private String name;

    private int planet;

    public static final int
            MERCURY = 1,
            VENUS = 2,
            EARTH = 3,
            MOON = 31,
            MARS = 4,
            JUPITER = 5,
            SATURN = 6,
            URANUS = 7,
            NEPTUNE = 8,
            ASTEROID = 9;

    /**
     * Constructor for planet
     *
     * @param radius - planet radius
     * @param orbit - Orbit obj
     */
    public Planet (int planet, float radius, float scale, Orbit orbit) {
        this.radius = radius;
        this.orbit = orbit;
        this.planet = planet;

        x0 = orbit.getWidth() / 2;
        y0 = orbit.getHeight() / 2;
        angle = randomizeAngle();
        orbitRadius = orbit.getWidth() / 2;

        x = x0 + orbitRadius * (float)Math.cos(angle);
        y = y0 + orbitRadius * (float)Math.sin(angle);

        this.setSize((radius * scale) * 2, (radius * scale) * 2);
        this.actorSize = this.getWidth();
        this.setPosition(x, y);
        orbit.addActor(this);

        addPlanetListener();

        chooseTexture();

        planetActor = new PlanetActor();
        this.addActor(planetActor);

    }

    /**
     * Constructor for SUN (Alternative)
     *
     * @param radius - planet radius
     */
    public Planet (float radius, float scale) {
        this.radius = radius;
        this.setSize((radius * scale) * 2, (radius * scale) * 2);
        addPlanetListener();
        chooseTexture();
        this.actorSize = this.getWidth();
        planetActor = new PlanetActor();
        this.addActor(planetActor);
    }

    private class PlanetActor extends Actor {

        public PlanetActor () {
            this.setSize(actorSize, actorSize);
            this.setPosition(0, 0);
        }

        @Override
        public void draw(Batch batch, float parentAlpha) {
            Color color = this.getColor();
            batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
            batch.draw(regionToDraw, getX(), getY(), getWidth() / 2.0f, getHeight() / 2.0f, getWidth(),
                    getHeight(), 1, 1, getRotation());
            super.draw(batch, batch.getColor().a);
        }

    }

    private void addPlanetListener () {

        this.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("CLICKED " + name);
                SpaceScreen.setNewInformation(name + "\n" + information);
                super.touchUp(event, x, y, pointer, button);
            }
        });
    }

    private float randomizeAngle () {
        return MathUtils.random(0, 360);
    }

    private void chooseTexture () {
        switch (planet) {
            case MERCURY:
                this.name = "MERCURY";
                this.information = "Mercury (0.4 AU from the Sun) is the closest planet to the Sun and the " +
                        "smallest planet in the Solar System (0.055 Earth masses). Mercury has no natural " +
                        "satellites; besides impact craters, its only known geological features are lobed " +
                        "ridges or rupes that were probably produced by a period of contraction early in " +
                        "its history. Mercury's very tenuous atmosphere consists of atoms blasted off its " +
                        "surface by the solar wind. Its relatively large iron core and thin mantle have not " +
                        "yet been adequately explained. Hypotheses include that its outer layers were stripped " +
                        "off by a giant impact; or, that it was prevented from fully accreting by the young Sun's " +
                        "energy.";
                this.regionToDraw = Resources.ImgRes.getRegion(Resources.ImgRes.MERCURY);
                break;
            case VENUS:
                this.name = "VENUS";
                this.information = "Venus (0.7 AU from the Sun) is close in size to Earth (0.815 Earth masses) " +
                        "and, like Earth, has a thick silicate mantle around an iron core, a substantial " +
                        "atmosphere, and evidence of internal geological activity. It is much drier than " +
                        "Earth, and its atmosphere is ninety times as dense. Venus has no natural satellites. " +
                        "It is the hottest planet, with surface temperatures over 400 °C (752°F), most likely " +
                        "due to the amount of greenhouse gases in the atmosphere. No definitive evidence of " +
                        "current geological activity has been detected on Venus, but it has no magnetic field " +
                        "that would prevent depletion of its substantial atmosphere, which suggests that its " +
                        "atmosphere is being replenished by volcanic eruptions.";
                this.regionToDraw = Resources.ImgRes.getRegion(Resources.ImgRes.VENUS);
                break;
            case EARTH:
                this.name = "EARTH";
                this.information = "Earth (1 AU from the Sun) is the largest and densest of the inner planets, " +
                        "the only one known to have current geological activity, and the only place where life " +
                        "is known to exist. Its liquid hydrosphere is unique among the terrestrial planets, and " +
                        "it is the only planet where plate tectonics has been observed. Earth's atmosphere is " +
                        "radically different from those of the other planets, having been altered by the presence " +
                        "of life to contain 21% free oxygen. It has one natural satellite, the Moon, the only large " +
                        "satellite of a terrestrial planet in the Solar System.";
                this.regionToDraw = Resources.ImgRes.getRegion(Resources.ImgRes.EARTH);
                break;
            case MOON:
                this.name = "MOON";
                this.information = "The Moon is Earth's only permanent natural satellite. It is the fifth-largest " +
                        "natural satellite in the Solar System, and the largest among planetary satellites " +
                        "relative to the size of the planet that it orbits (its primary). It is the second-densest " +
                        "satellite among those whose densities are known (after Jupiter's satellite Io).\n" +
                        "The average distance of the Moon from the Earth is 384,400 km (238,900 mi), or 1.28 " +
                        "light-seconds.\n" +
                        "The Moon is thought to have formed about 4.5 billion years ago, not long after Earth. ";
                this.regionToDraw = Resources.ImgRes.getRegion(Resources.ImgRes.MOON);
                break;
            case MARS:
                this.name = "MARS";
                this.information = "Mars (1.5 AU from the Sun) is smaller than Earth and Venus " +
                        "(0.107 Earth masses). It has an atmosphere of mostly carbon dioxide with a " +
                        "surface pressure of 6.1 millibars (roughly 0.6% of that of Earth). Its surface, " +
                        "peppered with vast volcanoes, such as Olympus Mons, and rift valleys, such as " +
                        "Valles Marineris, shows geological activity that may have persisted until as " +
                        "recently as 2 million years ago. Its red colour comes from iron oxide (rust) " +
                        "in its soil. Mars has two tiny natural satellites (Deimos and Phobos) thought " +
                        "to be captured asteroids.";
                this.regionToDraw = Resources.ImgRes.getRegion(Resources.ImgRes.MARS);
                break;
            case JUPITER:
                this.name = "JUPITER";
                this.information = "Jupiter (5.2 AU), at 318 Earth masses, is 2.5 times the mass of all " +
                        "the other planets put together. It is composed largely of hydrogen and helium. " +
                        "Jupiter's strong internal heat creates semi-permanent features in its atmosphere, " +
                        "such as cloud bands and the Great Red Spot. Jupiter has 67 known satellites. The " +
                        "four largest, Ganymede, Callisto, Io, and Europa, show similarities to the " +
                        "terrestrial planets, such as volcanism and internal heating. Ganymede, the largest " +
                        "satellite in the Solar System, is larger than Mercury.";
                this.regionToDraw = Resources.ImgRes.getRegion(Resources.ImgRes.JUPITER);
                break;
            case SATURN:
                this.name = "SATURN";
                this.information = "Saturn (9.5 AU), distinguished by its extensive ring system, has " +
                        "several similarities to Jupiter, such as its atmospheric composition and " +
                        "magnetosphere. Although Saturn has 60% of Jupiter's volume, it is less than a " +
                        "third as massive, at 95 Earth masses. Saturn is the only planet of the Solar " +
                        "System that is less dense than water. The rings of Saturn are made up of small " +
                        "ice and rock particles. Saturn has 62 confirmed satellites composed largely of ice. " +
                        "Two of these, Titan and Enceladus, show signs of geological activity. Titan, the " +
                        "second-largest moon in the Solar System, is larger than Mercury and the only satellite " +
                        "in the Solar System with a substantial atmosphere.";
                this.regionToDraw = Resources.ImgRes.getRegion(Resources.ImgRes.SATURN);
                break;
            case URANUS:
                this.name = "URANUS";
                this.information = "Uranus (19.2 AU), at 14 Earth masses, is the lightest of the outer planets. " +
                        "Uniquely among the planets, it orbits the Sun on its side; its axial tilt is over " +
                        "ninety degrees to the ecliptic. It has a much colder core than the other giant " +
                        "planets and radiates very little heat into space. Uranus has 27 known satellites, " +
                        "the largest ones being Titania, Oberon, Umbriel, Ariel, and Miranda.";
                this.regionToDraw = Resources.ImgRes.getRegion(Resources.ImgRes.URANUS);
                break;
            case NEPTUNE:
                this.name = "NEPTUNE";
                this.information = "Neptune (30.1 AU), though slightly smaller than Uranus, is more massive " +
                        "(equivalent to 17 Earths) and hence more dense. It radiates more internal heat, " +
                        "but not as much as Jupiter or Saturn. Neptune has 14 known satellites. The largest, " +
                        "Triton, is geologically active, with geysers of liquid nitrogen. Triton is the only " +
                        "large satellite with a retrograde orbit. Neptune is accompanied in its orbit by several " +
                        "minor planets, termed Neptune trojans, that are in 1:1 resonance with it.";
                this.regionToDraw = Resources.ImgRes.getRegion(Resources.ImgRes.NEPTUNE);
                break;
            case ASTEROID:
                this.name = "ASTEROID";
                this.information = "Asteroids are minor planets, especially those of the inner Solar System. " +
                        "The larger ones have also been called planetoids. These terms have historically " +
                        "been applied to any astronomical object orbiting the Sun that did not show the " +
                        "disc of a planet and was not observed to have the characteristics of an active comet. ";
                this.regionToDraw = Resources.ImgRes.getRegion(Resources.ImgRes.ASTEROID);
                break;
            default:
                // SUN
                this.name = "SUN";
                this.information = "The Sun is the star at the center of the Solar System. " +
                        "It is a nearly perfect sphere of hot plasma, with internal convective motion " +
                        "that generates a magnetic field via a dynamo process. It is by far the most " +
                        "important source of energy for life on Earth. Its diameter is about 109 times " +
                        "that of Earth, and its mass is about 330,000 times that of Earth, accounting for " +
                        "about 99.86% of the total mass of the Solar System. About three quarters of the " +
                        "Sun's mass consists of hydrogen (~73%); the rest is mostly helium (~25%), with " +
                        "much smaller quantities of heavier elements, including oxygen, carbon, neon, and iron.";
                this.regionToDraw = Resources.ImgRes.getRegion(Resources.ImgRes.SUN);
                break;
        }
    }

    public void updateAxisPosition (float degree) {
        planetActor.addAction(Actions.rotateBy(degree));
    }

    public void updateOrbitPosition (float degree) {
        angle += degree;
        x = x0 + orbitRadius * (float)Math.cos(angle);
        y = y0 + orbitRadius * (float)Math.sin(angle);
        this.addAction(Actions.moveTo(x - this.getWidth() / 2, y - this.getHeight() / 2));
    }

    public float getRadius() {
        return radius;
    }

    public Orbit getOrbit() {
        return orbit;
    }

}
