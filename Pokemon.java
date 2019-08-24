public class Pokemon {
    public String name;
    public Pokemon(String name) //Constructor for a pokemon
    {
        this.name = name;
    }
    private static int max_EV = 510;
    private static int HP = 255;
    private static int ATK = 255;
    private static int DEF = 255;
    private static int SPATK = 255;
    private static int SPDEF = 255;
    private static int SPE = 255;
    public static void HELP(){
        System.out.println("    CALCULATE: apply EVs to your selected pokemon.");
        System.out.println("    PRINT EVS: print the remaining EVs for each stat of your selected pokemon.");
    }
    public void CALCULATE(String stat, int total){
        max_EV -= total;
        switch (stat){
            case "HP":
                HP -=total;
                System.out.println("Remaining HP EVs: " + HP);
                break;
            case "ATK":
                ATK -= total;
                System.out.println("Remaining ATK EVs: " + ATK);
                break;
            case "DEF":
                DEF -= total;
                System.out.println("Remaining DEF EVs: " + DEF);
                break;
            case "SPATK":
                SPATK -= total;
                System.out.println("Remaining SPATK EVs: " + SPATK);
                break;
            case "SPDEF":
                SPDEF -= total;
                System.out.println("Remaining SPDEF EVs: " + SPDEF);
                break;
            case "SPE":
                SPE -= total;
                System.out.println("Remaining SPE EVs: " + SPE);
                break;
        }
    }
    public void PRINT_EVS(){
        System.out.println("Total EVs remaining: " + max_EV);
        System.out.println("        HP current: " + (255-HP) + "\n" + "HP remaining: " + HP);
        System.out.println("        ATK current: " + (255-ATK) + "\n" + "ATK remaining: " + ATK);
        System.out.println("        DEF current: " + (255-DEF) + "\n" + "DEF remaining: " + DEF);
        System.out.println("        SPATK current: " + (255-SPATK) + "\n" + "SPATK remaining: " + SPATK);
        System.out.println("        SPDEF current: " + (255-SPDEF) + "\n" + "SPDEF remaining: " + SPDEF);
        System.out.println("        SPE current: " + (255-SPE) + "\n" + "SPE remaining: " + SPE);
    }
}
