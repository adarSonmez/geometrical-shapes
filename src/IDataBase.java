public interface IDataBase {
    default void welcome() {
        System.out.println("Welcome..");
    }

    static void testStatic() {
        System.out.println("testStatic method triggered.");
    }

    void nothing();
}