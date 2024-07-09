## 1. Реализовать метод вычисления факториала (n!) рекурсивным и итеративным способами.

### Рекурсивная реализация

```java
public static long factorialRecursive(int n) {
    if (n == 0) {
        return 1;
    } else {
        return n * factorialRecursive(n - 1);
    }
}

```

### Итеративная реализация

```java
public static long factorialIterative(int n) {
    long result = 1;
    for (int i = 1; i <= n; i++) {
        result *= i;
    }
    return result;
}
```

## 2. Итеративный и рекурсивный способы решения ханойской башни.

### Рекурсивное решение:

```java
public static void hanoi(int n, char fromRod, char toRod, char auxRod) {
    if (n == 0) {
        return;
    }
    hanoi(n - 1, fromRod, auxRod, toRod);
    System.out.println("Диск " + n + " с " + fromRod + " на " + toRod);
    hanoi(n - 1, auxRod, toRod, fromRod);
}
```

### Итеративное решение:

```java
private static void hanoiIterative(int n, String from, String to, String buf) {
    Stack<Integer> fromStack = new Stack<>();
    Stack<Integer> bufStack = new Stack<>();
    Stack<Integer> toStack = new Stack<>();

    // Инициализация исходного штыря
    for (int i = n; i > 0; i--) {
        fromStack.push(i);
    }

    int steps = (int) Math.pow(2, n - 1);
    while (steps > 0) {
        if (steps % 3 == 1) {
            moveDisk(fromStack, toStack, from, to);
        } else if (steps % 3 == 2) {
            moveDisk(fromStack, bufStack, from, buf);
        } else {
            moveDisk(bufStack, toStack, buf, to);
        }

        steps /= 3;
    }

    // Печать результата
    System.out.println("Диски на штыре " + to + ":");
    while (!toStack.isEmpty()) {
        System.out.print(toStack.pop() + " ");
    }
}

private static void moveDisk(Stack<Integer> from, Stack<Integer> to, String fromName, String toName) {
    if (!from.isEmpty()) {
        int disk = from.pop();
        to.push(disk);
        System.out.println("Переместить диск " + disk + " из " + fromName + " в " + toName);
    }
}

```

## 3. Реализовать рукерсивный подход указанного ниже итеративного метода подсчета количества согласных букв в слове:

```java
public static int countConsonantIteration(String str) {
   int count = 0;
   for (int i = 0; i < str.length(); i++) {
       if (isConsonant(str.charAt(i))) {
           count++;
       }
   }
   return count;
}
```
### Рекурсивный подход:

```java
public static int countConsonantRecursion(String str) {
    return countConsonant(str, str.length() - 1);
}


private static int countConsonant(String str, int index) {
    if (index < 0) {
        return 0;
    }
    int count = isConsonant(str.charAt(index)) ? 1 : 0;
    return count + countConsonantRecursionHelper(str, index - 1);
}

```
