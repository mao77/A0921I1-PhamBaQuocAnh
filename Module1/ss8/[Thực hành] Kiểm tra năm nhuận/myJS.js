function ktraNamNhuan() {
    let year = parseInt(document.getElementById('input').value);
    if (year % 4 == 0) {
        if (year % 100 == 0) {
            if (year % 400 == 0) {
                document.getElementById('result').innerText = year + ' la nam nhuan'
            } else {
                document.getElementById('result').innerText = year + ' khong phai la nam nhuan';
            }
        } else {
            document.getElementById('result').innerText = year + ' la nam nhuan';
        }
    } else {
        document.getElementById('result').innerText = year + ' khong phai la nam nhuan';
    }
}
