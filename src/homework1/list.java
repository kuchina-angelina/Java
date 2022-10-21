//package homework1;
//
//import java.util.ArrayList;
//import java.util.Random;
//
//    public class List {
//        int[] listValue;
//        int[] listWeight;
//
//    public List(int[] listValue, int[] listWeight) {
//        this.listValue = listValue;//список значений
//        this.listWeight = listWeight;//список весов
//    }
//
//    public static void main(String[] args){
//        List v = new List(new int[] {1,2,3}, new int[] {10,5,6});
//        v.FillList();
//    }
//    public int FillList(){//метод,куда записываются значения с весом в новый массив
//        ArrayList<Integer> list = new ArrayList<>();//список,куда записываются значения с весом
//        for(int v=0;v<listValue.length;v++){
//            for(int w=0;w<listWeight[v];w++){//пока w не станет равно весу,в массив будет добавляться элемент
//                list.add(listValue[v]);
//            }
//        }
//        //System.out.println(list);
//        // просим распечатать рандомный элемент
//        Random rand = new Random();
//        int randomElement = list.get(rand.nextInt(list.size()));
//        System.out.println(randomElement);
//
//        return randomElement;
//    }
//}