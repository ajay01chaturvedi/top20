package com.alg.top20.bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Result1 {
	TreeNode node;
	int ls_size;
	public Result1(TreeNode node, int ls_size) {
		super();
		this.node= node;
		this.ls_size = ls_size;
	}

}
public class BSTUtils {

	public static TreeNode createBalancedBST(int n) {
		return auxBBST(1, n).node;
	}
	private static int get_lsize(TreeNode root) {
		return root == null?0:root.ls_size;
	}
	//fix the bug: ls_size field
	private static Result1 auxBBST(int l, int r) {
		if(l > r) return null;
		int m = l + (r-l)/2;
		TreeNode tmp = new TreeNode(m);
		Result1 left = auxBBST(l, m-1);
		if(left != null) {
			tmp.left = left.node;
			tmp.ls_size = left.ls_size;
		} else {
			tmp.left = null;
		}
		Result1 right = auxBBST(m+1, r);
		tmp.right = right!=null?right.node:null;
		return new Result1(tmp, get_lsize(tmp.left)+get_lsize(tmp.right)+1);
	}
	
	public static TreeNode createOneSidedBST(int n) {
		return null;
	}
	
	private static TreeNode add(TreeNode root, int data) {
		if(root == null) return new TreeNode(data);
		if(data == root.data) return root;
		else if(data < root.data) {
			++root.ls_size;
			root.left = add(root.left, data);
		}
		else
			root.right = add(root.right, data);
		return root;		
	}
	public static TreeNode createRandomBST(int n) {
		TreeNode root = null;
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= n; ++i)
			list.add(i);
		Collections.shuffle(list);
		//System.out.println(list);
		for(Integer x: list)
			root = add(root, x);	
		return root;
	}
	
	public static void displayTree(TreeNode root) {
		auxDisplay(root, 0, "Root");
	}
	private static void auxDisplay(TreeNode root, int nspaces, String type) {
		if (root == null)
			return;
		for (int i = 0; i < nspaces; ++i)
			System.out.print(' ');
		System.out.println(root.data + "(" + type + "," + root.ls_size + ")");
		auxDisplay(root.left, nspaces + 4, "L");
		auxDisplay(root.right, nspaces + 4, "R");
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = createRandomBST(n);
		displayTree(root);
	}

}
