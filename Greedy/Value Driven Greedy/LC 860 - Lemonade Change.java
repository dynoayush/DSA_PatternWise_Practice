class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int n = bills.length;
        for(int i = 0;i < n;i++){
            int bill = bills[i];
            if(bill == 5){
                five = five+1;
            }
            else if(bill == 10){
                if(five == 0){
                    return false;
                }    
                five = five - 1;
                ten = ten + 1;
            }
            else if(bill == 20){
                if(ten > 0 && five > 0){
                    ten = ten - 1;
                    five = five - 1;
                }
                else if(five >= 3){
                    five = five - 3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}