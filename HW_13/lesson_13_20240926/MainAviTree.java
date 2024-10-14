package HW_13.lesson_13_20240926;

public class MainAviTree {
    public static void main(String[] args) {
        AvlTree tree = new AvlTree();
        //int[] keys = {10, 20, 30, 40, 50, 25};
        int[] keys = {75, 9, 18, 29, 17, 100, 88, 81};

        constructBST(tree, keys);

        tree.print3(tree.getRoot());

        // Поиск узла с ключом 100
        NodeTree result = tree.find(100);
        if (result != null) {
            System.out.println("Key found: " + result);
        } else {
            System.out.println("Key not found");
        }
        String separator = "---------------------------------------------------------------------------------";

        // Удаление узла
        int toDelete = 18;
        tree.delete(toDelete);
        System.out.println("Дерево после удаления узла "+ toDelete);
        tree.print3(tree.getRoot());
    }

    public static void constructBST(AvlTree tree, int[] keys) {
        NodeTree root = null;
        for (int key : keys) {
            NodeTree insert = tree.insert(tree.getRoot(), key);
            tree.setRoot(insert);
            tree.print3(tree.getRoot()); // визуализация
        }
    }
}
