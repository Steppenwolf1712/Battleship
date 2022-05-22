package de.ni.fun.battleship.view.gui.jframe.panels;

import de.ni.fun.battleship.model.Coordinate;
import de.ni.fun.battleship.model.GameState;
import de.ni.fun.battleship.model.ShipAreasData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

public class ShipArea extends JPanel implements Observer, MouseListener {

    private JLabel content;
    private boolean sharp;

    private Coordinate position;
    private ShipAreas parent;

    public ShipArea(Coordinate position, ShipAreas parent) {
        this.position = position;
        this.parent = parent;
        init();
        GameState state = GameState.getInstance();
        state.addObserver(this);
        sharp = state.isOwnTurn();
        this.addMouseListener(this);
    }

    private void init() {
        this.setLayout(new BorderLayout());
        Dimension fieldsize = new Dimension(20,20);
        this.setMinimumSize(fieldsize);
        this.setPreferredSize(fieldsize);

        content = new JLabel();
        this.add(content, BorderLayout.CENTER);
        refresh();
    }

    private void refresh() {
        URL url = this.getClass().getResource("/img/ComicWaterSmall.gif");
//        BufferedImage image = null;
//        try {
//            image = ImageIO.read(url);
//        } catch (IOException e) {
//            Printer.getInstance().printError(this.getClass(),e);
//        }
//        Image scaledImage = image.getScaledInstance(20,20, Image.SCALE_SMOOTH);
        Icon img = new ImageIcon(url);
        content.setIcon(img);

        this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof GameState) {
            GameState state = (GameState) arg;
            sharp = state.isOwnTurn();
        } else if (o instanceof ShipAreasData.ShipAreaData) {
                ShipAreasData.ShipAreaData data = (ShipAreasData.ShipAreaData) o;
                if (data.hasHit()) {
                    URL url;
                    if (data.hasShip()) {
                        if (data.isShipEnd()) {
                            if (data.hasHoriEnd()) {
                                if (data.isEndNorthWest()) {
                                    url = this.getClass().getResource("/img/ComicWaterSmallShipEastExplosion.gif");
                                } else {
                                    url = this.getClass().getResource("/img/ComicWaterSmallShipWestExplosion.gif");
                                }
                            } else {
                                if (data.isEndNorthWest()) {
                                    url = this.getClass().getResource("/img/ComicWaterSmallShipSouthExplosion.gif");
                                } else {
                                    url = this.getClass().getResource("/img/ComicWaterSmallShipNorthExplosion.gif");
                                }
                            }
                        } else {
                            url = this.getClass().getResource("/img/ShipExplosion.gif");
                        }
                    } else {
                        url = this.getClass().getResource("/img/EmptyDropSmall.jpg");
                    }
                    Icon img = new ImageIcon(url);
                    content.setIcon(img);
                } else {
                    if (data.hasShip()) {
                        URL url;
                        if (!data.isShipEnd()) {
                            url = this.getClass().getResource("/img/Ship.png");
                        } else {
                            if (data.hasHoriEnd()) {
                                if (data.isEndNorthWest()) {
                                    url = this.getClass().getResource("/img/ComicWaterSmallShipEast.gif");
                                } else {
                                    url = this.getClass().getResource("/img/ComicWaterSmallShipWest.gif");
                                }
                            } else {
                                if (data.isEndNorthWest()) {
                                    url = this.getClass().getResource("/img/ComicWaterSmallShipSouth.gif");
                                } else {
                                    url = this.getClass().getResource("/img/ComicWaterSmallShipNorth.gif");
                                }
                            }
                        }
                        Icon img = new ImageIcon(url);
                        content.setIcon(img);
                        parent.repaint();//Verbessert die Reaktionszeit
                    } else {
                        //Refresh of Field
                        refresh();
                    }
                }
                //this.add(content, BorderLayout.CENTER);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (sharp) {
            parent.hit(position);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse entered "+this.position +" and sharp= "+sharp);
        if (sharp)
            this.setBorder(BorderFactory.createLineBorder(Color.YELLOW,1));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse exited "+this.position);
        if (sharp)
            this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
    }
}
