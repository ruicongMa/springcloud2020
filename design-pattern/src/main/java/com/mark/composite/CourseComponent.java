package com.mark.composite;

/**
 * @author Mark
 * @date 2020/5/9 19:46
 */
public abstract class CourseComponent {

    public void addChild(CourseComponent catalogComponent) {
        throw new UnsupportedOperationException("不支持添加操作");
    }

  public void removeChild(CourseComponent catalogComponent) {
      throw new UnsupportedOperationException("不支持删除操作");
  }

    public String getName(CourseComponent catalogComponent) {
        throw new UnsupportedOperationException("不支持获取名称操作");
    }

    public double getPrice(CourseComponent catalogComponent) {
        throw new UnsupportedOperationException("不支持获取价格操作");
    }

    public void print() {
        throw new UnsupportedOperationException("不支持打印操作");
    }
}
