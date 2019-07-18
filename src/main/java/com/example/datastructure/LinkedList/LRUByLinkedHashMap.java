package com.example.datastructure.LinkedList;

/**
 * Demo class
 * 单链表简单实现LRU缓存淘汰算法
 *
 * @author drose
 * @date 2019/5/22 23:03
 */
public class LRUByLinkedHashMap<T> {

    //链表的默认容量
    private final static Integer DEFAULT_CAPACITY = 10;
    //链表的头节点
    private LNode<T> headNode;
    //链表容量
    private int capacity;
    //链表长度
    private int length;

    public LRUByLinkedHashMap() {
        //初始化时，头结点默认下个指向为空，因此使用这个构造方法
        this.headNode = new LNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUByLinkedHashMap(int capacity) {
        //初始化时，头结点默认下个指向为空，因此使用这个构造方法
        this.headNode = new LNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    //插入操作
    public boolean add(T data) {

        LNode<T> preNode = getPreNode(data);

        //第一种情况，如果元素存在，则删除该元素，并将其添加到头部
        if (preNode != null) {
            deleteOne(preNode);
            insertHead(data);
        } else {
            if (length >= capacity) {
                //第三种情况，如果元素不存在，并且容器容量已经满了，则删除最末尾一个，再添加到头部
                //删除末尾
                deleteTail();
            }
            //第二种情况，如果元素不存在，并且容器容量还没满，则直接添加在头部
            insertHead(data);
        }
        return true;
    }

    //插入头部操作
    public boolean insertHead(T data) {
        LNode next = headNode.getNext();
        //头结点重新指向该元素，该元素封装data数据并且指向头结点一开始指向的节点
        headNode.setNext(new LNode(data, next));
        length++;
        return true;
    }

    //删除下一个操作
    public boolean deleteOne(LNode preNode) {
        LNode next = preNode.getNext();
        preNode.setNext(next.getNext());
        next = null;
        length--;
        return true;
    }

    //删除末尾
    public boolean deleteTail() {
        LNode next = headNode;
        if (next.getNext() == null) {
            return false;
        }

        //倒数第二个
        while (next.getNext().getNext() != null) {
            next = next.getNext();
        }
        next.setNext(null);
        length--;
        return false;
    }

    //获取上一个节点
    public LNode<T> getPreNode(T data) {
        LNode node = headNode;
        while (node.getNext() != null) {
            //从头遍历，只要入参的data与下一个的data相同，则说明找到了
            if (data.equals(node.getNext().getData())) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    //查找单个,必须从头遍历
    public LNode<T> getOne(T data) {
        LNode node = headNode;
        while (node.getNext() != null) {
            if (data.equals(node.getData())) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    //查找全部
    public void getAll() {
        LNode next = headNode.getNext();
        while (next != null) {
            System.out.print(next.getData() + ",");
            next = next.getNext();
        }
        System.out.println(" ");
    }

    //内部类，即节点类，包含数据和指向下个节点的地址
    class LNode<T> {

        //存放该节点的数据
        private T data;
        //指向下一个节点
        private LNode next;

        public LNode() {
            this.next = null;
        }

        public LNode(T data) {
            this.data = data;
        }

        public LNode(T data, LNode next) {
            this.data = data;
            this.next = next;
        }

        public LNode getNext() {
            return next;
        }

        public void setNext(LNode next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}
