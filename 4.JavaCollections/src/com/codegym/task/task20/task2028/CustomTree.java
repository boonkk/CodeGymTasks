package com.codegym.task.task20.task2028;

import java.io.Serializable;
import java.util.*;


/* 
Build a tree (part 1)

*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;

    public CustomTree() {
        this.root = new Entry<String>("root");
    }

    @Override
    public boolean add(String s) {
        Queue<Entry<String>> queue = new LinkedList<>();
        boolean flag = false;
        queue.add(root);

        List<Entry<String>> temp = new ArrayList<>();


        while (!queue.isEmpty()) {
            Entry<String> currentNode = queue.poll();
            currentNode.checkChildren();
            if (currentNode.isAvailableToAddChildren()) {
                if (currentNode.availableToAddLeftChildren){
                    currentNode.leftChild = new Entry<>(s);
                    currentNode.leftChild.parent = currentNode;
                    return true;
                }
                else if (currentNode.availableToAddRightChildren) {
                    currentNode.rightChild = new Entry<>(s);
                    currentNode.rightChild.parent = currentNode;
                    return true;
                }
            }
            else {
                if (currentNode.leftChild != null){
                    queue.offer(currentNode.leftChild);
                }
                if (currentNode.rightChild != null){
                    queue.offer(currentNode.rightChild);
                }

                if(currentNode.leftChild == null && currentNode.rightChild == null) {
                    flag = true;
                    temp.add(currentNode);

                }
            }
        }
        if(flag) {
            temp.get(0).leftChild = new Entry<>(s);
            temp.get(0).leftChild.parent = temp.get(0);
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);

        int count = -1;

        while (!queue.isEmpty()) {
            Entry<String> tempNode = queue.poll();
            count++;

            if (tempNode.leftChild != null) queue.add(tempNode.leftChild);
            if (tempNode.rightChild != null) queue.add(tempNode.rightChild);
        }

        return count;
    }

    public String getParent(String s) {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Entry<String> tempNode = queue.poll();
            if (tempNode.elementName.equals(s)) return tempNode.parent.elementName;

            if (tempNode.leftChild != null) queue.add(tempNode.leftChild);
            if (tempNode.rightChild != null) queue.add(tempNode.rightChild);
        }

        return null;
    }

    @Override
    public boolean remove(Object o) throws UnsupportedOperationException{
        if(!(o instanceof String)){
            throw new UnsupportedOperationException();
        }
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> currentNode = queue.poll();
            if (currentNode.leftChild != null) {
                if (currentNode.leftChild.elementName.equals(o)){
                    currentNode.leftChild.parent.availableToAddLeftChildren = false;
                    currentNode.leftChild = null;
                    return true;
                }
                queue.offer(currentNode.leftChild);
            }
            if (currentNode.rightChild != null) {
                if (currentNode.rightChild.elementName.equals(o)){
                    currentNode.rightChild.parent.availableToAddRightChildren = false;
                    currentNode.rightChild = null;
                    return true;
                }
                queue.offer(currentNode.rightChild);
            }
        }
        return false;
    }

    public void printTree() {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Entry<String> tempNode = queue.poll();
            System.out.println(tempNode.elementName);

            if (tempNode.leftChild != null)
                queue.add(tempNode.leftChild);
            if (tempNode.rightChild != null)
                queue.add(tempNode.rightChild);
        }
    }

    @Override
    public String get(int index) {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        int iter = 0;

        while (!queue.isEmpty()) {
            Entry<String> tempNode = queue.poll();
            if (iter==index)
                return tempNode.elementName;
            if (tempNode.leftChild != null)
                queue.add(tempNode.leftChild);
            if (tempNode.rightChild != null)
                queue.add(tempNode.rightChild);
            iter++;
        }

        return null;
    }

    @Override
    public String set(int index, String element) {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        int iter = 0;

        while (!queue.isEmpty()) {
            Entry<String> tempNode = queue.poll();
            if (iter==index) {
                tempNode.elementName=element;
                return tempNode.elementName;
            }
            if (tempNode.leftChild != null)
                queue.add(tempNode.leftChild);
            if (tempNode.rightChild != null)
                queue.add(tempNode.rightChild);
            iter++;
        }

        return null;
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        void checkChildren() {
            if (leftChild != null) {
                availableToAddLeftChildren = false;
            }
            if (rightChild != null) {
                availableToAddRightChildren = false;
            }
        }


    }
}
