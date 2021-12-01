function check1() {
    let numa = parseInt(document.getElementById('numa').value);
    let numb = parseInt(document.getElementById('numb').value);
    // if ((numa+numb)<4) {
    //     document.getElementById('result').innerText='below';
    // }
    (numa + numb) < 4 ? document.getElementById('result1').innerText = 'below' : document.getElementById('result1').innerText = 'over';

}

function check2() {
    let string = document.getElementById('string').value;
    if (string == 'Employee') {
        document.getElementById('result2').innerText = 'hello';
    } else if (string == 'Director') {
        document.getElementById('result2').innerText = 'greetings';
    } else if (string == '') {
        document.getElementById('result2').innerText = 'no login';
    } else {
        document.getElementById('result2').innerText = '';
    }
}