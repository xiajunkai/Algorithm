public class BinaryTree {

    // 所有递归操作均存在回溯，即递归当前节点无法继续进行时，返回上一层重新进行递归操作

    // 前序遍历
    // 根 > 左 > 右
    public void preOrderTraverse(TreeNode root) {
        if (root != null) {
            // 输出父节点
            System.out.println(root);
            if (root.getLeft() != null) {
                preOrderTraverse(root.getLeft());
            }
            if (root.getRight() != null) {
                preOrderTraverse(root.getRight());
            }
        } else {
            System.out.println("二叉树为空，无法遍历！");
        }
    }

    // 中序遍历
    // 左 > 根 > 右
    public void inOrderTraverse(TreeNode root) {
        if ((root != null)) {
            if (root.getLeft() != null) {
                inOrderTraverse(root.getLeft());
            }
            // 输出
            System.out.println(root);
            if (root.getRight() != null) {
                inOrderTraverse(root.getRight());
            }
        } else {
            System.out.println("二叉树为空，无法遍历！");
        }
    }

    // 后序遍历
    // 左 > 右 > 根
    public void postOrderTraverse(TreeNode root) {
        if ((root != null)) {
            if (root.getLeft() != null) {
                inOrderTraverse(root.getLeft());
            }
            if (root.getRight() != null) {
                inOrderTraverse(root.getRight());
            }
            // 输出
            System.out.println(root);
        } else {
            System.out.println("二叉树为空，无法遍历！");
        }
    }

    // 前序查找
    // 找到返回节点，没找到返回no
    public TreeNode preOrderSearch(TreeNode root, int no) {
        // 根节点
        if (root.getNo() == no) {
            return root;
        }
        TreeNode result = null;
        // 左子树遍历
        if (root.getLeft() != null) {
            result = preOrderSearch(root.getLeft(), no);
        }
        // 理解一下此处的判断
        if (result != null) {
            return result;
        }
        // 右子树遍历
        if (root.getRight() != null) {
            result = preOrderSearch(root.getRight(), no);
        }
        return result;
    }

    // 中序遍历查找
    public TreeNode inOrderSearch(TreeNode root, int no) {
        TreeNode result = null;
        // 左子树
        if (root.getLeft() != null) {
            result = inOrderSearch(root.getLeft(), no);
        }
        if (result != null) {
            return result;
        }
        // 根节点
        if (root.getNo() == no) {
            return root;
        }

        // 右子树
        if (root.getRight() != null) {
            result = inOrderSearch(root.getRight(), no);
        }
        return result;
    }

    // 后序查找
    public TreeNode postOrderSearch(TreeNode root, int no) {
        TreeNode result = null;
        // 左子树
        if (root.getLeft() != null) {
            result = postOrderSearch(root.getLeft(), no);
        }
        if (result != null) {
            return result;
        }
        // 右子树
        if (root.getRight() != null) {
            result = postOrderSearch(root.getRight(), no);
        }
        if (result != null) {
            return result;
        }
        // 根节点
        if (root.getNo() == no) {
            return root;
        }
        return null;
    }

    // 删除二叉树
    // 递归删除节点
    // 若是叶子节点，则删除对应节点
    // 若是根节点，则删除对应子树
    public void delete(TreeNode root, int no) {
        if (root != null) {
            // 将root为根节点的数置为空树
            if (root.getNo() == no) {
                root = null;
            } else {
                deleteNode(root, no);
            }
        } else {
            System.out.println("root为空，无法删除子树！");
        }
    }

    public void deleteNode(TreeNode root, int no) {
        // 删除对应左叶子节点
        if (root.getLeft() != null && root.getLeft().getNo() == no) {
            root.setLeft(null);
            return;
        }
        // 右叶子节点
        if (root.getRight() != null && root.getRight().getNo() == no) {
            root.setRight(null);
            return;
        }
        // 左右叶子节点不为空，向左子树进行递归删除
        if (root.getLeft() != null) {
            // 在此处添加删除逻辑
            deleteNode(root.getLeft(), no);
        }
        //
        if (root.getRight() != null) {
            deleteNode(root.getRight(), no);
        }
    }
}