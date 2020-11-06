package com.dayeliu.practice;

/**
 * @author liuch
 * @date 2020/10/9 - 22:37
 */
public class MiGong {
    public static void main(String[] args) {
        miGongIssue();

    }

    //迷宫 最短路径问题
    //使用递归迷你迷宫问题

    /**
     * 确定迷宫大*小 及规则
     * 设置迷宫为 8*7大小
     *  1 - 墙
     *  2 - 标记可以走通
     *  3 - 标记走不通
     *  0 - 默认
     */
    public static void miGongIssue(){
        int[][] miGong = new int[8][7];

        //设置墙
        /*
        1	1	1	1	1	1	1
        1	0	0	0	0	0	1
        1	1	1	0	0	0	1
        1	0	0	0	0	0	1
        1	0	0	0	0	0	1
        1	0	0	0	0	0	1
        1	0	0	0	0	0	1
        1	1	1	1	1	1	1
         */
        for (int i = 0; i < 7; i++) {
            miGong[0][i] = 1;
            miGong[7][i] = 1;
        }
        miGong[3][1] = 1;
        miGong[3][2] = 1;
        //模拟走不出
        miGong[1][2] =1;
        miGong[2][2] =1;

        for (int i = 0; i < 7; i++) {
            miGong[i][0] = 1;
            miGong[i][6] = 1;
        }

        //制定游戏规则
//        miGongCount(miGong,1,1);
        miGongCount2(miGong,1,1);

        for (int i = 0; i < 8;i++) {
            for (int j = 0;j < 7; j++) {
                System.out.printf(miGong[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param map
     * @param beginRow
     * @param beginColum  出发点
     * @return
     * 当map[7][6] = 2 时到达出口 -> success
     *
     * 移到方向 下->右->上->左
     */
//    1	 1	1	1	1	1	1
//    1	 2	2	2	0	0	1
//    1	 1	1	2	0	0	1
//    1	 0	0	2	0	0	1
//    1	 0	0	2	0	0	1
//    1	 0	0	2	0	0	1
//    1	 0	0	2	2	2	1
//    1	 1	1	1	1	1	1
    private static boolean miGongCount(int[][] map, int beginRow,int beginColum) {
        if (map[6][5] == 2) {
            return true;
        }else if (map[beginRow][beginColum] == 0){
            //为0时代表可以继续
            //预设置当前值为2
            map[beginRow][beginColum] = 2;
            //制定游戏规则  移到方向 下->右->上->左
            if (miGongCount(map,beginRow + 1,beginColum)){//向下
                return true;
            }else
            if (miGongCount(map,beginRow,beginColum + 1)) {//right
                return true;
            }else
            if (miGongCount(map,beginRow - 1,beginColum)) {
                return true;
            }else
            if (miGongCount(map,beginRow,beginColum - 1)){
                return true;
            }else {
                //都走不通 设置当前位置为 3
                map[beginRow][beginColum] = 3;
                return false;
            }

        }else {
            //为 1 2 3 时代表走不通或者走过了 直接返回false
            return false;
        }
    }

    /**
     *
     * @param map
     * @param beginRow
     * @param beginColum
     * @return
     * 移到方向 上->右->下->左
     */
//    1  1	1	1	1	1	1
//    1  2	2	2	2	2	1
//    1  1	1	0	0	2	1
//    1  0	0	0	0	2	1
//    1  0	0	0	0	2	1
//    1  0	0	0	0	2	1
//    1  0	0	0	0	2	1
//    1  1	1	1	1	1	1
    private static boolean miGongCount2(int[][] map, int beginRow,int beginColum) {
        if (map[6][5] == 2) {
            return true;
        }else if (map[beginRow][beginColum] == 0){
            //为0时代表可以继续
            //预设置当前值为2
            map[beginRow][beginColum] = 2;
            //制定游戏规则  移到方向 上->右->下->左
            if (miGongCount2(map,beginRow - 1,beginColum)){//向下
                return true;
            }else
            if (miGongCount2(map,beginRow,beginColum + 1)) {//right
                return true;
            }else
            if (miGongCount2(map,beginRow + 1,beginColum)) {
                return true;
            }else
            if (miGongCount2(map,beginRow,beginColum - 1)){
                return true;
            }else {
                //都走不通 设置当前位置为 3
                map[beginRow][beginColum] = 3;
                return false;
            }

        }else {
            //为 1 2 3 时代表走不通或者走过了 直接返回false
            return false;
        }
    }
}
