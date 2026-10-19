// Using ArrayList
// class Solution {
//     public int findTheWinner(int n, int k) {
//         ArrayList<Integer> list = new ArrayList<>();
//         for(int i=1; i<=n; i++){
//             list.add(i);
//         }

//         int idx = 0;
//         //O(n)
//         while(list.size() > 1){
//             // As the present index is also included so we have to do k-1
//             idx = (idx + (k-1)) % list.size();
//             // O(n) - bcoz yaha shifting logic bhi lag rha h
//             list.remove(idx);
//         }

//         return list.get(0);
//     }
// }


// Using Circular queue
class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            q.add(i);
        }

        while(q.size() > 1){

            for(int i=0; i<(k-1); i++){
                q.offer(q.poll());
            }
            q.poll();
        }

        return q.peek();
    }
}


