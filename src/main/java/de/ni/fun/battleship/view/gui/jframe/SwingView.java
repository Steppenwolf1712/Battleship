package de.ni.fun.battleship.view.gui.jframe;

import de.ni.fun.battleship.model.IModel;
import de.ni.fun.battleship.model.Settings;
import de.ni.fun.battleship.view.IView;

public class SwingView implements IView {

    private static SwingView single = null;
    private static IModel model;

    private SwingView() {
    }

    public static SwingView getInstance() {
        if (single == null)
            single = new SwingView();
        return single;
    }

    public void setModel(IModel model) {
        this.model = model;
    }

    @Override
    public void askLogin() {

    }

    @Override
    public void askRegistration() {

    }

    @Override
    public void askSettings() {

    }

    @Override
    public void waitForPlayer(Settings settings) {

    }

    @Override
    public void stopWaitingForPlayer() {

    }
}
