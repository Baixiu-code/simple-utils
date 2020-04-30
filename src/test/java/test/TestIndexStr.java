package test;

/**
 * index
 * 获取字符串索引的位置
 * @author chenfanglin
 * @date 2020年04月30日
 */
public class TestIndexStr {

    public static Integer indexOfStr(String source,String needle){
        int sl=source.length();
        int nl=needle.length();
        int allLength=sl-nl+1;
        for(int start=0;start<allLength;++start){
            if(source.substring(start,start+nl).equals(needle)){
                return start;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(indexOfStr("271","1"));
    }

}
