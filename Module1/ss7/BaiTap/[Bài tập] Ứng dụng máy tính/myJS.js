let num1 = document.getElementById('num1');
let num2 = document.getElementById('num2');

function add() {
    let result = parseInt(num1.value) + parseInt(num2.value);
    document.getElementById('result').innerText = num1.value + '+' + num2.value + '=' + result
}

function sub() {
    let result = parseInt(num1.value) - parseInt(num2.value);
    document.getElementById('result').innerText = num1.value + '-' + num2.value + '=' + result;
}

function multi() {
    let result = parseInt(num1.value) * parseInt(num2.value);
    document.getElementById('result').innerText = num1.value + '*' + num2.value + '=' + result;
}

function divi() {
    let result = parseInt(num1.value) / parseInt(num2.value);
    document.getElementById('result').innerText=num1.value+'/'+num2.value+'='+result;
}
