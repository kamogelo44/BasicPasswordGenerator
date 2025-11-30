/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/*
Description: Generate a random password based on user preferences. Ask the user for the length and whether to include numbers and special characters.

Concepts Used: Random class, StringBuilder or character arrays, for loops, if conditions.

GitHub Boost: Explain in your code comments why using Random is okay for a beginner project but not for real-world security.
*/

/*
SECURITY NOTE: Using java.util.Random is fine for this beginner project because we're learning basic programming concepts.
However, for real-world security applications, Random is predictable and not cryptographically secure.
For production systems, use java.security.SecureRandom instead, which generates truly random, unpredictable values.
*/

package com.obcodes.basicpasswordgenerator;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Obakeng Phale
 */
public class BasicPasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        
        // Get password length from user
        System.out.print("Enter password length: ");
        int passwordLength = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        // Ask about numbers and special characters
        System.out.print("Do you want your password to consist of numbers and special characters? (yes(y)/no(n): ");
        String answer = scanner.nextLine().toLowerCase();
        
        String generatedPassword;
        
        if (answer.equals("yes")||answer.equals("y")) {
            generatedPassword = generatePasswordWithNumSpecialChar(passwordLength, rand);
        } else {
            generatedPassword = generateRandomPassword(passwordLength, rand);
        }
        
        System.out.println("Generated Password: " + generatedPassword);
        System.out.println("END OF PROGRAM");
        
        scanner.close();
    }
    
    /**
     * Generates a password with only lowercase and uppercase letters
     */
    public static String generateRandomPassword(int length, Random rand) {
        StringBuilder password = new StringBuilder();
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        for (int i = 0; i < length; i++) {
            int randomIndex = rand.nextInt(letters.length());
            password.append(letters.charAt(randomIndex));
        }
        
        return password.toString();
    }
    
    /**
     * Generates a password with letters, numbers, and special characters
     */
    public static String generatePasswordWithNumSpecialChar(int length, Random rand) {
        StringBuilder password = new StringBuilder();
        // Combined character set: letters + numbers + special characters
        String allCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+[]{}|;:,.<>?";
        
        for (int i = 0; i < length; i++) {
            int randomIndex = rand.nextInt(allCharacters.length());
            password.append(allCharacters.charAt(randomIndex));
        }
        
        return password.toString();
    }
}