function check() {
    let answer = document.getElementById('answer').value;
    if (answer == 'ECMAScript') {
        document.getElementById('result').innerText = 'DUNG';

    } else {
        document.getElementById('result').innerText = 'SAI';
    }
}