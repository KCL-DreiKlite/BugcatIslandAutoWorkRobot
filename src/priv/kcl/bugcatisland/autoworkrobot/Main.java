package priv.kcl.bugcatisland.autoworkrobot;

import priv.kcl.bugcatisland.autoworkrobot.core.Typer;
import priv.kcl.bugcatisland.autoworkrobot.view.Model;
import priv.kcl.bugcatisland.autoworkrobot.view.ViewModel;
import priv.kcl.bugcatisland.autoworkrobot.view.Viewer;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        final int robotAutoDelay = 200;
        try {
            Robot robot = new Robot();
            robot.setAutoDelay(robotAutoDelay);

            Typer typer = new Typer(robot);
            typer.setDebugMode(false);

            SwingUtilities.invokeLater(() -> {
                new Viewer(new ViewModel(new Model(typer)));
            });
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
