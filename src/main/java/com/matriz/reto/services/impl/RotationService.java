package com.matriz.reto.services.impl;

import com.matriz.reto.entities.Rotation;
import com.matriz.reto.services.IRotationService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RotationService  implements IRotationService {

    @Override
    public Rotation rotateInPlace90Degrees(Rotation rotation) {
        int[][] matrix = rotation.getMatrix();
        int clockwise = rotation.getClockwise();
        int n = matrix.length;
        int media = n / 2;
        if(!(clockwise== 1||clockwise== -1)){
            throw new RuntimeException("clockwise value incorrect");
        }
        printMatrix(matrix,n);
        for (int capa = 0; capa < media; capa++) {
            int primerCapa = capa;
            int ultimaCapa = n - 1 - capa;

            for (int i = primerCapa; i < ultimaCapa; i++) {
                int offset = i - primerCapa;
                int j = ultimaCapa - offset;
                rotationCase(matrix,i,j,primerCapa,ultimaCapa,clockwise);
            }
        }
        printMatrix(matrix,n);
        return rotation;
    }
    private void rotationCase(int[][] matrix, int i, int j, int primerCapa, int ultimaCapa,int clockwise){
        int top = matrix[primerCapa][i]; // guarda arriba
        if(clockwise==1){
            //   arriba       <-      izquierda
            matrix[primerCapa][i] = matrix[j][primerCapa];
            //  izquierda     <-  abajo
            matrix[j][primerCapa] = matrix[ultimaCapa][j];
            //  abajo     <-      derecha
            matrix[ultimaCapa][j] = matrix[i][ultimaCapa];
            //  derecha      <-     arriba
            matrix[i][ultimaCapa] = top; // derecha <- guarda arriba
        }else {
            // arriba <- derecha
            matrix[primerCapa][i] = matrix[i][ultimaCapa] ;
            // derecha <- abajo
            matrix[i][ultimaCapa] = matrix[ultimaCapa][j];
            // abajo <- izquierda
            matrix[ultimaCapa][j] = matrix[j][primerCapa];
            //izquierda <- arriba
            matrix[j][primerCapa] = top;
        }
    }

    private void printMatrix(int[][]matrix, int length){
        for ( int mtz[]:matrix){
            if(mtz.length!=length){
                throw new RuntimeException("matrix format incorrect");
            }
            System.out.println(Arrays.toString(mtz));
        }
    }


}
