package test.base.structure.shuixianhua;

/**
 * @Author chenfanglin 【chenfanglincfl@163.com】
 * @Date 2017/3/1711:46
 */
public class exp2{
    public static void main(String args[]){
        int i=0;
        math mymath = new math();
        for(i=100;i<=999;i++)
            if(mymath.shuixianhua(i)==true)
                System.out.println(i);
    }
}
class math
{
    public int f(int x)
    {
        if(x==1 || x==2)
            return 1;
        else
            return f(x-1)+f(x-2);
    }
    public boolean iszhishu(int x)
    {
        for(int i=2;i<=x/2;i++)
            if (x % 2==0 )
                return false;
        return true;
    }
    public boolean shuixianhua(int x)
    {
        int i=0,j=0,k=0;
        i=x / 100;
        j=(x % 100) /10;
        k=x % 10;
        if(x==i*i*i+j*j*j+k*k*k)
            return true;
        else
            return false;

    }
}