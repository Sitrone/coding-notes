void qsort(int left,int right)/* 对v[left]到v[right]的区间进行排序 */
{
     int i,last;/* last是本次分区的分界线 */
     if (left>=right)
     {
         return;/* left>=right则无意义 */
     }
     last=left;/* 先把边界设到最左边 */
     swap(left,(left+right)/2);/* 把当作基准,放到最左边 */
/* 此时v={7,9,4,3,1,2,5,8,6,0},基准数是7,last是1 */
     for (i=left+1;i<=right;i++)/* 从第二个元素开始,向后遍历整个区间 */
     {
         if (v[i]<v[left])/* v[left]是基准数,v[i]是与它比较的数 */
         {
             swap(i,++last);/* 把v[i]与自增1后的v[last]交换
                                         也就是把边界扩充到i */
         }
     }
/* 到这里,数组v变成了:{7,4,3,1,2,5,6,0,9,8} 蓝:7 绿:小于7 黄:大于7*/
     swap(left,last);/* 交换基准和边界 */
/* 通过上一步的交换,数组变成了:{0,4,3,1,2,5,6,7,9,8} */
/* 比7小的在左边,比7大的在右边,7在中间,下标为last */
     qsort(left,last-1);/* 数组被last分成两半,左边比较v[left]到v[last-1] */
     qsort(last+1,right);/* 右边比较v[last+1]到v[right],递归地执行下去 */
}
