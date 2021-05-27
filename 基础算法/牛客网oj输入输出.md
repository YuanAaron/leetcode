## 题目1: A+B(1)

计算a+b

**输入描述:**
```
输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据包括多组。
```

**输出描述:**
```
输出a+b的结果
```

**示例1**

输入
```
1 5
10 20
```

输出
```
6
30
```

### 题解1

```java
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] s = line.split(" ");
            int a=Integer.parseInt(s[0]);
            int b=Integer.parseInt(s[1]);
            System.out.println(sum(a,b));
        }
    }
    
    public static int sum(int a,int b) {
        return a+b;
    }
}
```

### 题解2

```java
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line=null;
        while ((line=br.readLine())!=null) {
            String[] s = line.split(" ");
            int a=Integer.parseInt(s[0]);
            int b=Integer.parseInt(s[1]);
            System.out.println(sum(a,b));
        }
    }

    public static int sum(int a,int b) {
        return a+b;
    }
}
```

## 题目2: A+B(2)

计算a+b

**输入描述:**
```
输入第一行包括一个数据组数t(1<=t<=100)
接下来每行包括两个正整数a,b(1 <= a, b <= 10^9)
```

**输出描述:**
```
输出a+b的结果
```

**示例1**

输入
```
2
1 5
10 20
```

输出
```
6
30
```

### 题解1

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int cnt = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < cnt; i++) {
            String line = scanner.nextLine();
            String[] s = line.split(" ");
            int a=Integer.parseInt(s[0]);
            int b=Integer.parseInt(s[1]);
            System.out.println(sum(a,b));

        }
    }

    public static int sum(int a,int b) {
        return a+b;
    }
}
```

### 题解2

```java
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int cnt=Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            String[] s = br.readLine().split(" ");
            int a=Integer.parseInt(s[0]);
            int b=Integer.parseInt(s[1]);
            System.out.println(sum(a,b));
        }
    }

    public static int sum(int a,int b) {
        return a+b;
    }
}
```

## 题目3: A+B(3)

计算a+b

**输入描述:**
```
输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据有多组，如果输入0 0，则结束输入
```

**输出描述:**
```
输出a+b的结果
```

**示例1**

输入
```
1 5
10 20
0 0
```

输出
```
6
30
```

### 题解1

```java
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if ("0 0".equals(line))
                break;
            String[] s = line.split(" ");
            int a=Integer.parseInt(s[0]);
            int b=Integer.parseInt(s[1]);
            System.out.println(sum(a,b));
        }
    }

    public static int sum(int a,int b) {
        return a+b;
    }
}
```

### 题解2

```java
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line=null;
        while ((line=br.readLine())!=null && !line.equals("0 0")) {
            String[] s = line.split(" ");
            int a=Integer.parseInt(s[0]);
            int b=Integer.parseInt(s[1]);
            System.out.println(sum(a,b));
        }
    }

    public static int sum(int a,int b) {
        return a+b;
    }
}
```

## 题目4: A+B(4)

计算一系列数的和

**输入描述:**
```
输入数据包括多组。
每组数据一行，每行的第一个整数为该行的整数个数n(1 <= n <= 100)，n为0的时候结束输入。
接下来的n个正整数即为需要求和的每个正整数。
```

**输出描述:**
```
每组数据输出求和的结果
```

**示例1**

输入
```
4 1 2 3 4
5 1 2 3 4 5
0
```

输出
```
10
15
```

### 题解1

```java
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if ("0".equals(line))
                break;
            String[] s = line.split(" ");
            int cnt=Integer.parseInt(s[0]);
            int res=0;
            for (int i = 1; i <= cnt; i++) {
                res+=Integer.parseInt(s[i]);
            }
            System.out.println(res);
        }
    }
}
```


### 题解2

```java
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line=null;
        while ((line=br.readLine())!=null && !line.equals("0")) {
            String[] s = line.split(" ");
            int cnt=Integer.parseInt(s[0]);
            int res=0;
            for (int i = 1; i <= cnt; i++) {
                res+=Integer.parseInt(s[i]);
            }
            System.out.println(res);
        }
    }
}
```

## 题目5: A+B(5)

计算一系列数的和

**输入描述:**
```
输入的第一行包括一个正整数t(1<=t<=100)，表示数据组数。
接下来t行，每行一组数据。
每行的第一个整数为该行的整数个数n(1 <= n <= 100)
接下来的n个正整数即为需要求和的每个正整数。
```

**输出描述:**
```
每组数据输出求和的结果
```

**示例1**

输入
```
2
4 1 2 3 4
5 1 2 3 4 5
```

输出
```
10
15
```

### 题解1

```java
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < lines; i++) {
            String[] s = scanner.nextLine().split(" ");
            int cnt=Integer.parseInt(s[0]);
            int res=0;
            for (int j = 1; j <= cnt; j++) {
                res+=Integer.parseInt(s[j]);
            }
            System.out.println(res);
        }
    }
}
```

### 题解2

```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(br.readLine());
        for (int i = 0; i < lines; i++) {
            String[] s = br.readLine().split(" ");
            int cnt=Integer.parseInt(s[0]);
            int res=0;
            for (int j = 1; j <= cnt; j++) {
                res+=Integer.parseInt(s[j]);
            }
            System.out.println(res);
        }
    }
}
```

## 题目6: A+B(6)

计算一系列数的和

**输入描述:**
```
输入数据包括多组，每行表示一组输入数据。
每行的第一个整数为该行的整数个数n(1 <= n <= 100)。
接下来的n个正整数即为需要求和的每个正整数。
```

**输出描述:**
```
每组数据输出求和的结果
```

**示例1**

输入
```
4 1 2 3 4
5 1 2 3 4 5
```

输出
```
10
15
```

### 题解1

```java
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] s = scanner.nextLine().split(" ");
            int res=0;
            for (int j = 1; j < s.length; j++) {
                res+=Integer.parseInt(s[j]);
            }
            System.out.println(res);
        }
    }
}
```

### 题解2

```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line=null;
        while ((line=br.readLine())!=null) {
            String[] s = line.split(" ");
            int res=0;
            for (int j = 1; j < s.length; j++) {
                res+=Integer.parseInt(s[j]);
            }
            System.out.println(res);
        }
    }
}
```

## 题目7: A+B(7)

计算一系列数的和

**输入描述:**
```
输入数据包括多组，每行表示一组输入数据。
每行不定有n个整数，空格隔开。(1 <= n <= 100)
```

**输出描述:**
```
每组数据输出求和的结果
```

**示例1**

输入
```
1 2 3
4 5
0 0 0 0 0
```

输出
```
6
9
0
```

### 题解1

```java
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] s = scanner.nextLine().split(" ");
            int res=0;
            for (int j = 0; j < s.length; j++) {
                res+=Integer.parseInt(s[j]);
            }
            System.out.println(res);
        }
    }
}
```

### 题解2

```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line=null;
        while ((line=br.readLine())!=null) {
            String[] s = line.split(" ");
            int res=0;
            for (int j = 0; j < s.length; j++) {
                res+=Integer.parseInt(s[j]);
            }
            System.out.println(res);
        }
    }
}
```

## 题目8: 字符串排序(1)

对输入的字符串进行排序后输出

**输入描述:**
```
输入有两行，第一行n
第二行是空格隔开的n个字符串
```

**输出描述:**
```
输出一行排序后的字符串，空格隔开，无结尾空格
```

**示例1**

输入
```
5
c d a bb e
```

输出
```
a bb c d e
```

### 题解1

```java
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int cnt = Integer.parseInt(scanner.nextLine());
        String[] s = scanner.nextLine().split(" ");
        Arrays.sort(s);
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<cnt-1;i++) {
            sb.append(s[i]).append(" ");
        }
        System.out.println(sb.append(s[cnt-1]).toString());
    }
}
```

### 题解2

```java
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        Arrays.sort(s);
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<cnt-1;i++) {
            sb.append(s[i]).append(" ");
        }
        System.out.println(sb.append(s[cnt-1]).toString());
    }
}
```

## 题目9: 字符串排序(2)

对输入的字符串进行排序后输出

**输入描述:**
```
多个测试用例，每个测试用例一行。
每行通过空格隔开，有n个字符，n<100
```

**输出描述:**
```
对于每组测试用例，输出一行排序后的字符串，每个字符串通过空格隔开
```

**示例1**

输入
```
a c bb
f dddd
nowcoder
```

输出
```
a bb c
dddd f
nowcoder
```

### 题解1

```java
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] s = scanner.nextLine().split(" ");
            Arrays.sort(s);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length - 1; i++) {
                sb.append(s[i]).append(" ");
            }
            System.out.println(sb.append(s[s.length - 1]).toString());
        }
    }
}
```


### 题解2

```java
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line=null;
        while ((line=br.readLine())!=null) {
            String[] s = line.split(" ");
            Arrays.sort(s);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length-1; i++) {
                sb.append(s[i]).append(" ");
            }
            System.out.println(sb.append(s[s.length-1]).toString());
        }
    }
}
```

## 题目10: 字符串排序(3)

对输入的字符串进行排序后输出

**输入描述:**
```
多个测试用例，每个测试用例一行。
每行通过,隔开，有n个字符，n<100
```

**输出描述:**
```
对于每组测试用例，输出一行排序后的字符串，用,隔开，无结尾空格
```

**示例1**

输入
```
a c bb
f dddd
nowcoder
```

输出
```
a bb c
dddd f
nowcoder
```

### 题解

```java
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line=null;
        while ((line=br.readLine())!=null) {
            String[] s = line.split(",");
            Arrays.sort(s);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length-1; i++) {
                sb.append(s[i]).append(",");
            }
            System.out.println(sb.append(s[s.length-1]).toString());
        }
    }
}
```
