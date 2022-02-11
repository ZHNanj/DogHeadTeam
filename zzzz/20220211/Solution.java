import java.util.ArrayList;

/**
 * leetcode 02
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *  
 *
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static LNode addTwoNumbers(LNode l1, LNode l2) {
        LNode result = new LNode(0);
        LNode resultCur = result;
        boolean flag = false;
        while(l1 != null) {
            if(flag) {
                if(l2 == null) {
                    resultCur.next = new LNode(l1.val + 1);
                } else {
                    resultCur.next = new LNode(l1.val + l2.val + 1);
                    l2 = l2.next;
                }
            } else {
                if(l2 == null) {
                    resultCur.next = new LNode(l1.val);
                } else {
                    resultCur.next = new LNode(l1.val + l2.val);
                    l2 = l2.next;
                }
            }
            int sum = resultCur.next.val;
            if(sum > 9) {
                flag = true;
                resultCur.next.val = sum - 10;
            }
            resultCur = resultCur.next;
            l1 = l1.next;
        }

        while(l2 != null) {
            if(flag) {
                resultCur.next = new LNode(l2.val + 1);
            } else {
                resultCur.next = new LNode(l2.val);
            }
            if(resultCur.next.val < 10) {
                flag = false;
            } else {
                flag = true;
                resultCur.next.val = resultCur.next.val - 10;
            }
            l2 = l2.next;
            resultCur = resultCur.next;
        }

        if(flag) {
            resultCur.next = new LNode(1);
        }

        return result.next;
    }


    public static void main(String[] args) {
        LNode l1 = new LNode(2);
        l1.next = new LNode(4);
        l1.next.next = new LNode(9);

        LNode l2 = new LNode(5);
        l2.next = new LNode(6);
        l2.next.next = new LNode(4);
        l2.next.next.next = new LNode(9);

        System.out.println(addTwoNumbers(l1, l2));
    }
}