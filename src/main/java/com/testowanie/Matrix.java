package com.testowanie;
import java.util.Scanner;

import static jdk.nashorn.internal.objects.Global.Infinity;
class Matrix {
    public static void matrixMain() {
        Scanner in = new Scanner(System.in);
        int frows;
        int fcolumns;
        int srows;
        int scolumns;

        // Sets the dimensions of matrices
        System.out.println("Enter size of first matrix");
        frows = in.nextInt();
        fcolumns = in.nextInt();

        System.out.println("Enter size of second matrix");
        srows = in.nextInt();
        scolumns = in.nextInt();

        // Creates the matrices with the given dimensions
        double[][] matrix1 = new double[frows][fcolumns];
        double[][] matrix2 = new double[srows][scolumns];
        // Sets the matrices values
        double[][] matrix1Values = setMatrixValues(matrix1,"First");
        double[][] matrix2Values = setMatrixValues(matrix2, "Second");

        double[][] resultMatrix;

        System.out.println("Select matrix operation, \n type in + for addition, - for subtraction or * for multiplication:");
        String operator = in.next();
        switch(operator){
            case "*":
                resultMatrix = multiplyMatrices(matrix1Values, matrix2Values);
                printMatrix(resultMatrix);
                break;
            case "+":
                resultMatrix = addMatrices(matrix1Values, matrix2Values);
                printMatrix(resultMatrix);
                break;
            case "-":
                resultMatrix = subtractMatrices(matrix1Values, matrix2Values);
                printMatrix(resultMatrix);
                break;
            default:
                System.out.println("Operator not valid");
                break;
        }


    }
    // This method simply recurses through an array assigning values at each
    // location
    public static double[][] setMatrixValues(double[][] matrix, String label){
        System.out.println("Enter " + label + " matrix values:");
        Scanner in = new Scanner(System.in);
        double [] values = new double[matrix.length * matrix[0].length];
        for(int k = 0; k < values.length; k++){
            values[k] = in.nextInt();
        }
        int v = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j< matrix[0].length; j++){
                matrix[i][j] = values[v];
                v++;
            }
        }
        return matrix;
    }
    // All methods below this line perform operations
    public static double[][] multiplyMatrices(double[][] matrix1, double[][] matrix2){
        boolean status = checkIfValidMult(matrix1, matrix2);
        double[][] result= new double[matrix1.length][matrix2[0].length];
        if(status == true){

            for (int i=0; i<matrix1.length; ++i)
                for (int j=0; j<matrix2[0].length; ++j)
                    for (int k=0; k<matrix1[0].length; ++k)
                        result[i][j] += matrix1[i][k] * matrix2[k][j];
            return result;
        }else{
            System.out.println("Invalid Input");
            return new double[][]{{Infinity}};
        }
    }
    public static double[][] addMatrices(double[][] matrix1, double[][] matrix2){
        boolean status = checkIfValidAddSub(matrix1, matrix2);
        double[][] result = new double[matrix1.length][matrix1[0].length];
        if(status == true){
            for(int i = 0; i < matrix1.length; i++){
                for(int j = 0; j < matrix1[0].length; j++){
                    double charM1 = matrix1[i][j];
                    double charM2 = matrix2[i][j];
                    result[i][j] = charM1 + charM2;
                }
            }
            return result;
        }else{
            System.out.println("In order to add or subtract matrices they both must have the same number of rows \n and the same number of columns");
            return new double[][]{{Infinity}};
        }
    }
    public static double[][] subtractMatrices(double[][] matrix1, double[][] matrix2){
        boolean status = checkIfValidAddSub(matrix1, matrix2);
        double[][] result = new double[matrix1.length][matrix1[0].length];
        if(status == true){
            for(int i = 0; i < matrix1.length; i++){
                for(int j = 0; j < matrix1[0].length; j++){
                    double charM1 = matrix1[i][j];
                    double charM2 = matrix2[i][j];
                    result[i][j] = charM1 - charM2;
                }
            }
            return result;
        }else{
            System.out.println("In order to add or subtract matrices they both must have the same number of rows \n and the same number of columns");
            return new double[][]{{Infinity}};
        }
    }
    // The methods below this line will check if operation can e performed on
    // matrices
    public static boolean checkIfValidAddSub(double[][] matrix1, double[][] matrix2){
        boolean status;
        int numRows1 = matrix1.length;
        int numColumns1 = matrix1[0].length;
        int numRows2 = matrix2.length;
        int numColumns2 = matrix2[0].length;
        if(numRows1 == numRows2 && numColumns1 == numColumns2){
            status = true;
        }else{
            status = false;
        }
        return status;
    }
    public static boolean checkIfValidMult(double[][] matrix1, double[][] matrix2){
        boolean status;
        int columns = matrix1[0].length;
        int rows = matrix2.length;
        if( columns == rows){
            status = true;
        }else{
            status = false;
        }
        return status;
    }

    public static void printMatrix(double[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}