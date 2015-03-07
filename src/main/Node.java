// Universidad ICESI
// Created by: Andres Felipe Ortiz - 10207000


package main;

/*
 * Class which represent a node.
 */
public class Node 
{
	/*
	 * Left node.
	 */
	private Node left;
	
	/*
	 * Right node.
	 */
	private Node right;
	
	/*
	 * Node's Object.
	 */
	private Object root;
	
	
	/*
	 * Builder Method
	 */
	public Node (Object root2)
	{
		root = root2;
		left = null;
		right = null;
	}
	
	
	/*
	 * Method which build the binary tree recursively
	 */
	public Node makeTree (Object[] preorder, Object[] inorder)
	{
		if(preorder.length > 0 && inorder.length > 0)
		{
			//For the base case
			if(preorder.length == 1 && inorder.length == 1)
			{
				//add the root of the binary three
				Node leaf = new Node(preorder[0]);
				System.out.println("Se creo la hoja:  " + (String)leaf.getObject());
				return leaf;
			}
			
			//For any other case
			else
			{
				//add the root of the binary three
				Object root2 = preorder[0];
				addRoot(root2);
				System.out.println("Se creo nodo raiz:  " + (String)root2);
				
				//Get positions and cut the array to the left binary tree------------------------------------
				int pos = getPos(inorder, root2);
				int pos2 = -1;
				if(pos > 0)
				{
					Object[] inorderLeft = cutArray(inorder, 0, pos-1);

					pos2 = getPos(preorder, inorderLeft[inorderLeft.length-1]);
					Object[] preorderLeft = cutArray(preorder, 1, pos2);
					
					//add the left node
					Node tempLeft = new Node(null);
					tempLeft = tempLeft.makeTree(preorderLeft, inorderLeft);
					addLeft(tempLeft);
					System.out.println("Se agrego:  " + (String)tempLeft.getObject() + "  a la izquierda del nodo: " + (String)root);
				}
				
				if(pos2 == -1)
					pos2 = pos;
				if(pos2 < preorder.length-1 && pos < inorder.length-1)
				{
					//Get positions and cut the array to the right binary tree------------------------------------
					Object[] inorderRight = cutArray(inorder, pos + 1, inorder.length-1);
					Object[] preorderRight = cutArray(preorder, pos2 + 1, preorder.length-1);
					
					//add the right node
					Node tempRight = new Node(null);
					tempRight = tempRight.makeTree(preorderRight, inorderRight);
					addRight(tempRight);
					System.out.println("Se agrego:  " + (String)tempRight.getObject() + "  a la derecha del nodo:  " + (String)root);
				}
				
				//Return the complete node
				System.out.println("Nodo con ramas retornado:  " + (String)getObject());
				return this;
			}
		}
		else
			return null;
	}
	
	
	
	/*
	 * Add the Object to the node.
	 */
	public void addRoot (Object root)
	{
		this.root = root;
	}
	
	/*
	 * Add the right node.
	 */
	public void addRight (Node right)
	{
		this.right = right;
	}
	
	/*
	 * Add the left node.
	 */
	public void addLeft (Node left)
	{
		this.left = left;
	}
	
	/*
	 * Method which cut an array of Objects from the position i to j.
	 */
	public Object[] cutArray (Object[] array, int i, int j)
	{
		Object[] obj = new Object[j+1-i];
		int index = 0;
		for(int k=i; k<=j; k++)
		{
			obj[index] = array[k];
			index++;
		}
		return obj;
	}
	
	
	/*
	 * Method which give the position of the Object o from an array of Objects.
	 */
	public int getPos (Object[] array, Object o)
	{
		for(int i=0; i<array.length; i++)
		{
			Object ob = array[i];
			if(ob != null && ob.equals(o))
				return i;
		}
		return -1;
	}
	
	
	
	//---------------Methods to test the binary tree ONLY----------------------------------------------
	
	// Universidad ICESI
	// Created by: Andres Felipe Ortiz - 10207000
	
	
	/*
	 * Method which return the POST-ORDER
	 */
	public String getPostorder ()
	{
		if(getLeft() == null && getRight() == null)
			return (String)getObject();
		else
		{
			String string = "";
			if(getLeft() != null)
				string += getLeft().getPostorder();
			if(getRight() != null)
				string += getRight().getPostorder();
			
			return string + (String)getObject();
		}
	}
	
	/*
	 * Method which return the Object in this node.
	 */
	public Object getObject ()
	{
		return root;
	}
	
	/*
	 * Method which return the left node.
	 */
	public Node getLeft ()
	{
		return left;
	}
	
	/*
	 * Method which return the right node.
	 */
	public Node getRight ()
	{
		return right;
	}
	
}
