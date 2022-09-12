package class07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * T一定要是非基础类型，有基础类型需求包一层
 *
 * @author Mark
 * @date 2022/2/17 11:15
 */
public class HeapGreater<T> {

    private ArrayList<T> heap;
    // a -> 0
    // b -> 1
    // c -> 2
    private HashMap<T, Integer> indexMap; // 反向索引表
    private int heapSize;
    private Comparator<? super T> comp;

    public HeapGreater(Comparator<T> c) {
        this.heap = new ArrayList<>();
        this.indexMap = new HashMap<>();
        this.heapSize = 0;
        this.comp = c;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public int size() {
        return heapSize;
    }

    public boolean contains(T obj) {
        return indexMap.containsKey(obj);
    }

    public T peek() {
        return heap.get(0);
    }

    public void push(T obj) {
        heap.add(obj);
        indexMap.put(obj, heapSize);
        heapInsert(heapSize++);
    }

    public T pop() {
        T ans = heap.get(0);
        swap(0, heapSize - 1);
        indexMap.remove(ans);
        heap.remove(--heapSize);
        heapify(0);
        return ans;
    }

    public void remove(T obj) {
        T replace = heap.get(heapSize - 1);
        int index = indexMap.get(obj);
        indexMap.remove(obj);
        heap.remove(--heapSize);
        if (obj != replace) {
            heap.set(index, replace);
            indexMap.put(replace, index);
            resign(replace);
        }
    }

    // heapInsert、heapify 只会执行一个
    public void resign(T obj) {
        heapInsert(indexMap.get(obj));
        heapify(indexMap.get(obj));
    }

    // 请返回堆上的所有元素
    public List<T> getAllElements() {
        List<T> ans = new ArrayList<>();
        for (T c : heap) {
            ans.add(c);
        }
        return ans;
    }

    // 默认小根堆，heapInsert 往上移，谁小往上移
    private void heapInsert(int index) {
        while (comp.compare(heap.get(index), heap.get((index - 1) / 2)) < 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 默认小根堆，heapify 往下沉，谁大往下沉
    private void heapify(int index) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int smallest = left + 1 < heapSize && comp.compare(heap.get(left + 1), heap.get(left)) < 0 ? (left + 1) : left;
            smallest = comp.compare(heap.get(smallest), heap.get(index)) < 0 ? smallest : index;
            if (smallest == index) {
                break;
            }
            swap(smallest, index);
            index = smallest;
            left = 2 * index + 1;
        }
    }

    private void swap(int i, int j) {
        T o1 = heap.get(i);
        T o2 = heap.get(j);
        heap.set(i, o2);
        heap.set(j, o1);
        indexMap.put(o2, i);
        indexMap.put(o1, j);
    }

    public static void main(String[] args) {
        HeapGreater<Student> heap = new HeapGreater<>(Comparator.comparingInt(s -> s.age));
        Student s1 = new Student("张三", 20);
        Student s2 = new Student("李四", 30);
        Student s3 = new Student("王五", 18);
        heap.push(s1);
        heap.push(s2);
        heap.push(s3);
        System.out.println("此时堆顶与元素：" + heap.peek().age);
        while (!heap.isEmpty()) {
            Student stu = heap.pop();
            System.out.println(stu.name + "," + stu.age);
        }
        System.out.println("======================");
        s1 = new Student("张三", 20);
        s2 = new Student("李四", 30);
        s3 = new Student("王五", 18);
        heap.push(s1);
        heap.push(s2);
        heap.push(s3);
        heap.remove(s2);
        System.out.println("此时堆顶与元素：" + heap.peek().age);
        while (!heap.isEmpty()) {
            Student stu = heap.pop();
            System.out.println(stu.name + "," + stu.age);
        }
    }

    public static class Student {
        String name;
        int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
