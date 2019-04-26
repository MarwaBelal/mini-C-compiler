package minicompiler;

public class node {
    int value;
    node left;
    node right;
    
    node(int value){
        this.value = value;
        right = null;
        left = null;
        
    }
    
    public void print(node n){
        if(n != null){
            print(n.left);
            System.out.println("" + n.value);
            print(n.right);
        }
    }
    
}
