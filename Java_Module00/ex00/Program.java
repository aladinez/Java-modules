
class Program{
    /**
     * @param args
     */
    public static void main(String[] args){
        int value = 479598;
        int ret = (value / 100000) + (value / 10000) % 10 + (value / 1000) % 10 + (value / 100) % 10 + (value / 10) % 10 + value % 10;
        System.out.println(ret);
    }
};