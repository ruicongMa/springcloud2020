import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 统计文件数
 *
 * @author Mark
 * @date 2021/9/15 17:26
 */
public class Code02_CountFiles {

    /**
     * 给定一个文件目录的路径，
     * 写一个函数统计这个目录下所有的文件数量并返回
     * 隐藏文件也算，但是文件夹不算
     */

    // 栈实现：就是图的深度遍历
    public static int getFileNumber(String folderPath) {
        File root = new File(folderPath);
        if (!root.isDirectory() && !root.isFile()) {
            return 0;
        }
        if (root.isFile()) {
            return 1;
        }
        Stack<File> stack = new Stack<>();
        stack.push(root);
        int files = 0;
        while (!stack.isEmpty()) {
            File folder = stack.pop();
            for (File next : folder.listFiles()) {
                if (next.isFile()) {
                    files++;
                }
                if (next.isDirectory()) {
                    stack.push(next);
                }
            }
        }
        return files;
    }

    /**
     * 类似图的宽度遍历：队列实现
     */
    public static int getFileNumber2(String folderPath) {
        File root = new File(folderPath);
        if (!root.isDirectory() && !root.isFile()) {
            return 0;
        }
        if (root.isFile()) {
            return 1;
        }
        Queue<File> queue = new LinkedList<>();
        queue.offer(root);
        int files = 0;
        while (!queue.isEmpty()) {
            File folder = queue.poll();
            for (File next : folder.listFiles()) {
                if (next.isFile()) {
                    files++;
                }
                if (next.isDirectory()) {
                    queue.offer(next);
                }
            }
        }
        return files;
    }

    public static void main(String[] args) {
        // 你可以自己更改目录
        String path = "G:\\idea\\workspaces\\springcloud2020\\algorithm\\coding-for-great-offer\\src";
        System.out.println(getFileNumber(path) == getFileNumber2(path));
    }

}
