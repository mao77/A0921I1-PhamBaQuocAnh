// var fib = function(n) {
//     if (n === 1) {
//         return [0, 1];
//     } else {
//         var arr = fib(n - 1);
//         arr.push(arr[arr.length - 1] + arr[arr.length - 2]);
//         return arr;
//     }
// };
//
// console.log(fib(2));
let fib = function (n:number) {
    if (n==1) {
        return [0,1];
    }else {
        let arr:any = fib(n-1);
        arr.push(arr[arr.length - 1] + arr[arr.length - 2]);
        return arr;
    }
}

let sum:number = 0;
for (let i : number = 0; i < fib(20).length; i++){
    sum = sum + fib(20)[i];
}
console.log(sum);
