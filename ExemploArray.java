/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author marksaurelio
 */
public class ExemploArray {
    public static void main(String[] args) {
        int [] numeros = new int[5]; //inicialização
        // populando o array
        for (int i = 0; i < numeros.length; i++){
            System.out.println("Informe o "+(i+1)+"º número: ");
            numeros[i] = new Scanner(System.in).nextInt();
        } 
        // apresentado o array
        for (int i = 0; i < numeros.length; i++){
            System.out.println(numeros[i]);
        }
    }
}
