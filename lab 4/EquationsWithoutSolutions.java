public class EquationsWithoutSolutions extends Exception {

    public String toString() {
        return "Error: Рівняння не має розв'язків, оскільки дискримінант < 0!!!";
    }
}
