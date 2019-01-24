package leetcode.tree.pathSum;

import baseObj.TreeNode;
import leetcode.tag.type.Tree;

/**
 * 437. Path Sum III
 *
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf,
 * but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class PathSumIII {

    /**
     * Thank god this only asked to return the total possible number
     *
     * Solution could start from root, solution could start from right and solution could start from left
     * this summarized the sub problem
     *
     * result = R(root) + R(root.left) + R(root.right)
     * Space: O(n) due to recursion.
     * Time: O(n^2)
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSum(root, sum) + sumFrom(root.left, sum) + sumFrom(root.right, sum);
    }

    public int sumFrom(TreeNode root, int sum) {
        if (root == null) return 0;
        return (sum==root.value?1:0) + sumFrom(root.left, sum - root.value) + sumFrom(root.right, sum - root.value);
    }
}
