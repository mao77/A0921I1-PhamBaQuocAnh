function check() {
    let num = parseInt(document.getElementById('input').value);
    if (num > 0) {
        document.getElementById('result').innerText = '1';
    } else if (num < 0) {
        document.getElementById('result').innerText = '-1';
    } else {
        document.getElementById('result').innerText = '0';
    }
}