package processor;
import java.util.Scanner;
import java.util.Arrays;


class Matrix {
    private int m;
    private int n;
    private double[][] matrix;

    public void setMatrix(int n, int m, double[][] matrix) {
        this.m = m;
        this.n = n;
        this.matrix = matrix;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public void printMatrix (){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.printf("%.2f ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void multiplicationMatrices(Matrix matrix) {
        double[][] aux = new double[n][matrix.getM()];
        double[][] aux2 = matrix.getMatrix();
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < matrix.getM(); i++) {
                    for (int j = 0; j < matrix.getN(); j++) {
                        aux[k][i] += this.matrix[k][j] * aux2[j][i];
                    }
                }
            }

            for (int i = 0; i < n; i++){
                for (int j = 0; j < matrix.getM(); j++){
                    System.out.print(aux[i][j] + " ");
                }
                System.out.println();
            }

    }

    public void addMatrix(Matrix matrix) {
        double[][] aux = new double[n][m];
        for(int i = 0; i < this.n; i++){
            for(int j = 0; j < this.m; j++){
                aux[i][j] = this.matrix[i][j] + matrix.getMatrix()[i][j];
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.print(aux[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void mulConstant(double c) {
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                matrix[i][j] *= c;
            }
        }
        printMatrix();
    }

    public void transposeMatrix(int mode) {
        double[][] aux = new double[n][m];
        if(mode == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    aux[j][i] = matrix[i][j];
                }
            }
        }else if(mode == 2){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    aux[i][j] = matrix[(n-1)-j][(m-1)-i];
                }
            }
        }else if(mode == 3){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    aux[j][i] = matrix[j][(m-1)-i];
                }
            }
        }else if(mode == 4){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    aux[i][j] = matrix[(n-1)-i][j];
                }
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.print(aux[i][j] + " ");
            }
            System.out.println();
        }
    }

}

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while(true) {
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix to a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("4. Transpose matrix");
            System.out.println("5. Calculate a determinant");
            System.out.println("6. Inverse matrix");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            Matrix matrix1 = new Matrix();
            Matrix matrix2 = new Matrix();
            int n = 0;
            int m = 0;
            double[][] elements;
            double[][] elements1;

            switch (choice){
                case 1:
                    System.out.print("Enter size of first matrix: ");
                    n = scanner.nextInt();
                    m = scanner.nextInt();
                    elements = new double[n][m];
                    System.out.println("Enter first matrix:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            elements[i][j] = scanner.nextDouble();
                        }
                    }
                    matrix1.setMatrix(n, m, elements);
                    System.out.print("Enter size of second matrix: ");
                    n = scanner.nextInt();
                    m = scanner.nextInt();
                    elements1 = new double[n][m];
                    System.out.println("Enter second matrix:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            elements1[i][j] = scanner.nextDouble();
                        }
                    }
                    matrix2.setMatrix(n, m, elements1);
                    matrix1.addMatrix(matrix2);
                    break;
                case 2:
                    System.out.print("Enter matrix size: ");
                    n = scanner.nextInt();
                    m = scanner.nextInt();
                    elements = new double[n][m];
                    System.out.println("Enter matrix:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            elements[i][j] = scanner.nextDouble();
                        }
                    }
                    matrix1.setMatrix(n, m, elements);
                    System.out.println("Enter constant:");
                    double c = scanner.nextInt();
                    matrix1.mulConstant(c);
                    break;
                case 3:
                    System.out.print("Enter size of first matrix: ");
                    n = scanner.nextInt();
                    m = scanner.nextInt();
                    elements = new double[n][m];
                    System.out.println("Enter first matrix:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            elements[i][j] = scanner.nextDouble();
                        }
                    }
                    matrix1.setMatrix(n, m, elements);
                    System.out.print("Enter size of second matrix: ");
                    n = scanner.nextInt();
                    m = scanner.nextInt();
                    elements1 = new double[n][m];
                    System.out.println("Enter second matrix:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            elements1[i][j] = scanner.nextDouble();
                        }
                    }
                    matrix2.setMatrix(n, m, elements1);
                    System.out.println("The multiplication result is:");
                    matrix1.multiplicationMatrices(matrix2);
                    break;
                case 4:
                    transposeMatrix();
                    break;
                case 5:
                    System.out.print("Enter matrix size: ");
                    n = scanner.nextInt();
                    m = scanner.nextInt();
                    elements = new double[n][m];
                    System.out.println("Enter matrix:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            elements[i][j] = scanner.nextDouble();
                        }
                    }
                    matrix1.setMatrix(n, m, elements);
                    double[][] aux = matrix1.getMatrix();
                    double det = determinant(aux, n);
                    System.out.println("The result is:");
                    System.out.println(det);
                    break;
                case 6:
                    System.out.print("Enter matrix size: ");
                    n = scanner.nextInt();
                    m = scanner.nextInt();
                    elements = new double[n][m];
                    System.out.println("Enter matrix:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            elements[i][j] = scanner.nextDouble();
                        }
                    }
                    matrix1.setMatrix(n, m, elements);
                    double[][] aux1 = matrix1.getMatrix();
                    double det1 = determinant(aux1, n);
                    double[] res = matrixCofactor(aux1, n);
                    int cont = 0;
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            aux1[j][i] = res[cont];
                            cont++;
                        }
                    }
                    matrix2.setMatrix(n, m, aux1);
                    double constant = 1/det1;
                    System.out.println("The result is:");
                    matrix2.mulConstant(constant);
                    break;
                case 0:
                    System.exit(0);
            }
        }

    }

    public static void transposeMatrix() {
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Transpose matrix");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();
        int n;
        int m;
        double[][] elements;
        Matrix matrix = new Matrix();
        System.out.print("Enter matrix size: ");
        n = scanner.nextInt();
        m = scanner.nextInt();
        elements = new double[n][m];
        System.out.println("Enter matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                elements[i][j] = scanner.nextDouble();
            }
        }
        matrix.setMatrix(n, m, elements);
        System.out.println("The result is:");
        switch (choice){
            case 1:
                matrix.transposeMatrix(choice);
                return;
            case 2:
                matrix.transposeMatrix(choice);
                return;
            case 3:
                matrix.transposeMatrix(choice);
                return;
            case 4:
                matrix.transposeMatrix(choice);
                return;
        }
    }

    public static double determinant(double[][] matrix, int n) {
        double d = 0;
        int cont = -1;
        if (n == 2){
            return (matrix[0][0]*matrix[1][1]) - (matrix[1][0]*matrix[0][1]);
        }
        cont++;
            for (int j = 0; j < n; j++){
                d += Math.pow((-1), cont+j)* (matrix[0][j] * (determinant(subMat(matrix, n, 0, j), n-1)));

            }
        return d;
    }

    public static double[][] subMat(double[][] matrix, int n, int cont, int cont1) {
        double[][] aux = new double[n][n];
        int i = 0;
        int j = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if(row != cont && col != cont1){
                    aux[i][j++] = matrix[row][col];
                    if(j == n-1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
        return aux;
    }

    public static double[] matrixCofactor(double[][] matrix, int n) {
        double[] d = new double[n*n];
        int cont = -1;
        int cont1 = 0;
        int cont2 = 0;
        if (n == 2){
            d[(n*n)-1] = (matrix[0][0]*matrix[1][1]) - (matrix[1][0]*matrix[0][1]);
            return d;
        }
        cont++;
        for (int j = 0; j < (n*n); j++){
            d[j] += Math.pow((-1), cont1+cont2)* (determinant(subMat(matrix, n, cont1, cont2), n-1));
            cont2++;
            if(cont2 == n){
                cont2 = 0;
                cont1++;
            }
        }
        return d;
    }
}