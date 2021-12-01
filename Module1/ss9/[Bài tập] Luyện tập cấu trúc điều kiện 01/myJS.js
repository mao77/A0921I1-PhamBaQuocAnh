function doBai1() {
    let numa = parseFloat(document.getElementById('numa').value);
    let numb = parseFloat(document.getElementById('numb').value);
    let result = numa / numb;
    if (numa % numb == 0) {
        document.getElementById('resultBai1').value = 'a chia het cho b';
    } else {
        document.getElementById('resultBai1').value = 'a khong chia het cho b';
    }
}

function doBai2() {
    let tuoihs = parseInt(document.getElementById('tuoihs').value);
    if (tuoihs >= 15) {
        document.getElementById('resultBai2').value = 'hs du tuoi vao lop 10';
    } else {
        document.getElementById('resultBai2').value = 'hs khong du tuoi vao lop 10(tuoi hs < 15t)';
    }
}

function doBai3() {
    let numc = parseInt(document.getElementById('numc').value);
    if (numc > 0) {
        document.getElementById('resultBai3').value = numc + ' lon hon 0';
    } else if (numc < 0) {
        document.getElementById('resultBai3').value = numc + ' nho hon 0';
    } else {
        document.getElementById('resultBai3').value = numc + ' = 0';
    }
}

function doBai4() {
    let num1 = parseInt(document.getElementById('num1').value);
    let num2 = parseInt(document.getElementById('num2').value);
    let num3 = parseInt(document.getElementById('num3').value);
    if (num1 > num2) {
        if (num1 > num3) {
            document.getElementById('resultBai4').value = 'a = ' + num1 + ' la so lon nhat';
        } else {
            document.getElementById('resultBai4').value = 'c = ' + num3 + ' la so lon nhat';
        }
    } else if (num2 > num3) {
        document.getElementById('resultBai4').value = 'b = ' + num2 + ' la so lon nhat';
    } else {
        document.getElementById('resultBai4').value = 'c = ' + num3 + ' la so lon nhat';
    }
}

function doBai5() {
    let diemGiuaKi = parseFloat(document.getElementById('diemGiuaKi').value);
    let diemCuoiKi = parseFloat(document.getElementById('diemCuoiKi').value);
    let diemTrungBinh = ((diemCuoiKi * 2) + diemGiuaKi) / 2;
    if (diemTrungBinh > 14) {
        document.getElementById('resultBai5').value = 'hs xuat sac';
    } else if (diemTrungBinh > 11) {
        document.getElementById('resultBai5').value = 'hs gioi';
    } else if (diemTrungBinh > 9) {
        document.getElementById('resultBai5').value = 'hs kha';
    } else if (diemTrungBinh > 7) {
        document.getElementById('resultBai5').value = 'hs trung binh';
    } else if (diemTrungBinh > 5) {
        document.getElementById('resultBai5').value = 'hs yeu';
    } else
        document.getElementById('resultBai5').value = 'hs kem';

}

function doBai6() {
    let doanhSo = parseInt(document.getElementById('doanhSo').value);
    if (doanhSo >= 100000000) {
        document.getElementById('resultBai6').value = 'hoa hong = ' + doanhSo * 10 / 100 + ' (10%)';
    } else if (doanhSo >= 70000000) {
        document.getElementById('resultBai6').value = ' hoa hong = ' + doanhSo * 7 / 100+ ' (7%)';
    } else if (doanhSo >= 30000000) {
        document.getElementById('resultBai6').value = 'hoa hong = ' + doanhSo * 5 / 100+ ' (5%)';
    } else if (doanhSo >= 10000000) {
        document.getElementById('resultBai6').value = 'hoa hong = ' + doanhSo * 3 / 100+ ' (3%)';
    } else {
        document.getElementById('resultBai6').value = 'hoa hong = ' + doanhSo * 1 / 100+ ' (1%)';
    }
}

function doBai7() {
    let soPhutGoi = parseInt(document.getElementById('soPhutGoi').value);
    let cuoc = soPhutGoi*2000;
    document.getElementById('resultBai7').value = 'cuoc = '+ cuoc;
}