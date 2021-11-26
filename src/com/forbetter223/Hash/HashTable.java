package com.forbetter223.Hash;

/**
 * 用数组+链表实现哈希查找
 */
public class HashTable {
    private PersonLink[] personLinks;
    private int size;

    public static void main(String[] args) {
        HashTable ht = new HashTable(7);
        ht.add(new Person(1,"张一"));
        ht.add(new Person(9,"张二"));
        ht.add(new Person(21,"张三"));
        ht.print();
        ht.find(22);
        ht.delete(new Person(1,"张一"));
        ht.print();
    }

    public HashTable(int pSize) {
        this.size = pSize;
        this.personLinks = new PersonLink[size];
        for (int i = 0; i < size; i++) {
            personLinks[i] = new PersonLink(size);
        }
    }

    public void add(Person node) {
        int index = hashFunction(node.ID);
        personLinks[index].add(node);
    }

    /**
     * 散列函数
     * 用取模的方法判断当前节点应该放到数组的哪个位置。
     * @param ID
     * @return
     */
    public int hashFunction(int ID) {
        return ID % size;
    }

    public void print(){
        for (int i = 0; i < size; i++) {
            personLinks[i].print(i + 1);
        }
    }

    public void find(int id){
        System.out.printf("该值位于链表 %d : ",hashFunction(id) + 1);
        personLinks[hashFunction(id)].find(id);
    }

    public void delete(Person node){
        personLinks[hashFunction(node.ID)].delete(node);
    }
}
