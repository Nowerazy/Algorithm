package action;

import java.util.Stack;

public class BinaryTree {
	private BinaryTree lchild;
	private BinaryTree rchild;
	private Object data;

	/**
	 * @param args
	 */
	public BinaryTree(BinaryTree l, BinaryTree r, Object data) {
		lchild = l;
		rchild = r;
		this.data = data;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree G = new BinaryTree(null, null, 'G');
		BinaryTree H = new BinaryTree(null, null, 'H');
		BinaryTree F = new BinaryTree(G, H, 'F');
		BinaryTree D = new BinaryTree(null, F, 'D');
		BinaryTree E = new BinaryTree(null, null, 'E');
		BinaryTree B = new BinaryTree(D, E, 'B');
		BinaryTree C = new BinaryTree(null, null, 'C');
		BinaryTree A = new BinaryTree(B, C, 'A');

		System.out.println("先序遍历。。。。。。。");
		pre(A);
		System.out.println();

		System.out.println("中序遍历。。。。。。。");
		in(A);
		System.out.println();

		System.out.println("后序遍历。。。。。。。");
		post(A);
		System.out.println();

		System.out.println("非递归先序遍历。。。。。。。");
		preTraverse(A);
		System.out.println();

		System.out.println("非递归中序遍历。。。。。。。");
		inTraverse(A);
		System.out.println();

		System.out.println("非递归后序遍历。。。。。。。");
		postTraverse(A);
		System.out.println();

		System.out.println("非递归后序遍历2。。。。。。。");
		postTraverse2(A);
		System.out.println();
	}

	public static void visit(BinaryTree bt) {
		System.out.print(bt.data + " ");
	}

	// 递归先序遍历
	public static void pre(BinaryTree root) {
		if (root == null)
			return;
		visit(root);
		if (root.lchild != null)
			pre(root.lchild);
		if (root.rchild != null)
			pre(root.rchild);
	}

	// 递归中序遍历
	public static void in(BinaryTree root) {
		if (root == null)
			return;
		if (root.lchild != null)
			in(root.lchild);
		visit(root);
		if (root.rchild != null)
			in(root.rchild);
	}

	// 递归后序遍历
	public static void post(BinaryTree root) {
		if (root == null)
			return;
		if (root.lchild != null)
			post(root.lchild);
		if (root.rchild != null)
			post(root.rchild);
		visit(root);
	}

	// 非递归先序遍历
	public static void preTraverse(BinaryTree root) {
		Stack s = new Stack();
		s.push(root);
		while (!s.isEmpty()) {
			BinaryTree bt = (BinaryTree) s.pop();
			visit(bt);
			if (bt.rchild != null)
				s.push(bt.rchild);
			if (bt.lchild != null)
				s.push(bt.lchild);
		}
	}

	// 非递归中序遍历
	public static void inTraverse(BinaryTree root) {
		Stack s = new Stack();
		BinaryTree p = root;
		while (p != null || !s.isEmpty()) {
			if (p != null) {
				s.push(p);
				p = p.lchild;
			} else {
				p = (BinaryTree) s.pop();
				visit(p);
				p = p.rchild;
			}
		}
	}

	// 非递归后序遍历
	public static void postTraverse(BinaryTree root) {
		Stack s = new Stack();
		BinaryTree p = root;
		// pre标记最近出栈的节点，用于判断是否是p节点的右孩子，如果是的话，就可以访问p节点
		BinaryTree pre = p;
		// flag标记是出栈还是继续将左孩子进栈
		boolean flag = true;
		while (p != null || !s.isEmpty()) {
			if (p != null && flag) {
				s.push(p);
				p = p.lchild;
			} else {
				if (s.isEmpty())
					return;
				p = (BinaryTree) s.peek();
				if (p.rchild != null && p.rchild != pre) {
					p = p.rchild;
					flag = true;
				} else {
					p = (BinaryTree) s.pop();
					visit(p);
					flag = false;
					pre = p;
				}
			}
		}
	}

	// 非递归后序遍历2
	public static void postTraverse2(BinaryTree root) {
		Stack s = new Stack();
		BinaryTree p = root;
		// pre标记最近出栈的节点，用于判断是否是p节点的右孩子，如果是的话，就可以访问p节点
		BinaryTree pre = p;
		while (p != null || !s.isEmpty()) {
			if (p != null) {
				s.push(p);
				p = p.lchild;
			} else {
				if (s.isEmpty())
					return;
				p = (BinaryTree) s.peek();
				if (p.rchild != null && p.rchild != pre) {
					p = p.rchild;
				} else {
					p = (BinaryTree) s.pop();
					visit(p);
					pre = p;
					p = null;
				}
			}
		}
	}
}
