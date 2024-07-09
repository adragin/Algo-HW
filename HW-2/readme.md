
## Реализовать на java и просчитать временную сложность задач:

### task #1

```
START
READ number n
IF n == 1 THEN return
FOR i = 1, i <= n, i + 1
    FOR j = 1; j <= n, j + 1
        print "*"
        BREAK
END
```

```java
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner();
        int n = scanner.nextInt();
        if (n == 1) {    // 1
            return;
        }
        for (int i = 1; i <= n; i++) {      //  1+2n
            for (int j = 1; j <= n; j++) {  
                System.out.print("*");  
                break;                      // из-за break цикл выполнится только 1 раз для каждого i
            }
        }
    }
}     // Итого: 1+2n = O(n)
```

### task #2

```
START
READ number n
numbers i = 0, j = 0, a = 0
FOR i = n/2, i <= n; i + 1
    FOR j = 2, j <= n, j * 2
        a = a + n / 2
END
```

```java
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner();
        int n = scanner.nextInt();
        int a = 0;
        for (int i = n / 2; i <= n; i++) {     // выполняется n/2 раз
            for (int j = 2; j <= n; j *= 2) {  // выполняется log(n) раз
                a = a + n / 2;
            }
        }
    }
}        // Итог:  n/2 * log(n) = O(n Log(n))
```

### task #3

```
START
READ number n
number a = 0
FOR i = 0, i < n, i + 1
    FOR j = n, j > i, j - 1
        a = a + i + j
END
```

```java
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner();
        int n = scanner.nextInt();
        int a = 0;
        for (int i = 0; i < n; i++) {      // выполняется 1+2n раз.
            for (int j = n; j > i; j--) {  // выполняется (n-1) раз.
                a = a + i + j;
            }
        }
    }
}       // Итог:  (1+2n) * (n-1) = O(n^2)
```

### task #4

```
START
READ number n
numbers a = 0, i = n
WHILE i > 0
    a = a + i
    i = i / 2
END
```

```java
public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner();
        int n = scanner.nextInt();
        int a = 0;        // 1
        int i = n;        // 1
        while (i > 0) {   // 1
            a = a + i;    // 1
            i = i / 2;    // log(n)
        }
    }
}     // Итог:  log(n)

```