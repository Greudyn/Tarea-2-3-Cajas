package cajas.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @Author: Greudyn Velasquez.
 * @Datecreation: Aug 2, 2022 9:41:26 PM
 * @FileName: TodasLasSoluciones.java
 * @version: 0.1
 * @Description: Metodo para obtener todas las soluciones de las 3 cajas
 */
public class TodasLasSoluciones {
    static final int    numeroDeEspacios = 3;
    private int[]       caja             = new int[numeroDeEspacios];
    private List<int[]> colocados        = new ArrayList<>();

    void imprimirSolucion(int[] caja) {
        String[] pelotas = new String[numeroDeEspacios];
        for (int i = 0; i < numeroDeEspacios; i++) {
            if (caja[i] == 1) {
                pelotas[i] = "Roja";
            } else {
                pelotas[i] = "Blanca";
            }
            System.out.print(" " + pelotas[i] + " ");
        }
        System.out.println();
    }

    boolean altValida(int i, int p) {
        caja[p] = i;
        if (p == 0) {
            return true;
        } else {
            if (caja[p - 1] != caja[p]) {
                if (caja[numeroDeEspacios - 1] != 0) {
                    int[] validacionDeCaja = colocados.stream().filter(x -> Arrays.equals(x, caja)).findFirst().orElse(null);
                    if (Objects.isNull(validacionDeCaja)) {
                        int[] cajaValida = new int[numeroDeEspacios];
                        for (i = 0; i < numeroDeEspacios; i++) {
                            cajaValida[i] = caja[i];
                        }
                        imprimirSolucion(cajaValida);
                        colocados.add(cajaValida);
                        return true;
                    } else {
                        caja = new int[5];
                        return false;
                    }
                } else {
                    return true;
                }
            } else {
                return false;
            }
        }
    }

    void todasLasPelotasEnCaja(int p) {
        int i;
        for (i = 1; i < 3; i++) {
            if (altValida(i, p)) {
                if (p < numeroDeEspacios - 1) {
                    todasLasPelotasEnCaja(p + 1);
                }
            } else {
                caja[p] = 0;
            }
        }
    }
}
