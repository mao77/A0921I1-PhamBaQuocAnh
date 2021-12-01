function check() {
    let weight = parseFloat(document.getElementById('weight').value);
    let height = parseFloat(document.getElementById('height').value);
    let bmi = weight / Math.pow(height, 2);
    console.log(weight);
    console.log(height);
    console.log(bmi);
    if (bmi < 18.5) {
        document.getElementById('check').innerText = 'Underweight';
    } else if (bmi < 25) {
        document.getElementById('check').innerText = 'Normal';
    } else if (bmi < 30) {
        document.getElementById('check').innerText = 'OverWeight';
    } else {
        document.getElementById('check').innerText = 'Obese';
    }
}