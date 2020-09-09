/*
稀疏数组
二维数组 转 稀疏数组
1.遍历二维数组，得到有效数据的个数 sum
2.根据sum 就可以创建稀疏数组 spaseArr int[sum+1][3]
3.将二维数组的有效数据传到稀疏数组

稀疏数组转二位
1.先读取第一行，根据第一行的数据创建原始二维数组
2.再读取后几行的数据，并赋值给原始数组
 */
public class parseArr {
    public static void main(String[] args) {
        //  创建原始数组
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        // for(数据类型 变量名 :遍历的目标){ //数据类型 变量名:声明一个变量用来接收遍历目标遍历后的元素
        //}
        System.out.println("原始的二维数组");
        for (int [] row:chessArr1
             ) {
            for (int date:row
                 ) {
                System.out.printf("%d\t",date);
            }
            System.out.println();
        }
        // 将二维数组转稀疏数组
        // 1. 先遍历二维数组 得到非0的数据个数
        int sum = 0 ;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j]!= 0){
                    sum++;
                }
            }
        }
        System.out.println("sum = " + sum);
        // 2. 创建稀疏数组
        int sparseArr[][] = new int[sum+1][3];
        // 给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        // 遍历二位数值，将非0的值放到sparseArr
        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j]!= 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        System.out.println("得到的稀疏数组为");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        System.out.println();
        // 稀疏数组 - 二位数组
        // 1.先读取第一行
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        //输出恢复后的二位数组
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] =sparseArr[i][2];
        }
        System.out.println("恢复后的二维数组");
        System.out.println();
        for (int [] row:sparseArr
             ) {
            for (int date :row
                 ) {
                System.out.printf("%d\t",date);
            }
            System.out.println();
        }

    }
}
