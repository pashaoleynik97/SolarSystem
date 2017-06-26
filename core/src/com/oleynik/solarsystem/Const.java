package com.oleynik.solarsystem;

/**
 * Created by MATHAHAKAR on 25.11.2016.
 * vk.com/mathahakar
 * mathahakar1997@gmail.com
 */
public class Const {

    private static float GLOBAL_SCALE = 0.001f;

    /* ORBITS RADIUS (KM) */
    public static final float ORB_MERCURY_RADIUS = ((46001009L + 69817445L) / 2) * GLOBAL_SCALE;
    public static final float ORB_VENUS_RADIUS   = ((107476259L + 108942109L) / 2) * GLOBAL_SCALE;
    public static final float ORB_EARTH_RADIUS   = ((147098290L + 152098232L) / 2) * GLOBAL_SCALE;
    public static final float ORB_MARS_RADIUS    = ((206655000L + 249232000L) / 2) * GLOBAL_SCALE;
    public static final float ORB_JUPITER_RADIUS = ((740573600L + 816520800L) / 2) * GLOBAL_SCALE;
    public static final float ORB_SATURN_RADIUS  = ((135357296L + 1513325783L) / 2) * GLOBAL_SCALE;
    public static final float ORB_URANUS_RADIUS  = ((2748938461L + 3004419704L) / 2) * GLOBAL_SCALE;
    public static final float ORB_NEPTUNE_RADIUS = (((4452940833L + 4553946490L) / 2)) * GLOBAL_SCALE;
    public static final float ORB_MOON_RADIUS    = 363104L * GLOBAL_SCALE;


    /* AXIS ROTATION TIME (DAYS) */
    public static final float AXIS_TIME_SUN = 25.379995f;
    public static final float AXIS_TIME_MERCURY = 58.6462f;
    public static final float AXIS_TIME_VENUS = 243.0187f;
    public static final float AXIS_TIME_EARTH = 0.99726968f;
    public static final float AXIS_TIME_MOON = 27.321661f;
    public static final float AXIS_TIME_MARS = 1.02595675f;
    public static final float AXIS_TIME_JUPITER = 0.41354f;
    public static final float AXIS_TIME_SATURN = 0.44401f;
    public static final float AXIS_TIME_URANUS = 0.71833f;
    public static final float AXIS_TIME_NEPTUNE = 0.67125f;

    /* ORBIT TIME (DAYS) */
    public static final float ORB_TIME_MERCURY = 87.97f;
    public static final float ORB_TIME_VENUS = 224.7f;
    public static final float ORB_TIME_EARTH = 365.2564f;
    public static final float ORB_TIME_MOON = 27.322f; // with Earth as center
    public static final float ORB_TIME_MARS = 686.68202f;
    public static final float ORB_TIME_ASTEROIDS = 1680.17944f;
    public static final float ORB_TIME_JUPITER = 4331.940904f;
    public static final float ORB_TIME_SATURN = 10760.453544f;
    public static final float ORB_TIME_URANUS = 30688.842728f;
    public static final float ORB_TIME_NEPTUNE = 60186.949592f;

    /* PLANETS RADIUS (KM) */
    public static final float RADIUS_MERCURY = 2439.7f * GLOBAL_SCALE;
    public static final float RADIUS_VENUS = 6051.8f * GLOBAL_SCALE;
    public static final float RADIUS_EARTH = 6371.0f * GLOBAL_SCALE;
    public static final float RADIUS_MARS = 3389.5f * GLOBAL_SCALE;
    public static final float RADIUS_JUPITER = 69911.0f * GLOBAL_SCALE;
    public static final float RADIUS_SATURN = 58232.0f * GLOBAL_SCALE;
    public static final float RADIUS_URANUS = 25362.0f * GLOBAL_SCALE;
    public static final float RADIUS_NEPTUNE = 24622.0f * GLOBAL_SCALE;
    public static final float RADIUS_MOON = 1737.1f * GLOBAL_SCALE;
//    public static final float RADIUS_SUN = 696000000.0f; // * too big for model
    public static final float RADIUS_SUN = RADIUS_JUPITER; // as Jupiter


}
