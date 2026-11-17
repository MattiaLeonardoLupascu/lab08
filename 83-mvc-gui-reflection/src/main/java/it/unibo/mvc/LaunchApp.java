package it.unibo.mvc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.controller.DrawNumberControllerImpl;
import it.unibo.mvc.model.DrawNumberImpl;

/**
 * Application entry-point.
 */
public final class LaunchApp {

    private LaunchApp() { }

    /**
     * Runs the application.
     *
     * @throws ClassNotFoundException if the fetches class does not exist
     * @throws NoSuchMethodException if the 0-ary constructor do not exist
     * @throws InvocationTargetException if the constructor throws exceptions
     * @throws InstantiationException if the constructor throws exceptions
     * @throws IllegalAccessException in case of reflection issues
     * @throws IllegalArgumentException in case of reflection issues
     */
    public static void main() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IllegalArgumentException{
        String drawNumberSwingViewName = "it.unibo.mvc.view.DrawNumberSwingView";
        Class viewClass = Class.forName(drawNumberSwingViewName);
        String drawNumberSwingViewNameOutput = "it.unibo.mvc.view.DrawNumberStandardOutputView";
        Class viewClassOutput = Class.forName(drawNumberSwingViewNameOutput);
        Constructor constructor = viewClass.getConstructor();
        Constructor constructor2 = viewClassOutput.getConstructor();
        final var model = new DrawNumberImpl();
        final DrawNumberController app = new DrawNumberControllerImpl(model);
        for (int i = 0; i < 3; i++) {
            Object swing = constructor.newInstance();
            Object output = constructor2.newInstance();
            app.addView((DrawNumberView) swing);
            app.addView((DrawNumberView) output);
        }
    }
}
