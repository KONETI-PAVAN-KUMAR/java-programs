//Node definition
class Node{
    int val;
    Node left,right;
    Node(int val){
        this.val=val;
        left=right=null;
    }
}
//Binary tree definition
public class BinaryTree{
    Node root;
    //Insert nodes manually(not BST insert)
    void buildSampleTree(){
        root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
    }
    //Inorder traversal(left,root,right)
    void inorder(Node node){
        if(node != null){
            inorder(node.left);
            System.out.print(node.val+"");
            inorder(node.right);
            }
        }
    //preorder traversal(root,left,right)
        void preorder(Node node){
            if(node != null){
                System.out.print(node.val+"");
                preorder(node.left);
                preorder(node.right);
            }
        }
        //postorder traversal(left,right,root)
        void postorder(Node node){
            if(node != null){
              postorder(node.left);
              postorder(node.right);
              System.out.print(node.val+"");
            }
        }
        //Level order traversal(BFS)
        void levelOrder(){
            if(root==null) return;
            java.util.Queue<Node>queue=new java.util.LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                Node current=queue.poll();
                System.out.print(current.val+"");
                if(current.left!=null)
                queue.add(current.left);
                if(current.right!=null)
                queue.add(current.right);
            }
        }
        //Drive code
        public static void main(String[] args){
            BinaryTree tree=new BinaryTree();
            tree.buildSampleTree();
            System.out.println("Inorder Traversal");
            tree.inorder(tree.root);
            System.out.println("\npreorder Traversal");
            tree.preorder(tree.root);
            System.out.println("\npostorder Traversal");
            tree.postorder(tree.root);
            System.out.println("\nLevelorder Traversal");
            tree.levelOrder();
        }
}
