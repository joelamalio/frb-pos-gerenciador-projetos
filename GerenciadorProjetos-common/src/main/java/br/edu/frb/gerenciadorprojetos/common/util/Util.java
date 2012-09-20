/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.frb.gerenciadorprojetos.common.util;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author joelamalio
 */
public class Util {

    public static boolean isNullOrEmpty(final Object valor) {
        if (valor == null) {
            return true;
        } else if (valor instanceof String) {
            String string = (String) valor;
            return string.isEmpty();
        } else if (valor instanceof Collection) {
            Collection collection = (Collection) valor;
            return collection.isEmpty();
        } else if (valor instanceof Map) {
            Map map = (Map) valor;
            return map.isEmpty();
        } else if (valor instanceof Object[]) {
            Object[] array = (Object[]) valor;
            for (Object object : array) {
                if (!isNullOrEmpty(object)) {
                    return false;
                }
            }
        }
        return false;
    }

    public static int calcularDiferencaEntre(final Date data1, final Date data2) {
        int tempDifference;
        int difference = 0;
        Calendar earlier = Calendar.getInstance();
        Calendar later = Calendar.getInstance();

        earlier.setTime(data1);
        later.setTime(data2);

        while (earlier.get(Calendar.YEAR) != later.get(Calendar.YEAR)) {
            tempDifference = 365 * (later.get(Calendar.YEAR) - earlier.get(Calendar.YEAR));
            difference += tempDifference;

            earlier.add(Calendar.DAY_OF_YEAR, tempDifference);
        }

        if (earlier.get(Calendar.DAY_OF_YEAR) != later.get(Calendar.DAY_OF_YEAR)) {
            tempDifference = later.get(Calendar.DAY_OF_YEAR) - earlier.get(Calendar.DAY_OF_YEAR);
            difference += tempDifference;

            earlier.add(Calendar.DAY_OF_YEAR, tempDifference);
        }

        return difference;
    }
}
