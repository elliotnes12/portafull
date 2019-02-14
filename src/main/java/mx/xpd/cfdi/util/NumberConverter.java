package mx.xpd.cfdi.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.regex.Pattern;


public class  NumberConverter {

    private final static String[] UNIDADES = {"", "un ", "dos ", "tres ", "cuatro ", "cinco ", "seis ", "siete ", "ocho ", "nueve "};
    private final static String[] DECENAS = {"diez ", "once ", "doce ", "trece ", "catorce ", "quince ", "dieciseis ",
        "diecisiete ", "dieciocho ", "diecinueve", "veinte ", "treinta ", "cuarenta ",
        "cincuenta ", "sesenta ", "setenta ", "ochenta ", "noventa "};
    private final static String[] CENTENAS = {"", "ciento ", "doscientos ", "trescientos ", "cuatrocientos ", "quinientos ", "seiscientos ",
        "setecientos ", "ochocientos ", "novecientos "};

    public static String  convertNumberToLetter(String numero) {
    	String result = convertNumberToLetter(numero, false);
    	result = "" + result.substring(0,1).toUpperCase() + result.substring(1); 
    			
    	return result;
    }
    
    public static String  convertNumberToLetter(String numero, boolean mayusculas) {
        String literal = "";
        String parte_decimal;    
        //si el numero utiliza (.) en lugar de (,) -> se reemplaza
        numero = numero.replace(".", ",");
        //si el numero no tiene parte decimal, se le agrega ,00
        if(numero.indexOf(",")==-1){
            numero = numero + ",00";
        }
        int leng = numero.indexOf(",");
        
        if(numero.substring(numero.indexOf(",")).length() > 2) {
            numero = numero.substring(0, leng + 3); // numero.substring(numero.indexOf(","), 3);
        }
        System.out.println(numero);
        //se valida formato de entrada -> 0,00 y 999 999 999,00
        if (Pattern.matches("\\d{1,9},\\d{1,2}", numero)) {
            //se divide el numero 0000000,00 -> entero y decimal
            String Num[] = numero.split(",");            
            //de da formato al numero decimal
            if ( Num[1].length() == 1) {
            	Num[1] =  Num[1] + "0";
            }
            parte_decimal = "pesos, " + Num[1] + "/100 M.N.";
            //se convierte el numero a literal
            if (Integer.parseInt(Num[0]) == 0) {//si el valor es cero
                literal = "cero ";
            } else if (Integer.parseInt(Num[0]) > 999999) {//si es millon
                literal = getMillones(Num[0]);
            } else if (Integer.parseInt(Num[0]) > 999) {//si es miles
                literal = getMiles(Num[0]);
            } else if (Integer.parseInt(Num[0]) > 99) {//si es centena
                literal = getCentenas(Num[0]);
            } else if (Integer.parseInt(Num[0]) > 9) {//si es decena
                literal = getDecenas(Num[0]);
            } else {//sino unidades -> 9
                literal = getUnidades(Num[0]);
            }
            //devuelve el resultado en mayusculas o minusculas
            if (mayusculas) {
                return (literal + parte_decimal).toUpperCase();
            } else {
                return (literal + parte_decimal);
            }
        } else {//error, no se puede convertir
            return literal = null;
        }
    }

    /* funciones para convertir los numeros a literales */

    private static String getUnidades(String numero) {// 1 - 9
        //si tuviera algun 0 antes se lo quita -> 09 = 9 o 009=9
        String num = numero.substring(numero.length() - 1);
        return UNIDADES[Integer.parseInt(num)];
    }

    private static  String getDecenas(String num) {// 99                        
        int n = Integer.parseInt(num);
        if (n < 10) {//para casos como -> 01 - 09
            return getUnidades(num);
        } else if (n > 19) {//para 20...99
            String u = getUnidades(num);
            if (u.equals("")) { //para 20,30,40,50,60,70,80,90
                return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8];
            } else {
                return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8] + "y " + u;
            }
        } else {//numeros entre 11 y 19
            return DECENAS[n - 10];
        }
    }

    private static String getCentenas(String num) {// 999 o 099
        if( Integer.parseInt(num)>99 ){//es centena
            if (Integer.parseInt(num) == 100) {//caso especial
                return " cien ";
            } else {
                 return CENTENAS[Integer.parseInt(num.substring(0, 1))] + getDecenas(num.substring(1));
            } 
        }else{//por Ej. 099 
            //se quita el 0 antes de convertir a decenas
            return getDecenas(Integer.parseInt(num)+"");            
        }        
    }

    private static String getMiles(String numero) {// 999 999
        //obtiene las centenas
        String c = numero.substring(numero.length() - 3);
        //obtiene los miles
        String m = numero.substring(0, numero.length() - 3);
        String n="";
        //se comprueba que miles tenga valor entero
        if (Integer.parseInt(m) > 0) {
            n = getCentenas(m);           
            return n + "mil " + getCentenas(c);
        } else {
            return "" + getCentenas(c);
        }

    }

    private static String getMillones(String numero) { //000 000 000        
        //se obtiene los miles
        String miles = numero.substring(numero.length() - 6);
        //se obtiene los millones
        String millon = numero.substring(0, numero.length() - 6);
        String n = "";
        if(millon.length()>1){
            n = getCentenas(millon) + "millones ";
        }else{
            n = getUnidades(millon) + "millon ";
        }
        return n + getMiles(miles);        
    }
}

/*

public class NumberConverter {

	private static final String[] UNIDADES = { "", "UN ", "DOS ", "TRES ",
			"CUATRO ", "CINCO ", "SEIS ", "SIETE ", "OCHO ", "NUEVE ", "DIEZ ",
			"ONCE ", "DOCE ", "TRECE ", "CATORCE ", "QUINCE ", "DIECISEIS",
			"DIECISIETE", "DIECIOCHO", "DIECINUEVE", "VEINTE" };
	private static final String[] DECENAS = { "VENTI", "TREINTA ", "CUARENTA ",
			"CINCUENTA ", "SESENTA ", "SETENTA ", "OCHENTA ", "NOVENTA ",
			"CIEN " };
	private static final String[] CENTENAS = { "CIENTO ", "DOSCIENTOS ",
			"TRESCIENTOS ", "CUATROCIENTOS ", "QUINIENTOS ", "SEISCIENTOS ",
			"SETECIENTOS ", "OCHOCIENTOS ", "NOVECIENTOS " };

	/**
	 * Convierte a letras un numero de la forma $123,456.32
	 * 
	 * @param number
	 *            Numero en representacion texto
	 * @throws NumberFormatException
	 *             Si valor del numero no es valido (fuera de rango o )
	 * @return Numero en letras
	 */

/*
public static String convertNumberToLetter(String number)
			throws NumberFormatException {
		return convertNumberToLetter(Double.parseDouble(number));
	}

	/**
	 * Convierte un numero en representacion numerica a uno en representacion de
	 * texto. El numero es valido si esta entre 0 y 999'999.999
	 * 
	 * @param number
	 *            Numero a convertir
	 * @return Numero convertido a texto
	 * @throws NumberFormatException
	 *             Si el numero esta fuera del rango
	 */
/*
	public static String convertNumberToLetter(double doubleNumber)
			throws NumberFormatException {

		StringBuilder converted = new StringBuilder();

		String patternThreeDecimalPoints = "#.###";

		DecimalFormat format = new DecimalFormat(patternThreeDecimalPoints);
		format.setRoundingMode(RoundingMode.DOWN);

		// formateamos el numero, para ajustarlo a el formato de tres puntos
		// decimales
		String formatedDouble = format.format(doubleNumber);
		doubleNumber = Double.parseDouble(formatedDouble);

		// Validamos que sea un numero legal
		if (doubleNumber > 999999999) {
			throw new NumberFormatException(
					"El numero es mayor de 999'999.999, "
							+ "no es posible convertirlo");
		}

		if (doubleNumber < 0) {
			throw new NumberFormatException("El numero debe ser positivo");
		}

		String splitNumber[] = String.valueOf(doubleNumber).replace('.', '#')
				.split("#");

		// Descompone el trio de millones
		int millon = Integer.parseInt(String.valueOf(getDigitAt(splitNumber[0],
				8))
				+ String.valueOf(getDigitAt(splitNumber[0], 7))
				+ String.valueOf(getDigitAt(splitNumber[0], 6)));
		if (millon == 1) {
			converted.append("UN MILLON ");
		} else if (millon > 1) {
			converted.append(convertNumber(String.valueOf(millon))
					+ "MILLONES ");
		}

		// Descompone el trio de miles
		int miles = Integer.parseInt(String.valueOf(getDigitAt(splitNumber[0],
				5))
				+ String.valueOf(getDigitAt(splitNumber[0], 4))
				+ String.valueOf(getDigitAt(splitNumber[0], 3)));
		if (miles == 1) {
			converted.append("MIL ");
		} else if (miles > 1) {
			converted.append(convertNumber(String.valueOf(miles)) + "MIL ");
		}

		// Descompone el ultimo trio de unidades
		int cientos = Integer.parseInt(String.valueOf(getDigitAt(
				splitNumber[0], 2))
				+ String.valueOf(getDigitAt(splitNumber[0], 1))
				+ String.valueOf(getDigitAt(splitNumber[0], 0)));
		if (cientos == 1) {
			converted.append("UN");
		}

		if (millon + miles + cientos == 0) {
			converted.append("CERO");
		}
		if (cientos > 1) {
			converted.append(convertNumber(String.valueOf(cientos)));
		}

		converted.append("PESOS");

		// Descompone los centavos
		int centavos = Integer.parseInt(String.valueOf(getDigitAt(
				splitNumber[1], 2))
				+ String.valueOf(getDigitAt(splitNumber[1], 1))
				+ String.valueOf(getDigitAt(splitNumber[1], 0)));
		if (centavos == 1) {
			converted.append(" CON UN CENTAVO");
		} else if (centavos > 1) {
			converted.append(" CON " + convertNumber(String.valueOf(centavos))
					+ "CENTAVOS");
		}
		
		return converted.toString();
	}

	/**
	 * Convierte los trios de numeros que componen las unidades, las decenas y
	 * las centenas del numero.
	 * 
	 * @param number
	 *            Numero a convetir en digitos
	 * @return Numero convertido en letras
	 */
/*
private static String convertNumber(String number) {

		if (number.length() > 3) {
			throw new NumberFormatException(
					"La longitud maxima debe ser 3 digitos");
		}

		// Caso especial con el 100
		if (number.equals("100")) {
			return "CIEN";
		}

		StringBuilder output = new StringBuilder();
		if (getDigitAt(number, 2) != 0) {
			output.append(CENTENAS[getDigitAt(number, 2) - 1]);
		}

		int k = Integer.parseInt(String.valueOf(getDigitAt(number, 1))
				+ String.valueOf(getDigitAt(number, 0)));

		if (k <= 20) {
			output.append(UNIDADES[k]);
		} else if (k > 30 && getDigitAt(number, 0) != 0) {
			output.append(DECENAS[getDigitAt(number, 1) - 2] + "Y "
					+ UNIDADES[getDigitAt(number, 0)]);
		} else {
			output.append(DECENAS[getDigitAt(number, 1) - 2]
					+ UNIDADES[getDigitAt(number, 0)]);
		}

		return output.toString() + " ";
	}

	/**
	 * Retorna el digito numerico en la posicion indicada de derecha a izquierda
	 * 
	 * @param origin
	 *            Cadena en la cual se busca el digito
	 * @param position
	 *            Posicion de derecha a izquierda a retornar
	 * @return Digito ubicado en la posicion indicada
	 */
/*
private static int getDigitAt(String origin, int position) {
		if (origin.length() > position && position >= 0) {
			return origin.charAt(origin.length() - position - 1) - 48;
		}
		return 0;
	}

}
*/