package examples._2025_08_20__try_catch_finally;

public class Main {
    public static void main(String[] args) throws Exception {
        Exception ex;
        String s = null;

        try {
            s.length();
        } catch (NullPointerException e) {
            ex = e;
            throw ex;
        } finally {
            System.out.println("Finally");
            ex = new Exception("Finally");
            System.out.println(ex.getMessage());
        }
    }
}
