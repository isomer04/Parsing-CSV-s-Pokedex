/**
 * @author Jin An, Delaware Technical Community College
 * ITN262: Programming III
 * Assignment 1 Starter Code
 */

//package itn262assignment1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokedexDriver {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // The following is adapted from Example 1. Using Buffered Reader and String.split() from https://www.javainterviewpoint.com/how-to-read-and-parse-csv-file-in-java/
        BufferedReader br = null;
        try
        {
            //Reading the csv file
            br = new BufferedReader(new FileReader("pokemon.csv"));

            //Create List for holding Pokemon objects
            List<Pokemon> pokemonList = new ArrayList<Pokemon>();

            String line = "";
            //Read to skip the header
            br.readLine();
            //Reading from the second line

            int countTotalLine= 0;
            while ((line = br.readLine()) != null)
            {
                String[] pokemonDetails = line.split(",");
                // When the string is split, it will result in an array with the following information in the corresponding index
                // 0 - #
                // 1 - Name
                // 2 - Type1
                // 3 - Type2
                // 4 - Total
                // 5 - HP
                // 6 - Attack
                // 7 - Defense
                // 8 - Sp. Atk
                // 9 - Sp. Def
                // 10 - Speed
                // 11 - Generation
                // 12 - Legendary
                // *Note that pokemonDetails is an array of strings, so it must be cast to the appropriate data type when used in your program

//                System.out.println(pokemonDetails[1] + ", HP: " + pokemonDetails[5]);

                if(pokemonDetails.length > 0 )
                {
                    //Create a temporary pokemon
                    Pokemon pokemon = new Pokemon();

                    pokemon.setName(pokemonDetails[1]);
                    pokemon.setAttack(Integer.parseInt(pokemonDetails[6]));

                    // Save the Pokemon details in Pokemon object
                    // ########### WHAT GOES HERE? #############
                    // Or, you can create a different constructor that initializes all the pokemon data
                    pokemonList.add(pokemon);
                    // Add the temporary pokemon to the ArrayList object
                }

                countTotalLine++;
            } // end of the while loop

            System.out.println("Importing pokemon.csv file...");

            System.out.println(countTotalLine + " have been imported\n");
//            System.out.print(pokemonList);

            boolean repeat = false;

            while (repeat == false) {
                System.out.println("Enter attack threshold: ");
                int attackPower = scanner.nextInt();
                System.out.println("All the pokemon that are above attack " + attackPower +" :");
                int count = 0;

                for (int i = 0; i < pokemonList.size(); i++) {
                    if (pokemonList.get(i).getAttack() > attackPower) {
//                        System.out.println(" All the " + pokemonList.get(i).getName() + " that are above attack " + pokemonList.get(i).getAttack());
                        System.out.println(pokemonList.get(i));
                        count++;

                    }
                }

                if(count != 0) {
                    System.out.println(" \nTotal " + count + " pokemons has " + attackPower + " power  more than above\n");
                    repeat = false;
                } else {
                    System.out.println(" \nTotal " + count + " pokemons has " + attackPower + " power  more than above\n");
                    repeat = true;
                }
            }
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
        finally
        {
            try
            {
                br.close();
            }
            catch(IOException ie)
            {
                System.out.println("Error occured while closing the BufferedReader");
                ie.printStackTrace();
            }
        }
        // End of code adapted from Example 1. Using Buffered Reader and String.split() from https://www.javainterviewpoint.com/how-to-read-and-parse-csv-file-in-java/



    }

}


