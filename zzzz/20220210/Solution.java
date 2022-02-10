/**
 * 剑指 Offer 26. 树的子结构
 *
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 *
 * 0 <= 节点个数 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/*
 * 解题思路，二叉树的题目可以先推断出符合题目的条件
 * 需要 B 是 A 的子结构，则推断出条件
 * 1. 左子树相等
 * 2. 右子树相等
 * 3. B 中不能含有 A 中没有的节点
 * 4. A B 均不为空
 * 将代码看作一个黑盒，进行递归操作。
 */
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 递归在A中查找B的根结点
        return (A != null && B != null) && (process(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public boolean process(TreeNode A, TreeNode B) {
        if(B == null) {
            return true;
        }
        if(A == null || A.val != B.val) {
            return false;
        }
        return process(A.left, B.left) && process(A.right, B.right);
    }
}