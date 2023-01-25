class SLLNODE {
    constructor(val){
        this.value= val;
        this.next = null;
    }
}


class SLL {
    // constructor, other methods, removed for brevity
    constructor() {
        this.head =null;
    }
    addFront(value){
        var newNode = new SLLNode(value);
        newNode.next = this.head;
        this.head = newNode;
        return this.head;
    }

    removeFront(){
        if (this.head==null){
            return this.head;
        }
        var removedNode = this.head;
        this.head = removedNode.next;
        removedNode.next = null;
        return this.head;
    }

    front(){
        if(this.head == null){
            return null;
        } else {
            return this.head.value;
        }
    }



}

var mySLL = new SLL();
console.log(mySLL.front());
mySLL.addFront(10);
mySLL.addFront(5);
console.log(mySLL.front());
mySLL.addFront(3);
console.log(mySLL);
mySLL.removeFront();
console.log(mySLL);