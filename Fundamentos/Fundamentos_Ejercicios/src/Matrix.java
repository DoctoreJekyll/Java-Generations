public class Matrix
{
    private int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    public void SoutPares()
    {
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                if (matriz[i][j] % 2 == 0){
                    System.out.println(matriz[i][j]);
                };
            }
        }
    }

    private void imprimeMatriz(int[][] m)
    {
        for (int i = 0; i < m.length; i++){
            for (int j = 0; j < m[i].length; j++){
                System.out.print(m[i][j] + "\t");
            }
        }
    }

    private void test(int size)
    {
        if (size <= 0)
        {
            return;
        }

        int[][] matriz2 = new int[size][size];

        for (int i = 0; i < matriz2.length; i++){
            for (int j = 0; j < matriz2[i].length; j++){
                matriz2[i][j] = 3;
            }
        }

        imprimeMatriz(matriz2);
    }

    public void play()
    {
        imprimeMatriz(matriz);
    }


}
