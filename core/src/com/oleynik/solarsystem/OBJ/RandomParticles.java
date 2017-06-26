package com.oleynik.solarsystem.OBJ;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.oleynik.solarsystem.RES.Resources;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MATHAHAKAR on 28.11.2016.
 * vk.com/mathahakar
 * mathahakar1997@gmail.com
 */
public class RandomParticles {

    private List<Particle> particles;

    private float maxX, maxY;
    private float size;

    private Stage stage;

    /**
     * Конструктор подвижных частиц
     *
     * @param quantity - кол-во частиц
     * @param size - размер частицы
     * @param maxX - максимально допустимое значение X (для всего экрана: stage.getWidth())
     * @param maxY - максимально допустимое значение Y (для всего экрана: stage.getHeight())
     * @param stage - сцена, на которую необходимо добавить частицы
     */
    public RandomParticles (float quantity, float size, float maxX, float maxY, Stage stage) {
        this.size = size;
        this.maxX = maxX;
        this.maxY = maxY;

        this.stage = stage;

        this.particles = new ArrayList<Particle>();

        createParticles(quantity);
        addParticlesOnStage();
    }

    private class Particle extends Actor {

        private boolean notMoving = true;

        private float destinationX, destinationY;

        /**
         * Конструктор частицы
         *
         * @param size - размер частицы
         */
        public Particle (float size) {

            this.setSize(size, size);
            this.setPosition(randX(), randY());

        }

        @Override
        public void draw(Batch batch, float parentAlpha) {
            batch.draw(Resources.ImgRes.getRegion(Resources.ImgRes.ASTEROID), getX(), getY(), getWidth(), getHeight());
            super.draw(batch, parentAlpha);
        }


    }

    /**
     * Метод для создания объектов частиц и добавления их в List
     *
     * @param quantity - кол-во создаваемых частиц
     */
    private void createParticles (float quantity) {
        for (int i = 0; i < quantity; i ++) {
            particles.add(new Particle(MathUtils.random(this.size * 0.1f, this.size)));
        }
    }

    /**
     * Метод для назначения случайных координат и запуска движения частиц в сгенерированное место
     * Выполняется только в случае значения переменной notMoving = true
     * Вызывается в методе update ()
     */
    private void moveParticles () {
        for (int i = 0; i < particles.size(); i ++) {
            if (particles.get(i).notMoving) {
                particles.get(i).destinationX = randX();
                particles.get(i).destinationY = randY();
                particles.get(i).addAction(Actions.moveTo(particles.get(i).destinationX,
                        particles.get(i).destinationY, MathUtils.random(25.0f, 50.0f)));
                particles.get(i).notMoving = false;
            }
        }
    }

    /**
     * Проверка достижения частицей установленных координат
     * Если частица достигает координат, значение переменной notMoving = true
     * Это позволяет методу moveParticles () назначить новые случайные координаты
     * Вызывается в update ()
     */
    private void checkParticles () {
        for (int i = 0; i < particles.size(); i ++) {
            if (MathUtils.isEqual(Math.round(particles.get(i).getX()),
                    Math.round(particles.get(i).destinationX)) ||
                    MathUtils.isEqual(Math.round(particles.get(i).getY()),
                            Math.round(particles.get(i).destinationY))) {
                particles.get(i).notMoving = true;
            }
        }
    }

    /**
     * Метод вызывается в render() класса, где используется объект RandomParticles
     */
    public void update () {
        checkParticles();
        moveParticles();
    }

    /**
     * Метод для добавления частиц на сцену
     * Вызывается в конструкторе этого класса (RandomParticles)
     */
    private void addParticlesOnStage () {
        for (int i = 0; i < particles.size(); i ++) {
            stage.addActor(particles.get(i));
        }
    }

    /**
     * Метод, возвращающий случайное значение в диапазоне [0, maxX]
     *
     * @return - возвращаемое случайное значение
     */
    private float randX () {
        return MathUtils.random(0, maxX);
    }

    /**
     * Метод, возвращающий случайное значение в диапазоне [0, maxY]
     *
     * @return - возвращаемое случайное значение
     */
    private float randY () {
        return MathUtils.random(0, maxY);
    }


}
