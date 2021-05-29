public interface IDataBase {
    default void welcome() {
        System.out.println("Welcome..");
    }

    void nothing();
}