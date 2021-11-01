package de.ni.fun.battleship.control.main;

import de.ni.fun.battleship.control.network.client.BattleshipClient;
import de.ni.fun.battleship.model.ClientModel;
import de.ni.fun.battleship.model.IModel;
import de.ni.fun.battleship.view.IView;
import de.ni.fun.battleship.view.console.ConsoleView;
import de.ni.fun.battleship.view.gui.jframe.SwingView;

public class MainClient {

    public static final String MODE_CONSOLE = "Konsole";
    public static final String MODE_GUI = "GUI";

    public static IView view;

    private static BattleshipClient assist;
    private static String mode;

    public MainClient(BattleshipClient client, String mode) {
        assist = client;
        this.mode = mode;
        init();
    }

    private void init() {
        IModel model = ClientModel.getInstance();
        if (mode.equals(MODE_CONSOLE)) {
            view = ConsoleView.getConsole();
        } else if (mode.equals(MODE_GUI)) {
            SwingView viewer = SwingView.getInstance();
            viewer.setModel(model);
            view = viewer;
        }
    }
}
