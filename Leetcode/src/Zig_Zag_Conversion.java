import java.util.ArrayList;
import java.util.List;

public class Zig_Zag_Conversion {
//    public static String convert(String string,int numRows){
//        if(numRows==1)return string;
//        List<StringBuilder> rows = new ArrayList<>();
//        /**
//         * Берем минимум,т.к. очевидно,что если длина строки меньше колонок,
//         * то нам нет смысла выделять дополнительные
//         */
//        for(int i = 0;i<Math.min(numRows,string.length());++i){
//            rows.add(new StringBuilder());
//        }
//        int cur_Row = 0;
//        boolean go_Down = false;
//        for(char c:string.toCharArray()){
//            rows.get(cur_Row).append(c);
//            if(cur_Row == 0 || cur_Row == numRows-1)go_Down = !go_Down;
//            cur_Row+= go_Down?1:-1;
//        }
//        StringBuilder result = new StringBuilder();
//        for(StringBuilder stringBuilder:rows){
//            result.append(stringBuilder);
//        }
//        return result.toString();
//    }
    public static String convert(String string,int numRow){
        if(numRow==1)return string;
        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0;i<Math.min(numRow,string.length());++i){
            rows.add(new StringBuilder());
        }
        boolean go_Down = false;
        int curRow = 0;
        for(char c: string.toCharArray()){
            rows.get(curRow).append(c);
            if(curRow == 0 || curRow==numRow-1)go_Down=!go_Down;
            curRow+=go_Down?1:-1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(StringBuilder stringBuilder1:rows){
            stringBuilder.append(stringBuilder1);
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args){
        System.out.println(convert("PAYPALISHIRING",3));
        System.out.println("PAHNAPLSIIGYIR");
        System.out.println(convert("PAYPALISHIRING",4));
        System.out.println("PINALSIGYAHRPI");
    }
}
