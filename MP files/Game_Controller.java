import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * Game_Controller class that controls the whole game.
 */
public class Game_Controller {

    // board
    private BoardTiles boardTiles;

    // player stats
    private Status status;

    private OverallStats overallStats;

    // selected tile coordinates
    private int xSelected = -1;
    private int ySelected = -1;

    // crops
    private Apple apple = new Apple();
    private Carrot carrot = new Carrot();
    private Mango mango = new Mango();
    private Potato potato = new Potato();
    private Rose rose = new Rose();
    private Sunflower sunflower = new Sunflower();
    private Tulips tulips = new Tulips();
    private Turnip turnip = new Turnip();

    // registration status
    private Farmer farmer = new Farmer();
    private Registered_Farmer registered_farmer = new Registered_Farmer();
    private Distinguished_Farmer distinguished_farmer = new Distinguished_Farmer();
    private Legendary_Farmer legendary_farmer = new Legendary_Farmer();

    // tools
    private Fertilizer fertilizer;
    private Pickaxe pickaxe;
    private Plow plow;
    private Shovel shovel;
    private Watering_Can watering_can;


    // gui
    private startMenu startMenu;
    private Status_GUI status_gui;
    private Planting_GUI planting_gui;
    private Registration_GUI registration_gui;
    private MainGUI gui;
    private Game_Over_GUI game_over_gui;


    /**
     * Game_Controller that initializes the database and GUI.
     * @param startMenu is the start menu GUI
     * @param status_gui is the status menu GUI
     * @param planting_gui is the planting menu GUI
     * @param registration_gui is the registration menu GUI
     * @param gui is the main menu GUI
     * @param game_over_gui is the game over GUI
     * @param boardTiles containing the data for the board
     * @param fertilizer contains the data for the fertilizer
     * @param pickaxe contains the data for the pickaxe
     * @param plow contains the data for the plow
     * @param shovel contains the data for the shovel
     * @param watering_can contains the data for the watering can
     * @param status contains the data for the Player's status
     * @param overallStats contains the data for the Player's overall stats
     */
    public Game_Controller(startMenu startMenu, Status_GUI status_gui, Planting_GUI planting_gui, Registration_GUI registration_gui,
                           MainGUI gui, Game_Over_GUI game_over_gui, BoardTiles boardTiles, Fertilizer fertilizer, Pickaxe pickaxe,
                           Plow plow, Shovel shovel, Watering_Can watering_can, Status status, OverallStats overallStats) {
        this.startMenu = startMenu;
        this.status_gui = status_gui;
        this.planting_gui = planting_gui;
        this.registration_gui = registration_gui;
        this.gui = gui;
        this.game_over_gui = game_over_gui;

        this.boardTiles = boardTiles;
        this.fertilizer = fertilizer;
        this.pickaxe = pickaxe;
        this.plow = plow;
        this.shovel = shovel;
        this.watering_can = watering_can;
        this.status = status;
        this.overallStats = overallStats;

        updateMainGUI();


        // start menu
        this.startMenu.setActionListener(e -> {
            if (startMenu.isVisible()) {
                // start
                if (e.getSource() == startMenu.getStart()) {
                    // reset all
                    boardTiles.resetBoard();
                    status.statReset();
                    overallStats.resetOverallStats();
                    updateMainGUI();
                    startMenu.dispose();
                    gui.resetTextAreaHistory();
                    game_over_gui.setTextAreaStatus("");
                    game_over_gui.setTextFieldReason("");
                    gui.setVisible(true);

                // quit
                } else if (e.getSource() == startMenu.getQuit())
                    startMenu.dispose();
            }
        });

        // status gui
        this.status_gui.setActionListener(e -> {
            // back button
            if(e.getActionCommand().equals("Back") && status_gui.isActive() && status_gui.isVisible()){
                status_gui.setVisible(false);
                gui.setVisible(true);
            }
        });

        // planting gui
        this.planting_gui.setActionListener(e -> {
            // current selected item and user pressed on the plant button
            if(!Objects.equals(planting_gui.getCropBox().getSelectedItem(), "") && e.getSource() == planting_gui.getPlant()) {
                if (Objects.equals(planting_gui.getCropBox().getSelectedItem(), "Apple"))
                    gui.setTextAreaHistory(boardTiles.getTile(xSelected, ySelected).Planting(boardTiles.getBoard(), xSelected, ySelected, apple, status, overallStats));
                else if (Objects.equals(planting_gui.getCropBox().getSelectedItem(), "Carrot"))
                    gui.setTextAreaHistory(boardTiles.getTile(xSelected, ySelected).Planting(boardTiles.getBoard(), xSelected, ySelected, carrot, status, overallStats));
                else if (Objects.equals(planting_gui.getCropBox().getSelectedItem(), "Mango"))
                    gui.setTextAreaHistory(boardTiles.getTile(xSelected, ySelected).Planting(boardTiles.getBoard(), xSelected, ySelected, mango, status, overallStats));
                else if (Objects.equals(planting_gui.getCropBox().getSelectedItem(), "Potato"))
                    gui.setTextAreaHistory(boardTiles.getTile(xSelected, ySelected).Planting(boardTiles.getBoard(), xSelected, ySelected, potato, status, overallStats));
                else if (Objects.equals(planting_gui.getCropBox().getSelectedItem(), "Rose"))
                    gui.setTextAreaHistory(boardTiles.getTile(xSelected, ySelected).Planting(boardTiles.getBoard(), xSelected, ySelected, rose, status, overallStats));
                else if (Objects.equals(planting_gui.getCropBox().getSelectedItem(), "Sunflower"))
                    gui.setTextAreaHistory(boardTiles.getTile(xSelected, ySelected).Planting(boardTiles.getBoard(), xSelected, ySelected, sunflower, status, overallStats));
                else if (Objects.equals(planting_gui.getCropBox().getSelectedItem(), "Tulips"))
                    gui.setTextAreaHistory(boardTiles.getTile(xSelected, ySelected).Planting(boardTiles.getBoard(), xSelected, ySelected, tulips, status, overallStats));
                else if (Objects.equals(planting_gui.getCropBox().getSelectedItem(), "Turnip"))
                    gui.setTextAreaHistory(boardTiles.getTile(xSelected, ySelected).Planting(boardTiles.getBoard(), xSelected, ySelected, turnip, status, overallStats));
                updateMainGUI();
                planting_gui.setVisible(false);
                gui.setVisible(true);
            }

            // show the description of the selected item
            else if(e.getSource() == planting_gui.getCropBox()){
                // apple
                if (Objects.equals(planting_gui.getCropBox().getSelectedItem(), "Apple"))
                    planting_gui.setCropDesc(apple.toString(status));

                // carrot
                else if (Objects.equals(planting_gui.getCropBox().getSelectedItem(), "Carrot"))
                    planting_gui.setCropDesc(carrot.toString(status));

                // mango
                else if (Objects.equals(planting_gui.getCropBox().getSelectedItem(), "Mango"))
                    planting_gui.setCropDesc(mango.toString(status));

                // potato
                else if (Objects.equals(planting_gui.getCropBox().getSelectedItem(), "Potato"))
                    planting_gui.setCropDesc(potato.toString(status));

                // rose
                else if (Objects.equals(planting_gui.getCropBox().getSelectedItem(), "Rose"))
                    planting_gui.setCropDesc(rose.toString(status));

                // sunflower
                else if (Objects.equals(planting_gui.getCropBox().getSelectedItem(), "Sunflower"))
                    planting_gui.setCropDesc(sunflower.toString(status));

                // tulips
                else if (Objects.equals(planting_gui.getCropBox().getSelectedItem(), "Tulips"))
                    planting_gui.setCropDesc(tulips.toString(status));

                // turnip
                else if (Objects.equals(planting_gui.getCropBox().getSelectedItem(), "Turnip"))
                    planting_gui.setCropDesc(turnip.toString(status));
            }

            // user pressed the cancel the button
            else if (e.getSource() == planting_gui.getCancel()){
                planting_gui.setVisible(false);
                gui.setVisible(true);
                updateMainGUI();
            }
        });

        // registration gui
        this.registration_gui.setActionListener(e ->{
            // current selected item and user clicked on register button
            if(!Objects.equals(registration_gui.getRegistrationBox().getSelectedItem(), "") && (e.getSource() == registration_gui.getRegister())) {
                // farmer
                if (Objects.equals(registration_gui.getRegistrationBox().getSelectedItem(), "Farmer"))
                    gui.setTextAreaHistory(status.setRegistration(farmer));

                // registered farmer
                else if (Objects.equals(registration_gui.getRegistrationBox().getSelectedItem(), "Registered Farmer"))
                    gui.setTextAreaHistory(status.setRegistration(registered_farmer));

                // distinguished farmer
                else if (Objects.equals(registration_gui.getRegistrationBox().getSelectedItem(), "Distinguished Farmer"))
                    gui.setTextAreaHistory(status.setRegistration(distinguished_farmer));

                //legendary farmer
                else if (Objects.equals(registration_gui.getRegistrationBox().getSelectedItem(), "Legendary Farmer"))
                    gui.setTextAreaHistory(status.setRegistration(legendary_farmer));

                registration_gui.setVisible(false);
                gui.setVisible(true);
            }
            // update description depending on the selected item
            else if(e.getSource() == registration_gui.getRegistrationBox()){

                // farmer
                if (Objects.equals(registration_gui.getRegistrationBox().getSelectedItem(), "Farmer"))
                    registration_gui.setRegisDesc(farmer.toString());

                // registered farmer
                else if (Objects.equals(registration_gui.getRegistrationBox().getSelectedItem(), "Registered Farmer"))
                    registration_gui.setRegisDesc(registered_farmer.toString());

                // distinguished farmer
                else if (Objects.equals(registration_gui.getRegistrationBox().getSelectedItem(), "Distinguished Farmer"))
                    registration_gui.setRegisDesc(distinguished_farmer.toString());

                // legendary farmer
                else if (Objects.equals(registration_gui.getRegistrationBox().getSelectedItem(), "Legendary Farmer"))
                    registration_gui.setRegisDesc(legendary_farmer.toString());
            }
            // user clicked on cancel
            else if (e.getSource() == registration_gui.getRegisCancel()){
                registration_gui.setVisible(false);
                gui.setVisible(true);
            }
            failCheck();
        });


        // main menu gui
        this.gui.setActionListener(e -> {
            if (gui.isVisible() && gui.isActive()) {

                // button from the grid, update selected tile
                if (e.getActionCommand().equals(" ")) {
                    var found = false;
                    if (xSelected != -1 && ySelected != -1)
                        gui.resetBorderTile(xSelected, ySelected);

                    for (int row = 0; row < 10 && !found; row++)
                        for (int col = 0; col < 5 && !found; col++)
                            if (gui.getButtonFromGrid(row, col) == e.getSource()) {
                                gui.setBorderTile(row, col);
                                xSelected = row;
                                ySelected = col;
                                found = true;
                            }

                // no selected tile but player wants to register or advance a day
                }else if ((e.getSource() == gui.getOKButton()) && (xSelected == -1) && (ySelected == -1)) {
                    // register
                     if(Objects.equals(gui.getToolBox().getSelectedItem(), "Register")) {
                        registration_gui.setVisible(true);
                        gui.setVisible(false);
                    }
                     // advance a day
                     else if(Objects.equals(gui.getToolBox().getSelectedItem(), "Advance a Day")){

                         gui.resetTextAreaHistory();
                         status.setDays(status.getDays() + 1);
                         gui.setDays(status.getDays());

                         for (int i = 0; i < 10; i++)
                             for (int j = 0; j < 5; j++) {
                                 if (!boardTiles.getTile(i, j).getCrop().getName().equals("null")) {
                                     boardTiles.getTile(i, j).setDays(boardTiles.getTile(i, j).getDays() - 1);
                                     String s = boardTiles.getTile(i, j).harvestCheck();
                                    if(!s.equals("")) {
                                        gui.setTextAreaHistory("Tile " + (i + 1) + " x " + (j + 1) + ": " + s);
                                        gui.setColorTile(boardTiles.getBoard(), i, j);
                                    }
                                 }
                             }
                     }
                     else
                         gui.setTextAreaHistory("Cannot execute action. Please select a tile.");

                 // selected tile and user clicked on the ok button
                } else if ((e.getSource() == gui.getOKButton()) && (xSelected != -1) && (ySelected != -1)) {

                    // plow
                    if (Objects.equals(gui.getToolBox().getSelectedItem(), "Plow")) {
                        gui.setTextAreaHistory(plow.Plowing(boardTiles.getTile(xSelected, ySelected), status, overallStats));
                        updateMainGUI();
                    }

                    // watering can
                    else if(Objects.equals(gui.getToolBox().getSelectedItem(), "Watering Can")) {
                        gui.setTextAreaHistory(watering_can.Watering(boardTiles.getTile(xSelected, ySelected), status, overallStats));
                        updateMainGUI();
                    }

                    // fertilizer
                    else if(Objects.equals(gui.getToolBox().getSelectedItem(), "Fertilizer")) {
                        gui.setTextAreaHistory(fertilizer.Fertilizing(boardTiles.getTile(xSelected, ySelected), status, overallStats));
                        updateMainGUI();
                    }

                    // pickaxe
                    else if(Objects.equals(gui.getToolBox().getSelectedItem(), "Pickaxe")) {
                        gui.setTextAreaHistory(pickaxe.Pickaxing(boardTiles.getTile(xSelected, ySelected), status));
                        updateMainGUI();
                    }

                    // shovel
                    else if(Objects.equals(gui.getToolBox().getSelectedItem(), "Shovel")) {
                        gui.setTextAreaHistory(shovel.Shoveling(boardTiles.getTile(xSelected, ySelected), status));
                        updateMainGUI();
                    }

                    // plant
                    else if(Objects.equals(gui.getToolBox().getSelectedItem(), "Plant")) {
                        planting_gui.setVisible(true);
                        gui.setVisible(false);
                    }

                    // harvest
                    else if(Objects.equals(gui.getToolBox().getSelectedItem(), "Harvest")) {
                        gui.setTextAreaHistory(boardTiles.getTile(xSelected, ySelected).harvest(status, overallStats));
                        boardTiles.getTile(xSelected, ySelected).resetTile(false);
                        gui.setColorTile(boardTiles.getBoard(), xSelected, ySelected);
                    }

                    // register
                    else if(Objects.equals(gui.getToolBox().getSelectedItem(), "Register")) {
                        registration_gui.setVisible(true);
                        gui.setVisible(false);

                    }

                    // check a tile
                    else if(Objects.equals(gui.getToolBox().getSelectedItem(), "Check a Tile")) {
                        gui.setTextAreaDesc(boardTiles.getTile(xSelected, ySelected).toString("Check a Tile"));
                        updateMainGUI();
                    }

                    // advance day
                    else if (Objects.equals(gui.getToolBox().getSelectedItem(), "Advance a Day")) {
                        gui.resetTextAreaHistory();
                        status.setDays(status.getDays() + 1);
                        gui.setDays(status.getDays());
                        for (int i = 0; i < 10; i++)
                            for (int j = 0; j < 5; j++) {
                                if (!boardTiles.getTile(i, j).getCrop().getName().equals("null")) {
                                    boardTiles.getTile(i, j).setDays(boardTiles.getTile(i, j).getDays() - 1);
                                    String s = boardTiles.getTile(i, j).harvestCheck();
                                    if(!s.equals("")) {
                                        gui.setTextAreaHistory("Tile " + (i + 1) + " x " + (j + 1) + ": " + s);
                                        gui.setColorTile(boardTiles.getBoard(), i, j);
                                    }
                                }
                            }
                    }

                }

                // update description
                else if (e.getSource() == gui.getToolBox()) {

                    // plow
                    if (Objects.equals(gui.getToolBox().getSelectedItem(), "Plow"))
                        gui.setTextAreaDesc(plow.toString());

                    // watering can
                    else if (Objects.equals(gui.getToolBox().getSelectedItem(), "Watering Can"))
                        gui.setTextAreaDesc(watering_can.toString());

                    // fertilizer
                    else if (Objects.equals(gui.getToolBox().getSelectedItem(), "Fertilizer"))
                        gui.setTextAreaDesc(fertilizer.toString());

                    // pickaxe
                    else if (Objects.equals(gui.getToolBox().getSelectedItem(), "Pickaxe"))
                        gui.setTextAreaDesc(pickaxe.toString());

                    // shovel
                    else if (Objects.equals(gui.getToolBox().getSelectedItem(), "Shovel"))
                        gui.setTextAreaDesc(shovel.toString());

                    // plant
                    else if (Objects.equals(gui.getToolBox().getSelectedItem(), "Plant"))
                        gui.setTextAreaDesc(boardTiles.getTile(0, 0).toString("Plant"));

                    // harvest
                    else if (Objects.equals(gui.getToolBox().getSelectedItem(), "Harvest"))
                        gui.setTextAreaDesc(boardTiles.getTile(0, 0).toString("Harvest"));

                    // register
                    else if (Objects.equals(gui.getToolBox().getSelectedItem(), "Register"))
                        gui.setTextAreaDesc(status.getRegStatus().toString("Register"));

                    // advance a day
                    else if (Objects.equals(gui.getToolBox().getSelectedItem(), "Advance a Day"))
                        gui.setTextAreaDesc("Advance a day. Nothing more, nothing less. " +
                                "Make sure you've done everything you need to do before doing this.");

                    // description of check a tile
                    else if (Objects.equals(gui.getToolBox().getSelectedItem(), "Check a Tile"))
                        gui.setTextAreaDesc(boardTiles.getTile(0, 0).toString("insert check a tile description here"));

                }

                // user clicked on status button
                else if(e.getSource() == gui.getStatsButton()){
                    status_gui.setTextAreaStats(status.toString());
                    gui.setVisible(false);
                    status_gui.setVisible(true);
                }
            }
            failCheck();
        });

        // game over gui
        this.game_over_gui.setActionListener(e -> {

            // user clicked the button
            if(game_over_gui.isActive() && game_over_gui.isVisible())
            {
                if(e.getSource() == game_over_gui.getTitleButton()){
                    game_over_gui.setVisible(false);

                    gui.setVisible(false);
                    planting_gui.setVisible(false);
                    registration_gui.setVisible(false);
                    status_gui.setVisible(false);
                    startMenu.setVisible(true);
                }
            }
        });


    }

    /**
     * failCheck() is a method that checks if the game fail conditions have been met.
     */
    public void failCheck(){
        boardTiles.checkTiles();
        // there are no crops currently active and Player does not have enough object coins for a seed
        if ((boardTiles.getInactiveTiles() + boardTiles.getWitheredTiles() + boardTiles.getRockTiles() == 50) && (status.getObjectCoins() < 5))
        {
            game_over_gui.setTextFieldReason("No money to buy a crop!");
            game_over_gui.setTextAreaStatus(overallStats.toString(overallStats));
            gui.setVisible(false);
            game_over_gui.setVisible(true);
        }
        // all tiles have been withered
        else if((boardTiles.getWitheredTiles() + boardTiles.getRockTiles() == 50))
        {
            gui.setVisible(false);
            game_over_gui.setTextFieldReason("All tiles have withered :(");
            game_over_gui.setTextAreaStatus(overallStats.toString(overallStats));
            game_over_gui.setVisible(true);
        }
    }

    /**
     * updateMainGUI() is a method that updates the colors in the grid or tile board.
     */
    public void updateMainGUI(){
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 5; j++)
                gui.setColorTile(boardTiles.getBoard(), i, j);
    }

}
