/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> copy = new HashMap<>();
        Node curr = head;
        while(curr != null){
            Node newNode = new Node(curr.val);
            copy.put(curr, newNode);
            curr = curr.next;
        }

        Node copyhead = head;

        while(copyhead != null){
            Node newNode = copy.get(copyhead);
            newNode.next = copy.get(copyhead.next);
            newNode.random = copy.get(copyhead.random);
            copyhead = copyhead.next;
        }

        return copy.get(head);

    }
}
