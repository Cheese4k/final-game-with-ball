public class MyFirstClass {
    public static int a = 5;
    public static int c = 650;
    public static int m = 555;
    public static int seed = 1;

    public static int getNextRandom()
    {
        seed = (a * seed + c) % m;
        return seed;
    }

    public static void main(String[] args)
    {
        for (int i = 0; i < 3; i++)
        {
            System.out.println(getNextRandom());
        }
    }
}