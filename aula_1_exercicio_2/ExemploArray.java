// Source code is decompiled from a .class file using FernFlower decompiler.
package aula_1_exercicio_2;

import java.util.Scanner;

public class ExemploArray {
   public ExemploArray() {
   }

   @SuppressWarnings("resource")
   public static void main(String[] var0) {
      int[] var1 = new int[5];

      int var2;
      for(var2 = 0; var2 < var1.length; ++var2) {
         System.out.println("Informe o " + (var2 + 1) + "º número: ");
         var1[var2] = (new Scanner(System.in)).nextInt();
      }

      for(var2 = 0; var2 < var1.length; ++var2) {
         System.out.println(var1[var2]);
      }

   }
}
