function doBai1() {
    let tempC = parseInt(document.getElementById('tempC').value);
    let tempF = tempC * 9 / 5 + 32;
    document.getElementById('resultBai1').value = tempF + ' do F';
}

function doBai2() {
    let met = parseFloat(document.getElementById('met').value);
    let feet = met * 3.2808;
    document.getElementById('resultBai2').value = feet.toFixed(3) + ' feet';
}

function doBai3() {
    let a = parseFloat(document.getElementById('a').value);
    let s = Math.pow(a, 2);
    document.getElementById('resultBai3').value = 'dien tich = ' + s;
}

function doBai4() {
    let canha = parseFloat(document.getElementById('canha').value);
    let canhb = parseFloat(document.getElementById('canhb').value);
    let s = canha * canhb;
    document.getElementById('resultBai4').value = 'dien tich = ' + s.toFixed(2);
}

function doBai5() {
    let canhc = parseFloat(document.getElementById('canhc').value);
    let canhd = parseFloat(document.getElementById('canhd').value);
    let s = (canhc * canhd) / 2;
    document.getElementById('resultBai5').value = 'dien tich = ' + s;

}

function doBai6() {
    let biena = parseFloat(document.getElementById('biena').value);
    let bienb = parseFloat(document.getElementById('bienb').value);
    let x;
    if (biena == 0) {
        if (bienb == 0) {
            document.getElementById('resultBai6').value = ' pt co vo so nghiem'
        } else {
            document.getElementById('resultBai6').value = 'pt vo nghiem'
        }
    } else {
        x = parseFloat(-bienb / biena).toFixed(2);
        document.getElementById('resultBai6').value = 'x = ' + x;
    }
}

function doBai7() {
    let biena1 = parseFloat(document.getElementById('biena1').value);
    let bienb1 = parseFloat(document.getElementById('bienb1').value);
    let bienc1 = parseFloat(document.getElementById('bienc1').value);
    let delta;

    if (biena1 == 0) {
        if (bienb1 == 0) {
            document.getElementById('resultBai7').value = ' pt co vo so nghiem';
        } else {
            document.getElementById('resultBai7').value = 'x = ' + -bienc1 / bienb1;
        }
    } else {
        delta = Math.pow(bienb1, 2) - (4 * biena1 * bienc1);
        if (delta < 0) {
            document.getElementById('resultBai7').value = ' pt vo nghiem';
        }else if (delta == 0) {
            document.getElementById('resultBai7').value = 'pt co nghiem kep x1 = x2 = ' + -bienb1/(2 * biena1);
        }else {
            document.getElementById('resultBai7').value = 'x1 = ' + ((-bienb1 + Math.sqrt(delta))/(2*biena1)).toFixed(2) + '      x2 = ' + ((-bienb1 - Math.sqrt(delta))/(2*biena1)).toFixed(2);
        }
    }
}

function doBai8() {
    let tuoi = parseInt(document.getElementById('tuoi').value);
    if (tuoi < 120 && tuoi > 0) {
        document.getElementById('resultBai8').value = tuoi + ' la tuoi cua 1 nguoi';
    }else {
        document.getElementById('resultBai8').value = tuoi + ' khong phai la tuoi cua 1 nguoi';
    }
}

function  doBai9() {
    let canha2 = parseFloat(document.getElementById('canha2').value);
    let canhb2 = parseFloat(document.getElementById('canhb2').value);
    let canhc2 = parseFloat(document.getElementById('canhc2').value);
    if (canha2 > 0 && canhb2 > 0 && canhc2 > 0) {
        if (((canha2 + canhb2) > canhc2)&&((canha2 + canhc2) > canhb2)&&((canhb2 + canhc2) > canha2)) {
            document.getElementById('resultBai9').value = ' 3 canh a, b , c la cua 1 tam giac'
        }else {
            document.getElementById('resultBai9').value = ' 3 canh a, b, c khong tao thanh 1 tam giac'
        }
    }else {
        document.getElementById('resultBai9').value = '3 canh a, b, c khong tao thanh 1 tam giac';
    }
}

function doBai10() {
    let chuDien = parseFloat(document.getElementById('chuDien').value);
    let giaDien;
    if (chuDien>0 && chuDien <= 50) {
        giaDien = chuDien * 3000;
        document.getElementById('resultBai10').value = 'tien dien thang nay = ' + giaDien;
    }else if (chuDien <=100) {
        giaDien = chuDien *3500;
        document.getElementById('resultBai10').value = 'tien dien than nay = ' + giaDien;
    }else if (chuDien <=200) {
        giaDien = chuDien *4500;
        document.getElementById('resultBai10').value = 'tien dien than nay = ' + giaDien;
    }else if (chuDien <=400) {
        giaDien = chuDien *5500;
        document.getElementById('resultBai10').value = 'tien dien than nay = ' + giaDien;
    }else if (chuDien <=800) {
        giaDien = chuDien *6500;
        document.getElementById('resultBai10').value = 'tien dien than nay = ' + giaDien;
    }else if (chuDien <=1000) {
        giaDien = chuDien *7500;
        document.getElementById('resultBai10').value = 'tien dien than nay = ' + giaDien;
    }else {
        giaDien = chuDien * 8500;
        document.getElementById('resultBai10').value = 'tien dien thang nay = ' +giaDien;
    }
}

function doBai11() {
    let thuNhap = parseInt(document.getElementById('thuNhap').value);
    let thue;
    if (thuNhap > 0 && thuNhap <=5000000) {
        thue = thuNhap*5/100;
        document.getElementById('resultBai11').value = 'thue = ' + thue;
    }else if (thuNhap <=10000000) {
        thue = thuNhap*10/100;
        document.getElementById('resultBai11').value = 'thue = ' + thue;
    }else if (thuNhap <=18000000) {
        thue = thuNhap*15/100;
        document.getElementById('resultBai11').value = 'thue = ' + thue;
    }else if (thuNhap <=32000000) {
        thue = thuNhap*20/100;
        document.getElementById('resultBai11').value = 'thue = ' + thue;
    }else if (thuNhap <=52000000) {
        thue = thuNhap*25/100;
        document.getElementById('resultBai11').value = 'thue = ' + thue;
    }else if (thuNhap <=80000000) {
        thue = thuNhap*30/100;
        document.getElementById('resultBai11').value = 'thue = ' + thue;
    }else {
        thue = thuNhap*35/100;
        document.getElementById('resultBai11').value = 'thue = ' + thue;
    }
}

function doBai12() {
    let i = parseFloat(document.getElementById('tienVay').value);
    let j = parseInt(document.getElementById('thoiGianVay').value);
    for (let a = 1; a<=j;a++) {
        i+=(i*0.01);
    }
    document.getElementById('resultBai12').value = 'so tien ban phai tra sau ' + j + ' thang la '+ i + ' vnd';
}