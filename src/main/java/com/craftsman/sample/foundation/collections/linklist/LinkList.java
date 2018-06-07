package com.craftsman.sample.foundation.collections.linklist;


import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author chenfanglin 【chenfanglincfl@163.com】
 * @description node
 * @Date 2017/2/2421:29
 */
@Data
@NoArgsConstructor
public class LinkList<E> {

  public class Node<E>{
      E data;
      Node<E> next;
      public Node(E data,Node<E> next){
          this.data=data;
          this.next=next;
      }
  }
    private Node<E> head;
    private Node<E> tail;
    private int size=0;
    private Node<E> middle;

    public boolean isEmpty(){
        return size==0 || head==null;
    }

    public void add(E data){
        Node<E> d =new Node<>(data,null);
        if(isEmpty()){
            head=d;
            tail=head;
        }else{
            tail.next=d;
            tail=d;
            d.next=null;
        }
    }

    public boolean delete(E data){
        Node<E> d=new Node<>(data,null);
       if(isEmpty()){
           throw new NullPointerException("list is null");
       }
       for (int i=0;i<size;i++){
            return false;
       }
       return false;
    }
}
