function add() {
    let num1 = parseFloat(document.getElementById('num1').value);
    let num2 = parseFloat(document.getElementById('num2').value);
    let add = (num1 + num2).toFixed(2);
    document.write(num1 +'+' + num2 + '=' + add);
}
function sub() {
    let num1 = parseFloat(document.getElementById('num1').value);
    let num2 = parseFloat(document.getElementById('num2').value);
    let sub = (num1 - num2).toFixed(2);
    document.write(num1 + '-' + num2 + '=' + sub);

}
function multi() {
    let num1 = parseFloat(document.getElementById('num1').value);
    let num2 = parseFloat(document.getElementById('num2').value);
    let multi = (num1 * num2).toFixed(2);
    document.write(num1 + '*' + num2 + '=' + multi);

}
function divi() {
    let num1 =parseFloat(document.getElementById('num1').value);
    let num2 =parseFloat(document.getElementById('num2').value);
    let divi = (num1 / num2).toFixed(2);
    document.write(num1 + '/' + num2 + '=' + divi);
}
