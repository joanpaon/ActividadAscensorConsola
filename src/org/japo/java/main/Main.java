/* 
 * Copyright 2017 José A. Pacheco Ondoño - joanpaon@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Constantes
        final int PISO_MIN = 1;
        final int PISO_MAX = 10;
        final int NUM_PERSONAS = 4;

        // Locale ---> Reales con punto
        Locale lcl = new Locale("EN", "uk");

        // Scanner --- > Entrada de acentos con Windows
        Scanner scn = new Scanner(System.in, "ISO-8859-1");
        scn.useLocale(lcl);

        // Dato a introducir
        int piso = 0;

        // Turno Persona
        for (int personaAct = 0; personaAct < NUM_PERSONAS; personaAct++) {
            // Validación de Piso
            boolean pisoOK = true;
            do {
                // Selección Piso
                boolean entradaOK = true;
                do {
                    try {
                        // Entrada dato
                        System.out.printf("Persona %d - Piso ...: ", personaAct + 1);
                        piso = scn.nextInt();

                        // Entrada Correcta
                        entradaOK = false;
                    } catch (Exception e) {
                        // Entrada incorrecta
                        System.out.println("ERROR: Entrada Incorrecta");
                    } finally {
                        // Vaciar buffer
                        scn.nextLine();
                    }
                } while (entradaOK);

                // Validar Número de Piso
                pisoOK = piso >= PISO_MIN && piso <= PISO_MAX;
                if (!pisoOK) {
                    System.out.println("ERROR: Número de piso incorrecto");
                }
            } while (!pisoOK);

            // Conformación Elección
            System.out.printf("Persona %d - Piso ...: %d - OK\n", personaAct + 1, piso);
        }
    }
}
