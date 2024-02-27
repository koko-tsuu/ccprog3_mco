/**
 * Game_Driver() is a method that initiates the whole game and contains the main function.
 */
public class Game_Driver {

    /**
     * main() is the method that runs the program.
     * @param args is the command line arguments
     */
    public static void main(String[] args){
        startMenu startMenu = new startMenu();
        Status_GUI status_gui = new Status_GUI();
        Planting_GUI planting_gui = new Planting_GUI();
        Registration_GUI registration_gui = new Registration_GUI();
        MainGUI gui = new MainGUI();
        Game_Over_GUI game_over_gui = new Game_Over_GUI();

        BoardTiles boardTiles = new BoardTiles();

        Fertilizer fertilizer = new Fertilizer();
        Pickaxe pickaxe = new Pickaxe();
        Plow plow = new Plow();
        Shovel shovel = new Shovel();
        Watering_Can watering_can = new Watering_Can();
        Status status = new Status();
        OverallStats overallStats = new OverallStats();


        Game_Controller controller = new Game_Controller(startMenu, status_gui, planting_gui, registration_gui,
                gui, game_over_gui, boardTiles, fertilizer, pickaxe, plow, shovel, watering_can, status, overallStats);
    }
}
