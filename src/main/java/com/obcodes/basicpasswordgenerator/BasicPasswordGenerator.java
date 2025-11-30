/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
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
        try (Scanner scanner = new Scanner(System.in)) {
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
        }
    }
    
    /**
     * Generates a password with only lowercase and uppercase letters
     * @param length
     * @param rand
     * @return 
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
     * @param length
     * @param rand
     * @return 
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