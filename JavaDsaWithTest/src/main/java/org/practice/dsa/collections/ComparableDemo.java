package org.practice.dsa.collections;

public class ComparableDemo implements Comparable<ComparableDemo> {
    private int id;
    private String name;

    public ComparableDemo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(ComparableDemo o) {
//        if (this.id > o.id) {
//            return 1;
//        }
//        if (this.id < o.id) {
//            return -1;
//        }
//        return 0;

        return Integer.compare(this.id, o.id);
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}
