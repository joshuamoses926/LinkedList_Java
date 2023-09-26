class List { 
    Node head; // head node of list 
    class Node 
    { 
        int count;// count frequent of word
        String word;// word data
        String line;// line numbers of word separated by comma and space
        Node next; 
        // Constructor 
        public Node(String w,int c,String l) 
        { 
            word=w;
            count=c;
            line=l; 
        } 
    } 
 // function to add new node in List
    public List add(List list,String word,String line) 
    { 
        Node t=list.head;
        int c=1;
        // traverse list
        while(t!=null){
            if(t.word.toLowerCase().equals(word.toLowerCase()))
            {// if word already present with same name
                c++;
                break;
            }
            t=t.next;
        }
        // create a new node if word is not already present in List
        if(c==1)
        {
            Node node=new Node(word,1,line); 
            node.next=null;
             
            // list is empty so point head to new node 
            if (list.head==null) 
            { 
                list.head=node; 
            } 
            else 
            { 
                // traverse to last and insert node there
                Node last=list.head; 
                while(last.next!=null) 
                { 
                    last=last.next; 
                } 
                last.next=node; 
            } 
        }
        else
        {// if words is present in list
            t.count+=1;// increase count
            String m[]=t.line.split(",");
            int flag=0;
            // add line number to string line but make sure not add duplicate line number
            for(int i=0;i<m.length;i++)
            {
                if(m[i].equals(line))
                {
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {// line number is not already present
                t.line+=", "+line;
            }
        }
        return list; 
    } 
    
    // function to sort the linked list
    public void sort(List list)
    {
        Node curr=list.head;
        int c=0;
        // count the total nodes in list
        while(curr!=null)
        {
            c++;
            curr=curr.next;
        }
        curr=list.head;
        // using bubble sort algorithm, swap the node's data to sort the list
        for(int i=0;i<=c;i++)
        {
            curr=list.head;
            for(int j=0;j<c-i-1;j++)
            {
                Node t=curr;
                Node t1=t.next;
                
                if(t.word.toLowerCase().compareTo(t1.word.toLowerCase())>1)
                {
                    String tt=t.word;
                    t.word=t1.word;
                    t1.word=tt;
                    
                    int cc=t.count;
                    t.count=t1.count;
                    t1.count=cc;
                    
                    String ll=t.line;
                    t.line=t1.line;
                    t1.line=ll;
                }
                curr=curr.next;
            }
        }
    }
    // function to print contents of linked list 
    public void display(List list) 
    { 
        Node curr=list.head; 
        int unique=0,c=0;
        // traverse the linked list
        while(curr!=null) 
        { 
            // print data of node
            if(curr.word.length()>9)
                System.out.println(curr.word+"\t"+curr.count+" "+curr.line);
            else
                System.out.println(curr.word+"\t\t"+curr.count+" "+curr.line);
            c+=curr.count;
            // move to next node
            curr=curr.next;
            unique++;
        } 
        System.out.println("Total unique words: "+unique);
        System.out.println("Total number of words: "+c);
    } 
}