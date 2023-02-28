package com.matriz.reto.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rotation {
    private int clockwise;
    private int[][] matrix;
}
