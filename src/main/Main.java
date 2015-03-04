// Universidad ICESI
// Created by: Andres Felipe Ortiz - 10207000


package main;

public class Main 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		String[] preorder = {"a", "b", "d", "e", "c", "f", "g"};
		String[] inorder =  {"d", "b", "e", "a", "f", "c", "g"};
		
		System.out.println("Created by Andres Felipe Ortiz - 10207000");
		System.out.println("Universidad ICESI \n");
		System.out.println("BUILDING A BINARY TREE RECURSIVELY WITH ANY ARRAY OF OBJECTS \n");
		System.out.println("Pre-order: abdecfg");
		System.out.println("In-order:  dbeafcg \n\n");
		System.out.println("Process... \n");
		
		if(preorder != null && preorder.length > 0)
		{
			Node root = new Node(null);
			root = root.makeTree(preorder, inorder);
			System.out.println("\nBINARY TREE CREATED");
			System.out.println("Logic proof to make sure the binary tree is correct");
			System.out.println("Post-order:  " + root.getPostorder() + "\n");			
			System.out.println("Created by Andres Felipe Ortiz - 10207000");
			System.out.println("Universidad ICESI \n");

		}
		else
			System.out.println("Do not exit any node");
	}

}
