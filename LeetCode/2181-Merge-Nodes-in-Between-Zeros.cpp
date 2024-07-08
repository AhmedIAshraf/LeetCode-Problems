/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeNodes(ListNode* head) {
        ListNode* p = head->next;
        //cout<<p->val<<endl;
        ListNode* out=NULL;
        int sum=0;
        while(p!=NULL){
            if (p->val==0){
                if (out==NULL) out=head;
                else out=out->next;
                out->val=sum;
                sum=0;
            }
            else sum+=p->val;
            p=p->next;
        }
        out->next=NULL;
        return head;
    }
};