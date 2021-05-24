package subtask2

class BillCounter {

    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        val annBill = bill.toMutableList()
        annBill.removeAt(k);
        var sum = annBill.sum()
        sum /= 2 //должна заплатить тётька
        return if(b==sum){
            "Bon Appetit"
        }else{
            (b-sum).toString()
        }
    }
}
