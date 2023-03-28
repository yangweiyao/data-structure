# data-structure

堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：**即子结点的键值或索引总是小于（或者大于）它的父节点。**
<h5>二叉树</h5> 特点：每个节点最多只有2个子节点（不存在度大于2的节点）
<img src=https://user-images.githubusercontent.com/67896996/228106853-5a302ed3-1f0f-4611-9227-16f7563b94b0.png />

<h5>满二叉树</h5> 特点：叶子节点全部都在最底层；除叶子节点外，每个节点都有左右孩子；
<img src=https://user-images.githubusercontent.com/67896996/228107866-2cfc6e08-eca1-4117-9118-842b46ee53db.png />

<h5>完全二叉树</h5> 特点：叶子节点全部都在最底的两层；最后一层只缺少右边的叶子节点，左边一定有叶子节点；除了最后一层，其他层的节点个数均达到最大值；
<img src=https://user-images.githubusercontent.com/67896996/228107584-0feaa4d9-bb8f-4cc9-ac4e-733b22e7b180.png />

<h5>最大堆和最小堆</h5>
最大堆：堆顶是整个堆中最大元素；<br>
最小堆：堆顶是整个堆中最小元素；<br>

<h5>算法思路：</h5>
    例如：无序数组：int arr[] = {4,2,8,0,5,7,1,3,9};既然用到堆，肯定先要将数组构建成二叉堆。需要对数组从小到大排序，则构建成最大(小)堆。
<img src=https://user-images.githubusercontent.com/67896996/228108466-1cc20a3a-d7e7-485f-8775-004ce89be283.png />
<img src=https://user-images.githubusercontent.com/67896996/228108513-8898f4f1-7a76-4525-a1df-730d3a7d72a1.png />
在这个图中，明显不满足最大堆的要求。我们先拿序号为3,7,8的三个节点来研究，i=3的节点比i=7和i=8的节点都小，所以需要交换位置。注意此图是从0开始，也就是模拟数组下标从0开始。<br>
设为当前节点index，那么它的左节点=index*2+1，它的右节点=index*2+2；注意下标从0开始
<img src=https://user-images.githubusercontent.com/67896996/228109103-fe601662-79e1-4f31-a030-b86b3cd8d416.png />



<br>
<p>
版权声明：本文为CSDN博主「赤电惊云」的原创文章<br>
原文链接：https://blog.csdn.net/lipanpan900721/article/details/122313096<br>
</p>


