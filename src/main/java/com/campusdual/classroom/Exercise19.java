package com.campusdual.classroom;

import java.util.SplittableRandom;

public class Exercise19 {

    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {

        int rows = intArrayTri[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));
            sb.append("\n");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();

    }

    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayTri.length - 1; i++) {
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            sb.append("   ");
        }
        sb.append(getUnidimensionalString(intArrayTri[intArrayTri.length - 1][row]));

        return sb.toString();
    }

    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }

    public static String getTridimensionalString(int[][][] intArrayTri) {
        int[][] flatMatrix = flatTridimensionalArray(intArrayTri);
        return getTridimensionalString(intArrayTri, flatMatrix);
    }

    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {
        int[][] flatTriArray = new int[intArrayTri[0].length][intArrayTri[0][0].length];
        int sum = 0;
        for (int d = 0; d < flatTriArray.length; d++) {
            for (int k = 0; k < flatTriArray[d].length; k++) {
                for (int j = 0; j < intArrayTri.length; j++) {
                    sum += intArrayTri[j][d][k];
                }
                flatTriArray[d][k] = sum;
                sum = 0;
            }
        }
        return flatTriArray;
    }

    public static String getBidimensionalString(int[][] intArrayBi) {
        StringBuilder builder = new StringBuilder();
        int c = 1;
        for (int i = 0; i < intArrayBi.length; i++) {
            for (int a = 0; a < intArrayBi[i].length; a++) {
                builder.append((a < intArrayBi.length - 1) ? c++ + " " : (i < intArrayBi[i].length - 1) ?
                        c++ + "\n" : c++);
            }
        }
        return builder.toString();
    }

    public static String getUnidimensionalString(int[] uniArray) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < uniArray.length; i++) {
            builder.append((i < uniArray.length - 1) ? uniArray[i] + " " : uniArray[i]);
        }
        return builder.toString();
    }

    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int[] arrayTemplate = new int[columns];
        int cont = 1;
        for (int c = 0; c < columns; c++) {
            arrayTemplate[c] = cont;
            cont++;
        }
        return arrayTemplate;
    }

    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        int[][] bidArrayTemplate = new int[rows][columns];
        int cont = 1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                bidArrayTemplate[r][c] = cont;
                cont++;
            }
        }
        return bidArrayTemplate;
    }

    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int[][][] tridArrayTemplate = new int[depth][rows][columns];
        int c = 1;
        for (int j = 0; j < depth; j++) {
            for (int p = 0; p < rows; p++) {
                for (int a = 0; a < columns; a++) {
                    tridArrayTemplate[j][p][a] = c;
                    c++;
                }
            }
        }
        return tridArrayTemplate;
    }

    public static void main(String[] args) {
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println(getUnidimensionalString(uniArray));
        System.out.println("===================");
        int[][] intArrayBi = createAndPopulateBidimensionalArray(5, 5);
        System.out.println(getBidimensionalString(intArrayBi));
        System.out.println("===================");
        int[][][] intArrayTri = createAndPopulateTridimensionalArray(3, 3, 3);
        System.out.println(getTridimensionalString(intArrayTri));
    }
}
