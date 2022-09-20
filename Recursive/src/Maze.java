import java.util.Scanner;
import java.util.Stack;

public class Maze {
    static int n,m,endX,endY,min = 99999;
    static int[][] a = new int[51][51];
    static int[][] book = new int[51][51];
    public static void main(String[] args) {
        //读入n和m，n为行，m为列
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入行：");
        n = scanner.nextInt();
        System.out.println("输入列：");
        m = scanner.nextInt();
        System.out.println("输入迷宫：");
        for (int i =1; i<=n ;i++){
            for (int j =1;j<=m;j++){
                a[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
        int startX = 1,startY = 1;
        endX = n;
        endY = m;
        //从起点开始搜索
        book[startX][startY] = 1;//标记起点已经在路径中
        dfs(startX,startY,0);
        System.out.println("最短的路径 " + min);
    }
    public static void dfs(int x, int y, int step){
        //定义四个方向
        int[][] next= {{0,1},{1,0},{0,-1},{-1,0}};
        int tx,ty;
        //判断是否到达出口
        if(x ==endX  && y == endY){
            //更新最小值
            if(step<=min)
                min = step;
            return;
        }
        //四种走法
        for(int k =0; k<4;k++){
            //计算下一个坐标点
            tx = x + next[k][0];
            ty = y + next[k][1];
            //判断是否越界，是否为障碍物，是否在路径中
            if(tx < 1|| tx > n || ty <1|| ty > n){
                continue;
            }
            if(a[tx][ty] == 0 && book[tx][ty] == 0){
                book[tx][ty]  = 1;//标记这个点已经做过了
                dfs(tx,ty,step+1);//开始尝试下一个点
                book[tx][ty] = 0;//尝试结束，取消这个点的标记

            }
        }
    }
}
