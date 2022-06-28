package com.company;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PrintStream output = new PrintStream(System.out);
        int row = input.nextInt();
        int col = input.nextInt();
        int generation = input.nextInt();
        // игра расположениа на торе
        String life[][] = new String[101][101];
        String subLife[][] = new String[101][101];
        // считать данные
        for ( int r = 0; r < row; r++ )
        {
            String rowStr = input.next();
            for ( int c = 0; c < col; c++ )
            {
                life [r][c] = rowStr.substring(c, c + 1);
            }
        }

        // пока не закончится число покалений
        for (int i = 0; i < generation; i++)
        {
            // проверка соседей в строке 1
            for ( int r = 0; r < row; r++ )
            {
                for ( int c = 0; c < col; c++ )
                {
                    subLife[r][c] = life[r][c];
                    int neighbour = 0;
                    //подмассив 3 на 3
                    for ( int r2 = r - 1; r2 < (r+2); r2++ )
                    {
                        int subR = r2;
                        // если число на первой строке или на последней
                        if(r2 == -1)
                        {
                            subR = row-1;
                        }
                        if(r2 > (row-1))
                        {
                            subR = 0;
                        }
                        for ( int c2 = c-1; c2 < (c+2); c2++ )
                        {
                            int subC = c2;
                            if(c2 == -1)
                            {
                                subC = col-1;
                            }
                            if(c2 > (col-1))
                            {
                                subC = 0;
                            }
                            // проверка является текущий элемент самим элементом
                            // с которым все сравнивается
                            if((r == subR)&& (c == subC))
                            {
                                //пропустить итерацию и перейти в начало
                                continue;
                            }
                            //проверка элемента на присутствие  *
                            if (life [subR][subC].equals("*"))
                            {
                                neighbour++;
                            }
                        }
                    }
                    // уменьшить соседа на 1
                    //  если соседей > 3 или < 1
                    if ((neighbour > 3) || (neighbour < 2))
                    {
                        subLife [r][c] = ".";
                    }
                    else if (neighbour == 3)
                    {
                        subLife [r][c] = "*";
                    }

                }
            }
            // перезаписать подмассив на место массива
            for ( int r = 0; r < row; r++ )
            {
                for ( int c = 0; c < col; c++ )
                {
                    life[r][c] = subLife[r][c];
                }
            }
        }
        for ( int r = 0; r < row; r++ )
        {
            for ( int c = 0; c < col; c++ )
            {
                output.print(life[r][c]);
            }
            output.println();
        }

        output.flush();
    }
}
