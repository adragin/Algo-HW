package HW_13.lesson_13_20240926;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AvlTree {
    private NodeTree root;

    public NodeTree getRoot() {
        return root;
    }

    public void setRoot(NodeTree root) {
        this.root = root;
    }

    public NodeTree insert(NodeTree node, int key) {
        // 1. Выполняем обычную вставку в бинарное дерево поиска
        if (node == null) {
            return createNode(key);
        }

        // 2. Рекурсивно вставляем ключ в левое или правое поддерево
        if (key < node.getKey()) {
            node.setLeft(insert(node.getLeft(), key));
        } else { // Если ключ больше или равен текущему ключу
            node.setRight(insert(node.getRight(), key));
        }

        // 3. Обновляем высоту узла после вставки
        node.setHeight(1 + Util.max(Util.getHeightNode(node.getLeft()), Util.getHeightNode(node.getRight())));

        // 4. Балансируем дерево и возвращаем узел
        return balanceTree(key, node);
    }

    private NodeTree createNode(int key) {
        NodeTree newNode = new NodeTree();
        newNode.setKey(key);
        newNode.setHeight(1);
        return newNode;
    }

    private NodeTree balanceTree(int key, NodeTree node) {
        // 1. Обновление высоты узла
        int leftHeight = Util.getHeightNode(node.getLeft());
        int rightHeight = Util.getHeightNode(node.getRight());
        node.setHeight(1 + Util.max(leftHeight, rightHeight));

        // 2. Получаем баланс-фактор
        int balance = Util.getBalanceFactor(node);

        // 3. Проверяем на несбалансированность и выполняем вращения
        if (balance > 1) { // Левое поддерево тяжелее
            if (key < node.getLeft().getKey()) {
                // Левое-левое (Left-Left) случай
                return Util.rightRotate(node);
            } else {
                // Левое-правое (Left-Right) случай
                node.setLeft(Util.leftRotate(node.getLeft()));
                return Util.rightRotate(node);
            }
        }

        if (balance < -1) { // Правое поддерево тяжелее
            if (key > node.getRight().getKey()) {
                // Правое-правое (Right-Right) случай
                return Util.leftRotate(node);
            } else {
                // Правое-левое (Right-Left) случай
                node.setRight(Util.rightRotate(node.getRight()));
                return Util.leftRotate(node);
            }
        }

        // Возвращаем неизменённый узел
        return node;
    }


    public void print2(NodeTree node) {              // метод для вывода дерева в консоль
        Stack<NodeTree> globalStack = new Stack<>(); // общий стек для значений дерева
        globalStack.push(node);

        int gaps = 32;                               // начальное значение расстояния между элементами
        boolean isRowEmpty = false;

        String separator = "----------------------------------------------------------------";
        System.out.println(separator);               // черта для указания начала нового дерева

        while (!isRowEmpty) {
            Stack<NodeTree> localStack = new Stack<>();   // локальный стек для задания потомков элемента
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');

            while (!globalStack.isEmpty()) {              // покуда в общем стеке есть элементы
                NodeTree temp = globalStack.pop();       // берем следующий, при этом удаляя его из стека
                if (temp != null) {
                    System.out.print(temp.getKey());      // выводим его значение в консоли
                    localStack.push(temp.getLeft());   // сохраняем в локальный стек, наследники текущего элемента
                    localStack.push(temp.getRight());
                    if (temp.getLeft() != null ||
                            temp.getRight() != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("__");                 // - если элемент пустой
                    localStack.push(null);
                    localStack.push(null);
                }

                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;                                      // при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());    // перемещаем все элементы из локального стека в глобальный
            }
        }
        System.out.println(separator);                      // подводим черту
    }

    public NodeTree find(int key) {
        return findNode(root, key);
    }

    private NodeTree findNode(NodeTree node, int key) {
        if (node == null || node.getKey() == key) {  // если нашли ключ или достигли конца дерева
            return node;
        }

        // Ищем в левом или правом поддереве в зависимости от значения ключа
        if (key < node.getKey()) {
            return findNode(node.getLeft(), key);
        } else {
            return findNode(node.getRight(), key);
        }
    }

    public void delete(int key) {
        root = deleteNode(root, key);
    }

    private NodeTree deleteNode(NodeTree node, int key) {
        if (node == null) {
            return node;
        }

        // Если ключ меньше текущего узла, удаляем в левом поддереве
        if (key < node.getKey()) {
            node.setLeft(deleteNode(node.getLeft(), key));
        }
        // Если ключ больше текущего узла, удаляем в правом поддереве
        else if (key > node.getKey()) {
            node.setRight(deleteNode(node.getRight(), key));
        }
        // Если ключ равен ключу текущего узла, удаляем этот узел
        else {
            // Узел с одним или без потомков
            if (node.getLeft() == null || node.getRight() == null) {
                NodeTree child = node.getLeft() != null ? node.getLeft() : node.getRight();
                if (child == null) {
                    // Нет детей
                    node = null;
                } else {
                    // Один ребёнок
                    node = child;
                }
            } else {
                // Узел с двумя детьми: находим наименьший узел в правом поддереве
                NodeTree successor = Util.getMinValueNode(node.getRight());
                node.setKey(successor.getKey());
                node.setRight(deleteNode(node.getRight(), successor.getKey()));
            }
        }

        // Если дерево содержит только один узел, возвращаем его
        if (node == null) {
            return node;
        }

        // 2. Обновляем высоту текущего узла
        node.setHeight(1 + Util.max(Util.getHeightNode(node.getLeft()), Util.getHeightNode(node.getRight())));

        // 3. Балансируем узел, если дерево стало несбалансированным
        int balance = Util.getBalanceFactor(node);

        // Левое Левое (Left Left) нарушение
        if (balance > 1 && Util.getBalanceFactor(node.getLeft()) >= 0) {
            return Util.rightRotate(node);
        }

        // Левое Правое (Left Right) нарушение
        if (balance > 1 && Util.getBalanceFactor(node.getLeft()) < 0) {
            node.setLeft(Util.leftRotate(node.getLeft()));
            return Util.rightRotate(node);
        }

        // Правое Правое (Right Right) нарушение
        if (balance < -1 && Util.getBalanceFactor(node.getRight()) <= 0) {
            return Util.leftRotate(node);
        }

        // Правое Левое (Right Left) нарушение
        if (balance < -1 && Util.getBalanceFactor(node.getRight()) > 0) {
            node.setRight(Util.rightRotate(node.getRight()));
            return Util.leftRotate(node);
        }

        return node;
    }


    public void print3(NodeTree node) {
        if (node == null) {
            System.out.println("Tree is empty");
            return;
        }

        int treeHeight = getTreeHeight(node);  // высчитываем высоту дерева
        int gaps = (int) Math.pow(2, treeHeight - 1) * 6;  // начальные пробелы основываются на высоте дерева, расстояние между листьями - 6 пробелов
        String separator = "---------------------------------------------------------------------------------";
        System.out.println(separator);

        Queue<NodeTree> queue = new LinkedList<>();
        queue.add(node);

        boolean isRowEmpty = false;

        while (!isRowEmpty) {
            isRowEmpty = true;
            int nodesInLevel = queue.size();  // количество узлов на текущем уровне

            // печатаем начальные пробелы перед узлами
            for (int j = 0; j < gaps / 2; j++) {
                System.out.print(' ');
            }

            for (int i = 0; i < nodesInLevel; i++) {
                NodeTree currentNode = queue.poll();

                if (currentNode != null) {
                    System.out.printf("%3d", currentNode.getKey());  // выводим ключ узла
                    queue.add(currentNode.getLeft());
                    queue.add(currentNode.getRight());

                    if (currentNode.getLeft() != null || currentNode.getRight() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("---");  // пустой узел
                    queue.add(null);  // добавляем пустые потомки
                    queue.add(null);
                }

                // промежуток между узлами на одном уровне
                for (int j = 0; j < gaps - 3; j++) {
                    System.out.print(' ');
                }
            }

            System.out.println();
            gaps /= 2;  // уменьшаем пробелы для следующего уровня
        }

        System.out.println(separator);
    }

    // Вспомогательный метод для получения высоты дерева
    private int getTreeHeight(NodeTree node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getTreeHeight(node.getLeft()), getTreeHeight(node.getRight()));
    }


}