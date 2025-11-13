import java.util.Scanner;
public class CharacterMovement {
    public static int x=(int)(Math.random()*16),y=(int)(Math.random()*16);
    public static int gx=(int)(Math.random()*16),gy=(int)(Math.random()*16);
    public static char[][] map =new char[17][17];
    public static void memset(){
        for(int i = 1;i <= 16;i++){
            for(int j = 1;j <= 16;j++){
                map[i][j]='-';
            }
        }
    }
    public static void printGrid(){
        for(int i = 1;i <= 16;i++){
            for(int j = 1;j <= 16;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    public static void newGoal(){
        gx=(int)(Math.random()*16);
        gy=(int)(Math.random()*16);
        while(map[gx][gy]!='-'){
            gx=(int)(Math.random()*16);
            gy=(int)(Math.random()*16);
        }
        map[gx][gy]='G';
    }
    public static void beingAttack(){

    }
    public static void Move(int t,int cx,int cy){
        int[] dx={0,-1,1,0,0};
        int[] dy={0,0,0,-1,1};
        if(t==-1)return;
        int tx=cx+dx[t],ty=cy+dy[t];
        if(tx>0&&tx<=16&&ty>0&&ty<=16){
            if(map[gx][gy]=='M'){
                beingAttack();
            }
            map[x][y]='-';
            x=tx;y=ty;
             map[x][y]='|';
            printGrid();
        }
        else System.out.println("INVALID INPUT, PLEASE ENTER AGAIN");
    }
    public static void Enemy(int lvl){
        int mons = lvl * 3 - 2;
        int a=0,b=0,fl=1;
        for (int i = 0; i < mons; i++) {
            while(fl==1){
                a = (int) (Math.random()*17);
                b = (int) (Math.random()*17);
                if(map[a][b]=='-'){
                    map[a][b]='M';
                    fl=0;
                }
            }
        }
        
    }
    public static void main(String[] args){
        System.out.println("Tutorial:");
        System.out.println("Welcome fellow adventurer! Your goal is to reach the portal at 'G' to advance to the next level.");
        Scanner scanner = new Scanner(System.in);
        String input="";
        memset();
        map[x][y]='|';
        map[gx][gy]='G';
        printGrid();
        while(!input.equals("exit")){
            input=scanner.nextLine();
            int moveType=-1;
            if(input.equals("W")||input.equals("w"))
                moveType=1;
            if(input.equals("S")||input.equals("s"))
                moveType=2;
            if(input.equals("A")||input.equals("a"))
                moveType=3;
            if(input.equals("D")||input.equals("d"))
                moveType=4;
            Move(moveType,x,y);
            if(x==gx&&y==gy)newGoal();
        }
    }
}
