import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Pokemon> pokemon_party = new ArrayList<>();
    private static void HELP() {
        System.out.println("A list of the available commands:");
        System.out.println("    EXIT: exits the EV Tracker Tool.");
        System.out.println("    HELP: prints the list of available commands");
        System.out.println("    PARTY: prints the collection of pokemon entered in your pokemon index.");
        System.out.println("    ADD: add pokemon to your party. You can add multiple pokemon at once.");
        System.out.println("    REMOVE: remove pokemon from your party. You can remove multiple pokemon at once.");
        System.out.println("    SELECT: select a pokemon from your party to access EV commands.");
    }
    private static void PARTY() {
        if (pokemon_party.size() > 0) {
            for (Pokemon i : pokemon_party) {
                System.out.println("  " + i.name);
            }
        } else {
            System.out.println("Your party is empty. Add pokemon to it using the 'ADD' command");
        }
    }
    private static void ADD() {
        System.out.println("Enter the names of pokemon to add to your party. Enter 'STOP' when you are finished.");
        String added_pokemon;
        while (scanner.hasNext()) {
            added_pokemon = scanner.nextLine();
            if (added_pokemon.equals("STOP"))
                break;
            Pokemon pokemon = new Pokemon(added_pokemon);
            pokemon_party.add(pokemon);
        }
    }
    private static void REMOVE() {
        System.out.println("Enter the names of pokemon to remove from your party. Enter 'STOP' when you are finished.");
        if (pokemon_party.isEmpty()) {
            System.out.println("Your party is empty. You must add pokemon to it first.");
        } else {
            String removed_poke_name;
            while (scanner.hasNext()){
                removed_poke_name = scanner.nextLine();
                if (removed_poke_name.equals("STOP"))
                    break;
                try {
                    for (Pokemon p: pokemon_party) {
                        if (p.name.equals(removed_poke_name))
                            pokemon_party.remove(p);
                    }
                } catch (Exception e) {
                    System.out.println("Sorry, that pokemon is not in your party. Please try again.");
                    }
                }
            }
        }
    private static void SELECT(){
        if (pokemon_party.isEmpty()) {
            System.out.println("You must add pokemon to your party first.");
        } else {
            System.out.println("Enter the name of a pokemon from your party.");
            String pokemon_name = scanner.nextLine();
            Pokemon temp = get_pokemon(pokemon_name);
            if (!(temp == null)){
                selected_pokemon(temp);
            }
        }
    }
    private static void selected_pokemon(Pokemon selected){
        String entry;
        System.out.println("Type 'HELP' for the list of EV commands. Type 'STOP' to exit the SELECT window.");
        System.out.println("What do you want to do with " + selected.name + "?");
        while (scanner.hasNext()){
            entry = scanner.nextLine();
            switch (entry){
                case "HELP":
                    Pokemon.HELP();
                    break;
                case "CALCULATE":
                    System.out.println("What stat did your pokemon just gain? HP/ATK/DEF/SPDEF/SPATK/SPDEF/SPE");
                    String stat_name = scanner.nextLine();
                    if (!(stat_name_valid(stat_name)))
                        break;
                    System.out.println("What value EV did your pokemon just gain? 1/2/3");
                    int stat_val = scanner.nextInt();
                    if (!(stat_val_valid(stat_val)))
                        break;
                    scanner.nextLine();
                    System.out.println("Is your pokemon wearing the Macho Brace? YES/NO");
                    String option_1 = scanner.nextLine();
                    if (option_1.equals("YES") || option_1.equals(("NO"))) {
                        if (option_1.equals("YES")){
                            stat_val *= 2;
                        }
                    } else {
                        break;
                    }
                    System.out.println("Does your pokemon have pokerus? YES/NO");
                    String option_2 = scanner.nextLine();
                    if (option_2.equals("YES") || option_2.equals("NO")){
                        if (option_2.equals("YES")){
                            stat_val *= 2;
                        }
                    } else {
                        break;
                    }
                    selected.CALCULATE(stat_name, stat_val);
                    break;
                case "PRINT EVS":
                    selected.PRINT_EVS();
                    break;
                case "STOP":
                    System.out.println("*****Exited the SELECT window*****");
                    break;
                default:
                    System.out.println("Sorry, that command is not recognized. Please try again.");
            }
        }
    }
    private static boolean stat_name_valid(String stat){
        return (stat.equals("HP") || stat.equals("ATK") || stat.equals("DEF") || stat.equals("SPATK") || stat.equals("SPDEF")
                || stat.equals("SPE"));
    }
    private static boolean stat_val_valid(int val){
        return (val == 1 || val == 2 || val == 3);
    }
    private static Pokemon get_pokemon(String pokemon_name){
        for (Pokemon p: pokemon_party) {
            if (pokemon_name.equals(p.name)) {
                return p;
            }
        }
        System.out.println("Sorry, that pokemon is not in your party.");
        return null;
    }
    public static void main(String[] args) {
        String entry = "";
        System.out.println("Type 'HELP' for the list of commands. Type 'EXIT' to stop using the tool.");
        while (!(entry.equals("EXIT"))) {
            System.out.println("Enter a command: ");
            entry = scanner.nextLine();
            switch(entry) {
                case "HELP":
                    HELP();
                    break;
                case "ADD":
                    ADD();
                    break;
                case "REMOVE":
                    REMOVE();
                    break;
                case "PARTY":
                    PARTY();
                    break;
                case "SELECT":
                    SELECT();
                    break;
                case "EXIT":
                    break;
                default:
                    System.out.println("Sorry, that command is not recognized. Please try again.");
            }
        }
    }
}
