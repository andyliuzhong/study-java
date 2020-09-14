package com.dayeliu.sparsearray;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author liuch
 * @date 2020/9/14 - 20:24
 */
public class SparseArray {
    public static void main(String[] args) throws IOException {
        sparseAlth();
    }
    private static void sparseAlth() throws IOException {
        //二维数组 -> 稀疏数组
        int[][] sparseArr = twoArrToSparseArr();

        //将稀疏数组写入文件
        writeSparseToFile(sparseArr);


        //从文件读取稀疏数组
        ArrayList arrayList = readSparseFromFile();
        //将稀疏数组转为 二维数组
        int[][] twoArr = sparseArrToTwoArr(arrayList);
    }

    private static ArrayList readSparseFromFile() {
        ArrayList<String> list = new ArrayList();
        Path path = Paths.get("D:/tmpData/map.data");
        if (Files.exists(path)) {
            try(BufferedReader reader = Files.newBufferedReader(path)) {
                reader.lines().forEach((lines) -> {
                    list.add(lines);
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return list;
    }

    private static void writeSparseToFile(int[][] sparseArr) throws IOException {
        Path path = Paths.get("D:/tmpData/map.data");
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        BufferedWriter writer = Files.newBufferedWriter(path);
        for (int[] row:sparseArr){
            for (int data:row){
                writer.write(data + " ");
            }
            writer.write("\n");
            writer.flush();
        }
        writer.close();
    }

    private static int[][] twoArrToSparseArr() {
        //创建一个原始数组为 11 * 11的二维数组
        // 0 表示没有数据 1表示黑子  2表示黑子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[5][8] = 2;
        //输出原二维数组
        //0	0	0	0	0	0	0	0	0	0	0
        //0	0	1	0	0	0	0	0	0	0	0
        //0	0	0	2	0	0	0	0	0	0	0
        //0	0	0	0	0	0	0	0	0	0	0
        //0	0	0	0	0	0	0	0	0	0	0
        //0	0	0	0	0	0	0	0	0	0	0
        //0	0	0	0	0	0	0	0	0	0	0
        //0	0	0	0	0	0	0	0	0	0	0
        //0	0	0	0	0	0	0	0	0	0	0
        //0	0	0	0	0	0	0	0	0	0	0
        //0	0	0	0	0	0	0	0	0	0	0
        for (int[] row : chessArr1){
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //将二维数组转稀疏数组
        //1.得到非0数据的个数
        int sum = 0;
        for (int i = 0;i < 11; i++){
            for (int j = 0;j < 11;j++){
                if (chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }
        System.out.println("==================原二维数组非0个数" + sum);

        //创建稀疏数组  行 sum + 1 ,列 固定 3
        //第一行 存储原始二维数组 ： 行 列 非0数据个数
        int sparseArr[][] = new int[sum + 1][3];

        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //遍历二维数组 将非零数据存入稀疏数组
        int count = 0; //记录为第几个非零数据
        for (int i = 0;i < 11; i++){
            for (int j = 0;j < 11;j++){
                if (chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;//行
                    sparseArr[count][1] = j;//列
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        //输出稀疏数组
        //11 11	2
        //1	 2	1
        //2	 3	2
        System.out.println("=================稀疏数组");
        for (int i  = 0;i<sparseArr.length;i++){
            System.out.printf("%d\t%d\t%d\t",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
            System.out.println();
        }
        return sparseArr;
    }



    private static int[][] sparseArrToTwoArr(ArrayList<String> list) {
        //解析list
        String[] split = list.get(0).split(" ");
        int row = Integer.valueOf(split[0].trim());
        int colum = Integer.valueOf(split[1].trim());

        //读取稀疏数组第一行 得到原始二维数组的行 列
        //读书稀疏数组的后几行数据  -> 赋值给二维数组
//        int orignalArr[][] = new int[spars[0][0]][spars[0][1]];
        int orignalArr[][] = new int[row][colum];

//        for (int i = 1;i<spars.length;i++) {
//            orignalArr[spars[i][0]][spars[i][1]] = spars[i][2];
//        }
        for (int i = 1; i < list.size(); i++) {
            String[] strings = list.get(i).split(" ");
            orignalArr[Integer.valueOf(strings[0].trim())][Integer.valueOf(strings[1].trim())] = Integer.valueOf(strings[2].trim());
        }

        for (int[] rowData : orignalArr){
            for (int data : rowData) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        return orignalArr;
    }
}
